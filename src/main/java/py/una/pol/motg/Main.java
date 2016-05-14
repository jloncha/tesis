package py.una.pol.motg;

import java.io.FileNotFoundException;

import ilog.concert.IloException;
import ilog.cplex.*;

import java.io.IOException;

import py.una.pol.motg.ilp.ILPSolver;
import py.una.pol.motg.impl.VirtualNetworkGenerator;

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
    	System.out.println("Se inicia el programa principal");
    	VirtualNetworkGenerator generador = new VirtualNetworkGenerator();
    	ILPSolver ilp = new ILPSolver();
    	ilp.instanciar();
    	try {
    		generador.getDemands();
    		generador.selectRedesAleatorio();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    
}
