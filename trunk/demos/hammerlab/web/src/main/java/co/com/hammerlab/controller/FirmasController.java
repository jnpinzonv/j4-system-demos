package co.com.hammerlab.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;

import co.com.hammerlab.ejb.MantenimientoEquipoBean;
import co.com.hammerlab.model.Estado;
import co.com.hammerlab.model.MantenimientoEquipo;
import co.com.hammerlab.util.ConstantesUtil;

@Named("firmasController")
@ConversationScoped
public class FirmasController implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2412744316675957914L;

    @Inject
    private Conversation conversation;
    /**
     * Inyeccion de contexto de faces
     */
    @Inject
    private FacesContext facesContext;

    /**
     * Entidad sobre la que se gestiona la transaccion
     */
    private MantenimientoEquipo newObject;
    /**
     * Variable de control
     */
    private boolean editMode;

    /**
     * Variable de control de conversacion
     */
    private boolean bandera = Boolean.FALSE;

    /**
     * 
     */
    @Inject
    private MantenimientoEquipoBean mantenimientoEquipoBean;

    /**
     * 
     */
    private List<MantenimientoEquipo> listaMantenimiento;

    /**
     * 
     */
    private List<MantenimientoEquipo> selectMantenimiento;

    /**
     * 
     */
    public void busqueda() {
        listaMantenimiento = mantenimientoEquipoBean.getAllFirmas();
    }

    /**
     * Asigna el valor del objeto seleccionado pra su edicion
     * 
     * @param userId
     *            Identificador del objeto Seleccionado
     * @return Retorna regla de nevagacion
     */
    public String initEditarModo() {
        editMode = Boolean.TRUE;
        newObject = new MantenimientoEquipo();
        return ConstantesUtil.CREAR_ACTU;
    }

    public String cancelar() {
        newObject = new MantenimientoEquipo();
        busqueda();
        return ConstantesUtil.ATRAS;
    }

    /**
     * Actualiza un objeto en la base de datos
     * 
     * @return Retorna regla de nevagacion
     */
    public String actualizar() {
        try {
            for (MantenimientoEquipo element : selectMantenimiento) {
                element.setFirmaAprobacionTecnico(newObject.getFirmaAprobacionTecnico());
                element.setFirmaAprobacionContrato(newObject.getFirmaAprobacionContrato());
                element.setFirmaAprobacion(newObject.getFirmaAprobacion());
                element.setNumeroHojaFisica(newObject.getNumeroHojaFisica());
                element.setEstadoMantenimiento(Estado.FIRMADO);
                mantenimientoEquipoBean.update(element);
            }

            addMessage(FacesMessage.SEVERITY_INFO, "El registro del Mantenimiento fue actualizado con las firmas ingresadas");
            newObject = new MantenimientoEquipo();
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            addMessage(FacesMessage.SEVERITY_ERROR, errorMessage);
        }
        busqueda();
        selectMantenimiento=null;
        return ConstantesUtil.ATRAS;
    }

    /**
     * @param event
     */
    public void firmaAprobacionFuncionario(FileUploadEvent event) {
        newObject.setFirmaAprobacion(event.getFile().getContents());
        addMessage(FacesMessage.SEVERITY_INFO, event.getFile().getFileName() + " Fue cargado.");
    }

    /**
     * @param event
     */
    public void firmaAprobacionTecnico(FileUploadEvent event) {
        newObject.setFirmaAprobacionTecnico(event.getFile().getContents());
        addMessage(FacesMessage.SEVERITY_INFO, event.getFile().getFileName() + " Fue cargado.");
    }

    /**
     * @param event
     */
    public void firmaAprobacionContrato(FileUploadEvent event) {
        newObject.setFirmaAprobacionContrato(event.getFile().getContents());
        addMessage(FacesMessage.SEVERITY_INFO, event.getFile().getFileName() + " Fue cargado.");
    }

    /**
     * Inicializa el bakinbean de control
     */
    public void initNewObject() {

        if (bandera == Boolean.FALSE) {
            if (conversation.isTransient()) {
                conversation.begin();
            }
            bandera = Boolean.TRUE;
            // equipoHospitalario= controller.getSelectEquipos().get(0);
            newObject = new MantenimientoEquipo();
            busqueda();
            selectMantenimiento = null;

        }

    }

    /**
     * Realiza transformacion de mensaje para el control del log
     * 
     * @param e
     *            Excepcion generada
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
     * Genera un mensaje al contexto
     * 
     * @param severidad
     *            , Severidad del mensaje
     * @param mensaje
     *            Clave del mensaje
     */
    public void addMessage(Severity severidad, String mensaje) {
        facesContext.addMessage(null, new FacesMessage(severidad, "", mensaje));

    }

    /**
     * Devuelve el valor de editMode
     * 
     * @return El valor de editMode
     */
    public boolean isEditMode() {
        return editMode;
    }

    /**
     * Establece el valor de editMode
     * 
     * @param editMode
     *            El valor por establecer para editMode
     */
    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }

    /**
     * Devuelve el valor de bandera
     * 
     * @return El valor de bandera
     */
    public boolean isBandera() {
        return bandera;
    }

    /**
     * Establece el valor de bandera
     * 
     * @param bandera
     *            El valor por establecer para bandera
     */
    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    /**
     * Devuelve el valor de listaMantenimiento
     * 
     * @return El valor de listaMantenimiento
     */
    public List<MantenimientoEquipo> getListaMantenimiento() {
        return listaMantenimiento;
    }

    /**
     * Establece el valor de listaMantenimiento
     * 
     * @param listaMantenimiento
     *            El valor por establecer para listaMantenimiento
     */
    public void setListaMantenimiento(List<MantenimientoEquipo> listaMantenimiento) {
        this.listaMantenimiento = listaMantenimiento;
    }

    /**
     * Devuelve el valor de selectMantenimiento
     * 
     * @return El valor de selectMantenimiento
     */
    public List<MantenimientoEquipo> getSelectMantenimiento() {
        if (selectMantenimiento == null) {
            selectMantenimiento = new ArrayList<MantenimientoEquipo>();
        }
        return selectMantenimiento;
    }

    /**
     * Establece el valor de selectMantenimiento
     * 
     * @param selectMantenimiento
     *            El valor por establecer para selectMantenimiento
     */
    public void setSelectMantenimiento(List<MantenimientoEquipo> selectMantenimiento) {
        this.selectMantenimiento = selectMantenimiento;
    }

    /**
     * Establece el valor de newObject
     * 
     * @param newObject
     *            El valor por establecer para newObject
     */
    public void setNewObject(MantenimientoEquipo newObject) {
        this.newObject = newObject;
    }

    /**
     * Devuelve el valor de newUsuario
     * 
     * @return El valor de newUsuario
     */
    public MantenimientoEquipo getNewObject() {
        return newObject;
    }

}
