package py.una.pol.motg.objects;

import java.util.ArrayList;
import java.util.List;

public class VirtualNetwork {

	private List<SustrateNode> listaNodos;

	public VirtualNetwork() {
		this.listaNodos = new ArrayList<SustrateNode>();
	}

	public List<SustrateNode> getListaNodos() {
		return listaNodos;
	}

	public void setListaNodos(List<SustrateNode> listaNodos) {
		this.listaNodos = listaNodos;
	}
	
}
