package br.com.golfx;

import br.com.golfx.VitrineApp.ItensProperty;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CarrinhoApp extends Application {
	
	private AnchorPane pane;
	private TableView<ItensProperty> tbCarinho;
	private TableColumn<ItensProperty, String> columnProduto;
	private TableColumn<ItensProperty, Double> columnPreco;
	private Button btExcluir, btComprar, btVoltar;
	private static ObservableList<ItensProperty> listaItens;
	
	public void initItens(){
		for (Produto produto : VitrineApp.getCarinho().getProdutos()) {
			listaItens.add(new ItensProperty(produto.getNome(), produto.getPreco()));
		}
	}

	@Override
	public void start(Stage arg0) throws Exception {
	
	}
	public static void main(String[] args) {
		launch(args);
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
