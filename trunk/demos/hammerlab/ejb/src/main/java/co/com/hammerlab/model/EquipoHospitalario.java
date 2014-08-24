package co.com.hammerlab.model;
import java.util.*;
import javax.persistence.*;
import java.io.Serializable;

/**
 * <b>Descripcion:</b> Clase que <br/> se encarga de administrar los datos de un EquipoHospitalario
 * <b>Caso de Uso:</b> SOL_MOV- <br/> CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "equipo_hospitalario")
@NamedQueries({ @NamedQuery(name ="equipoHospitalario.getAll" , query = "select s from EquipoHospitalario s") })
public class EquipoHospitalario implements Serializable{

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
     *  fotoEquipo 
     */
     
     
     
     
     
    private String fotoEquipo;

    
    /**     
     *  marca 
     */
     
     
     
     
     
    private String marca;

    
    /**     
     *  modelo 
     */
     
     
     
     
     
    private String modelo;

    
    /**     
     *  ubicacion 
     */
     
     
     
     
     
    private String ubicacion;

    
    /**     
     *  fabricante 
     */
     
     
     
     
     
    private String fabricante;

    
    /**     
     *  representanteCol 
     */
     
     
     
     
     
    private String representanteCol;

    
    /**     
     *  direccion 
     */
     
     
     
     
     
    private String direccion;

    
    /**     
     *  telefono 
     */
     
     
     
     
     
    private String telefono;

    


     

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
      * Devuelve el valor de fotoEquipo
      * @return  El valor de fotoEquipo 
      */
    public String getfotoEquipo() {
		return fotoEquipo;
    }

    /**
     * Establece el valor de fotoEquipo
     * @param fotoEquipo
     *        El valor por establecer para  fotoEquipo                       
     */
    public void setfotoEquipo(String fotoEquipo){
		this.fotoEquipo = fotoEquipo;
    }

    

    /**
      * Devuelve el valor de marca
      * @return  El valor de marca 
      */
    public String getmarca() {
		return marca;
    }

    /**
     * Establece el valor de marca
     * @param marca
     *        El valor por establecer para  marca                       
     */
    public void setmarca(String marca){
		this.marca = marca;
    }

    

    /**
      * Devuelve el valor de modelo
      * @return  El valor de modelo 
      */
    public String getmodelo() {
		return modelo;
    }

    /**
     * Establece el valor de modelo
     * @param modelo
     *        El valor por establecer para  modelo                       
     */
    public void setmodelo(String modelo){
		this.modelo = modelo;
    }

    

    /**
      * Devuelve el valor de ubicacion
      * @return  El valor de ubicacion 
      */
    public String getubicacion() {
		return ubicacion;
    }

    /**
     * Establece el valor de ubicacion
     * @param ubicacion
     *        El valor por establecer para  ubicacion                       
     */
    public void setubicacion(String ubicacion){
		this.ubicacion = ubicacion;
    }

    

    /**
      * Devuelve el valor de fabricante
      * @return  El valor de fabricante 
      */
    public String getfabricante() {
		return fabricante;
    }

    /**
     * Establece el valor de fabricante
     * @param fabricante
     *        El valor por establecer para  fabricante                       
     */
    public void setfabricante(String fabricante){
		this.fabricante = fabricante;
    }

    

    /**
      * Devuelve el valor de representanteCol
      * @return  El valor de representanteCol 
      */
    public String getrepresentanteCol() {
		return representanteCol;
    }

    /**
     * Establece el valor de representanteCol
     * @param representanteCol
     *        El valor por establecer para  representanteCol                       
     */
    public void setrepresentanteCol(String representanteCol){
		this.representanteCol = representanteCol;
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

    	
}
