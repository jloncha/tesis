package py.una.pol.motg.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import py.una.pol.motg.objects.SustrateNetwork;
import py.una.pol.motg.objects.VirtualLink;
import py.una.pol.motg.objects.VirtualNetwork;
import py.una.pol.motg.objects.VirtualNode;

public class VirtualNetworkGenerator{
	SustrateNetwork sustrateNetwork;
	VirtualNetwork redVirtual;
	List<VirtualNode> listaNodos = new ArrayList<VirtualNode>();
	
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
					
					VirtualNode nodoVirtual = new VirtualNode();
					nodoVirtual.setCpu(Integer.valueOf(buffer.readLine()));
					nodoVirtual.setCpuDisponible(nodoVirtual.getCpu());
					//Procedemos a leer los enlaces
					if(linea.contains("enlace")){
						VirtualLink enlaceVirtual = new VirtualLink();
						VirtualNode nodoOrigen = new VirtualNode();
						nodoOrigen = redVirtual.getNodoByID(Integer.parseInt(buffer.readLine()));
						enlaceVirtual.setNodoDestino(redVirtual.getNodoByID(Integer.parseInt(buffer.readLine()))); 
						enlaceVirtual.setDistancia(Integer.parseInt(buffer.readLine()));
						nodoOrigen.addLink(enlaceVirtual);
					}
					redVirtual.addNodo(nodoVirtual);
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
