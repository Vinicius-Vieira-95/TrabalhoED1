package arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Arquivo {

	private File file;
	
	public Arquivo(File file) {
		this.file = file;
	}
	
	public void lerArquivo() {
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			String linha = br.readLine();
			while( linha != null) {
				System.out.println(linha);
				linha = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
}
