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

    private Boolean tecnicoConfirmar;

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
     * Establece el valor de tecnicoConfirmar
     * @param tecnicoConfirmar El valor por establecer para tecnicoConfirmar
     */
    public void setTecnicoConfirmar(Boolean tecnicoConfirmar) {
        this.tecnicoConfirmar = tecnicoConfirmar;
    }

    /**
     * Devuelve el valor de tecnicoUbicacion
     * @return El valor de tecnicoUbicacion
     */
    public String getTecnicoUbicacion() {
        return tecnicoUbicacion;
    }

    /**
     * Establece el valor de tecnicoUbicacion
     * @param tecnicoUbicacion El valor por establecer para tecnicoUbicacion
     */
    public void setTecnicoUbicacion(String tecnicoUbicacion) {
        this.tecnicoUbicacion = tecnicoUbicacion;
    }

    /**
     * Devuelve el valor de servicioConfirmar
     * @return El valor de servicioConfirmar
     */
    public Boolean getServicioConfirmar() {
        return servicioConfirmar;
    }

    /**
     * Establece el valor de servicioConfirmar
     * @param servicioConfirmar El valor por establecer para servicioConfirmar
     */
    public void setServicioConfirmar(Boolean servicioConfirmar) {
        this.servicioConfirmar = servicioConfirmar;
    }

    /**
     * Devuelve el valor de servicioUbicacion
     * @return El valor de servicioUbicacion
     */
    public String getServicioUbicacion() {
        return servicioUbicacion;
    }

    /**
     * Establece el valor de servicioUbicacion
     * @param servicioUbicacion El valor por establecer para servicioUbicacion
     */
    public void setServicioUbicacion(String servicioUbicacion) {
        this.servicioUbicacion = servicioUbicacion;
    }

    /**
     * Devuelve el valor de usuarioConfirmar
     * @return El valor de usuarioConfirmar
     */
    public Boolean getUsuarioConfirmar() {
        return usuarioConfirmar;
    }

    /**
     * Establece el valor de usuarioConfirmar
     * @param usuarioConfirmar El valor por establecer para usuarioConfirmar
     */
    public void setUsuarioConfirmar(Boolean usuarioConfirmar) {
        this.usuarioConfirmar = usuarioConfirmar;
    }

    /**
     * Devuelve el valor de usuarioUbicacion
     * @return El valor de usuarioUbicacion
     */
    public String getUsuarioUbicacion() {
        return usuarioUbicacion;
    }

    /**
     * Establece el valor de usuarioUbicacion
     * @param usuarioUbicacion El valor por establecer para usuarioUbicacion
     */
    public void setUsuarioUbicacion(String usuarioUbicacion) {
        this.usuarioUbicacion = usuarioUbicacion;
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

    /**
     * Devuelve el valor de tecnicoConfirmar
     * @return El valor de tecnicoConfirmar
     */
    public Boolean getTecnicoConfirmar() {
        return tecnicoConfirmar;
    }
    

}
