package py.una.pol.motg.objectimpl;

public class LAGImpl {
	private SustrateNetworkImpl redSustrato;	

	public LAGImpl() {
		
	}

	public SustrateNetworkImpl getRedSustrato() {
		return redSustrato;
	}

	public void setRedSustrato(SustrateNetworkImpl redSustrato) {
		this.redSustrato = redSustrato;
	}
	
	public SustrateNetworkImpl generarCapas(Integer n, Integer k) {
		SustrateNetworkImpl resp = new SustrateNetworkImpl();
		resp.setListaNodos(this.redSustrato.getListaNodos());
		//resp = this.redSustrato;
		//SustrateNetworkImpl aux = resp; 
		for (SustrateNodeImpl nodo : resp.getListaNodos()) {
			for (SustrateLinkImp enlace : nodo.getListaEnlaces()) {
				if (k + n - 1 < enlace.getSlots().size()) {
					for (Integer l = k; l <= k + n - 1; l++) {
						if (enlace.getSlots().get(l).isOcupado()) {
							// Significa que el slot esta ocupado
							//resp.getListaNodos().remove(nodo);
							//nodo.getListaEnlaces().remove(enlace);
							//resp.getListaNodos().add(nodo);
							SustrateNodeImpl nodoAux = new SustrateNodeImpl();
							nodoAux = nodo;
							resp.getListaNodos().remove(nodoAux);
							nodoAux.getListaEnlaces().remove(enlace);
							resp.getListaNodos().add(nodoAux);
						}
					}
				}
			}
		}
		return resp;
	}
}
