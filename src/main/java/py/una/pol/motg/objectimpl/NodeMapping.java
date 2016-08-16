package py.una.pol.motg.objectimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NodeMapping {

	public boolean mapearNodos(SustrateNetworkImpl sustrato, SustrateNetworkImpl request, Integer requerimiento){
		List<Boolean> mapeado = new ArrayList<Boolean>();
		SustrateNetworkImpl laLRCsub = calcularLaLRC(sustrato);
		SustrateNetworkImpl lRCvirtual = calcularLRC(request, requerimiento);
		
		for (int i = laLRCsub.getListaNodos().size() - 1 ; i >= 0; i--) {
			System.out.println("id" + laLRCsub.getListaNodos().get(i).getId() + " LaLRC " + laLRCsub.getListaNodos().get(i).getLaLRC());
		}
		for (int i = lRCvirtual.getListaNodos().size() - 1 ; i >= 0; i--) {
			System.out.println("id" + lRCvirtual.getListaNodos().get(i).getId() + " LRC " + lRCvirtual.getListaNodos().get(i).getLaLRC());
		}
		int cont = 0;
		MapVrVs map = new MapVrVs(laLRCsub.getListaNodos().size(), lRCvirtual.getListaNodos().size());
		for (int i = laLRCsub.getListaNodos().size() - 1 ; i >= 0; i--) {
			for (int j = lRCvirtual.getListaNodos().size() - 1 ; j >= 0; j--) {
				map.setMapear(i, j, 0);
			}
		}
		for (int i = lRCvirtual.getListaNodos().size() - 1 ; i >= 0; i--) {
			mapeado.add(false);
			for (int j = laLRCsub.getListaNodos().size() - 1 ; j >= 0; j--) {
				if(!laLRCsub.getListaNodos().get(j).getMapeado()){
					if(laLRCsub.getListaNodos().get(j).getCpu() >= lRCvirtual.getListaNodos().get(i).getCpu() 
							&& laLRCsub.getListaNodos().get(j).getListaEnlaces().size() >= lRCvirtual.getListaNodos().get(i).getListaEnlaces().size()){
						System.out.println("Asigna el nodo sustrato " + laLRCsub.getListaNodos().get(j).getId() +
								" a nodo request " + lRCvirtual.getListaNodos().get(i).getId());
						System.out.println("J " + j + " I " + i);
						map.setMapear(j, i, 1);
						laLRCsub.getListaNodos().get(j).setMapeado(true);
						mapeado.set(cont, true);
						break;
					}
				}
			}
			cont = cont + 1;
		}
		cont = 0;
		for (int i = 0; i < mapeado.size(); i++) {
			if(mapeado.get(i)){
				cont = cont + 1;
			}
		}
		for (int i = laLRCsub.getListaNodos().size() - 1 ; i >= 0; i--) {
			for (int j = lRCvirtual.getListaNodos().size() - 1 ; j >= 0; j--) {
				System.out.println(" I / J " + i + " " +j);
				System.out.println("Valores mapeados " + map.getMapear(i, j));
			}
		}
		
		if(cont == mapeado.size()){
			return true;
		}
		return false;
	}
	
	public SustrateNetworkImpl calcularLaLRC(SustrateNetworkImpl sustratoNetwork){
		//recorro la lista de nodos
		for(int i = 0; i < sustratoNetwork.getListaNodos().size(); i++){
			//capicidad por grado del nodo
			sustratoNetwork.getListaNodos().get(i).setLaLRC(sustratoNetwork.getListaNodos().get(i).getCpu() * 
					sustratoNetwork.getListaNodos().get(i).getListaEnlaces().size());
			sustratoNetwork.getListaNodos().get(i).setMapeado(false);
		}
		Collections.sort(sustratoNetwork.getListaNodos());
		return sustratoNetwork;
	}
	
	public SustrateNetworkImpl calcularLRC(SustrateNetworkImpl request, Integer n){
		//recorro la lista de nodos
		for(int i = 0; i < request.getListaNodos().size(); i++){
			//capicidad por grado del nodo
			request.getListaNodos().get(i).setLaLRC(request.getListaNodos().get(i).getCpu() * n);
		}
		Collections.sort(request.getListaNodos());
		return request;
	}
}
