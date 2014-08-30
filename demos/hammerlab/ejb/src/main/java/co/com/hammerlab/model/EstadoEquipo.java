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
 * se encarga de administrar los datos de un EstadoEquipo <b>Caso de Uso:</b> SOL_MOV- <br/>
 * CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "estado_equipo")
@NamedQueries({ @NamedQuery(name = "estadoEquipo.getAll", query = "select s from EstadoEquipo s") })
public class EstadoEquipo implements Serializable {

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
     * estado_confirmar
     */

    private String estado_confirmar;

    /**
     * causa
     */

    private String causa;

    /**
     * Realacion con equiopo principal
     */
    @OneToOne()
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
     * Devuelve el valor de estado_confirmar
     * @return El valor de estado_confirmar
     */
    public String getEstado_confirmar() {
        return estado_confirmar;
    }

    /**
     * Establece el valor de estado_confirmar
     * @param estado_confirmar El valor por establecer para estado_confirmar
     */
    public void setEstado_confirmar(String estado_confirmar) {
        this.estado_confirmar = estado_confirmar;
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
}