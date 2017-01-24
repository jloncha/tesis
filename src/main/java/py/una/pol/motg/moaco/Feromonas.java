package py.una.pol.motg.moaco;

//Tabla que representa las feromonas
public class Feromonas {
	private Estado estadoOrigen;
	private Estado estadoDestino;
	
	public Feromonas(){
		
	}

	public Estado getEstadoOrigen() {
		return estadoOrigen;
	}

	public void setEstadoOrigen(Estado estadoOrigen) {
		this.estadoOrigen = estadoOrigen;
	}

	public Estado getEstadoDestino() {
		return estadoDestino;
	}

	public void setEstadoDestino(Estado estadoDestino) {
		this.estadoDestino = estadoDestino;
	}
	
}
