package py.una.pol.motg.objects;

/***
 * 
 * @author Jean
 * Clase que representa un slot de la red EON
 * 
 */
public class EONSlot {
	private Integer idSlot;
	private Integer idFibra;
	private Number frecInicio;  ///representa la minima frecuencia con que inicia el slot
	private Number tamanho; 	///representa el tamanho de la frecuencia
	
	
	public EONSlot() {
	}
	
	public Integer getIdSlot() {
		return idSlot;
	}
	public void setIdSlot(Integer idSlot) {
		this.idSlot = idSlot;
	}
	public Integer getIdFibra() {
		return idFibra;
	}
	public void setIdFibra(Integer idFibra) {
		this.idFibra = idFibra;
	}
	public Number getFrecInicio() {
		return frecInicio;
	}
	public void setFrecInicio(Number frecInicio) {
		this.frecInicio = frecInicio;
	}
	public Number getTamanho() {
		return tamanho;
	}
	public void setTamanho(Number tamanho) {
		this.tamanho = tamanho;
	}
	
}
