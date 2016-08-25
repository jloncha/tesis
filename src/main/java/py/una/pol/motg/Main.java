package py.una.pol.motg;

import java.io.IOException;

import py.una.pol.motg.dirigido.Dijkstra;
import py.una.pol.motg.dirigido.LAGDir;
import py.una.pol.motg.dirigido.SubstrateNetworkGeneDir;
import py.una.pol.motg.dirigido.SustrateLinkDir;
import py.una.pol.motg.dirigido.SustrateNetworkDir;
import py.una.pol.motg.dirigido.SustrateNodeDir;

/**
 * @author Jean
 *
 */
public class Main {
	
    public static void main( String[] args ) throws IOException
    {
        //Clase principal
    	//Primero que nada, se debe definir que red de sustrato vamos a usar
    	/*9System.out.println("Se inicia el programa principal");
    	VirtualNetworkGenerator generador = new VirtualNetworkGenerator();
    	try {
    		generador.getDemands();
    		generador.selectRedesAleatorio();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();*/
    	
    	SubstrateNetworkGeneDir redFisica = new SubstrateNetworkGeneDir();
    	Dijkstra dikjstra = new Dijkstra(redFisica.getNetwork());
    	dikjstra.doDijkstra(1);
    	
    	/*for (SustrateNodeDir nodo : redFisica.getNetwork().getListaNodos()) {
    		System.out.println("#################");
    		System.out.println("Nodo " + nodo.getId());
			for (SustrateLinkDir enlaces : nodo.getListaEnlaces()) {
				System.out.println("##########Enlace#############");
				System.out.println(enlaces.getnodo().getId());
				//System.out.println(enlaces.getNodos().get(1).getId());
				
				for (EONSlotDir slots : enlaces.getSlots()) {
					System.out.println("Slots");
					System.out.println(slots.getIdSlot());
					System.out.println(slots.isOcupado());
				}
			}
		}*/
    	
    	
    	/*List<SustrateNetworkImpl> lista = new ArrayList<SustrateNetworkImpl>();
    	for (int i = 0; i < redFisica.getB(); i++) {*/
    		/*LAGDir lag = new LAGDir();
        	lag.setRedSustrato(redFisica.getNetwork());
        	//k se le pasa uno menos del que se quiere porque en java en indice empieza en 0
    		SustrateNetworkDir capa = lag.generarCapas(2, 1);
    		/*lista.add(capa);
		}*/
    	
    	/*int i = 1;
    	for (SustrateNetworkDir sustrateNetworkImpl : lista) {
    		System.out.println("#################CAPA :" + i);
    		for (SustrateNodeDir nodo : capa.getListaNodos()) {
        		System.out.println("#################");
        		System.out.println("Nodo " + nodo.getId());
    			for (SustrateLinkDir enlaces : nodo.getListaEnlaces()) {
    				System.out.println("##########Enlace#############");
    				System.out.println(enlaces.getnodo().getId());
    				
    				/*for (EONSlotImpl slots : enlaces.getSlots()) {
    					System.out.println("Slots");
    					System.out.println(slots.getIdSlot());
    					System.out.println(slots.isOcupado());
    				}
    			}
    		}*/
    		/*i = i+1;
		}*/
    	
    }
    
    
}
