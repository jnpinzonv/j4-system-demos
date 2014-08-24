package co.com.hammerlab.model;
import java.util.*;
import javax.persistence.*;
import java.io.Serializable;

/**
 * <b>Descripcion:</b> Clase que <br/> se encarga de administrar los datos de un AdquisicionEquipo
 * <b>Caso de Uso:</b> SOL_MOV- <br/> CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "adquisicion_equipo")
@NamedQueries({ @NamedQuery(name ="adquisicionEquipo.getAll" , query = "select s from AdquisicionEquipo s") })
public class AdquisicionEquipo implements Serializable{

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
     *  voltaje 
     */
     
     
     
     
     
    private Integer voltaje;

    
    /**     
     *  instalaciones 
     */
     
     
     
     
     
    private String instalaciones;

    
    /**     
     *  potencia 
     */
     
     
     
     
     
    private Integer potencia;

    
    /**     
     *  frecuencia 
     */
     
     
     
     
     
    private Double frecuencia;

    
    /**     
     *  capacidadTeorica 
     */
     
     
     
     
     
    private String capacidadTeorica;

    
    /**     
     *  capacidadPractica 
     */
     
     
     
     
     
    private String capacidadPractica;

    
    /**     
     *  tecnologia 
     */
     
     
     
     
     
    private String tecnologia;

    
    /**     
     *  insumos 
     */
     
     
     
     
     
    private String insumos;

    


     

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
      * Devuelve el valor de voltaje
      * @return  El valor de voltaje 
      */
    public Integer getvoltaje() {
		return voltaje;
    }

    /**
     * Establece el valor de voltaje
     * @param voltaje
     *        El valor por establecer para  voltaje                       
     */
    public void setvoltaje(Integer voltaje){
		this.voltaje = voltaje;
    }

    

    /**
      * Devuelve el valor de instalaciones
      * @return  El valor de instalaciones 
      */
    public String getinstalaciones() {
		return instalaciones;
    }

    /**
     * Establece el valor de instalaciones
     * @param instalaciones
     *        El valor por establecer para  instalaciones                       
     */
    public void setinstalaciones(String instalaciones){
		this.instalaciones = instalaciones;
    }

    

    /**
      * Devuelve el valor de potencia
      * @return  El valor de potencia 
      */
    public Integer getpotencia() {
		return potencia;
    }

    /**
     * Establece el valor de potencia
     * @param potencia
     *        El valor por establecer para  potencia                       
     */
    public void setpotencia(Integer potencia){
		this.potencia = potencia;
    }

    

    /**
      * Devuelve el valor de frecuencia
      * @return  El valor de frecuencia 
      */
    public Double getfrecuencia() {
		return frecuencia;
    }

    /**
     * Establece el valor de frecuencia
     * @param frecuencia
     *        El valor por establecer para  frecuencia                       
     */
    public void setfrecuencia(Double frecuencia){
		this.frecuencia = frecuencia;
    }

    

    /**
      * Devuelve el valor de capacidadTeorica
      * @return  El valor de capacidadTeorica 
      */
    public String getcapacidadTeorica() {
		return capacidadTeorica;
    }

    /**
     * Establece el valor de capacidadTeorica
     * @param capacidadTeorica
     *        El valor por establecer para  capacidadTeorica                       
     */
    public void setcapacidadTeorica(String capacidadTeorica){
		this.capacidadTeorica = capacidadTeorica;
    }

    

    /**
      * Devuelve el valor de capacidadPractica
      * @return  El valor de capacidadPractica 
      */
    public String getcapacidadPractica() {
		return capacidadPractica;
    }

    /**
     * Establece el valor de capacidadPractica
     * @param capacidadPractica
     *        El valor por establecer para  capacidadPractica                       
     */
    public void setcapacidadPractica(String capacidadPractica){
		this.capacidadPractica = capacidadPractica;
    }

    

    /**
      * Devuelve el valor de tecnologia
      * @return  El valor de tecnologia 
      */
    public String gettecnologia() {
		return tecnologia;
    }

    /**
     * Establece el valor de tecnologia
     * @param tecnologia
     *        El valor por establecer para  tecnologia                       
     */
    public void settecnologia(String tecnologia){
		this.tecnologia = tecnologia;
    }

    

    /**
      * Devuelve el valor de insumos
      * @return  El valor de insumos 
      */
    public String getinsumos() {
		return insumos;
    }

    /**
     * Establece el valor de insumos
     * @param insumos
     *        El valor por establecer para  insumos                       
     */
    public void setinsumos(String insumos){
		this.insumos = insumos;
    }

    	
}
