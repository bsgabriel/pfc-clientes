package com.gerenciador.main;

import com.gerenciador.main.view.controller.MainMenu;
import com.gerenciador.main.view.controller.TelaCadastrarCliente;
import javafx.application.Application;
import javafx.stage.Stage;

public class LauncherFX extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ScreenManager.getInstance().loadScreen(new MainMenu());
	}

}
