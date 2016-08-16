package py.una.pol.motg.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import py.una.pol.motg.objectimpl.EONSlotImpl;
import py.una.pol.motg.objectimpl.SustrateLinkImp;
import py.una.pol.motg.objectimpl.SustrateNetworkImpl;
import py.una.pol.motg.objectimpl.SustrateNodeImpl;

public class SubstrateNetworkGenerator {
	
	private SustrateNetworkImpl network = new SustrateNetworkImpl();
	
	private SustrateNetworkImpl virtualNetwork = new SustrateNetworkImpl();
	
	//es el nro total de frecuency slots
	private Integer b;
	
	//nro de slots requeridos por la red virtual
	private Integer n;
	
	public SubstrateNetworkGenerator() throws IOException {
		this.generar();
		this.generarVirtual();
	}

	public SustrateNetworkImpl getNetwork() {
		return network;
	}

	public SustrateNetworkImpl getVirtualNetwork() {
		return virtualNetwork;
	}

	public void setVirtualNetwork(SustrateNetworkImpl virtualNetwork) {
		this.virtualNetwork = virtualNetwork;
	}

	public void setNetwork(SustrateNetworkImpl network) {
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
		List<SustrateNodeImpl> nodos = new ArrayList<SustrateNodeImpl>();
		Integer id = 1;
		try {
			b = Integer.valueOf(buffer.readLine());
			System.out.println("Nro de frecuency slots total B: " + b);
			String linea = buffer.readLine();
			SustrateNodeImpl node1 = null;
			SustrateNodeImpl node2 = null;
			while(linea != null){
				
				String[] datos = linea.split(";");
				node1 = new SustrateNodeImpl(Integer.valueOf(datos[0]), Integer.valueOf(datos[1]));;
				node2 = new SustrateNodeImpl(Integer.valueOf(datos[2]), Integer.valueOf(datos[3]));
				SustrateLinkImp link = new SustrateLinkImp();
				
				for (SustrateNodeImpl node : nodos) {
					if(node.getId() == Integer.valueOf(datos[0])){
						node1 = node;
					}
					if(node.getId() == Integer.valueOf(datos[2])){
						node2 = node;
					}
				}
				link.getNodos().add(node1);
				link.getNodos().add(node2);
				
				List<EONSlotImpl> slots = new ArrayList<EONSlotImpl>();
				//el valor del 4 se definio de acuerdo a nuestro archivo si modificamos el archivo a n hay que cambiar este valor
				//Integer idSlot =1;
				for (int i = 4; i < b + 4; i++) {
					
					EONSlotImpl slot = new EONSlotImpl();
					slot.setIdSlot(id);
					slot.setOcupado(Boolean.valueOf(datos[i]));
					slots.add(slot);
					id = id + 1;
					//idSlot = idSlot + 1;
				}
				link.setSlots(slots);
				if(nodos.contains(node1)){
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
			
			network.setListaNodos(nodos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			buffer.close();
		}
	}
	
	public void generarVirtual() throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader("src\\main\\java\\requerimientos\\VON.txt"));
		List<SustrateNodeImpl> nodos = new ArrayList<SustrateNodeImpl>();
		try {
			n = Integer.valueOf(buffer.readLine());
			this.setN(n);
			System.out.println("Nro de frecuency slots requerido N: " + n);
			String linea = buffer.readLine();
			SustrateNodeImpl node1 = null;
			SustrateNodeImpl node2 = null;
			while(linea != null){
				
				String[] datos = linea.split(";");
				node1 = new SustrateNodeImpl(Integer.valueOf(datos[0]), Integer.valueOf(datos[1]));;
				node2 = new SustrateNodeImpl(Integer.valueOf(datos[2]), Integer.valueOf(datos[3]));
				SustrateLinkImp link = new SustrateLinkImp();
				
				for (SustrateNodeImpl node : nodos) {
					if(node.getId() == Integer.valueOf(datos[0])){
						node1 = node;
					}
					if(node.getId() == Integer.valueOf(datos[2])){
						node2 = node;
					}
				}
				link.getNodos().add(node1);
				link.getNodos().add(node2);
				
				/*List<EONSlotImpl> slots = new ArrayList<EONSlotImpl>();
				//el valor del 4 se definio de acuerdo a nuestro archivo si modificamos el archivo a n hay que cambiar este valor
				//Integer idSlot =1;
				for (int i = 4; i < b + 4; i++) {
					
					EONSlotImpl slot = new EONSlotImpl();
					slot.setIdSlot(id);
					slot.setOcupado(Boolean.valueOf(datos[i]));
					slots.add(slot);
					id = id + 1;
					//idSlot = idSlot + 1;
				}
				link.setSlots(slots);*/
				if(nodos.contains(node1)){
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
	}
}
