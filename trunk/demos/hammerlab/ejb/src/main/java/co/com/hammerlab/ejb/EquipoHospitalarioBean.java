package co.com.hammerlab.ejb;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import co.com.hammerlab.model.EquipoHospitalario;

/**
 * <b>Descripcion:</b> Clase que <br/>
 * Controla las transaccion y logica de negocio de una determianda entidad <b>Caso de Uso:</b> SOL_MOV- <br/>
 * CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class EquipoHospitalarioBean {

    /**
     * Controlador de base de datos
     */
    @Inject
    private EntityManager entityManager;

    /**
     * Manejador de transacciones para el EJB
     */
    @Resource
    private UserTransaction tx;

    /**
     * Persiste un objeto en la base de datos
     * 
     * @param obj
     *            Onjeto a ser persistido
     * @throws Exception
     */
    public void save(Object... obj) throws Exception {

        try {

            tx.begin();
            for (Object object : obj) {
                entityManager.persist(object);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new Exception(e);
        }
    }

    /**
     * Persiste un objeto en la base de datos
     * 
     * @param obj
     *            Onjeto a ser persistido
     */
    public void save(EquipoHospitalario obj) throws Exception{
        try {

            tx.begin();
            entityManager.persist(obj);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new Exception(e);
        }
    }

    /**
     * Actualiza un objeto en base de datos
     * 
     * @param obj
     *            Objeto a ser actualizado
     */
    public void update(EquipoHospitalario obj)throws Exception {
        try {

            tx.begin();
            entityManager.merge(obj);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new Exception(e);
        }
    }

    /**
     * Actualiza un objeto en base de datos
     * 
     * @param obj
     *            Objeto a ser actualizado
     */
    public void update(Object... obj)throws Exception {
        try {

            tx.begin();
            for (Object object : obj) {
                entityManager.merge(object);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new Exception(e);
        }
    }

    /**
     * Elimina un objeto en base de datos
     * 
     * @param idObj
     *            Parametro de filtro de eliminacion
     * @throws Exception 
     */
    public void delete(Long idObj) throws Exception {
        try {

            tx.begin();
            EquipoHospitalario obj = entityManager.find(EquipoHospitalario.class, idObj);
            entityManager.remove(obj);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new Exception(e);
        }
    }

    /**
     * Elimina un objeto en base de datos
     * 
     * @param idObj
     *            Parametro de filtro de eliminacion
     * @throws Exception
     */
    public void delete(Object... obj) throws Exception {

        try {

            tx.begin();
            for (Object object : obj) {
                entityManager.remove(object);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new Exception(e);
        }
    }

    /**
     * Busca un objeto en base de datos por su identificador
     * 
     * @param idObj
     *            Parametro de busqeuda
     * @return Retorna Un objeto
     */
    public EquipoHospitalario getByID(Long idObj) {
        return entityManager.find(EquipoHospitalario.class, idObj);
    }

    /**
     * Consulta todos los registro de un objeto
     * 
     * @return Lista de objetos
     */
    public List<EquipoHospitalario> getAll() {
        return entityManager.createNamedQuery("equipoHospitalario.getAll", EquipoHospitalario.class).getResultList();
    }

    /**
     * Consulta todos los registro de un objeto
     * 
     * @return Lista de objetos
     */
    public EquipoHospitalario getAllRelations(Long id) {
        Query q = entityManager.createNamedQuery("equipoHospitalario.getAllRelation", EquipoHospitalario.class);
        q.setParameter("ID", id);

        return (EquipoHospitalario) q.getSingleResult();
    }

    /**
     * Consulta todos los registro de un objeto
     * 
     * @return Lista de objetos
     */
    public List<EquipoHospitalario> search(String consulta, String... parametros) {
        Query q = entityManager.createNamedQuery(consulta, EquipoHospitalario.class);
        if (parametros.length == 3) {
            q.setParameter("EMPRESA", parametros[0]);
            q.setParameter("UBICACION", parametros[1]);
            q.setParameter("NOMBREEQUI", parametros[2]);
        } else if (parametros.length == 2) {
            if (consulta.equals("equipoHospitalario.getAllSearchEquipo")) {
                q.setParameter("EMPRESA", parametros[0]);
                q.setParameter("NOMBREEQUI", parametros[1]);
            } else {
                q.setParameter("EMPRESA", parametros[0]);
                q.setParameter("UBICACION", parametros[1]);
            }
        } else {
            q.setParameter("EMPRESA", parametros[0]);
        }
        return q.getResultList();
    }

}