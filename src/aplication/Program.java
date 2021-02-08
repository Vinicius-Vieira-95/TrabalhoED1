package aplication;

import java.io.File;

import arquivo.Arquivo;

public class Program {

	public static void main(String[] args) {
		
		String file = "C:\\TesteArq\\teste.txt";
		File file2 = new File(file);
		
		Arquivo arq = new Arquivo(file2);
		
		arq.lerArquivo();
		System.out.println();
		System.out.println("Palavras selecionandas");
		arq.pesquisarPalavras("Good easy but not by use programming");
		System.out.println("Good easy but not by use programming");
		System.out.println();
		System.out.println("\n Indice Remissivo");
		
		System.out.println(arq.getHash().toString());
		
	}
	
}
