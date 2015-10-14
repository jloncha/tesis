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
					//Cuando el archivo inicia, tiene un caracter mas (null), por eso esta validacion
					if(linea.length()==4){
						idRedActual = linea.substring(3);
					}
					//Significa que no es inicio de Linea
					else{
						idRedActual = linea.substring(2);
					}
					//Comprobamos que no sea el inicio de una nueva red virtual
					if(!idRedAnterior.equals(idRedActual)){
						//Si empieza una nueva red Virtual, la agregamos a nuestra topologia,
						//e instanciamos una nueva red virtual (nuevo vd)
						redesVirtual.add(redVirtual);
						redVirtual = new VirtualNetwork();
						redVirtual.setIdRedVirtual(Integer.parseInt(idRedActual));
						idRedAnterior = idRedActual;
					}
					//Instanciamos los nodos de la red virtual
					VirtualNode nodoVirtual = new VirtualNode();
					nodoVirtual.setId(Integer.valueOf(buffer.readLine()));
					nodoVirtual.setCpu(Integer.valueOf(buffer.readLine()));
					nodoVirtual.setCpuDisponible(nodoVirtual.getCpu());
					//Procedemos a leer los enlaces
					redVirtual.addNodo(nodoVirtual);
				}
				//Caso de ser un enlace, instanciamos y agregamos a la red virtual
				if(linea.contains("enlace")){
					VirtualLink enlaceVirtual = new VirtualLink();
					VirtualNode nodoOrigen = new VirtualNode();
					linea = buffer.readLine();
					nodoOrigen =redVirtual.getNodoByID(Integer.parseInt(buffer.readLine()));
					enlaceVirtual.setNodoDestino(redVirtual.getNodoByID(Integer.parseInt(buffer.readLine())));  
					enlaceVirtual.setDistancia(Integer.parseInt(buffer.readLine()));
					redVirtual.getNodoByID(nodoOrigen.getId()).addLink(enlaceVirtual);
				}
				
				redVirtual.setIdRedVirtual(Integer.parseInt(idRedActual));
				linea = buffer.readLine(); //Leemos la siguiente linea
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		finally{
			buffer.close();
		}
	}
}
