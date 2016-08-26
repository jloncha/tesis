package py.una.pol.motg.principal;

import java.util.List;

import py.una.pol.motg.dirigido.Conectado;
import py.una.pol.motg.dirigido.LAGDir;
import py.una.pol.motg.dirigido.NodeMappingDir;
import py.una.pol.motg.dirigido.ObtenerConectados;
import py.una.pol.motg.dirigido.SustrateNetworkDir;
import py.una.pol.motg.dirigido.VirtualNetworkDir;

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
		for(int k = 0; k<= totalRecorrer; k++){
			LAGDir lag = new LAGDir();
        	lag.setRedSustrato(network);
        	SustrateNetworkDir capa = lag.generarCapas(this.n, k);
        	
        	ObtenerConectados conectado = new ObtenerConectados();
        	List<Conectado> conectados = conectado.obtener(capa, virtualNetwork.getNodos().size());
        	for (int i = conectados.size() - 1; i >= 0; i--) {
        		NodeMappingDir nodeMapping = new NodeMappingDir();
            	asignado = nodeMapping.mapearNodos(network, virtualNetwork, this.n);
            	nodeMapping.getListaMapeados();
            	if(asignado){
            			//llamar a la funcion de jean descomponiendo el request virtual
            			/*devolver un boolean
            			dentro de la clase tener como quedo finalmente
            			idfisico - idvirtual - camino - indice donde empieza el k slot
            			if(exitoCompleto){
            				imprimir valores
            				return succes;
            			}*/
            	}
			}
        	
        	
		}
	}
	
}
