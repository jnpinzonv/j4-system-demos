package co.com.hammerlab.model;
import java.util.*;
import javax.persistence.*;
import java.io.Serializable;

/**
 * <b>Descripcion:</b> Clase que <br/> se encarga de administrar los datos de un EstadoEquipo
 * <b>Caso de Uso:</b> SOL_MOV- <br/> CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "estado_equipo")
@NamedQueries({ @NamedQuery(name ="estadoEquipo.getAll" , query = "select s from EstadoEquipo s") })
public class EstadoEquipo implements Serializable{

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
     *  estado_confirmar 
     */
     
     
     
     
     
    private String estado_confirmar;

    
    /**     
     *  causa 
     */
     
     
     
     
     
    private String causa;

    


     

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
      * Devuelve el valor de estado_confirmar
      * @return  El valor de estado_confirmar 
      */
    public String getestado_confirmar() {
		return estado_confirmar;
    }

    /**
     * Establece el valor de estado_confirmar
     * @param estado_confirmar
     *        El valor por establecer para  estado_confirmar                       
     */
    public void setestado_confirmar(String estado_confirmar){
		this.estado_confirmar = estado_confirmar;
    }

    

    /**
      * Devuelve el valor de causa
      * @return  El valor de causa 
      */
    public String getcausa() {
		return causa;
    }

    /**
     * Establece el valor de causa
     * @param causa
     *        El valor por establecer para  causa                       
     */
    public void setcausa(String causa){
		this.causa = causa;
    }

    	
}
