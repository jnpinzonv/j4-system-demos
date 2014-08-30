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
 * se encarga de administrar los datos de un ManualesEquipo <b>Caso de Uso:</b> SOL_MOV- <br/>
 * CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "manuales_equipo")
@NamedQueries({ @NamedQuery(name = "manualesEquipo.getAll", query = "select s from ManualesEquipo s") })
public class ManualesEquipo implements Serializable {

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
     * tecnico_confirmar
     */

    private boolean tecnicoConfirmar;

    /**
     * tecnico_ubicacion
     */

    private String tecnicoUbicacion;

    /**
     * servicio_confirmar
     */

    private Boolean servicioConfirmar;

    /**
     * servicio_ubicacion
     */

    private String servicioUbicacion;

    /**
     * usuario_confirmar
     */

    private Boolean usuarioConfirmar;

    /**
     * usuario_ubicacion
     */

    private String usuarioUbicacion;

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

}
