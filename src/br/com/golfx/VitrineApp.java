package br.com.golfx;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class VitrineApp extends Application {
	
	
	private AnchorPane pane;
	private Scene scene;
	private TextField txPesquisa;
	private TableView<ItensProperty> tbVitrine;
	private TableColumn<ItensProperty, String> columnProduto;
	private TableColumn<ItensProperty, Double> columnPreco;
	private static ObservableList<ItensProperty> listItens = FXCollections.observableArrayList();
	private static Carrinho carinho;
	
	

	@Override
	public void start(Stage stage) throws Exception {
		
		initComponets();
		initItens();
		
		initListener();
		
		scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Vitrine - Loja");
		stage.setResizable(false);
		stage.show();
		
		initLayout();
		
		tbVitrine.setItems(listItens);

	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void initComponets(){
		
		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
		
		txPesquisa = new TextField();
		txPesquisa.setPromptText("Digite o item para pesquisar ...");
		txPesquisa.setPrefWidth(250);
		
		tbVitrine = new TableView<ItensProperty>();
		tbVitrine.setPrefSize(780, 550);
		
		columnProduto = new TableColumn<ItensProperty, String>();
		columnPreco = new TableColumn<ItensProperty, Double>();
		
		tbVitrine.getColumns().addAll(columnProduto, columnPreco);
		
		pane.getChildren().addAll(txPesquisa, tbVitrine);
		
		carinho = new Carrinho();
		
		columnProduto.setCellValueFactory(new PropertyValueFactory<ItensProperty, String>("produto"));
		columnPreco.setCellValueFactory(new PropertyValueFactory<ItensProperty, Double>("preco"));
		
	}
	
	public void initLayout(){
		txPesquisa.setLayoutX((pane.getWidth() - txPesquisa.getWidth()) / 2);
		txPesquisa.setLayoutY(50);
		tbVitrine.setLayoutX((pane.getWidth() - tbVitrine.getWidth()) / 2);
		tbVitrine.setLayoutY(100);
		
		
	}
	
	public void initItens(){
		Produto p1 = new Produto("Bola", 10.0);
		Produto p2 = new Produto("Raquete", 100.0);
		Produto p3 = new Produto("Chuteira", 250.0);
		Produto p4 = new Produto("Capacete", 60.0);
		Produto p5 = new Produto("Luva", 35.0);
		Produto p6 = new Produto("Protetor Bucal", 40.0);
		Produto p7 = new Produto("Bast�o", 80.0);
		
		Vitrine vitrine = new Vitrine();
		
		vitrine.add(p1, p2, p3, p4, p5, p6, p7);
		
		for (Produto produto : vitrine.getProdutos()) {
			VitrineApp.listItens.add(new ItensProperty(produto.getNome(), produto.getPreco()));
		}	
	}
	
	public ObservableList<ItensProperty> findItens(){
		ObservableList<ItensProperty> itensEncontrados = FXCollections.observableArrayList();
		
		for (ItensProperty item : listItens) {
			if(item.getProduto().contains(txPesquisa.getText())){
				itensEncontrados.add(item);
			}
		}
		return itensEncontrados;
	}
	
	public void initListener(){
		
		txPesquisa.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				if(!txPesquisa.getText().equalsIgnoreCase("")){
					tbVitrine.setItems(findItens());
				}else{
					tbVitrine.setItems(listItens);
				}
			}
		});
	}

	public class ItensProperty {
		
		private SimpleStringProperty produto;
		private SimpleDoubleProperty preco;

		public ItensProperty(String produto, Double preco) {
			this.produto = new SimpleStringProperty(produto);
			this.preco = new SimpleDoubleProperty(preco);
		}

		public String getProduto() {
			return produto.get();
		}

		public void setProduto(String produto) {
			this.produto.set(produto);
		}

		public double getPreco() {
			return preco.get();
		}

		public void setPreco(double preco) {
			this.preco.set(preco);
		}

	}
}