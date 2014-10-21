package co.com.hammerlab.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@NamedQueries({
        @NamedQuery(name = "mantenimientoequipo.getAll", query = "select s from MantenimientoEquipo s"),
        @NamedQuery(name = "mantenimientoequipo.getAllIdTrans", query = "select s from MantenimientoEquipo s  where s.idTransaccion=:IDTRAN"),
        @NamedQuery(name = "mantenimientoequipo.getAllEquipo", query = "select s from MantenimientoEquipo s where s.equipoHospitalario=:EQUIPO"),
        @NamedQuery(name = "mantenimientoequipo.getfirmas", query = "select s from MantenimientoEquipo s where s.firmaAprobacion IS NULL or s.firmaAprobacionTecnico IS NULL") })
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
    @Column(columnDefinition="varchar(3000)")
    private String danioFalla;

    /**
     * reparaciones
     */
    @Column(columnDefinition="varchar(3000)")
    private String reparaciones;

    /**
     * repuestos
     */
    @Column(columnDefinition="varchar(3000)")
    private String repuestos;

    /**
     * observaciones
     */
    @Column(columnDefinition="varchar(1000)")
    private String observaciones;
    
    @Enumerated(EnumType.STRING)
    private Estado estadoMantenimiento;
    
    private Long numeroHojaFisica;

    /**
     * firmaAprobacion
     */
    @Lob
    private byte[] firmaAprobacion;

    /**
     * firmaAprobacion
     */
    @Lob
    private byte[] firmaAprobacionTecnico;

    /**
     * firmaAprobacion
     */
    @Lob
    private byte[] firmaAprobacionContrato;

    /**
     * IdTransaccion
     */

    private Long idTransaccion;

    /**
     * Realacion con equiopo principal
     */
    @ManyToOne
    private EquipoHospitalario equipoHospitalario;

    /**
     * Devuelve el valor de equipoHospitalario
     * 
     * @return El valor de equipoHospitalario
     */
    public EquipoHospitalario getEquipoHospitalario() {
        return equipoHospitalario;
    }

    /**
     * Establece el valor de equipoHospitalario
     * 
     * @param equipoHospitalario
     *            El valor por establecer para equipoHospitalario
     */
    public void setEquipoHospitalario(EquipoHospitalario equipoHospitalario) {
        this.equipoHospitalario = equipoHospitalario;
    }

    /**
     * Devuelve el valor de id
     * 
     * @return El valor de id
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el valor de id
     * 
     * @param id
     *            El valor por establecer para id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve el valor de fecha
     * 
     * @return El valor de fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece el valor de fecha
     * 
     * @param fecha
     *            El valor por establecer para fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve el valor de danioFalla
     * 
     * @return El valor de danioFalla
     */
    public String getDanioFalla() {
        return danioFalla;
    }

    /**
     * Establece el valor de danioFalla
     * 
     * @param danioFalla
     *            El valor por establecer para danioFalla
     */
    public void setDanioFalla(String danioFalla) {
        this.danioFalla = danioFalla;
    }

    /**
     * Devuelve el valor de reparaciones
     * 
     * @return El valor de reparaciones
     */
    public String getReparaciones() {
        return reparaciones;
    }

    /**
     * Establece el valor de reparaciones
     * 
     * @param reparaciones
     *            El valor por establecer para reparaciones
     */
    public void setReparaciones(String reparaciones) {
        this.reparaciones = reparaciones;
    }

    /**
     * Devuelve el valor de repuestos
     * 
     * @return El valor de repuestos
     */
    public String getRepuestos() {
        return repuestos;
    }

    /**
     * Establece el valor de repuestos
     * 
     * @param repuestos
     *            El valor por establecer para repuestos
     */
    public void setRepuestos(String repuestos) {
        this.repuestos = repuestos;
    }

    /**
     * Devuelve el valor de observaciones
     * 
     * @return El valor de observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Establece el valor de observaciones
     * 
     * @param observaciones
     *            El valor por establecer para observaciones
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Devuelve el valor de firmaAprobacion
     * 
     * @return El valor de firmaAprobacion
     */
    public byte[] getFirmaAprobacion() {
        return firmaAprobacion;
    }

    /**
     * Establece el valor de firmaAprobacion
     * 
     * @param firmaAprobacion
     *            El valor por establecer para firmaAprobacion
     */
    public void setFirmaAprobacion(byte[] firmaAprobacion) {
        this.firmaAprobacion = firmaAprobacion;
    }

    /**
     * Devuelve el valor de firmaAprobacionTecnico
     * 
     * @return El valor de firmaAprobacionTecnico
     */
    public byte[] getFirmaAprobacionTecnico() {
        return firmaAprobacionTecnico;
    }

    /**
     * Establece el valor de firmaAprobacionTecnico
     * 
     * @param firmaAprobacionTecnico
     *            El valor por establecer para firmaAprobacionTecnico
     */
    public void setFirmaAprobacionTecnico(byte[] firmaAprobacionTecnico) {
        this.firmaAprobacionTecnico = firmaAprobacionTecnico;
    }

    /**
     * Devuelve el valor de idTransaccion
     * 
     * @return El valor de idTransaccion
     */
    public Long getIdTransaccion() {
        return idTransaccion;
    }

    /**
     * Establece el valor de idTransaccion
     * 
     * @param idTransaccion
     *            El valor por establecer para idTransaccion
     */
    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    /**
     * Devuelve el valor de firmaAprobacionContrato
     * 
     * @return El valor de firmaAprobacionContrato
     */
    public byte[] getFirmaAprobacionContrato() {
        return firmaAprobacionContrato;
    }

    /**
     * Establece el valor de firmaAprobacionContrato
     * 
     * @param firmaAprobacionContrato
     *            El valor por establecer para firmaAprobacionContrato
     */
    public void setFirmaAprobacionContrato(byte[] firmaAprobacionContrato) {
        this.firmaAprobacionContrato = firmaAprobacionContrato;
    }

    /**
     * Devuelve el valor de estadoMantenimiento
     * @return El valor de estadoMantenimiento
     */
    public Estado getEstadoMantenimiento() {
        return estadoMantenimiento;
    }

    /**
     * Establece el valor de estadoMantenimiento
     * @param estadoMantenimiento El valor por establecer para estadoMantenimiento
     */
    public void setEstadoMantenimiento(Estado estadoMantenimiento) {
        this.estadoMantenimiento = estadoMantenimiento;
    }

    /**
     * Devuelve el valor de numeroHojaFisica
     * @return El valor de numeroHojaFisica
     */
    public Long getNumeroHojaFisica() {
        return numeroHojaFisica;
    }

    /**
     * Establece el valor de numeroHojaFisica
     * @param numeroHojaFisica El valor por establecer para numeroHojaFisica
     */
    public void setNumeroHojaFisica(Long numeroHojaFisica) {
        this.numeroHojaFisica = numeroHojaFisica;
    }
    
}
