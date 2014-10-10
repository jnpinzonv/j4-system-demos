package co.com.hammerlab.model;

public class RegistroActividadesDTO {

	private String nroTransaccion;
	
	private String fecha;
	
	private String danio;
	
	private String reparacion;
	
	private String repuesto;
	
	private String interna;
	
	private String costo;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDanio() {
		return danio;
	}

	public void setDanio(String danio) {
		this.danio = danio;
	}

	public String getReparacion() {
		return reparacion;
	}

	public void setReparacion(String reparacion) {
		this.reparacion = reparacion;
	}

	public String getInterna() {
		return interna;
	}

	public void setInterna(String interna) {
		this.interna = interna;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public String getRepuesto() {
		return repuesto;
	}

	public void setRepuesto(String repuesto) {
		this.repuesto = repuesto;
	}

	public String getNroTransaccion() {
		return nroTransaccion;
	}

	public void setNroTransaccion(String nroTransaccion) {
		this.nroTransaccion = nroTransaccion;
	}

}
