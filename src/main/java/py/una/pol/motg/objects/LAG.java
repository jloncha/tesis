package py.una.pol.motg.objects;

public class LAG {
	private SustrateNetwork redSustrato;	

	public LAG() {
		
	}

	public SustrateNetwork getRedSustrato() {
		return redSustrato;
	}

	public void setRedSustrato(SustrateNetwork redSustrato) {
		this.redSustrato = redSustrato;
	}
	
	public SustrateNetwork generarCapas(Integer n, Integer k) {
		SustrateNetwork resp = new SustrateNetwork();
		resp = this.redSustrato;
		for (SustrateNode nodo : resp.getListaNodos()) {
			for (SustrateLink enlace : nodo.getListaEnlaces()) {
				if (k + n - 1 < enlace.getSlots().size()) {
					for (Integer l = k; l < k + n - 1; l++) {
						if (enlace.getSlots().get(l).isOcupado()) {
							// Significa que el slot esta ocupado
							nodo.getListaEnlaces().remove(enlace);
						}
					}
				}
			}
		}
		return resp;
	}
}
