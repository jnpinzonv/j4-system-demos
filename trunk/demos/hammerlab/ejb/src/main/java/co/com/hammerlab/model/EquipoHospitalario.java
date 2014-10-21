package co.com.hammerlab.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * <b>Descripcion:</b> Clase que <br/>
 * se encarga de administrar los datos de un EquipoHospitalario <b>Caso de Uso:</b> SOL_MOV- <br/>
 * CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "equipo_hospitalario")
@NamedQueries({
        @NamedQuery(name = "equipoHospitalario.getAll", query = "select s from EquipoHospitalario s "),
        @NamedQuery(name = "equipoHospitalario.getAllRelation", query = "select s from EquipoHospitalario s fetch all properties where s.id=:ID"),
        @NamedQuery(name = "equipoHospitalario.getAllSearch", query = "select s from EquipoHospitalario s where s.ubicacion=:UBICACION and "
                + Constants.replaceVocals1
                + " s.nombreEquipo"
                + Constants.replaceVocals2
                + " like concat('%',:NOMBREEQUI,'%') and "
                + Constants.replaceVocals1 + " s.empresa.razonSocial" + Constants.replaceVocals2 + " like concat('%',:EMPRESA,'%')"), 
         @NamedQuery(name = "equipoHospitalario.getAllSearchUbicacion", query = "select s from EquipoHospitalario s where s.ubicacion=:UBICACION and "
               + Constants.replaceVocals1 + " s.empresa.razonSocial" + Constants.replaceVocals2 + " like concat('%',:EMPRESA,'%')"),
        @NamedQuery(name = "equipoHospitalario.getAllSearchEquipo", query = "select s from EquipoHospitalario s where "
                + Constants.replaceVocals1
                + " s.nombreEquipo"
                + Constants.replaceVocals2
                + " like concat('%',:NOMBREEQUI,'%') and "
                + Constants.replaceVocals1 + " s.empresa.razonSocial" + Constants.replaceVocals2 + " like concat('%',:EMPRESA,'%')"),
        @NamedQuery(name = "equipoHospitalario.getAllSearchRazon", query = "select s from EquipoHospitalario s where "
                + Constants.replaceVocals1 + " s.empresa.razonSocial" + Constants.replaceVocals2 + " like concat('%',:EMPRESA,'%')")})
public class EquipoHospitalario implements Serializable {

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
     * Nombre del equipo
     */
    private String nombreEquipo="";

    /**
     * fotoEquipo
     */
    @Lob
    private byte[] fotoEquipo;

    /**
     * marca
     */
    private String marca;

    /**
     * modelo
     */
    private String modelo;

    /**
     * ubicacion
     */
    private String ubicacion="";

    /**
     * fabricante
     */
    private String fabricante;

    /**
     * representanteCol
     */
    private String representanteCol;

    /**
     * direccion
     */
    private String direccion;

    /**
     * telefono
     */
    private String telefono;

    @ManyToOne(cascade = CascadeType.ALL)
    private Empresa empresa;

    /**
     * 
     */
    @OneToOne(cascade = CascadeType.ALL)
    private EquipoInfoTecnica infoTecnica;

    /**
     * 
     */
    @OneToOne(cascade = CascadeType.ALL)
    private EstadoEquipo estadoEquipo;

    /**
     * 
     */
    @OneToOne(cascade = CascadeType.ALL)
    private AdquisicionEquipo adquisicionEquipo;

    /**
     * 
     */
    @OneToOne(cascade = CascadeType.ALL)
    private FuncionamientoEquipo funcionamientoEquipo;

    /**
     * 
     */
    @OneToMany(mappedBy = "equipoHospitalario",cascade = CascadeType.ALL)
    private List<MantenimientoEquipo> mantenimientoEquipo;

    /**
     * 
     */
    @OneToOne(cascade = CascadeType.ALL)
    private ManualesEquipo manualesEquipo;

    /**
     * 
     */
    @OneToOne(cascade = CascadeType.ALL)
    private PlanosEquipo planosEquipo;

    /**
     * 
     */
    @OneToOne(cascade = CascadeType.ALL)
    private RecomendacionesEquipo recomendacionesEquipo;

    /**
     * 
     */
    @OneToMany(mappedBy = "equipoHospitalario",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<TipoManteEquipo> manteEquipo;

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
     * Devuelve el valor de fotoEquipo
     * 
     * @return El valor de fotoEquipo
     */
    public byte[] getFotoEquipo() {
        return fotoEquipo;
    }

    /**
     * Establece el valor de fotoEquipo
     * 
     * @param fotoEquipo
     *            El valor por establecer para fotoEquipo
     */
    public void setFotoEquipo(byte[] fotoEquipo) {
        this.fotoEquipo = fotoEquipo;
    }

    /**
     * Devuelve el valor de marca
     * 
     * @return El valor de marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece el valor de marca
     * 
     * @param marca
     *            El valor por establecer para marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Devuelve el valor de modelo
     * 
     * @return El valor de modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el valor de modelo
     * 
     * @param modelo
     *            El valor por establecer para modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Devuelve el valor de ubicacion
     * 
     * @return El valor de ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece el valor de ubicacion
     * 
     * @param ubicacion
     *            El valor por establecer para ubicacion
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Devuelve el valor de fabricante
     * 
     * @return El valor de fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * Establece el valor de fabricante
     * 
     * @param fabricante
     *            El valor por establecer para fabricante
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * Devuelve el valor de representanteCol
     * 
     * @return El valor de representanteCol
     */
    public String getRepresentanteCol() {
        return representanteCol;
    }

    /**
     * Establece el valor de representanteCol
     * 
     * @param representanteCol
     *            El valor por establecer para representanteCol
     */
    public void setRepresentanteCol(String representanteCol) {
        this.representanteCol = representanteCol;
    }

    /**
     * Devuelve el valor de direccion
     * 
     * @return El valor de direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece el valor de direccion
     * 
     * @param direccion
     *            El valor por establecer para direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve el valor de telefono
     * 
     * @return El valor de telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el valor de telefono
     * 
     * @param telefono
     *            El valor por establecer para telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve el valor de infoTecnica
     * 
     * @return El valor de infoTecnica
     */
    public EquipoInfoTecnica getInfoTecnica() {
        return infoTecnica;
    }

    /**
     * Establece el valor de infoTecnica
     * 
     * @param infoTecnica
     *            El valor por establecer para infoTecnica
     */
    public void setInfoTecnica(EquipoInfoTecnica infoTecnica) {
        this.infoTecnica = infoTecnica;
    }

    /**
     * Devuelve el valor de estadoEquipo
     * 
     * @return El valor de estadoEquipo
     */
    public EstadoEquipo getEstadoEquipo() {
        return estadoEquipo;
    }

    /**
     * Establece el valor de estadoEquipo
     * 
     * @param estadoEquipo
     *            El valor por establecer para estadoEquipo
     */
    public void setEstadoEquipo(EstadoEquipo estadoEquipo) {
        this.estadoEquipo = estadoEquipo;
    }

    /**
     * Devuelve el valor de adquisicionEquipo
     * 
     * @return El valor de adquisicionEquipo
     */
    public AdquisicionEquipo getAdquisicionEquipo() {
        return adquisicionEquipo;
    }

    /**
     * Establece el valor de adquisicionEquipo
     * 
     * @param adquisicionEquipo
     *            El valor por establecer para adquisicionEquipo
     */
    public void setAdquisicionEquipo(AdquisicionEquipo adquisicionEquipo) {
        this.adquisicionEquipo = adquisicionEquipo;
    }

    /**
     * Devuelve el valor de funcionamientoEquipo
     * 
     * @return El valor de funcionamientoEquipo
     */
    public FuncionamientoEquipo getFuncionamientoEquipo() {
        return funcionamientoEquipo;
    }

    /**
     * Establece el valor de funcionamientoEquipo
     * 
     * @param funcionamientoEquipo
     *            El valor por establecer para funcionamientoEquipo
     */
    public void setFuncionamientoEquipo(FuncionamientoEquipo funcionamientoEquipo) {
        this.funcionamientoEquipo = funcionamientoEquipo;
    }

    /**
     * Devuelve el valor de mantenimientoEquipo
     * 
     * @return El valor de mantenimientoEquipo
     */
    public List<MantenimientoEquipo> getMantenimientoEquipo() {
        return mantenimientoEquipo;
    }

    /**
     * Establece el valor de mantenimientoEquipo
     * 
     * @param mantenimientoEquipo
     *            El valor por establecer para mantenimientoEquipo
     */
    public void setMantenimientoEquipo(List<MantenimientoEquipo> mantenimientoEquipo) {
        this.mantenimientoEquipo = mantenimientoEquipo;
    }

    /**
     * Devuelve el valor de manualesEquipo
     * 
     * @return El valor de manualesEquipo
     */
    public ManualesEquipo getManualesEquipo() {
        return manualesEquipo;
    }

    /**
     * Establece el valor de manualesEquipo
     * 
     * @param manualesEquipo
     *            El valor por establecer para manualesEquipo
     */
    public void setManualesEquipo(ManualesEquipo manualesEquipo) {
        this.manualesEquipo = manualesEquipo;
    }

    /**
     * Devuelve el valor de planosEquipo
     * 
     * @return El valor de planosEquipo
     */
    public PlanosEquipo getPlanosEquipo() {
        return planosEquipo;
    }

    /**
     * Establece el valor de planosEquipo
     * 
     * @param planosEquipo
     *            El valor por establecer para planosEquipo
     */
    public void setPlanosEquipo(PlanosEquipo planosEquipo) {
        this.planosEquipo = planosEquipo;
    }

    /**
     * Devuelve el valor de recomendacionesEquipo
     * 
     * @return El valor de recomendacionesEquipo
     */
    public RecomendacionesEquipo getRecomendacionesEquipo() {
        return recomendacionesEquipo;
    }

    /**
     * Establece el valor de recomendacionesEquipo
     * 
     * @param recomendacionesEquipo
     *            El valor por establecer para recomendacionesEquipo
     */
    public void setRecomendacionesEquipo(RecomendacionesEquipo recomendacionesEquipo) {
        this.recomendacionesEquipo = recomendacionesEquipo;
    }

    /**
     * Devuelve el valor de manteEquipo
     * 
     * @return El valor de manteEquipo
     */
    public List<TipoManteEquipo> getManteEquipo() {
        return manteEquipo;
    }

    /**
     * Establece el valor de manteEquipo
     * 
     * @param manteEquipo
     *            El valor por establecer para manteEquipo
     */
    public void setManteEquipo(List<TipoManteEquipo> manteEquipo) {
        this.manteEquipo = manteEquipo;
    }

    /**
     * Devuelve el valor de empresa
     * 
     * @return El valor de empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * Establece el valor de empresa
     * 
     * @param empresa
     *            El valor por establecer para empresa
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Devuelve el valor de nombreEquipo
     * 
     * @return El valor de nombreEquipo
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     * Establece el valor de nombreEquipo
     * 
     * @param nombreEquipo
     *            El valor por establecer para nombreEquipo
     */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }
}
