package lista;

public class NoDuplamenteEncadeado {

	private NoDuplamenteEncadeado prox; // apontara para o proximo endereço de memoria
	private NoDuplamenteEncadeado ant; //apontará para o enederço anterio no endereço de meroria
	private Object elemento; //tipo de Objeto
	
	public NoDuplamenteEncadeado(){
	}
	
	public NoDuplamenteEncadeado getProx() {
		return prox;
	}
	public void setProx(NoDuplamenteEncadeado prox) {
		this.prox = prox;
	}
	
	public NoDuplamenteEncadeado getAnt() {
		return ant;
	}

	public void setAnt(NoDuplamenteEncadeado ant) {
		this.ant = ant;
	}

	public Object getElemento() {
		return elemento;
	}
	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}

	@Override
	public String toString() {
		return  (String) elemento;
	}
	
}
