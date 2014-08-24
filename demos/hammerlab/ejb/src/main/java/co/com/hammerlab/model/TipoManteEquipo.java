package co.com.hammerlab.model;
import java.util.*;
import javax.persistence.*;
import java.io.Serializable;

/**
 * <b>Descripcion:</b> Clase que <br/> se encarga de administrar los datos de un TipoManteEquipo
 * <b>Caso de Uso:</b> SOL_MOV- <br/> CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "tipo_mante_equipo")
@NamedQueries({ @NamedQuery(name ="tipoManteEquipo.getAll" , query = "select s from TipoManteEquipo s") })
public class TipoManteEquipo implements Serializable{

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
     *  tipo_mantenimiento 
     */
     
     
     
     
     
    private String tipo_mantenimiento;

    
    /**     
     *  propio 
     */
     
     
     
     
     
    private Boolean propio;

    
    /**     
     *  contratado 
     */
     
     
     
     
     
    private Boolean contratado;

    
    /**     
     *  cual 
     */
     
     
     
     
     
    private String cual;

    


     

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
      * Devuelve el valor de tipo_mantenimiento
      * @return  El valor de tipo_mantenimiento 
      */
    public String gettipo_mantenimiento() {
		return tipo_mantenimiento;
    }

    /**
     * Establece el valor de tipo_mantenimiento
     * @param tipo_mantenimiento
     *        El valor por establecer para  tipo_mantenimiento                       
     */
    public void settipo_mantenimiento(String tipo_mantenimiento){
		this.tipo_mantenimiento = tipo_mantenimiento;
    }

    

    /**
      * Devuelve el valor de propio
      * @return  El valor de propio 
      */
    public Boolean getpropio() {
		return propio;
    }

    /**
     * Establece el valor de propio
     * @param propio
     *        El valor por establecer para  propio                       
     */
    public void setpropio(Boolean propio){
		this.propio = propio;
    }

    

    /**
      * Devuelve el valor de contratado
      * @return  El valor de contratado 
      */
    public Boolean getcontratado() {
		return contratado;
    }

    /**
     * Establece el valor de contratado
     * @param contratado
     *        El valor por establecer para  contratado                       
     */
    public void setcontratado(Boolean contratado){
		this.contratado = contratado;
    }

    

    /**
      * Devuelve el valor de cual
      * @return  El valor de cual 
      */
    public String getcual() {
		return cual;
    }

    /**
     * Establece el valor de cual
     * @param cual
     *        El valor por establecer para  cual                       
     */
    public void setcual(String cual){
		this.cual = cual;
    }

    	
}
