package py.una.pol.motg.impl;

import py.una.pol.motg.dirigido.Dijkstra;
import py.una.pol.motg.dirigido.SustrateLinkDir;
import py.una.pol.motg.dirigido.SustrateNetworkDir;
import py.una.pol.motg.dirigido.SustrateNodeDir;

public class LinkMapping {
	private SustrateNetworkDir redInterna = new SustrateNetworkDir();

	public SustrateNetworkDir getRedInterna() {
		return redInterna;
	}

	public void setRedInterna(SustrateNetworkDir redInterna) {
		this.redInterna = redInterna;
	}

	public Boolean linkMappingByNode(SustrateNetworkDir redSustrato, SustrateNodeDir nodo1, SustrateNodeDir nodo2) {
		Boolean resp = false;
		try {
			// Lo primero que hacemos es buscar el camino mas corto entre el
			// nodo1 y nodo2
			// Usando el algoritmo de Dijkstra para camino mas corto
			// Buscamos el enlace
			this.redInterna = redSustrato;
			Dijkstra dijkstra = new Dijkstra(redSustrato);
			dijkstra.setNodoDestino(nodo2.getId() - 1);
			if (dijkstra.doDijkstra(nodo1.getId() - 1)) {
				for (Integer i = redSustrato.getListaNodos().size() - 1; i >= 0; i--) {
					SustrateNodeDir nodo = redSustrato.getListaNodos().get(i);
					if (nodo == nodo1) {
						for (Integer j = nodo.getListaEnlaces().size()-1; j >= 0; j--) {
							SustrateLinkDir enlace = nodo.getListaEnlaces().get(j);
							if (enlace.getnodo() == nodo2) {
								// Significa que es el enlace que queremos
								// eliminar
								redInterna.getListaNodos().get(j).getListaEnlaces().remove(enlace);

							}
						}
					} else if (nodo == nodo2) {
						for (Integer j = nodo.getListaEnlaces().size()-1; j >= 0; j--) {
							SustrateLinkDir enlace = nodo.getListaEnlaces().get(j);
							if (enlace.getnodo() == nodo1) {
								// Significa que es el enlace que queremos
								// eliminar
								redInterna.getListaNodos().get(j).getListaEnlaces().remove(enlace);

							}
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return true;
	}
}
