package co.com.hammerlab.model;
import java.util.*;
import javax.persistence.*;
import java.io.Serializable;

/**
 * <b>Descripcion:</b> Clase que <br/> se encarga de administrar los datos de un FuncionamientoEquipo
 * <b>Caso de Uso:</b> SOL_MOV- <br/> CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "funcionamiento_equipo")
@NamedQueries({ @NamedQuery(name ="funcionamientoEquipo.getAll" , query = "select s from FuncionamientoEquipo s") })
public class FuncionamientoEquipo implements Serializable{

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
     *  funcionamiento_confirmar 
     */
     
     
     
     
     
    private String funcionamiento_confirmar;

    
    /**     
     *  anios_fuera_servicio 
     */
     
     
     
     
     
    private Integer anios_fuera_servicio;

    
    /**     
     *  causa 
     */
     
     
     
     
     
    private String causa;

    
    /**     
     *  fuera_servicio 
     */
     
     
     
     
     
    private Boolean fuera_servicio;

    


     

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
      * Devuelve el valor de funcionamiento_confirmar
      * @return  El valor de funcionamiento_confirmar 
      */
    public String getfuncionamiento_confirmar() {
		return funcionamiento_confirmar;
    }

    /**
     * Establece el valor de funcionamiento_confirmar
     * @param funcionamiento_confirmar
     *        El valor por establecer para  funcionamiento_confirmar                       
     */
    public void setfuncionamiento_confirmar(String funcionamiento_confirmar){
		this.funcionamiento_confirmar = funcionamiento_confirmar;
    }

    

    /**
      * Devuelve el valor de anios_fuera_servicio
      * @return  El valor de anios_fuera_servicio 
      */
    public Integer getanios_fuera_servicio() {
		return anios_fuera_servicio;
    }

    /**
     * Establece el valor de anios_fuera_servicio
     * @param anios_fuera_servicio
     *        El valor por establecer para  anios_fuera_servicio                       
     */
    public void setanios_fuera_servicio(Integer anios_fuera_servicio){
		this.anios_fuera_servicio = anios_fuera_servicio;
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

    

    /**
      * Devuelve el valor de fuera_servicio
      * @return  El valor de fuera_servicio 
      */
    public Boolean getfuera_servicio() {
		return fuera_servicio;
    }

    /**
     * Establece el valor de fuera_servicio
     * @param fuera_servicio
     *        El valor por establecer para  fuera_servicio                       
     */
    public void setfuera_servicio(Boolean fuera_servicio){
		this.fuera_servicio = fuera_servicio;
    }

    	
}
