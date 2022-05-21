package com.gerenciador.main.view.controller;

import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;

public abstract class AbstractController {

    private static final String FXML_PATH = "../fxml/";
    private static final String CSS_PATH = "../css/";

    /**
     * Nome simples da classe de controller da tela
     */
    private String className;

    protected String screenId;
    protected Stage stage;

    protected AbstractController() {
        this.className = getClass().getSimpleName();
        this.stage = initStage();
        this.screenId = generateScreenId();
    }

    public Stage getStage() {
        return this.stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Pega o nome da classe de controller e procura pelo arquivo .fxml na package
     * com.gerenciador.main.javafx.view.fxml
     *
     * @return url com o endereço do arquivo
     */
    public URL getFxmlFile() {
        return getClass().getResource(FXML_PATH + className + ".fxml");
    }

    /**
     * Pega o nome da classe de controller e procura pelo arquivo .css na package
     * com.gerenciador.main.javafx.view.css
     *
     * @return url com o endereço do arquivo
     */
    public URL getCssFile() {
        return getClass().getResource(CSS_PATH + className + ".css");
    }

    /**
     * Inicializa o stage da tela com alguns valores padrões
     *
     * Por padrão, as telas são abertas em tela cheia. O tamanho mínimo é sempre 800x600
     */
    private Stage initStage() {
        Stage stg = new Stage();
        stg.setMinWidth(800);
        stg.setMinHeight(600);
        stg.setWidth(Screen.getPrimary().getBounds().getWidth());
        stg.setHeight(Screen.getPrimary().getBounds().getHeight());
        return stg;
    }

    private String generateScreenId() {
        return "ID_".concat(this.className.toUpperCase());
    }
}
