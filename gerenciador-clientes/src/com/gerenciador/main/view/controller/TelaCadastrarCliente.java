package com.gerenciador.main.view.controller;

import com.gerenciador.database.entidades.PfcPurificador;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TelaCadastrarCliente extends AbstractController {

    @FXML
    private TextField inputNome;

    @FXML
    private TextField inputCpfCnpj;

    @FXML
    private RadioButton rdPessoaFisica;

    @FXML
    private RadioButton rdEmpresa;

    @FXML
    private TextField inputTelefone;

    @FXML
    private TextField inputCelular;

    @FXML
    private TextField inputEmail;

    @FXML
    private TextField inputCidade;

    @FXML
    private TextField inputEstado;

    @FXML
    private TextField inputRua;

    @FXML
    private TextField inputBairro;

    @FXML
    private TextField inputNumero;

    @FXML
    private TextArea inputObservacao;

    @FXML
    private TableView<PfcPurificador> tblPurificadores;


}
