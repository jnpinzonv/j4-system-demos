package co.com.hammerlab.model;
import java.util.*;
import javax.persistence.*;
import java.io.Serializable;

/**
 * <b>Descripcion:</b> Clase que <br/> se encarga de administrar los datos de un ManualesEquipo
 * <b>Caso de Uso:</b> SOL_MOV- <br/> CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "manuales_equipo")
@NamedQueries({ @NamedQuery(name ="manualesEquipo.getAll" , query = "select s from ManualesEquipo s") })
public class ManualesEquipo implements Serializable{

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
     *  tecnico_confirmar 
     */
     
     
     
     
     
    private boolean tecnico_confirmar;

    
    /**     
     *  tecnico_ubicacion 
     */
     
     
     
     
     
    private String tecnico_ubicacion;

    
    /**     
     *  servicio_confirmar 
     */
     
     
     
     
     
    private Boolean servicio_confirmar;

    
    /**     
     *  servicio_ubicacion 
     */
     
     
     
     
     
    private String servicio_ubicacion;

    
    /**     
     *  usuario_confirmar 
     */
     
     
     
     
     
    private Boolean usuario_confirmar;

    
    /**     
     *  usuario_ubicacion 
     */
     
     
     
     
     
    private String usuario_ubicacion;

    


     

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
      * Devuelve el valor de tecnico_confirmar
      * @return  El valor de tecnico_confirmar 
      */
    public boolean gettecnico_confirmar() {
		return tecnico_confirmar;
    }

    /**
     * Establece el valor de tecnico_confirmar
     * @param tecnico_confirmar
     *        El valor por establecer para  tecnico_confirmar                       
     */
    public void settecnico_confirmar(boolean tecnico_confirmar){
		this.tecnico_confirmar = tecnico_confirmar;
    }

    

    /**
      * Devuelve el valor de tecnico_ubicacion
      * @return  El valor de tecnico_ubicacion 
      */
    public String gettecnico_ubicacion() {
		return tecnico_ubicacion;
    }

    /**
     * Establece el valor de tecnico_ubicacion
     * @param tecnico_ubicacion
     *        El valor por establecer para  tecnico_ubicacion                       
     */
    public void settecnico_ubicacion(String tecnico_ubicacion){
		this.tecnico_ubicacion = tecnico_ubicacion;
    }

    

    /**
      * Devuelve el valor de servicio_confirmar
      * @return  El valor de servicio_confirmar 
      */
    public Boolean getservicio_confirmar() {
		return servicio_confirmar;
    }

    /**
     * Establece el valor de servicio_confirmar
     * @param servicio_confirmar
     *        El valor por establecer para  servicio_confirmar                       
     */
    public void setservicio_confirmar(Boolean servicio_confirmar){
		this.servicio_confirmar = servicio_confirmar;
    }

    

    /**
      * Devuelve el valor de servicio_ubicacion
      * @return  El valor de servicio_ubicacion 
      */
    public String getservicio_ubicacion() {
		return servicio_ubicacion;
    }

    /**
     * Establece el valor de servicio_ubicacion
     * @param servicio_ubicacion
     *        El valor por establecer para  servicio_ubicacion                       
     */
    public void setservicio_ubicacion(String servicio_ubicacion){
		this.servicio_ubicacion = servicio_ubicacion;
    }

    

    /**
      * Devuelve el valor de usuario_confirmar
      * @return  El valor de usuario_confirmar 
      */
    public Boolean getusuario_confirmar() {
		return usuario_confirmar;
    }

    /**
     * Establece el valor de usuario_confirmar
     * @param usuario_confirmar
     *        El valor por establecer para  usuario_confirmar                       
     */
    public void setusuario_confirmar(Boolean usuario_confirmar){
		this.usuario_confirmar = usuario_confirmar;
    }

    

    /**
      * Devuelve el valor de usuario_ubicacion
      * @return  El valor de usuario_ubicacion 
      */
    public String getusuario_ubicacion() {
		return usuario_ubicacion;
    }

    /**
     * Establece el valor de usuario_ubicacion
     * @param usuario_ubicacion
     *        El valor por establecer para  usuario_ubicacion                       
     */
    public void setusuario_ubicacion(String usuario_ubicacion){
		this.usuario_ubicacion = usuario_ubicacion;
    }

    	
}
