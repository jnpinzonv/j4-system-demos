package co.com.hammerlab.model;

import java.io.Serializable;

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
    private Integer voltaje;

    /**
     * instalaciones
     */
    private String instalaciones;

    /**
     * potencia
     */
    private Integer potencia;

    /**
     * frecuencia
     */
    private Double frecuencia;

    /**
     * capacidadTeorica
     */
    private String capacidadTeorica;

    /**
     * capacidadPractica
     */
    private String capacidadPractica;

    /**
     * tecnologia
     */
    private String tecnologia;

    /**
     * insumos
     */
    private String insumos;
    
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
     * Devuelve el valor de voltaje
     * @return El valor de voltaje
     */
    public Integer getVoltaje() {
        return voltaje;
    }

    /**
     * Establece el valor de voltaje
     * @param voltaje El valor por establecer para voltaje
     */
    public void setVoltaje(Integer voltaje) {
        this.voltaje = voltaje;
    }

    /**
     * Devuelve el valor de instalaciones
     * @return El valor de instalaciones
     */
    public String getInstalaciones() {
        return instalaciones;
    }

    /**
     * Establece el valor de instalaciones
     * @param instalaciones El valor por establecer para instalaciones
     */
    public void setInstalaciones(String instalaciones) {
        this.instalaciones = instalaciones;
    }

    /**
     * Devuelve el valor de potencia
     * @return El valor de potencia
     */
    public Integer getPotencia() {
        return potencia;
    }

    /**
     * Establece el valor de potencia
     * @param potencia El valor por establecer para potencia
     */
    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    /**
     * Devuelve el valor de frecuencia
     * @return El valor de frecuencia
     */
    public Double getFrecuencia() {
        return frecuencia;
    }

    /**
     * Establece el valor de frecuencia
     * @param frecuencia El valor por establecer para frecuencia
     */
    public void setFrecuencia(Double frecuencia) {
        this.frecuencia = frecuencia;
    }

    /**
     * Devuelve el valor de capacidadTeorica
     * @return El valor de capacidadTeorica
     */
    public String getCapacidadTeorica() {
        return capacidadTeorica;
    }

    /**
     * Establece el valor de capacidadTeorica
     * @param capacidadTeorica El valor por establecer para capacidadTeorica
     */
    public void setCapacidadTeorica(String capacidadTeorica) {
        this.capacidadTeorica = capacidadTeorica;
    }

    /**
     * Devuelve el valor de capacidadPractica
     * @return El valor de capacidadPractica
     */
    public String getCapacidadPractica() {
        return capacidadPractica;
    }

    /**
     * Establece el valor de capacidadPractica
     * @param capacidadPractica El valor por establecer para capacidadPractica
     */
    public void setCapacidadPractica(String capacidadPractica) {
        this.capacidadPractica = capacidadPractica;
    }

    /**
     * Devuelve el valor de tecnologia
     * @return El valor de tecnologia
     */
    public String getTecnologia() {
        return tecnologia;
    }

    /**
     * Establece el valor de tecnologia
     * @param tecnologia El valor por establecer para tecnologia
     */
    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    /**
     * Devuelve el valor de insumos
     * @return El valor de insumos
     */
    public String getInsumos() {
        return insumos;
    }

    /**
     * Establece el valor de insumos
     * @param insumos El valor por establecer para insumos
     */
    public void setInsumos(String insumos) {
        this.insumos = insumos;
    }
}
