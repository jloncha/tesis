package py.una.pol.motg.objects;

import java.util.ArrayList;
import java.util.List;

public class VirtualNetwork {

	private List<VirtualNode> listaNodos;
	

	public VirtualNetwork() {
		this.listaNodos = new ArrayList<VirtualNode>();
	}

	public List<VirtualNode> getListaNodos() {
		return listaNodos;
	}

	public void setListaNodos(List<VirtualNode> listaNodos) {
		this.listaNodos = listaNodos;
	}
	
	public void addNodo(VirtualNode nodoVirtual){
		this.listaNodos.add(nodoVirtual);
	}
	
	public VirtualNode getNodoByID(Integer id){
		VirtualNode resp = new VirtualNode();
		for (VirtualNode e: this.listaNodos){
			if (e.getId()==id ){
				return e;
			}
		}
		return resp;

	}
}
