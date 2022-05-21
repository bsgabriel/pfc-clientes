package com.gerenciador.main;

import com.gerenciador.main.view.controller.AbstractController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class ScreenManager {

	private static ScreenManager instance;
	private FXMLLoader loader;

	private ScreenManager() {
		loader = new FXMLLoader();
	}

	public static ScreenManager getInstance() {
		if (instance == null) {
			instance = new ScreenManager();
		}
		return instance;
	}

	public void loadScreen(AbstractController controller) {
		loadScreen(controller, "Gerenciador de Clientes");
	}

	public void loadScreen(AbstractController controller, String title) {
		try {
			loader.setController(controller);
			Parent root = FXMLLoader.load(controller.getFxmlFile());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(controller.getCssFile().toExternalForm());
			Stage stage = controller.getStage();
			stage.setTitle(title);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
