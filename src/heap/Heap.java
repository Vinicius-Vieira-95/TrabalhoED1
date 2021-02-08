package heap;

//Heap Sort
public class Heap {
	
	//atributo
	private int quant = 0; //variavel de controle
	private int vetor[];
	
	public Heap() {
	}
	
	//construtor
	public Heap( int capacidade) {
		this.vetor = new int [capacidade];
	}
	
	public void inserir(int elemento) {
		this.vetor[++quant] = elemento; //primeiro incrementar para começar na posição 1 e 
		                               //tbm para facilitar o calculo de divisão
		subir(quant); //metodo para comparar se filho for maior que o pai.
	}
	
	public void subir(int filho ) {
		int pai = filho / 2; //Pai esta sempre acima do filho
		if(pai >= 1) { // pq existe filho
			if(this.vetor[filho] > this.vetor[pai]) { //verifica-se se filho é maior que pai.
				int aux = this.vetor[pai];
				this.vetor[pai] = this.vetor[filho];
				this.vetor[filho] = aux;
				
				subir(pai); //chamada recursiva
			}
		}
	}
	
	public int remover() {
		
		int retirado = this.vetor[1];
		this.vetor[1] = this.vetor[quant];
		this.quant--;
		descer(1);
		
		return retirado;
	}
	
	public void descer(int pai) {
		int filhoEsq = pai*2; //filho esquerdo
		int filhoDir = (pai*2) + 1; //filho direito
		
		int maior = pai;
		
		if((filhoEsq <= quant) && this.vetor[filhoEsq] > this.vetor[maior]) {
			maior = filhoEsq;
		}
		if((filhoDir <= quant) && this.vetor[filhoDir] > this.vetor[maior]) {
			maior = filhoDir;
		}
		
		if(maior != pai) {
			int aux = this.vetor[pai];
			this.vetor[pai] = this.vetor[maior];
			this.vetor[maior] = aux;
			
			descer(maior); // chamada recursiva
		}
		
	}
	
	public void recberArray(int [] v) {
		this.quant = 0; //reset

		this.vetor = new int[v.length + 1];
		for(int i = 0; i < this.vetor.length - 1; i++) {
			inserir(v[i]);
		}
		
	}
	
	public void imprimirArvoreHeap() {	
		for(int v = 0; v <= quant; v++) {
			if(this.vetor[v] != 0) {
				System.out.print(vetor[v]+" ");
			}
		}
	}
}

