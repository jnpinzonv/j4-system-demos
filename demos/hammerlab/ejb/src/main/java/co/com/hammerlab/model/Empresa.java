package co.com.hammerlab.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * <b>Descripcion:</b> Clase que <br/> se encarga de administrar los datos de un Empresa
 * <b>Caso de Uso:</b> SOL_MOV- <br/> CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "empresa")
@NamedQueries({ @NamedQuery(name ="empresa.getAll" , query = "select s from Empresa s") })
public class Empresa implements Serializable{

    /**
     * representa el identificador de Serializacion
     */
    private static final long serialVersionUID = 1L;

	
    
    /**     
     *  id 
     */
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO) 
     
     
     
    private Long id;

    
    /**     
     *  razonSocial 
     */
     
     
     
     
     
    private String razonSocial;

    
    /**     
     *  nit 
     */
     
     
     
     
     
    private Integer nit;

    
    /**     
     *  telefono 
     */
     
     
     
     
     
    private String telefono;

    
    /**     
     *  direccion 
     */
     
     
     
     
     
    private String direccion;

    
    /**     
     *  correoElectronico 
     */
     
     
     
     
     
    private String correoElectronico;

    
    /**     
     *  correoElectronico 
     */
     
     
     
     
     
    private String sitioWeb;


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return razonSocial;
	}


	/**
	 * @param razonSocial the razonSocial to set
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


	/**
	 * @return the nit
	 */
	public Integer getNit() {
		return nit;
	}


	/**
	 * @param nit the nit to set
	 */
	public void setNit(Integer nit) {
		this.nit = nit;
	}


	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}


	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}


	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	/**
	 * @return the correoElectronico
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}


	/**
	 * @param correoElectronico the correoElectronico to set
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	/**
	 * @return the sitioWeb
	 */
	public String getSitioWeb() {
		return sitioWeb;
	}


	/**
	 * @param sitioWeb the sitioWeb to set
	 */
	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

    


     

 

    

    

    	
}
