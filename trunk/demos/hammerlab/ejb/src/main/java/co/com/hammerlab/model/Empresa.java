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
     *  sitioWeb 
     */
     
     
     
     
     
    private String sitioWeb;

    


     

    /**
      * Devuelve el valor de id
      * @return  El valor de id 
      */
    public Long getid() {
		return id;
    }

    /**
     * Establece el valor de id
     * @param id
     *        El valor por establecer para  id                       
     */
    public void setid(Long id){
		this.id = id;
    }

    

    /**
      * Devuelve el valor de razonSocial
      * @return  El valor de razonSocial 
      */
    public String getrazonSocial() {
		return razonSocial;
    }

    /**
     * Establece el valor de razonSocial
     * @param razonSocial
     *        El valor por establecer para  razonSocial                       
     */
    public void setrazonSocial(String razonSocial){
		this.razonSocial = razonSocial;
    }

    

    /**
      * Devuelve el valor de nit
      * @return  El valor de nit 
      */
    public Integer getnit() {
		return nit;
    }

    /**
     * Establece el valor de nit
     * @param nit
     *        El valor por establecer para  nit                       
     */
    public void setnit(Integer nit){
		this.nit = nit;
    }

    

    /**
      * Devuelve el valor de telefono
      * @return  El valor de telefono 
      */
    public String gettelefono() {
		return telefono;
    }

    /**
     * Establece el valor de telefono
     * @param telefono
     *        El valor por establecer para  telefono                       
     */
    public void settelefono(String telefono){
		this.telefono = telefono;
    }

    

    /**
      * Devuelve el valor de direccion
      * @return  El valor de direccion 
      */
    public String getdireccion() {
		return direccion;
    }

    /**
     * Establece el valor de direccion
     * @param direccion
     *        El valor por establecer para  direccion                       
     */
    public void setdireccion(String direccion){
		this.direccion = direccion;
    }

    

    /**
      * Devuelve el valor de correoElectronico
      * @return  El valor de correoElectronico 
      */
    public String getcorreoElectronico() {
		return correoElectronico;
    }

    /**
     * Establece el valor de correoElectronico
     * @param correoElectronico
     *        El valor por establecer para  correoElectronico                       
     */
    public void setcorreoElectronico(String correoElectronico){
		this.correoElectronico = correoElectronico;
    }

    

    /**
      * Devuelve el valor de sitioWeb
      * @return  El valor de sitioWeb 
      */
    public String getsitioWeb() {
		return sitioWeb;
    }

    /**
     * Establece el valor de sitioWeb
     * @param sitioWeb
     *        El valor por establecer para  sitioWeb                       
     */
    public void setsitioWeb(String sitioWeb){
		this.sitioWeb = sitioWeb;
    }

    	
}
