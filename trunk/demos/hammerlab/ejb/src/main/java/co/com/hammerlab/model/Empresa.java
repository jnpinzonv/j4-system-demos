package co.com.hammerlab.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * <b>Descripcion:</b> Clase que <br/>
 * se encarga de administrar los datos de un Empresa <b>Caso de Uso:</b> SOL_MOV- <br/>
 * CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "empresa")
@NamedQueries({ @NamedQuery(name = "empresa.getAll", query = "select s from Empresa s"),
                @NamedQuery(name = "empresa.getRazonSocial", query = "Select e from Empresa e where " + Constants.replaceVocals1 + " e.razonSocial " + Constants.replaceVocals2 + " like concat('%',:RAZONSOCIAL,'%') ")})
public class Empresa implements Serializable {

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
     * razonSocial
     */
    @Size(max=255, min=0)
    private String razonSocial="";   
    

    /**
     * nit
     */
    @Size(max=255, min=0)
    private String nit;

    /**
     * telefono
     */
    @Size(max=255, min=0)
    private String telefono;

    /**
     * direccion
     */
    @Size(max=255, min=0)
    private String direccion;

    /**
     * correoElectronico
     */
    @Size(max=255, min=0)
    @Pattern(regexp="^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="La dirección de correo no es correcta en su estructura")
    private String correoElectronico;

    /**
     * sitioWeb
     */
    @Size(max=255, min=0)
    private String sitioWeb;
    
    /**
     * 
     */
    @OneToMany(mappedBy="empresa")
    private List<EquipoHospitalario> listaEquipos;

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
     * Devuelve el valor de razonSocial
     * @return El valor de razonSocial
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * Establece el valor de razonSocial
     * @param razonSocial El valor por establecer para razonSocial
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     * Devuelve el valor de nit
     * @return El valor de nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * Establece el valor de nit
     * @param nit El valor por establecer para nit
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * Devuelve el valor de telefono
     * @return El valor de telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el valor de telefono
     * @param telefono El valor por establecer para telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve el valor de direccion
     * @return El valor de direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece el valor de direccion
     * @param direccion El valor por establecer para direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve el valor de correoElectronico
     * @return El valor de correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Establece el valor de correoElectronico
     * @param correoElectronico El valor por establecer para correoElectronico
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Devuelve el valor de sitioWeb
     * @return El valor de sitioWeb
     */
    public String getSitioWeb() {
        return sitioWeb;
    }

    /**
     * Establece el valor de sitioWeb
     * @param sitioWeb El valor por establecer para sitioWeb
     */
    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    /**
     * Devuelve el valor de listaEquipos
     * @return El valor de listaEquipos
     */
    public List<EquipoHospitalario> getListaEquipos() {
        return listaEquipos;
    }

    /**
     * Establece el valor de listaEquipos
     * @param listaEquipos El valor por establecer para listaEquipos
     */
    public void setListaEquipos(List<EquipoHospitalario> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

   

    
}
