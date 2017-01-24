package py.una.pol.motg.moaco;

import java.util.ArrayList;

public class Solucion {
	private ArrayList<Object> coreVector = new ArrayList<Object>();
	
	//Metodo que resetea el vector principal
	public void reset(){
		Integer size = coreVector.size();
		for (Integer i= size; i>0;i--){
			coreVector.remove(i);
		}
	}

	//Geter y seter
	public ArrayList<Object> getCoreVector() {
		return coreVector;
	}

	public void setCoreVector(ArrayList<Object> coreVector) {
		this.coreVector = coreVector;
	}
	
	public void imprimir (){
		for(Object obj : coreVector){
			System.out.println(obj + ", ");
		}
	}

}
