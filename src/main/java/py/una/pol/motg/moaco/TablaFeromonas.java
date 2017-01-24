package py.una.pol.motg.moaco;

import java.util.ArrayList;
import java.util.List;

public class TablaFeromonas {
	//Unico valor es la tabla dinamica
	List<Feromonas> tablaFeromonas = new ArrayList<Feromonas>();
	
	public TablaFeromonas() {
	}
	
	public void imprimirTabla(){
		for (Feromonas feromona: this.tablaFeromonas){
			//Cambiar por Logger
			System.out.println(feromona.getEstadoOrigen() + " " + feromona.getEstadoDestino());
		}
	}
	
	
	
}
