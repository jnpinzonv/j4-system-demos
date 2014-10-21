package co.com.hammerlab.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

    @Enumerated(EnumType.STRING)
    private TipoMantenimiento tipoMantenimiento;

    /**
     * propio
     */

    private Boolean tipoContrato;
    
    /**
     * cual
     */
    private String cual;
    
    /**
     * 
     */
    private String valor;
    
   

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
    public TipoMantenimiento getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    /**
     * Establece el valor de tipoMantenimiento
     * @param tipoMantenimiento El valor por establecer para tipoMantenimiento
     */
    public void setTipoMantenimiento(TipoMantenimiento tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }

    /**
     * Devuelve el valor de tipoContrato
     * @return El valor de tipoContrato
     */
    public Boolean getTipoContrato() {
        return tipoContrato;
    }

    /**
     * Establece el valor de tipoContrato
     * @param tipoContrato El valor por establecer para tipoContrato
     */
    public void setTipoContrato(Boolean tipoContrato) {
        this.tipoContrato = tipoContrato;
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
     * Devuelve el valor de valor
     * @return El valor de valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * Establece el valor de valor
     * @param valor El valor por establecer para valor
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    

    
}
