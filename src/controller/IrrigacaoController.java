package controller;

import java.io.Serializable;

import java.util.InputMismatchException;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import application.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class IrrigacaoController implements Serializable {

	private static final long serialVersionUID = -8248257843709767818L;

	private String dados;
	String luminosidade;

	public String getDados() {
		System.out.println("chamou getDados");
		return dados;
	}

	public void setDados(String dados) {
		this.dados = dados;
		try {
			BufferedReader arquivo = new BufferedReader(new FileReader(
					"C:\\Users\\mathe\\OneDrive\\Documentos\\UNITINS\\ESTR DADOS\\Historico_de_Log.txt"));

			List<String> arquivoArray = new ArrayList<String>();

			while (arquivo.ready()) {

				arquivoArray.add(arquivo.readLine());

			}

			arquivo.close();

			int quantidadeElementosLista = arquivoArray.size();
			System.out.println("LINHA: " + arquivoArray.size());

			// int umidadeAr = quantidadeElementosLista - 5;
			// int temperaturaAr = quantidadeElementosLista - 4;
			// int leituraSolo = quantidadeElementosLista - 2;

			int posicaoLuminosidade = quantidadeElementosLista - 3;
			luminosidade = arquivoArray.get(posicaoLuminosidade);

			System.out.println("teste" + arquivoArray.get(posicaoLuminosidade));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getLuminosidade() {
		String retorno = "";
		if (dados != null) {
			retorno = luminosidade;
		}
		return retorno;
	}
//    
}