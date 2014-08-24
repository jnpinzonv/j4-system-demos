package co.com.hammerlab.model;
import java.util.*;
import javax.persistence.*;
import java.io.Serializable;

/**
 * <b>Descripcion:</b> Clase que <br/> se encarga de administrar los datos de un RecomendacionesEquipo
 * <b>Caso de Uso:</b> SOL_MOV- <br/> CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "recomendaciones_equipo")
@NamedQueries({ @NamedQuery(name ="recomendacionesEquipo.getAll" , query = "select s from RecomendacionesEquipo s") })
public class RecomendacionesEquipo implements Serializable{

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
     *  detalle 
     */
     
     
     
     
     
    private String detalle;

    


     

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
      * Devuelve el valor de detalle
      * @return  El valor de detalle 
      */
    public String getdetalle() {
		return detalle;
    }

    /**
     * Establece el valor de detalle
     * @param detalle
     *        El valor por establecer para  detalle                       
     */
    public void setdetalle(String detalle){
		this.detalle = detalle;
    }

    	
}
