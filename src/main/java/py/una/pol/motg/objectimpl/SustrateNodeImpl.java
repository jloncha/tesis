package py.una.pol.motg.objectimpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jean Salcedo
 * Clase que abstrae un nodo fisico 
 * 
 */
public class SustrateNodeImpl {
	private Integer id;
	private Integer cpu;
	private Integer cpuDisponible;
	private List<SustrateLinkImp> listaEnlaces;
	

	public SustrateNodeImpl() {
	}

	public SustrateNodeImpl(Integer id, int cpu) {
		this.id = id;
		this.cpu = cpu;
		this.cpuDisponible = cpu;
		this.listaEnlaces = new ArrayList<SustrateLinkImp>();
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

	public List<SustrateLinkImp> getListaEnlaces() {
		return listaEnlaces;
	}

	public void setListaEnlaces(List<SustrateLinkImp> listaEnlaces) {
		this.listaEnlaces = listaEnlaces;
	}
	
	public void addLink (SustrateLinkImp enlace){
		this.listaEnlaces.add(enlace);
	}
	

}
