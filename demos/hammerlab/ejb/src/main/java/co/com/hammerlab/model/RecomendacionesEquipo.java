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
 * se encarga de administrar los datos de un RecomendacionesEquipo <b>Caso de Uso:</b> SOL_MOV- <br/>
 * CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "recomendaciones_equipo")
@NamedQueries({ @NamedQuery(name = "recomendacionesEquipo.getAll", query = "select s from RecomendacionesEquipo s") })
public class RecomendacionesEquipo implements Serializable {

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
     * detalle
     */
    private String detalle;
    
    /**
     * Realacion con equiopo principal
     */
    @OneToOne(mappedBy="recomendacionesEquipo")
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
     * Devuelve el valor de detalle
     * @return El valor de detalle
     */
    public String getDetalle() {
        return detalle;
    }

    /**
     * Establece el valor de detalle
     * @param detalle El valor por establecer para detalle
     */
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
