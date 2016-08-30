package py.una.pol.motg.principal;

import java.util.List;

import py.una.pol.motg.dirigido.Conectado;
import py.una.pol.motg.dirigido.LAGDir;
import py.una.pol.motg.dirigido.MapVRDir;
import py.una.pol.motg.dirigido.NodeMappingDir;
import py.una.pol.motg.dirigido.ObtenerConectados;
import py.una.pol.motg.dirigido.RespLinkMapping;
import py.una.pol.motg.dirigido.SustrateLinkDir;
import py.una.pol.motg.dirigido.SustrateNetworkDir;
import py.una.pol.motg.dirigido.SustrateNodeDir;
import py.una.pol.motg.dirigido.VirtualLinkDir;
import py.una.pol.motg.dirigido.VirtualNetworkDir;
import py.una.pol.motg.dirigido.VirtualNodeDir;
import py.una.pol.motg.impl.LinkMapping;

public class LaLrcLaSp {

	private SustrateNetworkDir temporal;
	private Integer b;
	private Integer n;
	
	public LaLrcLaSp(Integer b, Integer n) {
		temporal = new SustrateNetworkDir();
		this.b = b;
		this.n = n;
	}

	public SustrateNetworkDir getTemporal() {
		return temporal;
	}


	public void setTemporal(SustrateNetworkDir temporal) {
		this.temporal = temporal;
	}


	public Integer getB() {
		return b;
	}


	public void setB(Integer b) {
		this.b = b;
	}


	public Integer getN() {
		return n;
	}


	public void setN(Integer n) {
		this.n = n;
	}


	public void resultado(SustrateNetworkDir network, VirtualNetworkDir virtualNetwork){
		temporal.setListaNodos(network.getListaNodos());
		Integer totalRecorrer = this.b - this.n + 1;
		boolean asignado  = false;
		RespLinkMapping resp = new RespLinkMapping();
		for(int k = 0; k<= totalRecorrer; k++){
			LAGDir lag = new LAGDir();
        	lag.setRedSustrato(network);
        	SustrateNetworkDir capa = lag.generarCapas(this.n, k);
        	
        	ObtenerConectados conectado = new ObtenerConectados();
        	List<Conectado> conectados = conectado.obtener(capa, virtualNetwork.getNodos().size());
        	for (int i = conectados.size() - 1; i >= 0; i--) {
        		NodeMappingDir nodeMapping = new NodeMappingDir();
            	asignado = nodeMapping.mapearNodos(capa, virtualNetwork, this.n);
            	//nodeMapping.getListaMapeados();
            	for (MapVRDir mapeamiento : nodeMapping.getListaMapeados().getMapRequest()) {
					System.out.println("Nodo Fisico " + mapeamiento.getIdFisico() + " Nodo Virtual " +mapeamiento.getIdRequest());
				}
            	if(asignado){
            		resp = mapearEnlacesCompleto(virtualNetwork, nodeMapping, capa);
            		if (resp.getMapeado()){
            			//Significa que pudo ser mapeado
            			for (SustrateNodeDir nodo  : resp.getRedSustrato().getListaNodos()) {
            				System.out.println("Nodo " + nodo.getId());
            				for (SustrateLinkDir enlaceAux : nodo.getListaEnlaces()) {
            					System.out.println("Enlace de " + nodo.getId() +"-->" + enlaceAux.getnodo().getId());
							}
						}
            			break;
            		}
            	}
			}
        	if(resp.getMapeado()){
        		break;
        	}
        	
        	
		}
	}
	
	/*
	 * Metodo que mapea todos los enlaces de una red virtual
	 * recibiendo la red sustrato, red virtual y los nodos mapeados como parametro como parametro
	 */
	
	public RespLinkMapping mapearEnlacesCompleto(VirtualNetworkDir virtualNetwork, NodeMappingDir nodeMapping,
			SustrateNetworkDir red) {
		LinkMapping mapeoLink = new LinkMapping();
		SustrateNetworkDir capa = new SustrateNetworkDir();
		RespLinkMapping resp = new RespLinkMapping();
		capa = red;
		for (MapVRDir nodo : nodeMapping.getListaMapeados().getMapRequest()) {
			// Recuperar los enlaces virtuales
			// Primero obtenemos todos los nodos de la red virtual
			for (VirtualNodeDir nodoVirtual : virtualNetwork.getNodos()) {
				// Si el nodo virtual es igual al que estamos buscando
				// Buscamos todos sus enlaces
				System.out.println("Nodo Virtual " + nodoVirtual.getId());
				if (nodoVirtual.getId() == nodo.getIdRequest()) {
					// Una vez que tenemos el nodo procedemos a buscar el enlace
					SustrateNodeDir nodo1 = capa.getListaNodos().get(nodo.getIdFisico() - 1);
					SustrateNodeDir nodo2 = new SustrateNodeDir();
					for (VirtualLinkDir enlaceVirtual : nodoVirtual.getListaEnlaces()) {
						// Buscamos el segundo nodo virtual para armar el enlace
						for (MapVRDir nodoMap : nodeMapping.getListaMapeados().getMapRequest()) {
							if (nodoMap.getIdRequest() == enlaceVirtual.getNodoVirtual().getId()) {
								nodo2 = capa.getListaNodos().get(nodoMap.getIdFisico() - 1);
							}
						}
						// Buscamos si se puede mapear, si se mapea tiene true
						Boolean respMapeo = mapeoLink.linkMappingByNode(capa, nodo1, nodo2);
						capa = mapeoLink.getRedInterna();
						resp.setRedSustrato(capa);
						if (!respMapeo) {
							//Si es que no se pudo mapear al menos un  enlace, ya se retorna false
							resp.setMapeado(false);
							
							return resp;
						}
					}

				}
			}

		}
		resp.setMapeado(true);
		resp.setRedSustrato(capa);
		return resp;

	}
	
}
