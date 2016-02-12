package py.una.pol.motg.objects;
/****
 * 
 * @author Jean
 *	Clase que representa la fibra optica EON
 */

public class Fiber {
	
	private Integer idFiber;
	private Integer capacidad;	
	private Boolean full;
	
	public Fiber() {
	}

	public Integer getIdFiber() {
		return idFiber;
	}

	public void setIdFiber(Integer idFiber) {
		this.idFiber = idFiber;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Boolean getFull() {
		return full;
	}

	public void setFull(Boolean full) {
		this.full = full;
	}
	
	
}
