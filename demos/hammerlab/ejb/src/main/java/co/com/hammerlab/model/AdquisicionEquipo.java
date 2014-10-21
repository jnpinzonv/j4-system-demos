package co.com.hammerlab.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * <b>Descripcion:</b> Clase que <br/>
 * se encarga de administrar los datos de un AdquisicionEquipo <b>Caso de Uso:</b> SOL_MOV- <br/>
 * CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "adquisicion_equipo")
@NamedQueries({ @NamedQuery(name = "adquisicionEquipo.getAll", query = "select s from AdquisicionEquipo s") })
public class AdquisicionEquipo implements Serializable {

    /**
     * representa el identificador de Serializacion
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * voltaje
     */
    private  String fechaAdquisicion;

    /**
     * instalaciones
     */
    private String fechaInstalacion;

    /**
     * potencia
     */
    private String aniosOperacion;

    /**
     * frecuencia
     */
    private String propiedadEquipo;

    /**
     * capacidadTeorica
     */
    private String aniosFueraServicio;

    /**
     * capacidadPractica
     */
    private String razon;

    /**
     * tecnologia
     */
    private String garantia;

    /**
     * Perido de Garantia
     */   
    private String peridoGarantia;
    
    /**
     * 
     */
    private String cubrimientoGarantia;
    
    /**
     * 
     */
    private String clasificacionDecreto;
    
    /**
     * 
     */
    private String calibracionTipo;
    
    /**
     * 
     */
    private String calibracionPeriocidad;
    
    /**
     * Realacion con equiopo principal
     */
    @OneToOne(mappedBy = "adquisicionEquipo")
    private EquipoHospitalario equipoHospitalario;
    
    /**
     * Devuelve el valor de equipoHospitalario
     * @return El valor de equipoHospitalario
     */
    public EquipoHospitalario getEquipoHospitalario() {
        return equipoHospitalario;
    }

    /**
     * Establece el valor de equipoHospitalario
     * @param equipoHospitalario El valor por establecer para equipoHospitalario
     */
    public void setEquipoHospitalario(EquipoHospitalario equipoHospitalario) {
        this.equipoHospitalario = equipoHospitalario;
    }

    /**
     * Devuelve el valor de id
     * @return El valor de id
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el valor de id
     * @param id El valor por establecer para id
     */
    public void setId(Long id) {
        this.id = id;
    }
   
    /**
     * Devuelve el valor de fechaAdquisicion
     * @return El valor de fechaAdquisicion
     */
    public String getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    /**
     * Establece el valor de fechaAdquisicion
     * @param fechaAdquisicion El valor por establecer para fechaAdquisicion
     */
    public void setFechaAdquisicion(String fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    /**
     * Devuelve el valor de fechaInstalacion
     * @return El valor de fechaInstalacion
     */
    public String getFechaInstalacion() {
        return fechaInstalacion;
    }

    /**
     * Establece el valor de fechaInstalacion
     * @param fechaInstalacion El valor por establecer para fechaInstalacion
     */
    public void setFechaInstalacion(String fechaInstalacion) {
        this.fechaInstalacion = fechaInstalacion;
    }

    /**
     * Devuelve el valor de propiedadEquipo
     * @return El valor de propiedadEquipo
     */
    public String getPropiedadEquipo() {
        return propiedadEquipo;
    }

    /**
     * Establece el valor de propiedadEquipo
     * @param propiedadEquipo El valor por establecer para propiedadEquipo
     */
    public void setPropiedadEquipo(String propiedadEquipo) {
        this.propiedadEquipo = propiedadEquipo;
    }

   

    /**
     * Devuelve el valor de razon
     * @return El valor de razon
     */
    public String getRazon() {
        return razon;
    }

    /**
     * Establece el valor de razon
     * @param razon El valor por establecer para razon
     */
    public void setRazon(String razon) {
        this.razon = razon;
    }

    /**
     * Devuelve el valor de garantia
     * @return El valor de garantia
     */
    public String getGarantia() {
        return garantia;
    }

    /**
     * Establece el valor de garantia
     * @param garantia El valor por establecer para garantia
     */
    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    

    /**
     * Devuelve el valor de cubrimientoGarantia
     * @return El valor de cubrimientoGarantia
     */
    public String getCubrimientoGarantia() {
        return cubrimientoGarantia;
    }

    /**
     * Establece el valor de cubrimientoGarantia
     * @param cubrimientoGarantia El valor por establecer para cubrimientoGarantia
     */
    public void setCubrimientoGarantia(String cubrimientoGarantia) {
        this.cubrimientoGarantia = cubrimientoGarantia;
    }

    /**
     * Devuelve el valor de clasificacionDecreto
     * @return El valor de clasificacionDecreto
     */
    public String getClasificacionDecreto() {
        return clasificacionDecreto;
    }

    /**
     * Establece el valor de clasificacionDecreto
     * @param clasificacionDecreto El valor por establecer para clasificacionDecreto
     */
    public void setClasificacionDecreto(String clasificacionDecreto) {
        this.clasificacionDecreto = clasificacionDecreto;
    }

    /**
     * Devuelve el valor de calibracionTipo
     * @return El valor de calibracionTipo
     */
    public String getCalibracionTipo() {
        return calibracionTipo;
    }

    /**
     * Establece el valor de calibracionTipo
     * @param calibracionTipo El valor por establecer para calibracionTipo
     */
    public void setCalibracionTipo(String calibracionTipo) {
        this.calibracionTipo = calibracionTipo;
    }

    /**
     * Devuelve el valor de calibracionPeriocidad
     * @return El valor de calibracionPeriocidad
     */
    public String getCalibracionPeriocidad() {
        return calibracionPeriocidad;
    }

    /**
     * Establece el valor de calibracionPeriocidad
     * @param calibracionPeriocidad El valor por establecer para calibracionPeriocidad
     */
    public void setCalibracionPeriocidad(String calibracionPeriocidad) {
        this.calibracionPeriocidad = calibracionPeriocidad;
    }

    /**
     * Devuelve el valor de aniosOperacion
     * @return El valor de aniosOperacion
     */
    public String getAniosOperacion() {
        return aniosOperacion;
    }

    /**
     * Establece el valor de aniosOperacion
     * @param aniosOperacion El valor por establecer para aniosOperacion
     */
    public void setAniosOperacion(String aniosOperacion) {
        this.aniosOperacion = aniosOperacion;
    }

    /**
     * Devuelve el valor de aniosFueraServicio
     * @return El valor de aniosFueraServicio
     */
    public String getAniosFueraServicio() {
        return aniosFueraServicio;
    }

    /**
     * Establece el valor de aniosFueraServicio
     * @param aniosFueraServicio El valor por establecer para aniosFueraServicio
     */
    public void setAniosFueraServicio(String aniosFueraServicio) {
        this.aniosFueraServicio = aniosFueraServicio;
    }

    /**
     * Devuelve el valor de peridoGarantia
     * @return El valor de peridoGarantia
     */
    public String getPeridoGarantia() {
        return peridoGarantia;
    }

    /**
     * Establece el valor de peridoGarantia
     * @param peridoGarantia El valor por establecer para peridoGarantia
     */
    public void setPeridoGarantia(String peridoGarantia) {
        this.peridoGarantia = peridoGarantia;
    }

    
    
}
