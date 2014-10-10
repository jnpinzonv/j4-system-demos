package co.com.hammerlab.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * <b>Descripcion:</b> Clase que <br/>
 * se encarga de administrar los datos de un TipoManteEquipo <b>Caso de Uso:</b> SOL_MOV- <br/>
 * CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "tipo_mante_equipo")
@NamedQueries({ @NamedQuery(name = "tipoManteEquipo.getAll", query = "select s from TipoManteEquipo s") })
public class TipoManteEquipo implements Serializable {

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
     * tipo_mantenimiento
     */

    private String tipoMantenimiento;

    /**
     * propio
     */

    private Boolean propio;

    /**
     * contratado
     */

    private Boolean contratado;

    /**
     * cual
     */
    private String cual;
    
    /**
     * 
     */
    @Transient
    private transient String contratadoStr;
    
    /**
     * 
     */
    @Transient
    private transient String propioStr;

    /**
     * Realacion con equiopo principal
     */
    @ManyToOne
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
     * Devuelve el valor de tipoMantenimiento
     * @return El valor de tipoMantenimiento
     */
    public String getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    /**
     * Establece el valor de tipoMantenimiento
     * @param tipoMantenimiento El valor por establecer para tipoMantenimiento
     */
    public void setTipoMantenimiento(String tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }

    /**
     * Devuelve el valor de propio
     * @return El valor de propio
     */
    public Boolean getPropio() {
        return propio;
    }

    /**
     * Establece el valor de propio
     * @param propio El valor por establecer para propio
     */
    public void setPropio(Boolean propio) {
        this.propio = propio;
    }

    /**
     * Devuelve el valor de contratado
     * @return El valor de contratado
     */
    public Boolean getContratado() {
        return contratado;
    }

    /**
     * Establece el valor de contratado
     * @param contratado El valor por establecer para contratado
     */
    public void setContratado(Boolean contratado) {
        this.contratado = contratado;
    }

    /**
     * Devuelve el valor de cual
     * @return El valor de cual
     */
    public String getCual() {
        return cual;
    }

    /**
     * Establece el valor de cual
     * @param cual El valor por establecer para cual
     */
    public void setCual(String cual) {
        this.cual = cual;
    }

    /**
     * Devuelve el valor de contratadoStr
     * @return El valor de contratadoStr
     */
    public String getContratadoStr() {
        return contratadoStr;
    }

    /**
     * Establece el valor de contratadoStr
     * @param contratadoStr El valor por establecer para contratadoStr
     */
    public void setContratadoStr(String contratadoStr) {
        this.contratadoStr = contratadoStr;
    }

    /**
     * Devuelve el valor de propioStr
     * @return El valor de propioStr
     */
    public String getPropioStr() {
        return propioStr;
    }

    /**
     * Establece el valor de propioStr
     * @param propioStr El valor por establecer para propioStr
     */
    public void setPropioStr(String propioStr) {
        this.propioStr = propioStr;
    }

    
}
