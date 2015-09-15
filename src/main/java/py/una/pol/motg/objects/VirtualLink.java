package py.una.pol.motg.objects;

public class VirtualLink {
	
	private VirtualNode nodoDestino;
	private Integer distancia;
	
	public VirtualLink() {

	}
	
	public VirtualLink(Integer distancia) {
		this.nodoDestino = new VirtualNode();
		this.distancia = distancia;
	}

	public VirtualNode getNodoDestino() {
		return nodoDestino;
	}
	public void setNodoDestino(VirtualNode nodoDestino) {
		this.nodoDestino = nodoDestino;
	}
	public Integer getDistancia() {
		return distancia;
	}
	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

}
