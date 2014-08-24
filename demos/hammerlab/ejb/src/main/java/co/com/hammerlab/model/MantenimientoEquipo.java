package co.com.hammerlab.model;
import java.util.*;
import javax.persistence.*;
import java.io.Serializable;

/**
 * <b>Descripcion:</b> Clase que <br/> se encarga de administrar los datos de un MantenimientoEquipo
 * <b>Caso de Uso:</b> SOL_MOV- <br/> CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "mantenimiento_equipo")
@NamedQueries({ @NamedQuery(name ="mantenimientoequipo.getAll" , query = "select s from MantenimientoEquipo s") })
public class MantenimientoEquipo implements Serializable{

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
     *  fecha 
     */
     
     
     
     
     
    private Date fecha;

    
    /**     
     *  danio_falla 
     */
     
     
     
     
     
    private String danio_falla;

    
    /**     
     *  reparaciones 
     */
     
     
     
     
     
    private String reparaciones;

    
    /**     
     *  repuestos 
     */
     
     
     
     
     
    private String repuestos;

    
    /**     
     *  costo_total 
     */
     
     
     
     
     
    private Double costo_total;

    
    /**     
     *  observaciones 
     */
     
     
     
     
     
    private String observaciones;

    
    /**     
     *  firmaAprovacion 
     */
     
     
     
     
     
    private String firmaAprovacion;

    
    /**     
     *  cedulaAprovacion 
     */
     
     
     
     
     
    private String cedulaAprovacion;

    
    /**     
     *  IdTransaccion 
     */
     
     
     
     
     
    private Long IdTransaccion;

    


     

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
      * Devuelve el valor de fecha
      * @return  El valor de fecha 
      */
    public Date getfecha() {
		return fecha;
    }

    /**
     * Establece el valor de fecha
     * @param fecha
     *        El valor por establecer para  fecha                       
     */
    public void setfecha(Date fecha){
		this.fecha = fecha;
    }

    

    /**
      * Devuelve el valor de danio_falla
      * @return  El valor de danio_falla 
      */
    public String getdanio_falla() {
		return danio_falla;
    }

    /**
     * Establece el valor de danio_falla
     * @param danio_falla
     *        El valor por establecer para  danio_falla                       
     */
    public void setdanio_falla(String danio_falla){
		this.danio_falla = danio_falla;
    }

    

    /**
      * Devuelve el valor de reparaciones
      * @return  El valor de reparaciones 
      */
    public String getreparaciones() {
		return reparaciones;
    }

    /**
     * Establece el valor de reparaciones
     * @param reparaciones
     *        El valor por establecer para  reparaciones                       
     */
    public void setreparaciones(String reparaciones){
		this.reparaciones = reparaciones;
    }

    

    /**
      * Devuelve el valor de repuestos
      * @return  El valor de repuestos 
      */
    public String getrepuestos() {
		return repuestos;
    }

    /**
     * Establece el valor de repuestos
     * @param repuestos
     *        El valor por establecer para  repuestos                       
     */
    public void setrepuestos(String repuestos){
		this.repuestos = repuestos;
    }

    

    /**
      * Devuelve el valor de costo_total
      * @return  El valor de costo_total 
      */
    public Double getcosto_total() {
		return costo_total;
    }

    /**
     * Establece el valor de costo_total
     * @param costo_total
     *        El valor por establecer para  costo_total                       
     */
    public void setcosto_total(Double costo_total){
		this.costo_total = costo_total;
    }

    

    /**
      * Devuelve el valor de observaciones
      * @return  El valor de observaciones 
      */
    public String getobservaciones() {
		return observaciones;
    }

    /**
     * Establece el valor de observaciones
     * @param observaciones
     *        El valor por establecer para  observaciones                       
     */
    public void setobservaciones(String observaciones){
		this.observaciones = observaciones;
    }

    

    /**
      * Devuelve el valor de firmaAprovacion
      * @return  El valor de firmaAprovacion 
      */
    public String getfirmaAprovacion() {
		return firmaAprovacion;
    }

    /**
     * Establece el valor de firmaAprovacion
     * @param firmaAprovacion
     *        El valor por establecer para  firmaAprovacion                       
     */
    public void setfirmaAprovacion(String firmaAprovacion){
		this.firmaAprovacion = firmaAprovacion;
    }

    

    /**
      * Devuelve el valor de cedulaAprovacion
      * @return  El valor de cedulaAprovacion 
      */
    public String getcedulaAprovacion() {
		return cedulaAprovacion;
    }

    /**
     * Establece el valor de cedulaAprovacion
     * @param cedulaAprovacion
     *        El valor por establecer para  cedulaAprovacion                       
     */
    public void setcedulaAprovacion(String cedulaAprovacion){
		this.cedulaAprovacion = cedulaAprovacion;
    }

    

    /**
      * Devuelve el valor de IdTransaccion
      * @return  El valor de IdTransaccion 
      */
    public Long getIdTransaccion() {
		return IdTransaccion;
    }

    /**
     * Establece el valor de IdTransaccion
     * @param IdTransaccion
     *        El valor por establecer para  IdTransaccion                       
     */
    public void setIdTransaccion(Long IdTransaccion){
		this.IdTransaccion = IdTransaccion;
    }

    	
}
