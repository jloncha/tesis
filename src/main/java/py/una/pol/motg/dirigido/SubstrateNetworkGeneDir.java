package py.una.pol.motg.dirigido;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SubstrateNetworkGeneDir {
	
	private SustrateNetworkDir network = new SustrateNetworkDir();
	
	private SustrateNetworkDir virtualNetwork = new SustrateNetworkDir();
	
	//es el nro total de frecuency slots
	private Integer b;
	
	//nro de slots requeridos por la red virtual
	private Integer n;
	
	public SubstrateNetworkGeneDir() throws IOException {
		this.generar();
	//	this.generarVirtual();
	}

	public SustrateNetworkDir getNetwork() {
		return network;
	}

	public SustrateNetworkDir getVirtualNetwork() {
		return virtualNetwork;
	}

	public void setVirtualNetwork(SustrateNetworkDir virtualNetwork) {
		this.virtualNetwork = virtualNetwork;
	}

	public void setNetwork(SustrateNetworkDir network) {
		this.network = network;
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

	public void generar() throws IOException{
		BufferedReader buffer = new BufferedReader(new FileReader("src\\main\\java\\requerimientos\\SustrateNetwork.txt"));
		List<SustrateNodeDir> nodos = new ArrayList<SustrateNodeDir>();
		Integer id = 1;
		try {
			b = Integer.valueOf(buffer.readLine());
			System.out.println("Nro de frecuency slots total B: " + b);
			String linea = buffer.readLine();
			SustrateNodeDir node1 = null;
			SustrateNodeDir node2 = null;
			while(linea != null){
				
				String[] datos = linea.split(";");
				node1 = new SustrateNodeDir(Integer.valueOf(datos[0]), Integer.valueOf(datos[1]));;
				node2 = new SustrateNodeDir(Integer.valueOf(datos[2]), Integer.valueOf(datos[3]));
				SustrateLinkDir link = new SustrateLinkDir();
				SustrateLinkDir linkDest = new SustrateLinkDir(); //Enlace de Destino a Origen
								
				for (SustrateNodeDir node : nodos) {
					if(node.getId() == Integer.valueOf(datos[0])){
						node1 = node;
					}
					if(node.getId() == Integer.valueOf(datos[2])){
						node2 = node;
					}
				}
				link.setnodo(node2);
				linkDest.setnodo(node1);
				
				List<EONSlotDir> slots = new ArrayList<EONSlotDir>();
				//el valor del 4 se definio de acuerdo a nuestro archivo si modificamos el archivo a n hay que cambiar este valor
				//Integer idSlot =1;
				for (int i = 4; i < b + 4; i++) {
					
					EONSlotDir slot = new EONSlotDir();
					slot.setIdSlot(id);
					slot.setOcupado(Boolean.valueOf(datos[i]));
					slots.add(slot);
					id = id + 1;
					//idSlot = idSlot + 1;
				}
				link.setSlots(slots);
				linkDest.setSlots(slots);
				
				//Actualizamos los nodos que estan en la red sustrato
				if(nodos.contains(node1)){
					//Si es que existe, o sea no es la primera vez, removemos el existente
					nodos.remove(node1);
				}
				if(nodos.contains(node2)){
					nodos.remove(node2);
				}
				
				node1.getListaEnlaces().add(link);
				node2.getListaEnlaces().add(linkDest);
				
				nodos.add(node1);
				nodos.add(node2);
				
				linea = buffer.readLine();
			}
			
			network.setListaNodos(nodos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			buffer.close();
		}
	}
	
	/*public void generarVirtual() throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader("src\\main\\java\\requerimientos\\VON.txt"));
		List<SustrateNodeDir> nodos = new ArrayList<SustrateNodeDir>();
		try {
			n = Integer.valueOf(buffer.readLine());
			this.setN(n);
			System.out.println("Nro de frecuency slots requerido N: " + n);
			String linea = buffer.readLine();
			SustrateNodeDir node1 = null;
			SustrateNodeDir node2 = null;
			while(linea != null){
				
				String[] datos = linea.split(";");
				node1 = new SustrateNodeDir(Integer.valueOf(datos[0]), Integer.valueOf(datos[1]));;
				node2 = new SustrateNodeDir(Integer.valueOf(datos[2]), Integer.valueOf(datos[3]));
				SustrateLinkDir link = new SustrateLinkDir();
				
				for (SustrateNodeDir node : nodos) {
					if(node.getId() == Integer.valueOf(datos[0])){
						node1 = node;
					}
					if(node.getId() == Integer.valueOf(datos[2])){
						node2 = node;
					}
				}
				link.getNodos().add(node1);
				link.getNodos().add(node2);*/
				
				/*List<EONSlotDir> slots = new ArrayList<EONSlotDir>();
				//el valor del 4 se definio de acuerdo a nuestro archivo si modificamos el archivo a n hay que cambiar este valor
				//Integer idSlot =1;
				for (int i = 4; i < b + 4; i++) {
					
					EONSlotDir slot = new EONSlotDir();
					slot.setIdSlot(id);
					slot.setOcupado(Boolean.valueOf(datos[i]));
					slots.add(slot);
					id = id + 1;
					//idSlot = idSlot + 1;
				}
				link.setSlots(slots);*/
				/*if(nodos.contains(node1)){
					nodos.remove(node1);
				}
				if(nodos.contains(node2)){
					nodos.remove(node2);
				}
				node1.addLink(link);
				node2.addLink(link);

				nodos.add(node1);
				nodos.add(node2);
				
				linea = buffer.readLine();
			}
			
			virtualNetwork.setListaNodos(nodos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			buffer.close();
		}
	}*/
}
