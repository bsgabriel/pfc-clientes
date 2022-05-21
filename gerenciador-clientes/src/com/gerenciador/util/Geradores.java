package com.gerenciador.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class Geradores {

	/**
	 * Gera um cpf válido. <br>
	 * Referência: https://www.geradorcpf.com/algoritmo_do_cpf.html
	 * 
	 * @return
	 */
	public static String gerarCpf() {
		/* gera os primeiros 9 dígitos */
		ArrayList<Integer> lstCpf = new ArrayList<>();

		Random rand = new Random();

		// gera um número de 0 a 9 e adiciona na lista de números aleatórios
		for (int i = 0; i < 9; i++) {
			lstCpf.add(rand.nextInt(10));
		}

		/* gera o primeiro dígito verificador */
		ArrayList<Integer> lstMultiplicados = new ArrayList<>();
		Integer verificador;
		Integer somaTotal = 0;
		Integer resto;
		Integer peso = 10;

		// pra cada item da lista, multiplicamos seu valor pelo seu peso
		for (Integer num : lstCpf) {
			lstMultiplicados.add(num * peso);
			peso--;
		}

		// soma o todos os itens multiplicados
		for (Integer num : lstMultiplicados) {
			somaTotal += num;
		}

		resto = somaTotal % 11;

		// se o resto da divisao for menor que 2, o primeiro dígito será 0,
		// se não, subtraímos 11 pelo resto da divisão
		if (resto < 2) {
			verificador = 0;
		} else {
			verificador = 11 - resto;
		}

		lstCpf.add(verificador);

		/* gera o segundo dígito verificador */
		lstMultiplicados.clear();
		somaTotal = 0;
		peso = 11;

		for (Integer num : lstCpf) {
			lstMultiplicados.add(num * peso);
			peso--;
		}

		for (Integer num : lstMultiplicados) {
			somaTotal += num;
		}

		resto = somaTotal % 11;

		// o procedimento do segundo dígito é o mesmo que o anterior
		if (resto < 2) {
			verificador = 0;
		} else {
			verificador = 11 - resto;
		}
		lstCpf.add(verificador);

		String cpf = "";
		for (Integer num : lstCpf) {
			cpf = cpf.concat(num.toString());
		}
		return cpf;
	}

	/**
	 * Chama uma api que gera um nome
	 * 
	 * @return
	 */
	public static String gerarNome() throws IOException {
		String nome = "";

		URL urlNome = new URL("https://gerador-nomes.herokuapp.com/nome");
		URL urlSobrenome = new URL("https://gerador-nomes.herokuapp.com/apelido");

		HttpURLConnection con = (HttpURLConnection) urlNome.openConnection();

		con.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

		nome = nome.concat(in.readLine()).replace("\"", "").replace("[", "").replace("]", "").concat(" ");

		con = (HttpURLConnection) urlSobrenome.openConnection();
		in = new BufferedReader(new InputStreamReader(con.getInputStream()));

		nome = nome.concat(in.readLine()).replace("\"", "").replace("[", "").replace("]", "");
		
		in.close();

		return nome;
	}

	public static void main(String[] args) {
		try {
			System.out.println(String.format("%s, %s", gerarNome(), gerarCpf()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
