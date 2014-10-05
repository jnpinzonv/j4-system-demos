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
 * se encarga de administrar los datos de un PlanosEquipo <b>Caso de Uso:</b> SOL_MOV- <br/>
 * CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "planos_equipo")
@NamedQueries({ @NamedQuery(name = "planosEquipo.getAll", query = "select s from PlanosEquipo s") })
public class PlanosEquipo implements Serializable {

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
     * instalacion_confirmar
     */
    private Boolean instalacionConfirmar;

    /**
     * instalacion_ubicacion
     */

    private String instalacionUbicacion;

    /**
     * partes_confirmar
     */

    private Boolean partesConfirmar;

    /**
     * partes_ubicacion
     */

    private String partesUbicacion;

    /**
     * funcionamiento_confirmar
     */

    private Boolean funcionamientoConfirmar;

    /**
     * funcionamiento_ubicacion
     */

    private String funcionamientoUbicacion;

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
     * Devuelve el valor de instalacionConfirmar
     * @return El valor de instalacionConfirmar
     */
    public Boolean getInstalacionConfirmar() {
        return instalacionConfirmar;
    }

    /**
     * Establece el valor de instalacionConfirmar
     * @param instalacionConfirmar El valor por establecer para instalacionConfirmar
     */
    public void setInstalacionConfirmar(Boolean instalacionConfirmar) {
        this.instalacionConfirmar = instalacionConfirmar;
    }

    /**
     * Devuelve el valor de instalacionUbicacion
     * @return El valor de instalacionUbicacion
     */
    public String getInstalacionUbicacion() {
        return instalacionUbicacion;
    }

    /**
     * Establece el valor de instalacionUbicacion
     * @param instalacionUbicacion El valor por establecer para instalacionUbicacion
     */
    public void setInstalacionUbicacion(String instalacionUbicacion) {
        this.instalacionUbicacion = instalacionUbicacion;
    }

    /**
     * Devuelve el valor de partesConfirmar
     * @return El valor de partesConfirmar
     */
    public Boolean getPartesConfirmar() {
        return partesConfirmar;
    }

    /**
     * Establece el valor de partesConfirmar
     * @param partesConfirmar El valor por establecer para partesConfirmar
     */
    public void setPartesConfirmar(Boolean partesConfirmar) {
        this.partesConfirmar = partesConfirmar;
    }

    /**
     * Devuelve el valor de partesUbicacion
     * @return El valor de partesUbicacion
     */
    public String getPartesUbicacion() {
        return partesUbicacion;
    }

    /**
     * Establece el valor de partesUbicacion
     * @param partesUbicacion El valor por establecer para partesUbicacion
     */
    public void setPartesUbicacion(String partesUbicacion) {
        this.partesUbicacion = partesUbicacion;
    }
  
   
    /**
     * Devuelve el valor de funcionamientoUbicacion
     * @return El valor de funcionamientoUbicacion
     */
    public String getFuncionamientoUbicacion() {
        return funcionamientoUbicacion;
    }

    /**
     * Establece el valor de funcionamientoUbicacion
     * @param funcionamientoUbicacion El valor por establecer para funcionamientoUbicacion
     */
    public void setFuncionamientoUbicacion(String funcionamientoUbicacion) {
        this.funcionamientoUbicacion = funcionamientoUbicacion;
    }

    /**
     * Devuelve el valor de funcionamientoConfirmar
     * @return El valor de funcionamientoConfirmar
     */
    public Boolean getFuncionamientoConfirmar() {
        return funcionamientoConfirmar;
    }

    /**
     * Establece el valor de funcionamientoConfirmar
     * @param funcionamientoConfirmar El valor por establecer para funcionamientoConfirmar
     */
    public void setFuncionamientoConfirmar(Boolean funcionamientoConfirmar) {
        this.funcionamientoConfirmar = funcionamientoConfirmar;
    }
    
    

}
