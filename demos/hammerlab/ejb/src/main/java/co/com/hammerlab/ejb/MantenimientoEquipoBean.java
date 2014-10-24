package co.com.hammerlab.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.com.hammerlab.model.EquipoHospitalario;
import co.com.hammerlab.model.Estado;
import co.com.hammerlab.model.MantenimientoEquipo;

/**
 * <b>Descripcion:</b> Clase que <br/>
 * Controla las transaccion y logica de negocio de una determianda entidad <b>Caso de Uso:</b> SOL_MOV- <br/>
 * CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@Stateless
public class MantenimientoEquipoBean {

    /**
     * Controlador de base de datos
     */
    @Inject
    private EntityManager entityManager;

    /**
     * Persiste un objeto en la base de datos
     * 
     * @param obj
     *            Onjeto a ser persistido
     */
    public void save(MantenimientoEquipo obj) {
        entityManager.persist(obj);
    }

    /**
     * Actualiza un objeto en base de datos
     * 
     * @param obj
     *            Objeto a ser actualizado
     */
    public void update(MantenimientoEquipo obj) {
        entityManager.merge(obj);
    }

    /**
     * Elimina un objeto en base de datos
     * 
     * @param idObj
     *            Parametro de filtro de eliminacion
     */
    public void delete(Long idObj) {
        MantenimientoEquipo obj = entityManager.find(MantenimientoEquipo.class, idObj);
        entityManager.remove(obj);
    }

    /**
     * Busca un objeto en base de datos por su identificador
     * 
     * @param idObj
     *            Parametro de busqeuda
     * @return Retorna Un objeto
     */
    public MantenimientoEquipo getByID(Long idObj) {
        return entityManager.find(MantenimientoEquipo.class, idObj);
    }

    /**
     * Consulta todos los registro de un objeto
     * 
     * @return Lista de objetos
     */
    public List<MantenimientoEquipo> getAll() {
        return entityManager.createNamedQuery("mantenimientoequipo.getAll", MantenimientoEquipo.class).getResultList();
    }

    /**
     * Consulta todos los registro de un objeto
     * 
     * @return Lista de objetos
     */
    public List<MantenimientoEquipo> getAll(EquipoHospitalario idEquipo) {
        Query q = entityManager.createNamedQuery("mantenimientoequipo.getAllEquipo", MantenimientoEquipo.class);
        q.setParameter("EQUIPO", idEquipo);
        return q.getResultList();
    }

    /**
     * Consulta todos los registro de un objeto
     * 
     * @return Lista de objetos
     */
    public List<MantenimientoEquipo> getAll(Long idEquipo, Estado estadoEquipo) {
        Query q = entityManager.createNamedQuery("mantenimientoequipo.getAllDOS", MantenimientoEquipo.class);
        q.setParameter("IDTRAN", idEquipo);
        q.setParameter("ESTADO", estadoEquipo);
        return q.getResultList();
    }

    /**
     * Consulta todos los registro de un objeto
     * 
     * @return Lista de objetos
     */
    public List<MantenimientoEquipo> getAllIDTra(Long idEquipo) {
        Query q = entityManager.createNamedQuery("mantenimientoequipo.getAllIdTrans", MantenimientoEquipo.class);
        q.setParameter("IDTRAN", idEquipo);
        return q.getResultList();
    }

    /**
     * Consulta todos los registro de un objeto
     * 
     * @return Lista de objetos
     */
    public List<MantenimientoEquipo> getAllESTADO(Estado estadoEquipo) {
        Query q = entityManager.createNamedQuery("mantenimientoequipo.getAllESTADO", MantenimientoEquipo.class);
        q.setParameter("ESTADO", estadoEquipo);
        return q.getResultList();
    }

    /**
     * Consulta todos los registro de un objeto
     * 
     * @return Lista de objetos
     */
    public List<MantenimientoEquipo> getAllFirmas() {
        return entityManager.createNamedQuery("mantenimientoequipo.getfirmas", MantenimientoEquipo.class).getResultList();
    }

}