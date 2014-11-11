/**
 * 
 */
package co.com.hammerlab.ejb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.hammerlab.model.CategoriasParametros;
import co.com.hammerlab.model.Constants;
import co.com.hammerlab.model.ParametrosGenerales;

/**
 * <b>Descripcion:</b> Clase que <br/>
 * Controla las transaccion y logica de negocio de una determianda entidad
 * <b>Caso de Uso:</b> SOL_MOV- <br/>
 * ParametrosGenerales
 * 
 * @author Luis Arturo Zarate Ayala <luisarturo1989@gmail.com>
 */
@Stateless
public class ParametrosGeneralesBean {

	@Inject
	private EntityManager entityManager;

	/**
	 * Persiste un objeto en la base de datos
	 * 
	 * @param obj
	 *            Onjeto a ser persistido
	 */
	public void save(ParametrosGenerales parametrosGenerales) {
		entityManager.persist(parametrosGenerales);
	}

	/**
	 * Actualiza un objeto en base de datos
	 * 
	 * @param obj
	 *            Objeto a ser actualizado
	 */
	public void update(ParametrosGenerales parametrosGenerales) {
		entityManager.merge(parametrosGenerales);
	}

	/**
	 * Elimina un objeto en base de datos
	 * 
	 * @param idObj
	 *            Parametro de filtro de eliminacion
	 */
	public void delete(Long idObj) {
		ParametrosGenerales obj = entityManager.find(ParametrosGenerales.class,
				idObj);
		entityManager.remove(obj);
	}

	/**
	 * Busca un objeto en base de datos por su identificador
	 * 
	 * @param idObj
	 *            Parametro de busqeuda
	 * @return Retorna Un objeto
	 */
	public ParametrosGenerales getById(Long id) {
		return entityManager.find(ParametrosGenerales.class, id);
	}

	/**
	 * Consulta todos los registro de un objeto
	 * 
	 * @return Lista de objetos
	 */
	public List<ParametrosGenerales> getAll() {
		Query q = entityManager.createNamedQuery(
				"parametrosGenerales.getAllCategoria",
				ParametrosGenerales.class);
		return q.getResultList();
	}

	/**
	 * @return
	 */
	public List<CategoriasParametros> getListaCategorias() {
		return entityManager.createQuery(
				"select distinct c.categoria from ParametrosGenerales c")
				.getResultList();
	}

	/**
	 * @param generales
	 * @return
	 */
	public List<ParametrosGenerales> getAllSearch(ParametrosGenerales generales) {
		StringBuilder query = new StringBuilder();
		StringBuilder whereSentence = new StringBuilder();
		query.append("select c from ParametrosGenerales c ");
		
		Map <String, Object> parametros = new TreeMap<String, Object>();
		if (generales.getDescripcion() != null
				&& !generales.getDescripcion().trim().equals("")) {
			whereSentence.append(Constants.replaceVocals1 + " c.descripcion"
					+ Constants.replaceVocals2
					+ " like concat('%',:DESCRIPCION,'%')");
			parametros.put("DESCRIPCION",generales.getDescripcion());
		}
		if (generales.getCategoria() != null) {
			if (!whereSentence.toString().equals("")) {
				whereSentence.append(" and ");
			}
			whereSentence.append(" c.categoria = :CATEGORIA ");
			parametros.put("CATEGORIA",generales.getCategoria());
		}
		if (generales.getPropiedad() != null
				&& !generales.getPropiedad().trim().equals("")) {
			if (!whereSentence.toString().equals("")) {
				whereSentence.append(" and ");
			}
			whereSentence.append(Constants.replaceVocals1 + " c.propiedad"
					+ Constants.replaceVocals2
					+ " like concat('%',:PROPIEDAD,'%')");
			parametros.put("PROPIEDAD",generales.getPropiedad());
		}
		if (generales.getValorClave() != null
				&& !generales.getValorClave().trim().equals("")) {
			if (!whereSentence.toString().equals("")) {
				whereSentence.append(" and ");
			}
			whereSentence.append(Constants.replaceVocals1 + " c.valorClave"
					+ Constants.replaceVocals2
					+ " like concat('%',:VALORCLAVE,'%')");
			parametros.put("VALORCLAVE",generales.getValorClave());
		}
		if (!whereSentence.toString().equals("")) {
			query.append(" where ");
			query.append(whereSentence.toString());
		}
		query.append(" order by c.categoria, c.propiedad, c.valorClave");
		Query consulta = entityManager.createQuery(query.toString().trim());
		if (!parametros.isEmpty()) {
			Iterator<String> keys = parametros.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				consulta.setParameter(key, parametros.get(key));				
			}			
		}
		return consulta.getResultList(); 
	}
}
