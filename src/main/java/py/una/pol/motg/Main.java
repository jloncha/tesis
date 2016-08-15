package py.una.pol.motg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import py.una.pol.motg.impl.SubstrateNetworkGenerator;
import py.una.pol.motg.objectimpl.EONSlotImpl;
import py.una.pol.motg.objectimpl.LAGImpl;
import py.una.pol.motg.objectimpl.SustrateLinkImp;
import py.una.pol.motg.objectimpl.SustrateNetworkImpl;
import py.una.pol.motg.objectimpl.SustrateNodeImpl;

/**
 * @author Jean
 *
 */
public class Main 
{
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
    	
    	SubstrateNetworkGenerator redFisica = new SubstrateNetworkGenerator();
    	/*for (SustrateNodeImpl nodo : redFisica.getNetwork().getListaNodos()) {
    		System.out.println("#################");
    		System.out.println("Nodo " + nodo.getId());
			for (SustrateLinkImp enlaces : nodo.getListaEnlaces()) {
				System.out.println("##########Enlace#############");
				System.out.println(enlaces.getNodos().get(0).getId());
				System.out.println(enlaces.getNodos().get(1).getId());
				
				for (EONSlotImpl slots : enlaces.getSlots()) {
					System.out.println("Slots");
					System.out.println(slots.getIdSlot());
					System.out.println(slots.isOcupado());
				}
			}
		}*/
    	
    	LAGImpl lag = new LAGImpl();
    	lag.setRedSustrato(redFisica.getNetwork());
    	List<SustrateNetworkImpl> lista = new ArrayList<SustrateNetworkImpl>();
    	for (int i = 0; i < redFisica.getB(); i++) {
    		SustrateNetworkImpl capa = lag.generarCapas(1, i + 1);
    		lista.add(capa);
		}
    	
    	int i = 1;
    	for (SustrateNetworkImpl sustrateNetworkImpl : lista) {
    		System.out.println("#################CAPA :" + i);
    		for (SustrateNodeImpl nodo : sustrateNetworkImpl.getListaNodos()) {
        		System.out.println("#################");
        		System.out.println("Nodo " + nodo.getId());
    			for (SustrateLinkImp enlaces : nodo.getListaEnlaces()) {
    				System.out.println("##########Enlace#############");
    				System.out.println(enlaces.getNodos().get(0).getId());
    				System.out.println(enlaces.getNodos().get(1).getId());
    				
    				for (EONSlotImpl slots : enlaces.getSlots()) {
    					System.out.println("Slots");
    					System.out.println(slots.getIdSlot());
    					System.out.println(slots.isOcupado());
    				}
    			}
    		}
    		i = i+1;
		}
    	
    }
    
    
}
