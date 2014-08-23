package co.com.hammerlab.controller;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import co.com.hammerlab.ejb.EmpresaBean;
import co.com.hammerlab.model.Empresa;
/**
 * <b>Descripcion:</b> Clase que <br/> se encarga de controlar los datos de un Empresa
 * <b>Caso de Uso:</b> SOL_MOV- <br/> CreacionModeloBaseDatosPagoUso
 * 
 * @author Josué Nicolás Pinzón Villamil <jnpinzonv@gmail.com>
 */
@ManagedBean
@ViewScoped
public class EmpresaController {

    /**
     * Inyeccion de contexto de faces
     */
    @Inject
    private FacesContext facesContext;
    /**
     * Realcion con el EJB que controla las transacciones del objeto
     */
    @Inject
    private EmpresaBean EmpresaBean;
    /**
     * Entidad sobre la que se gestiona la transaccion
     */
    private Empresa newObject;
    /**
     * Variable de control
     */
    private boolean editEmpresa;

    /**
     * Devuelve el valor de editEmpresa
     * 
     * @return El valor de editEmpresa
     */
    @Produces
    @Named
    public boolean iseditEmpresa() {
        return editEmpresa;
    }

      /**
     * Devuelve el valor de newUsuario
     * 
     * @return El valor de newUsuario
     */
    @Produces
    @Named
    public Empresa getNewObject() {
        return newObject;
    }
    /**
     * Asigna el valor del objeto seleccionado pra su edicion
     * @param userId Identificador del objeto Seleccionado
     * @return Retorna regla de nevagacion
     */
    public void cargarEmpresaEditar(Long objectId) {
        editEmpresa = Boolean.TRUE;
        newObject = EmpresaBean.getByID(objectId);
    }
    /**
     * Actualiza un objeto en la base de datos
     * @return Retorna regla de nevagacion
     */
    public void actualizarEmpresa() {
        try {
            EmpresaBean.update(newObject);
            editEmpresa = Boolean.FALSE;
            initNewObject();
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "No se realizo la actualización");
            facesContext.addMessage(null, m);
        }
    }
    /**
     * Elimina un objeto en base de datos
     * @param id Identificador del objeto a eliminar
     * @return Retorna regla de nevagacion
     */
    public void eliminarEmpresa(Long idObject) {
        try {
            EmpresaBean.delete(idObject);
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Empresa Eliminada!", "Exito!!"));
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Se Elimino la Empresa");
            facesContext.addMessage(null, m);
        }
    }
    /**
     * Registra un nuevo objeto en Base de datos
     *@return Retorna regla de nevagacion
     * @throws Exception Lanza una excepcion si hay un error en la transacciòn 
     */
    public String register() throws Exception {
        try {
            EmpresaBean.save(newObject);
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!", "Se realizo un resgistro exitoso de Empresa"));
            initNewObject();
            return "";
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Error de Empresa");
            facesContext.addMessage(null, m);
        }
        return "";
    }
    /**
     * Inicializa el bakinbean de control
     */
    @PostConstruct
    public void initNewObject() {
        if (editEmpresa == Boolean.FALSE) {
            newObject = new Empresa();
        }
    }
    /**
     * Realiza transformacion de mensaje para el control del log
     * @param e Excepcion generada
     * @return Retorna el mensaje de error
     */
    private String getRootErrorMessage(Exception e) {
        // Default to general error message that registration failed.
        String errorMessage = "Registration failed. See server log for more information";
        if (e == null) {
            // This shouldn't happen, but return the default messages
            return errorMessage;
        }

        // Start with the exception and recurse to find the root cause
        Throwable t = e;
        while (t != null) {
            // Get the message from the Throwable class instance
            errorMessage = t.getLocalizedMessage();
            t = t.getCause();
        }
        // This is the root cause message
        return errorMessage;
    }
    /**
     * Lista de objetos a ser consultados y visualizados en pantalla
     * @return Retorna una lista de obejtos
     */
    public List< Empresa > getListaEmpresa() {
        return EmpresaBean.getAll();
    }
}
