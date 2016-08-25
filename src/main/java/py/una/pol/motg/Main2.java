package py.una.pol.motg;

import java.io.IOException;

import py.una.pol.motg.dirigido.ObtenerConectados;
import py.una.pol.motg.dirigido.SubstrateNetworkGeneDir;
import py.una.pol.motg.dirigido.SustrateLinkDir;
import py.una.pol.motg.dirigido.SustrateNodeDir;

/**
 * @author Jean
 *
 */
public class Main2 
{
    public static void main( String[] args ) throws IOException
    { 	
    	SubstrateNetworkGeneDir redFisica = new SubstrateNetworkGeneDir();
    	/*NodeMapping nodeMapping = new NodeMapping();
    	/*boolean asignado = nodeMapping.mapearNodos(redFisica.getNetwork(), redFisica.getVirtualNetwork(), redFisica.getN());
    	System.out.println(asignado);*/
    	
    	/*for (SustrateNodeDir nodo : redFisica.getNetwork().getListaNodos()) {
    		System.out.println("#################");
    		System.out.println("Nodo " + nodo.getId());
			for (SustrateLinkDir enlaces : nodo.getListaEnlaces()) {
				System.out.println("##########Enlace#############");
				System.out.println("ID nodo destino " + enlaces.getnodo().getId());
			}
   
    	}*/
    	ObtenerConectados conectados = new ObtenerConectados();
    	conectados.obtener(redFisica.getNetwork());
    }
    
}
