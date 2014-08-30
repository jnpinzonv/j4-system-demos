package co.com.hammerlab.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * <b>Descripcion:</b> Clase que <br/>
 * se encarga de administrar los datos de un MantenimientoEquipo <b>Caso de Uso:</b> SOL_MOV- <br/>
 * CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "mantenimiento_equipo")
@NamedQueries({ @NamedQuery(name = "mantenimientoequipo.getAll", query = "select s from MantenimientoEquipo s") })
public class MantenimientoEquipo implements Serializable {

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
     * fecha
     */

    private Date fecha;

    /**
     * danio_falla
     */

    private String danioFalla;

    /**
     * reparaciones
     */

    private String reparaciones;

    /**
     * repuestos
     */

    private String repuestos;

    /**
     * costo_total
     */

    private Double costoTotal;

    /**
     * observaciones
     */

    private String observaciones;

    /**
     * firmaAprovacion
     */
    @Lob
    private byte[] firmaAprovacion;

    /**
     * cedulaAprovacion
     */

    private String cedulaAprovacion;

    /**
     * IdTransaccion
     */

    private Long IdTransaccion;

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
     * Devuelve el valor de fecha
     * @return El valor de fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece el valor de fecha
     * @param fecha El valor por establecer para fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve el valor de danioFalla
     * @return El valor de danioFalla
     */
    public String getDanioFalla() {
        return danioFalla;
    }

    /**
     * Establece el valor de danioFalla
     * @param danioFalla El valor por establecer para danioFalla
     */
    public void setDanioFalla(String danioFalla) {
        this.danioFalla = danioFalla;
    }

    /**
     * Devuelve el valor de reparaciones
     * @return El valor de reparaciones
     */
    public String getReparaciones() {
        return reparaciones;
    }

    /**
     * Establece el valor de reparaciones
     * @param reparaciones El valor por establecer para reparaciones
     */
    public void setReparaciones(String reparaciones) {
        this.reparaciones = reparaciones;
    }

    /**
     * Devuelve el valor de repuestos
     * @return El valor de repuestos
     */
    public String getRepuestos() {
        return repuestos;
    }

    /**
     * Establece el valor de repuestos
     * @param repuestos El valor por establecer para repuestos
     */
    public void setRepuestos(String repuestos) {
        this.repuestos = repuestos;
    }

    /**
     * Devuelve el valor de costoTotal
     * @return El valor de costoTotal
     */
    public Double getCostoTotal() {
        return costoTotal;
    }

    /**
     * Establece el valor de costoTotal
     * @param costoTotal El valor por establecer para costoTotal
     */
    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    /**
     * Devuelve el valor de observaciones
     * @return El valor de observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Establece el valor de observaciones
     * @param observaciones El valor por establecer para observaciones
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

   

    /**
     * Devuelve el valor de firmaAprovacion
     * @return El valor de firmaAprovacion
     */
    public byte[] getFirmaAprovacion() {
        return firmaAprovacion;
    }

    /**
     * Establece el valor de firmaAprovacion
     * @param firmaAprovacion El valor por establecer para firmaAprovacion
     */
    public void setFirmaAprovacion(byte[] firmaAprovacion) {
        this.firmaAprovacion = firmaAprovacion;
    }

    /**
     * Devuelve el valor de cedulaAprovacion
     * @return El valor de cedulaAprovacion
     */
    public String getCedulaAprovacion() {
        return cedulaAprovacion;
    }

    /**
     * Establece el valor de cedulaAprovacion
     * @param cedulaAprovacion El valor por establecer para cedulaAprovacion
     */
    public void setCedulaAprovacion(String cedulaAprovacion) {
        this.cedulaAprovacion = cedulaAprovacion;
    }

    /**
     * Devuelve el valor de idTransaccion
     * @return El valor de idTransaccion
     */
    public Long getIdTransaccion() {
        return IdTransaccion;
    }

    /**
     * Establece el valor de idTransaccion
     * @param idTransaccion El valor por establecer para idTransaccion
     */
    public void setIdTransaccion(Long idTransaccion) {
        IdTransaccion = idTransaccion;
    }
    
    

}
