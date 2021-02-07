package aplication;

import hash.tabela.Hash;

public class Program {

	public static void main(String[] args) {
		
		
		Hash h = new Hash(10);
		
		h.insereHash_EnderecoAberto("lua");
		h.insereHash_EnderecoAberto("sol");
		h.insereHash_EnderecoAberto("jupter");
		h.insereHash_EnderecoAberto("venus");
		h.insereHash_EnderecoAberto("marte");
		h.insereHash_EnderecoAberto("saturno");
		h.insereHash_EnderecoAberto("neturno");
		h.insereHash_EnderecoAberto("estrela");
		h.insereHash_EnderecoAberto("mervcurio");
		h.insereHash_EnderecoAberto("terra");
		
		h.insereLinha("lua", 1);
		h.insereLinha("lua", 3);
		h.insereLinha("lua", 5);
		
		h.buscaHash_SemColisão("lua");
		
		System.out.println(h.toString());
	}
	
}
