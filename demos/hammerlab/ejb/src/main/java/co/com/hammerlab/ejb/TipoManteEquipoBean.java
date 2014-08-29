package co.com.hammerlab.ejb;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import co.com.hammerlab.model.TipoManteEquipo;

/**
 * <b>Descripcion:</b> Clase que <br/> Controla las transaccion y logica de negocio de una determianda entidad
 * <b>Caso de Uso:</b> SOL_MOV- <br/> CreacionModeloBaseDatosPagoUso
 *
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Stateless
public class TipoManteEquipoBean {
        
        /**
         * Controlador de base de datos
         */
        @Inject
        private EntityManager entityManager;
         /**
         * Persiste un objeto en la base de datos
         * @param obj Onjeto a ser persistido
         */
        public void save(TipoManteEquipo obj) {
                entityManager.persist(obj);
        }
        /**
         * Actualiza un objeto en base de datos
         * @param obj Objeto a ser actualizado
         */
        public void update(TipoManteEquipo obj) {
                entityManager.merge(obj);
        }
        /**
         * Elimina un objeto en base de datos
         * @param idObj Parametro de filtro de eliminacion 
         */
        public void delete(Long idObj) {
                TipoManteEquipo obj = entityManager.find(TipoManteEquipo.class, idObj);
                entityManager.remove(obj);
        }
        /**
         * Busca un objeto en base de datos por su identificador
         * @param idObj Parametro de busqeuda 
         * @return Retorna Un objeto
         */
        public TipoManteEquipo getByID(Long idObj) {
                return entityManager.find(TipoManteEquipo.class, idObj);
        }
       /**
         * Consulta todos los registro de un objeto
         * @return Lista de objetos 
         */
        public List< TipoManteEquipo > getAll() {
                return entityManager.createNamedQuery("tipoManteEquipo.getAll", TipoManteEquipo.class).getResultList();
        }

}