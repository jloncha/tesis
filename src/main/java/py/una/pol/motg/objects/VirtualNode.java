package py.una.pol.motg.objects;

import java.util.ArrayList;
import java.util.List;

public class VirtualNode {
	
	private Integer id;
	private Integer cpu;
	private Integer cpuDisponible;
	private List<VirtualLink> listaEnlaces;
	
	public VirtualNode() {
		
	}

	public VirtualNode(Integer id, Integer cpu, Integer cpuDisponible) {
		this.id = id;
		this.cpu = cpu;
		this.cpuDisponible = cpuDisponible;
		this.listaEnlaces = new ArrayList<VirtualLink>();
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
	public List<VirtualLink> getListaEnlaces() {
		return listaEnlaces;
	}
	public void setListaEnlaces(List<VirtualLink> listaEnlaces) {
		this.listaEnlaces = listaEnlaces;
	}
	public void addLink(VirtualLink enlaceVirtual){
		this.listaEnlaces.add(enlaceVirtual);
	}
	
	
}
