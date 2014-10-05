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
 * se encarga de administrar los datos de un FuncionamientoEquipo <b>Caso de Uso:</b> SOL_MOV- <br/>
 * CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "funcionamiento_equipo")
@NamedQueries({ @NamedQuery(name = "funcionamientoEquipo.getAll", query = "select s from FuncionamientoEquipo s") })
public class FuncionamientoEquipo implements Serializable {

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
     * funcionamiento_confirmar
     */

    private String funcionamientoConfirmar;

    /**
     * anios_fuera_servicio
     */

    private String anioFueraServicio;

    /**
     * causa
     */

    private String causa;

    /**
     * fuera_servicio
     */

    private Boolean fueraServicio;

    /**
     * Devuelve el valor de id
     * 
     * @return El valor de id
     */
    public Long getid() {
        return id;
    }

    /**
     * Realacion con equiopo principal
     */
    @OneToOne()
    private EquipoHospitalario equipoHospitalario;

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
     * Devuelve el valor de funcionamientoConfirmar
     * @return El valor de funcionamientoConfirmar
     */
    public String getFuncionamientoConfirmar() {
        return funcionamientoConfirmar;
    }

    /**
     * Establece el valor de funcionamientoConfirmar
     * @param funcionamientoConfirmar El valor por establecer para funcionamientoConfirmar
     */
    public void setFuncionamientoConfirmar(String funcionamientoConfirmar) {
        this.funcionamientoConfirmar = funcionamientoConfirmar;
    }

    /**
     * Devuelve el valor de anioFueraServicio
     * @return El valor de anioFueraServicio
     */
    public String getAnioFueraServicio() {
        return anioFueraServicio;
    }

    /**
     * Establece el valor de anioFueraServicio
     * @param anioFueraServicio El valor por establecer para anioFueraServicio
     */
    public void setAnioFueraServicio(String anioFueraServicio) {
        this.anioFueraServicio = anioFueraServicio;
    }

    /**
     * Devuelve el valor de causa
     * @return El valor de causa
     */
    public String getCausa() {
        return causa;
    }

    /**
     * Establece el valor de causa
     * @param causa El valor por establecer para causa
     */
    public void setCausa(String causa) {
        this.causa = causa;
    }

    /**
     * Devuelve el valor de fueraServicio
     * @return El valor de fueraServicio
     */
    public Boolean getFueraServicio() {
        return fueraServicio;
    }

    /**
     * Establece el valor de fueraServicio
     * @param fueraServicio El valor por establecer para fueraServicio
     */
    public void setFueraServicio(Boolean fueraServicio) {
        this.fueraServicio = fueraServicio;
    }

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
    

}
