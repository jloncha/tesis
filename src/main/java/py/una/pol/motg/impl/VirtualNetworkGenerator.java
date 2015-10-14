package py.una.pol.motg.impl;

import java.io.BufferedReader;
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
	List<VirtualNetwork> redesVirtual = new ArrayList<VirtualNetwork>();
	List<VirtualNode> listaNodos = new ArrayList<VirtualNode>();
	
	/****
	 * Metodo que se encarga de leer las redes virtuales desde el archivo de configuracion
	 * @throws IOException 
	 */
	public void getDemands() throws IOException{
		BufferedReader buffer = new BufferedReader(new FileReader("src\\main\\java\\requerimientos\\NodosVirtuales.txt"));
		String idRedAnterior = "0";
		String idRedActual = "0";
		try {
			String linea = buffer.readLine();
			VirtualNetwork redVirtual = new VirtualNetwork();
			//Se comprueba que no se haya llegado al final de la linea
			while (linea != null){
				//Se comprueba que no tenga la palabra vd, que indica que es una demanda virtual, que s
				//se convertira en una red virtual
				if(linea.contains("vd")){
					if(linea.length()==4){
						idRedActual = linea.substring(3);
					}
					else{
						idRedActual = linea.substring(2);
					}
					if(!idRedAnterior.equals(idRedActual)){
						redesVirtual.add(redVirtual);
						redVirtual = new VirtualNetwork();
						redVirtual.setIdRedVirtual(Integer.parseInt(idRedActual));
						idRedAnterior = idRedActual;
					}
					/*if(!idRedAnterior.equals(linea.substring(3))){
						redVirtual = new VirtualNetwork();
						redVirtual.setIdRedVirtual(Integer.parseInt(linea.substring(3)));
					}*/
					VirtualNode nodoVirtual = new VirtualNode();
					nodoVirtual.setId(Integer.valueOf(buffer.readLine()));
					nodoVirtual.setCpu(Integer.valueOf(buffer.readLine()));
					nodoVirtual.setCpuDisponible(nodoVirtual.getCpu());
					//Procedemos a leer los enlaces
					redVirtual.addNodo(nodoVirtual);
				}
				if(linea.contains("enlace")){
					VirtualLink enlaceVirtual = new VirtualLink();
					VirtualNode nodoOrigen = new VirtualNode();
					linea = buffer.readLine();
					nodoOrigen =redVirtual.getNodoByID(Integer.parseInt(buffer.readLine()));
					enlaceVirtual.setNodoDestino(redVirtual.getNodoByID(Integer.parseInt(buffer.readLine()))); 
					//nodoOrigen = redesVirtual.getNodoByID(Integer.parseInt(buffer.readLine()));
					//enlaceVirtual.setNodoDestino(redesVirtual.getNodoByID(Integer.parseInt(buffer.readLine()))); 
					enlaceVirtual.setDistancia(Integer.parseInt(buffer.readLine()));
					redVirtual.getNodoByID(nodoOrigen.getId()).addLink(enlaceVirtual);
					//redesVirtual.getNodoByID(nodoOrigen.getId()).addLink(enlaceVirtual);
				}
				
				linea = buffer.readLine();
				/*if(!idRedActual.equals(idRedAnterior)){
					redVirtual.setIdRedVirtual(Integer.parseInt(idRedAnterior));
					redesVirtual.add(redVirtual);
					redVirtual = new VirtualNetwork();
					redVirtual.setIdRedVirtual(Integer.parseInt(idRedActual));
					idRedAnterior = idRedActual;
				}*/
				
			}
			
			for (VirtualNode e: redesVirtual.get(0).getListaNodos()){
				System.out.println(e.getId());
				System.out.println(e.getCpu());
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		finally{
			buffer.close();
		}
	}
}
