package py.una.pol.motg.objectimpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jean Salcedo
 * Clase que abstrae un nodo fisico 
 * 
 */
public class SustrateNodeImpl implements Comparable<SustrateNodeImpl>{
	private Integer id;
	private Integer cpu;
	private Integer cpuDisponible;
	private Integer laLRC;
	private Integer LRC;
	private List<SustrateLinkImp> listaEnlaces;
	private boolean mapeado;
	
	public SustrateNodeImpl() {
	}

	public SustrateNodeImpl(Integer id, int cpu) {
		this.id = id;
		this.cpu = cpu;
		this.cpuDisponible = cpu;
		this.listaEnlaces = new ArrayList<SustrateLinkImp>();
	}
	
	public Integer getLaLRC() {
		return laLRC;
	}

	public void setLaLRC(Integer laLRC) {
		this.laLRC = laLRC;
	}

	public Integer getLRC() {
		return LRC;
	}

	public void setLRC(Integer lRC) {
		LRC = lRC;
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

	public boolean getMapeado() {
		return mapeado;
	}

	public void setMapeado(boolean mapeado) {
		this.mapeado = mapeado;
	}

	public int compareTo(SustrateNodeImpl sustrate) {
		int cantidadComparada = ((SustrateNodeImpl) sustrate).getLaLRC();
		return this.getLaLRC() - cantidadComparada;
	}
	

}
