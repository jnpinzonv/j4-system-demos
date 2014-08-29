package co.com.hammerlab.model;
import java.util.*;
import javax.persistence.*;
import java.io.Serializable;

/**
 * <b>Descripcion:</b> Clase que <br/> se encarga de administrar los datos de un PlanosEquipo
 * <b>Caso de Uso:</b> SOL_MOV- <br/> CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "planos_equipo")
@NamedQueries({ @NamedQuery(name ="planosEquipo.getAll" , query = "select s from PlanosEquipo s") })
public class PlanosEquipo implements Serializable{

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
     *  instalacion_confirmar 
     */
   private Boolean instalacion_confirmar;

    
    /**     
     *  instalacion_ubicacion 
     */
     
     
     
     
     
    private String instalacion_ubicacion;

    
    /**     
     *  partes_confirmar 
     */
     
     
     
     
     
    private Boolean partes_confirmar;

    
    /**     
     *  partes_ubicacion 
     */
     
     
     
     
     
    private String partes_ubicacion;

    
    /**     
     *  funcionamiento_confirmar 
     */
     
     
     
     
     
    private boolean funcionamiento_confirmar;

    
    /**     
     *  funcionamiento_ubicacion 
     */
     
     
     
     
     
    private String funcionamiento_ubicacion;

    


     

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
      * Devuelve el valor de instalacion_confirmar
      * @return  El valor de instalacion_confirmar 
      */
    public Boolean getinstalacion_confirmar() {
		return instalacion_confirmar;
    }

    /**
     * Establece el valor de instalacion_confirmar
     * @param instalacion_confirmar
     *        El valor por establecer para  instalacion_confirmar                       
     */
    public void setinstalacion_confirmar(Boolean instalacion_confirmar){
		this.instalacion_confirmar = instalacion_confirmar;
    }

    

    /**
      * Devuelve el valor de instalacion_ubicacion
      * @return  El valor de instalacion_ubicacion 
      */
    public String getinstalacion_ubicacion() {
		return instalacion_ubicacion;
    }

    /**
     * Establece el valor de instalacion_ubicacion
     * @param instalacion_ubicacion
     *        El valor por establecer para  instalacion_ubicacion                       
     */
    public void setinstalacion_ubicacion(String instalacion_ubicacion){
		this.instalacion_ubicacion = instalacion_ubicacion;
    }

    

    /**
      * Devuelve el valor de partes_confirmar
      * @return  El valor de partes_confirmar 
      */
    public Boolean getpartes_confirmar() {
		return partes_confirmar;
    }

    /**
     * Establece el valor de partes_confirmar
     * @param partes_confirmar
     *        El valor por establecer para  partes_confirmar                       
     */
    public void setpartes_confirmar(Boolean partes_confirmar){
		this.partes_confirmar = partes_confirmar;
    }

    

    /**
      * Devuelve el valor de partes_ubicacion
      * @return  El valor de partes_ubicacion 
      */
    public String getpartes_ubicacion() {
		return partes_ubicacion;
    }

    /**
     * Establece el valor de partes_ubicacion
     * @param partes_ubicacion
     *        El valor por establecer para  partes_ubicacion                       
     */
    public void setpartes_ubicacion(String partes_ubicacion){
		this.partes_ubicacion = partes_ubicacion;
    }

    

    /**
      * Devuelve el valor de funcionamiento_confirmar
      * @return  El valor de funcionamiento_confirmar 
      */
    public boolean getfuncionamiento_confirmar() {
		return funcionamiento_confirmar;
    }

    /**
     * Establece el valor de funcionamiento_confirmar
     * @param funcionamiento_confirmar
     *        El valor por establecer para  funcionamiento_confirmar                       
     */
    public void setfuncionamiento_confirmar(boolean funcionamiento_confirmar){
		this.funcionamiento_confirmar = funcionamiento_confirmar;
    }

    

    /**
      * Devuelve el valor de funcionamiento_ubicacion
      * @return  El valor de funcionamiento_ubicacion 
      */
    public String getfuncionamiento_ubicacion() {
		return funcionamiento_ubicacion;
    }

    /**
     * Establece el valor de funcionamiento_ubicacion
     * @param funcionamiento_ubicacion
     *        El valor por establecer para  funcionamiento_ubicacion                       
     */
    public void setfuncionamiento_ubicacion(String funcionamiento_ubicacion){
		this.funcionamiento_ubicacion = funcionamiento_ubicacion;
    }

    	
}
