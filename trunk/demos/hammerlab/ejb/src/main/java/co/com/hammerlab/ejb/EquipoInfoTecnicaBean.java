package co.com.hammerlab.ejb;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.com.hammerlab.model.EquipoInfoTecnica;

/**
 * <b>Descripcion:</b> Clase que <br/> Controla las transaccion y logica de negocio de una determianda entidad
 * <b>Caso de Uso:</b> SOL_MOV- <br/> CreacionModeloBaseDatosPagoUso
 *
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Stateless
public class EquipoInfoTecnicaBean {
        
        /**
         * Controlador de base de datos
         */
        @PersistenceContext(unitName = "geoAutomotoresPU")
        private EntityManager entityManager;
         /**
         * Persiste un objeto en la base de datos
         * @param obj Onjeto a ser persistido
         */
        public void save(EquipoInfoTecnica obj) {
                entityManager.persist(obj);
        }
        /**
         * Actualiza un objeto en base de datos
         * @param obj Objeto a ser actualizado
         */
        public void update(EquipoInfoTecnica obj) {
                entityManager.merge(obj);
        }
        /**
         * Elimina un objeto en base de datos
         * @param idObj Parametro de filtro de eliminacion 
         */
        public void delete(Long idObj) {
                EquipoInfoTecnica obj = entityManager.find(EquipoInfoTecnica.class, idObj);
                entityManager.remove(obj);
        }
        /**
         * Busca un objeto en base de datos por su identificador
         * @param idObj Parametro de busqeuda 
         * @return Retorna Un objeto
         */
        public EquipoInfoTecnica getByID(Long idObj) {
                return entityManager.find(EquipoInfoTecnica.class, idObj);
        }
       /**
         * Consulta todos los registro de un objeto
         * @return Lista de objetos 
         */
        public List< EquipoInfoTecnica > getAll() {
                return entityManager.createNamedQuery("equipoInfoTecnica.getAll", EquipoInfoTecnica.class).getResultList();
        }

}