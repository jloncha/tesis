package py.una.pol.motg.objectimpl;

import java.util.List;

public class SustrateLinkImp {
	List<SustrateNodeImpl> nodos;
	List<EONSlot> slots;	
	
	public SustrateLinkImp() {

	}
	public List<SustrateNodeImpl> getNodos() {
		return nodos;
	}
	public void setNodos(List<SustrateNodeImpl> nodos) {
		this.nodos = nodos;
	}
	public List<EONSlot> getSlots() {
		return slots;
	}
	public void setSlots(List<EONSlot> slots) {
		this.slots = slots;
	}

	
}
