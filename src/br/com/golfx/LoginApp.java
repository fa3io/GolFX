package br.com.golfx;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



	public  class LoginApp extends Application {
		
		private AnchorPane pane;
		private TextField txLogin;
		private PasswordField txSenha;
		private Button btEntrar;
		private Button btSair;
		private Scene scene;
		private static Stage stage;
		
		
		
		public static Stage getStage() {
			return stage;
		}
		
		@Override
		public void start(Stage stage) throws Exception {
		
		initComponents();
		initListener();
		
		scene = new Scene(pane);
		//Adicionando arquivo css a nossa cena
		scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Login - GolFX");
		stage.setResizable(false);
		stage.show();
		initLayout();
		
		LoginApp.stage = stage;
		
			
		}
		public static void main(String[] args) {
			launch(args);
		}
		
		public void initComponents(){
			pane = new AnchorPane();
			pane.setPrefSize(400, 300);
			//dentro do nosso arquivo css associamos  uma classe ao componente
			pane.getStyleClass().add("pane");
			txLogin = new TextField();
			txLogin.setPromptText("Digite aqui seu login");
			txSenha = new PasswordField();
			txSenha.setPromptText("Digite aqui sua senha");
			btEntrar = new Button("Entrar");
			//adicionando css
			btEntrar.getStyleClass().add("btEntrar");
			btSair = new Button("Sair");
			//adicionando css
			btSair.getStyleClass().add("btSair");
			pane.getChildren().addAll(txLogin, txSenha, btEntrar, btSair);
			
			
			
			
		}
		public void initLayout(){
			txLogin.setLayoutX((pane.getWidth() - txLogin.getWidth()) / 2);
			txLogin.setLayoutY(50);
			txSenha.setLayoutX((pane.getWidth() - txSenha.getWidth()) / 2);
			txSenha.setLayoutY(100);
			btEntrar.setLayoutX((pane.getWidth() - btEntrar.getWidth()) / 2);
			btEntrar.setLayoutY(150);
			btSair.setLayoutX((pane.getWidth() - btSair.getWidth()) / 2);
			btSair.setLayoutY(200);
			
		}
		
		private void logar() {
			if(txLogin.getText().equals("fabio") && txSenha.getText().equals("123")){
				try {
					new VitrineApp().start(new Stage());
					LoginApp.getStage().close();
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro: "+ e.getMessage(),"Erro Login", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}else{
				JOptionPane.showMessageDialog(null, "Login ou Senha Inválidos !!!","Erro Login", JOptionPane.ERROR_MESSAGE);
			}
			
		}

		public void initListener(){
			btEntrar.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					logar();
				}
			});
			btSair.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
				System.exit(0);
				}
			});
		}
		
	}

