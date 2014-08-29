package co.com.hammerlab.ejb;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import co.com.hammerlab.model.AdquisicionEquipo;

/**
 * <b>Descripcion:</b> Clase que <br/> Controla las transaccion y logica de negocio de una determianda entidad
 * <b>Caso de Uso:</b> SOL_MOV- <br/> CreacionModeloBaseDatosPagoUso
 *
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Stateless
public class AdquisicionEquipoBean {
        
        /**
         * Controlador de base de datos
         */
        @Inject
        private EntityManager entityManager;
         /**
         * Persiste un objeto en la base de datos
         * @param obj Onjeto a ser persistido
         */
        public void save(AdquisicionEquipo obj) {
                entityManager.persist(obj);
        }
        /**
         * Actualiza un objeto en base de datos
         * @param obj Objeto a ser actualizado
         */
        public void update(AdquisicionEquipo obj) {
                entityManager.merge(obj);
        }
        /**
         * Elimina un objeto en base de datos
         * @param idObj Parametro de filtro de eliminacion 
         */
        public void delete(Long idObj) {
                AdquisicionEquipo obj = entityManager.find(AdquisicionEquipo.class, idObj);
                entityManager.remove(obj);
        }
        /**
         * Busca un objeto en base de datos por su identificador
         * @param idObj Parametro de busqeuda 
         * @return Retorna Un objeto
         */
        public AdquisicionEquipo getByID(Long idObj) {
                return entityManager.find(AdquisicionEquipo.class, idObj);
        }
       /**
         * Consulta todos los registro de un objeto
         * @return Lista de objetos 
         */
        public List< AdquisicionEquipo > getAll() {
                return entityManager.createNamedQuery("adquisicionEquipo.getAll", AdquisicionEquipo.class).getResultList();
        }

}