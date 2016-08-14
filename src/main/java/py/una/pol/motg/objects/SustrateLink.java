package py.una.pol.motg.objects;

import java.util.List;

/**
 * @author Jean Salcedo
 * Clase que representa un enlace en la red de Sustrato
 * 
 */
public class SustrateLink {
	private SustrateNode nodoDestino;
	private Integer distancia;
	private List<EONSlot> slots;

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

	public List<EONSlot> getSlots() {
		return slots;
	}

	public void setSlots(List<EONSlot> slots) {
		this.slots = slots;
	}

	
}
