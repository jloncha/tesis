package py.una.pol.motg.objectimpl;

public class MapVrVs {

	private Integer mapeado[][];

	public MapVrVs(Integer totalFisico, Integer totalVirtual) {
		this.mapeado = new Integer[totalFisico][totalVirtual];
	}
	
	public Integer[][] getMapeado() {
		return mapeado;
	}

	public void setMapeado(Integer[][] mapeado) {
		this.mapeado = mapeado;
	}

	
	public void setMapear(Integer i,Integer j, Integer valor){
		this.mapeado[i][j] = valor;
	}
	
	public Integer getMapear(Integer i, Integer j){
		return this.mapeado[i][j];
	}
}
