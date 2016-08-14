package py.una.pol.motg.objectimpl;

import java.util.ArrayList;
import java.util.List;


public class SustrateNetwork {
	private List<SustrateNodeImpl> listaNodos;
	public enum TypeNetwork{
		USNET,
		NSFNET
	}
	
	TypeNetwork tipo;
	
	public SustrateNetwork (){
		this.listaNodos = new ArrayList<SustrateNodeImpl>();
	}
	
	public SustrateNetwork (TypeNetwork tipo){
		this.tipo = tipo;
	}

	public List<SustrateNodeImpl> getListaNodos() {
		return listaNodos;
	}
	

	public void setListaNodos(List<SustrateNodeImpl> listaNodos) {
		this.listaNodos = listaNodos;
	}

	public TypeNetwork getTipo() {
		return tipo;
	}

	public void setTipo(TypeNetwork tipo) {
		this.tipo = tipo;
	}
	
	
}
	
	
