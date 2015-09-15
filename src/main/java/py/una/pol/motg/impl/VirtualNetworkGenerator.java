package py.una.pol.motg.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import py.una.pol.motg.objects.SustrateNetwork;

public class VirtualNetworkGenerator{
	SustrateNetwork sustrateNetwork;
	
	/****
	 * Metodo que se encarga de leer las redes virtuales desde el archivo de configuracion
	 * @throws FileNotFoundException 
	 */
	public void getDemands() throws FileNotFoundException{
		BufferedReader buffer = new BufferedReader(new FileReader("file.txt"));
		try {
			String linea = buffer.readLine();
			//Se comprueba que no se haya llegado al final de la linea
			while (linea != null){
				//Se comprueba que no tenga la palabra vd, que indica que es una demanda virtual, que s
				//se convertira en una red virtual
				if(linea.contains("vd")){
					
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
