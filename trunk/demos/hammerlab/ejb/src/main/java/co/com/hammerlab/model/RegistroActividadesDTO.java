package co.com.hammerlab.model;

import java.io.BufferedInputStream;

public class RegistroActividadesDTO {

	private String nroTransaccion;
	
	private String fecha;
	
	private String danio;
	
	private String reparacion;
	
	private String repuesto;
	
	private String observaciones;
	
	private BufferedInputStream firmaAprobacion;
	
	private BufferedInputStream firmaIngeniero;
	
	private BufferedInputStream firmaContratista;

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

	/**
	 * Metodo encargado de obtener el valor de la variable firmaAprobacion
	 * @return el valor de la variable firmaAprobacion 
	 */
	public BufferedInputStream getFirmaAprobacion() {
		return firmaAprobacion;
	}

	/**
	 * Metodo encargado de asignar el valor de parametro firmaAprobacion a la variable firmaAprobacion 
	 * @param firmaAprobacion valor a asignar a la variable almidon
	 */
	public void setFirmaAprobacion(BufferedInputStream firmaAprobacion) {
		this.firmaAprobacion = firmaAprobacion;
	}

	/**
	 * Metodo encargado de obtener el valor de la variable firmaIngeniero
	 * @return el valor de la variable firmaIngeniero 
	 */
	public BufferedInputStream getFirmaIngeniero() {
		return firmaIngeniero;
	}

	/**
	 * Metodo encargado de asignar el valor de parametro firmaIngeniero a la variable firmaIngeniero 
	 * @param firmaIngeniero valor a asignar a la variable almidon
	 */
	public void setFirmaIngeniero(BufferedInputStream firmaIngeniero) {
		this.firmaIngeniero = firmaIngeniero;
	}

	/**
	 * Metodo encargado de obtener el valor de la variable firmaContratista
	 * @return el valor de la variable firmaContratista 
	 */
	public BufferedInputStream getFirmaContratista() {
		return firmaContratista;
	}

	/**
	 * Metodo encargado de asignar el valor de parametro firmaContratista a la variable firmaContratista 
	 * @param firmaContratista valor a asignar a la variable almidon
	 */
	public void setFirmaContratista(BufferedInputStream firmaContratista) {
		this.firmaContratista = firmaContratista;
	}

	/**
	 * Metodo encargado de obtener el valor de la variable observaciones
	 * @return el valor de la variable observaciones 
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * Metodo encargado de asignar el valor de parametro observaciones a la variable observaciones 
	 * @param observaciones valor a asignar a la variable almidon
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
}
