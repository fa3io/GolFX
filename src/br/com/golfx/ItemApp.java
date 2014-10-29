package br.com.golfx;

import javafx.application.Application;
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

	public void initComponents() {

		pane = new AnchorPane();
		pane.setPrefSize(600, 400);
		pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, black 0%, silver 100%);");

		lbNome = new Label("Nome");
		lbPreco = new Label("Preço");

		btaddCarinho = new Button("Adicionar");

		pane.getChildren().addAll(lbNome, lbPreco);
		pane.getChildren().addAll();
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

		btaddCarinho.setLayoutX(20);
		btaddCarinho.setLayoutY(150);
		btaddCarinho.setFont(Font.font(null, FontWeight.BOLD, 20));
	}

	@Override
	public void start(Stage stage) throws Exception {
		initComponents();

		scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Item");
		stage.setResizable(false);
		stage.show();

		initLayout();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
