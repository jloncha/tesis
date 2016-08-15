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
		Integer aEmpezar = k + n - 1;
		for (int i =this.redSustrato.getListaNodos().size() - 1; i>=0; i--) {
			int totalEnlacesI = this.redSustrato.getListaNodos().get(i).getListaEnlaces().size();
			for (int j=totalEnlacesI - 1; j>=0; j--) {
				if (aEmpezar < this.redSustrato.getListaNodos().get(i).getListaEnlaces().get(j).getSlots().size()) {
					for (Integer l = k; l <= aEmpezar; l++) {
						/*System.out.println("IdNodo "+ this.redSustrato.getListaNodos().get(i).getId());
						System.out.println("IdSlot "+ this.redSustrato.getListaNodos().get(i).getListaEnlaces().get(j).slots.get(l).getIdSlot());
						System.out.println(this.redSustrato.getListaNodos().get(i).getListaEnlaces().get(j).getSlots().get(l).isOcupado());*/
						if (this.redSustrato.getListaNodos().get(i).getListaEnlaces().get(j).getSlots().get(l).isOcupado()) {
							// Significa que el slot esta ocupado
							resp.getListaNodos().get(i).getListaEnlaces().remove(resp.getListaNodos().get(i).getListaEnlaces().get(j));
							break;
						}
					}
				}
			}
		}
		return resp;
	}
}
