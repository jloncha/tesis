package py.una.pol.motg.objects;

/**
 * @author Jean Salcedo
 * Clase que representa un enlace en la red de Sustrato
 * 
 */
public class SustrateLink {
	private SustrateNode nodoDestino;
	private Integer distancia;

	public SustrateLink() {
	}
	
	public SustrateLink(SustrateNode nodoDestino, Integer distancia){
		this.nodoDestino = nodoDestino;
		this.distancia = distancia;
	}

	public SustrateLink (Integer distancia){
		this.nodoDestino = new SustrateNode();
		this.distancia = distancia;
	}

	public SustrateNode getNodoDestino() {
		return nodoDestino;
	}

	public void setNodoDestino(SustrateNode nodoDestino) {
		this.nodoDestino = nodoDestino;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}
	
	
}
