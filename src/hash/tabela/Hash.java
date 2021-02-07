package hash.tabela;

import java.util.Arrays;

import lista.ListaEncadeada;

public class Hash {

	private int quant;
	private ListaEncadeada<Integer> tabela[];

	public Hash(int tamanho) {
		tabela = new ListaEncadeada[tamanho];
	}

	public ListaEncadeada<Integer>[] getTabela() {
		return tabela;
	}

	public void setTabela(ListaEncadeada<Integer>[] tabela) {
		this.tabela = tabela;
	}

	public int getQuant() {
		return quant;
	}

	public boolean insereHash_EnderecoAberto(String object) {
		if (object == null || quant == tabela.length) {
			return false;
		}
		// deve colocar a chave como elemento de busca. String ou Inteiro
		// int chave = object.TipoInteiro
		int chave = valorString(object);

		int pos, novaPosicao;

		pos = chaveDivisao(chave, tabela.length);
		for (int i = 0; i < tabela.length; i++) {
			novaPosicao = sondagemLinear(pos, i, tabela.length);
			// public int sondagemQuadratica(int pos, int i, int tabela_size)
			// public int duploHash(int h1, int chave, int i, int tabela_size)
			if (tabela[novaPosicao] == null) {
				ListaEncadeada<Integer> novoObject = new ListaEncadeada<Integer>();
				novoObject.setPalavra(object);
				tabela[novaPosicao] = novoObject;
				this.quant++;
				return true;
			}
		}
		return false;
	}

	public ListaEncadeada<Integer> buscaHash_SemColisão(String chave) {
		int num = valorString(chave);
		int pos = chaveDivisao(num, tabela.length);

		if (tabela[pos] == null) {
			return null;
		}
		ListaEncadeada<Integer> elemento = tabela[pos];
		return elemento;
	}
	
	public void insereLinha(String palavra, int i) {
		int num = valorString(palavra);
		int pos = chaveDivisao(num, tabela.length);
		
		tabela[pos].inserirNoFim(i);
		
	}

	// Metodos para tratar colisões
	public int sondagemLinear(int pos, int i, int tabela_size) {
		return ((pos + i) & 0x7FFFFFFF) % tabela_size;
	}

	public int sondagemQuadratica(int pos, int i, int tabela_size) {
		pos = (int) (pos + 2 * i + 5 * (Math.pow(i, 2)));
		return (pos & 0x7FFFFFFF) % tabela_size;
	}

	public int duploHash(int h1, int chave, int i, int tabela_size) {
		int h2 = chaveDivisao(chave, tabela_size) + 1; // metodo chave divisao escolhida, por padrão de outras funçoes
		return ((h1 + i * h2) & 0x7FFFFFFF) % tabela_size;
	}

	// Metodos para calcular os tipos de chave.
	public int chaveDivisao(int chave, int tabela_size) {
		return (chave & 0x7FFFFFFF) % tabela_size;
	}

	public int chaveMultiplicacao(int chave, int tabela_size) {
		double a = 0.6180339887; // constante: 0 < A < 1
		double valor = chave * a;
		valor = valor - (int) valor;
		return (int) (tabela_size * valor);
	}

	public int chaveDobra(int chave, int tabela_size) {
		int num_bits = 5;
		int parte1 = chave >> num_bits;
		int parte2 = chave & (tabela_size - 1);
		return (parte1 ^ parte2);
	}

	// passando um valor String para Inteiro
	public int valorString(String str) {
		int valor = 7;
		int tamanho = str.length();
		// calculo pegando cada caracter da string
		for (int i = 0; i < tamanho; i++) {
			valor = 31 * valor + str.charAt(i);
		}
		return valor;
	}

	@Override
	public String toString() {
		return  Arrays.toString(tabela);
	}
	
	

}
