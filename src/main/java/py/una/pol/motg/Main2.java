package py.una.pol.motg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import py.una.pol.motg.impl.SubstrateNetworkGenerator;
import py.una.pol.motg.objectimpl.EONSlotImpl;
import py.una.pol.motg.objectimpl.LAGImpl;
import py.una.pol.motg.objectimpl.NodeMapping;
import py.una.pol.motg.objectimpl.SustrateLinkImp;
import py.una.pol.motg.objectimpl.SustrateNetworkImpl;
import py.una.pol.motg.objectimpl.SustrateNodeImpl;

/**
 * @author Jean
 *
 */
public class Main2 
{
    public static void main( String[] args ) throws IOException
    { 	
    	SubstrateNetworkGenerator redFisica = new SubstrateNetworkGenerator();
    	NodeMapping nodeMapping = new NodeMapping();
    	boolean asignado = nodeMapping.mapearNodos(redFisica.getNetwork(), redFisica.getVirtualNetwork(), redFisica.getN());
    	System.out.println(asignado);
   
    }
    
    
}
