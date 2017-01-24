package py.una.pol.motg.moaco;

/***
 * 
 * @author Jean
 * Clase que representa los estados de las hormigas
 */
public class Estado {
	private Integer idEstado;
	private String descripcion;
	private Boolean estadoValido;
	
	public Estado() {
		super();
	}
	public Integer getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Boolean getEstadoValido() {
		return estadoValido;
	}
	public void setEstadoValido(Boolean estadoValido) {
		this.estadoValido = estadoValido;
	}
	
	
	
}
