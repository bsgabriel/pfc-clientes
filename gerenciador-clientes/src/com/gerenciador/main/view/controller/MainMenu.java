package com.gerenciador.main.view.controller;

import com.gerenciador.database.entidades.PfcCliente;
import com.gerenciador.main.ScreenManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainMenu extends AbstractController {

	@FXML
	private TextField inputBusca;

	@FXML
	private TableView<PfcCliente> tblClientes;

	@FXML
	private void buscar() {

	}

	@FXML
	private void abrirTelaCadastro() {
		ScreenManager.getInstance().loadScreen(new TelaCadastrarCliente(), "Gerenciador de Clientes - Cadastro");
	}

	@FXML
	private void removerSelecionado() {

	}

	@FXML
	private void exibirDetalhes() {
	}

}
