package py.una.pol.motg.impl;

import py.una.pol.motg.objectimpl.SustrateLinkImp;
import py.una.pol.motg.objectimpl.SustrateNetworkImpl;
import py.una.pol.motg.objectimpl.SustrateNodeImpl;

public class LinkMapping {
	private SustrateNetworkImpl redInterna = new SustrateNetworkImpl();
	
	public Boolean linkMapping(SustrateNetworkImpl redSustrato, SustrateNodeImpl nodo1, SustrateNodeImpl nodo2){
		Boolean resp = false;
		try{
			//Lo primero que hacemos es buscar el camino mas corto entre el nodo1 y nodo2
			//Usando el algoritmo de Dijkstra para camino mas corto
			//Buscamos el enlace
			//Aca tengo que implementar la llamada a Dijkstra
			
			if (resp) {
				for (Integer i = redSustrato.getListaNodos().size() - 1; i >= 0; i--) {
					SustrateNodeImpl nodo = redSustrato.getListaNodos().get(i);
					if (nodo == nodo1 || nodo == nodo2) {
						for (Integer j = nodo.getListaEnlaces().size(); j >= 0; i--) {
							SustrateLinkImp enlace = nodo.getListaEnlaces().get(j);
							if (enlace.getNodos().contains(nodo1) && enlace.getNodos().contains(nodo2)) {
								// Significa que es el enlace que queremos
								// eliminar
								redSustrato.getListaNodos().get(i).getListaEnlaces().remove(enlace);
							}
						}
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return resp;
	}
}
