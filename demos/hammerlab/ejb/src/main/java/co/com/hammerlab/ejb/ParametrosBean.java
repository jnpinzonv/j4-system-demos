package co.com.hammerlab.ejb;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.hammerlab.model.CategoriasParametros;
import co.com.hammerlab.model.ParametrosGenerales;

/**
 * <b>Descripcion:</b> Clase que <br/> Controla las transaccion y logica de negocio de una determianda entidad
 * <b>Caso de Uso:</b> SOL_MOV- <br/> CreacionModeloBaseDatosPagoUso
 *
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Stateless
public class ParametrosBean {
        
    public transient static String a="hola";
        /**
         * Controlador de base de datos
         */
        @Inject
        private EntityManager entityManager;
         /**
         * Persiste un objeto en la base de datos
         * @param obj Onjeto a ser persistido
         */
        public void save(ParametrosGenerales obj) {
                entityManager.persist(obj);
        }
        /**
         * Actualiza un objeto en base de datos
         * @param obj Objeto a ser actualizado
         */
        public void update(ParametrosGenerales obj) {
                entityManager.merge(obj);
        }
        /**
         * Elimina un objeto en base de datos
         * @param idObj Parametro de filtro de eliminacion 
         */
        public void delete(Long idObj) {
                ParametrosGenerales obj = entityManager.find(ParametrosGenerales.class, idObj);
                entityManager.remove(obj);
        }
        /**
         * Busca un objeto en base de datos por su identificador
         * @param idObj Parametro de busqeuda 
         * @return Retorna Un objeto
         */
        public ParametrosGenerales getByID(Long idObj) {
                return entityManager.find(ParametrosGenerales.class, idObj);
        }
       /**
         * Consulta todos los registro de un objeto
         * @return Lista de objetos 
         */
        public List< ParametrosGenerales > getAll() {
                return entityManager.createNamedQuery("parametrosGenerales.getAll", ParametrosGenerales.class).getResultList();
        }
        
        /**
         * Consulta todos los registro de un objeto
         * @return Lista de objetos 
         */
        public List< ParametrosGenerales > getAllCategoria(CategoriasParametros categoria) {
            Query q= entityManager.createNamedQuery("parametrosCategoria.getAll",ParametrosGenerales.class);
                q.setParameter(1,categoria);
                return q.getResultList();
        }

}