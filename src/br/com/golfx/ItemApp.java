package br.com.golfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ItemApp extends Application {

	private AnchorPane pane;
	private ImageView imagem;
	private Label lbNome, lbPreco;
	private Button btaddCarinho;
	private static Stage stage;
	private Scene scene;
	private static Produto produto;
	private static int index;
	private String[] imagens = {"http://icons.iconarchive.com/icons/iconshock/soccer/128/soccer-3-icon.png",
								"http://icons.iconarchive.com/icons/kidaubis-design/olympic-games/128/Table-Tennis-icon.png",
								"http://icons.iconarchive.com/icons/ergosign/soccer-worldcup-2010/128/soccer-shoe-grass-icon.png",
								"http://icons.iconarchive.com/icons/iconshock/real-vista-sports/128/formula-1-helmet-icon.png",
								"http://icons.iconarchive.com/icons/iconshock/real-vista-sports/128/boxing-gloves-icon.png",
								"http://icons.iconarchive.com/icons/giannis-zographos/liverpool-fc/128/European-Shirt-2010-2011-icon.png",
								};

	public void initComponents() {

		pane = new AnchorPane();
		pane.setPrefSize(600, 400);
		pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, black 0%, silver 100%);");

		lbNome = new Label("Nome: " + ItemApp.getProduto().getNome());
		lbPreco = new Label("Preço: " + ItemApp.getProduto().getPreco());
		
		imagem = new ImageView(imagens[index]);

		btaddCarinho = new Button("Adicionar");

		pane.getChildren().addAll(lbNome, lbPreco, imagem );
		pane.getChildren().add(btaddCarinho);
		

	}

	public void initLayout() {

		lbNome.setLayoutX(20);
		lbNome.setLayoutY(50);
		lbNome.setTextFill(Color.WHITE);
		lbNome.setFont(Font.font(null, FontWeight.BOLD, 20));

		lbPreco.setLayoutX(20);
		lbPreco.setLayoutY(100);
		lbPreco.setTextFill(Color.WHITE);
		lbPreco.setFont(Font.font(null, FontWeight.BOLD, 20));
		
		imagem.setLayoutX(200);
		imagem.setLayoutY(50);

		btaddCarinho.setLayoutX(20);
		btaddCarinho.setLayoutY(150);
		btaddCarinho.setFont(Font.font(null, FontWeight.BOLD, 20));
	}

	@Override
	public void start(Stage stage) throws Exception {
		initComponents();
		initListener();
		scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Item");
		stage.setResizable(false);
		stage.show();

		initLayout();

	}

	private void initListener() {
		btaddCarinho.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				VitrineApp.getCarinho().add(produto);
				
				try {
					new CarrinhoApp().start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public static int getIndex() {
		return index;
	}
	public static void setIndex(int index) {
		ItemApp.index = index;
	}
	public static Produto getProduto() {
		return produto;
	}
	public static void setProduto(Produto produto) {
		ItemApp.produto = produto;
	}

}
