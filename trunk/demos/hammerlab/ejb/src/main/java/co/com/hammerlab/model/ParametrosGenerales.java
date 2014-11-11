package co.com.hammerlab.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * <b>Descripcion:</b> Clase que <br/>
 * representa una tabla parametrica de la ubicacion del equipo <b>Caso de
 * Uso:</b> SOL_MOV- <br/>
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Entity
@Table(name = "parametros_generales")
@NamedQueries({
		@NamedQuery(name = "parametrosGenerales.getAll", query = "select s from ParametrosGenerales s"),
		@NamedQuery(name = "parametrosCategoria.getAll", query = "select s from ParametrosGenerales s where s.categoria = ?"),
		@NamedQuery(name = "parametrosGenerales.getAllCategoria", query = "select s from ParametrosGenerales s order by s.categoria")})
public class ParametrosGenerales implements Serializable {

	/**
	 * representa el identificador de Serializacion
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Valor de la clave de la propiedad
	 */
	private String valorClave;

	/**
	 * Valor de la propiedad.
	 */
	private String propiedad;

	/**
	 * Categoria que a la que pertence un grupo de caracteristicas
	 */
	@Enumerated(EnumType.STRING)
	private CategoriasParametros categoria;

	/**
	 * Descripcion de la propiedad
	 */
	private String descripcion;

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
	 * Devuelve el valor de valorClave
	 * 
	 * @return El valor de valorClave
	 */
	public String getValorClave() {
		return valorClave;
	}

	/**
	 * Establece el valor de valorClave
	 * 
	 * @param valorClave
	 *            El valor por establecer para valorClave
	 */
	public void setValorClave(String valorClave) {
		this.valorClave = valorClave;
	}

	/**
	 * Devuelve el valor de propiedad
	 * 
	 * @return El valor de propiedad
	 */
	public String getPropiedad() {
		return propiedad;
	}

	/**
	 * Establece el valor de propiedad
	 * 
	 * @param propiedad
	 *            El valor por establecer para propiedad
	 */
	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}

	/**
	 * Devuelve el valor de categoria
	 * 
	 * @return El valor de categoria
	 */
	public CategoriasParametros getCategoria() {
		return categoria;
	}

	/**
	 * Establece el valor de categoria
	 * 
	 * @param categoria
	 *            El valor por establecer para categoria
	 */
	public void setCategoria(CategoriasParametros categoria) {
		this.categoria = categoria;
	}

	/**
	 * Devuelve el valor de descripcion
	 * 
	 * @return El valor de descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece el valor de descripcion
	 * 
	 * @param descripcion
	 *            El valor por establecer para descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
