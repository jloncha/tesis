package py.una.pol.motg.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jean Salcedo
 * Clase que abstrae un nodo fisico 
 * 
 */
public class SustrateNode {
	private Integer id;
	private Integer cpu;
	private Integer cpuDisponible;
	private List<SustrateLink> listaEnlaces;

	public SustrateNode() {
	}

	public SustrateNode(Integer id, int cpu) {
		this.id = id;
		this.cpu = cpu;
		this.cpuDisponible = cpu;
		this.listaEnlaces = new ArrayList<SustrateLink>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCpu() {
		return cpu;
	}

	public void setCpu(Integer cpu) {
		this.cpu = cpu;
	}

	public Integer getCpuDisponible() {
		return cpuDisponible;
	}

	public void setCpuDisponible(Integer cpuDisponible) {
		this.cpuDisponible = cpuDisponible;
	}

	public List<SustrateLink> getListaEnlaces() {
		return listaEnlaces;
	}

	public void setListaEnlaces(List<SustrateLink> listaEnlaces) {
		this.listaEnlaces = listaEnlaces;
	}
	
	public void addLink (SustrateLink enlace){
		this.listaEnlaces.add(enlace);
	}
	

}
