package co.com.hammerlab.ejb;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.hammerlab.model.Empresa;

/**
 * <b>Descripcion:</b> Clase que <br/> Controla las transaccion y logica de negocio de una determianda entidad
 * <b>Caso de Uso:</b> SOL_MOV- <br/> CreacionModeloBaseDatosPagoUso
 *
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Stateless
public class EmpresaBean {
        
        /**
         * Controlador de base de datos
         */
        @Inject
        private EntityManager entityManager;
         /**
         * Persiste un objeto en la base de datos
         * @param obj Onjeto a ser persistido
         */
        public void save(Empresa obj) {
                entityManager.persist(obj);
        }
        /**
         * Actualiza un objeto en base de datos
         * @param obj Objeto a ser actualizado
         */
        public void update(Empresa obj) {
                entityManager.merge(obj);
        }
        /**
         * Elimina un objeto en base de datos
         * @param idObj Parametro de filtro de eliminacion 
         */
        public void delete(Long idObj) {
                Empresa obj = entityManager.find(Empresa.class, idObj);
                entityManager.remove(obj);
        }
        /**
         * Busca un objeto en base de datos por su identificador
         * @param idObj Parametro de busqeuda 
         * @return Retorna Un objeto
         */
        public Empresa getByID(Long idObj) {
                return entityManager.find(Empresa.class, idObj);
        }
       /**
         * Consulta todos los registro de un objeto
         * @return Lista de objetos 
         */
        public List< Empresa > getAll() {
                return entityManager.createNamedQuery("empresa.getAll", Empresa.class).getResultList();
        }
        
        /**
         * Consulta todos los registro de un objeto
         * @return Lista de objetos 
         */
        public List< Empresa > getAllName(String parametro) {
            Query q= entityManager.createNamedQuery("empresa.getRazonSocial", Empresa.class);
                    q.setParameter("RAZONSOCIAL", parametro);
                return q.getResultList();
        }

}