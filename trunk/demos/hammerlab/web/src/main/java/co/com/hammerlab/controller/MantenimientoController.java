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

import co.com.hammerlab.ejb.MantenimientoEquipoBean;
import co.com.hammerlab.model.AdquisicionEquipo;
import co.com.hammerlab.model.EquipoHospitalario;
import co.com.hammerlab.model.EquipoInfoTecnica;
import co.com.hammerlab.model.EstadoEquipo;
import co.com.hammerlab.model.FuncionamientoEquipo;
import co.com.hammerlab.model.MantenimientoEquipo;
import co.com.hammerlab.model.ManualesEquipo;
import co.com.hammerlab.model.PlanosEquipo;
import co.com.hammerlab.model.RecomendacionesEquipo;
import co.com.hammerlab.model.TipoManteEquipo;
import co.com.hammerlab.util.ConstantesUtil;


@Named("mantenimientoController")
@ConversationScoped
public class MantenimientoController implements Serializable {

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
    private boolean bandera= Boolean.FALSE;
    
    /**
     * 
     */
    @Inject
    private MantenimientoEquipoBean mantenimientoEquipoBean;
    
    @Inject
    private EquipoController controller;
  
    
   private EquipoHospitalario equipoHospitalario;

   

      /**
     * Devuelve el valor de newUsuario
     * 
     * @return El valor de newUsuario
     */   
    public MantenimientoEquipo getNewObject() {
        return newObject;
    }
    
    /**
     * 
     */
    private List<MantenimientoEquipo> listaMantenimiento;
    
    /**
     * 
     */
    private List<MantenimientoEquipo> selectMantenimiento;
    
    public void busqueda(){
        listaMantenimiento= mantenimientoEquipoBean.getAll();
    }
    /**
     * Asigna el valor del objeto seleccionado pra su edicion
     * @param userId Identificador del objeto Seleccionado
     * @return Retorna regla de nevagacion
     */
    public String initEditarModo() {
        editMode = Boolean.TRUE;
        newObject = mantenimientoEquipoBean.getByID(selectMantenimiento.get(0).getId());
        return ConstantesUtil.CREAR_ACTU;
    }
    
    public String initVistaModo(){
         newObject = mantenimientoEquipoBean.getByID(selectMantenimiento.get(0).getId());
         return ConstantesUtil.VER;
    }
    
    public String initCrearModo(){
        return ConstantesUtil.CREAR_ACTU;
    }
    
    public String cancelar() {
        return ConstantesUtil.ATRAS;
    }
    
    public String reiniciar() {
        return ConstantesUtil.ATRAS;
    }
    /**
     * Actualiza un objeto en la base de datos
     * @return Retorna regla de nevagacion
     */
    public String actualizar() {
        try {
            mantenimientoEquipoBean.update(newObject);
            editMode = Boolean.FALSE;
            initNewObject();
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            addMessage(FacesMessage.SEVERITY_ERROR, errorMessage);            
        }
        
        return ConstantesUtil.ATRAS;
    }
    
   
    
    
    /**
     * Elimina un objeto en base de datos
     * @param id Identificador del objeto a eliminar
     * @return Retorna regla de nevagacion
     */
    public void eliminar(Long idObject) {
        try {
            mantenimientoEquipoBean.delete(idObject);
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Empresa Eliminada!", "Exito!!"));
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            addMessage(FacesMessage.SEVERITY_ERROR, errorMessage);
            
        }
    }
    /**
     * Registra un nuevo objeto en Base de datos
     *@return Retorna regla de nevagacion
     * @throws Exception Lanza una excepcion si hay un error en la transacciòn 
     */
    public String crear(){
        try {
            mantenimientoEquipoBean.save(newObject);
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!", "Se guardo un registro de una Empresa"));
            initNewObject();
            return ConstantesUtil.ATRAS;
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
           addMessage(FacesMessage.SEVERITY_ERROR, errorMessage);
           
        }
        return "";
    }
    /**
     * Inicializa el bakinbean de control
     */   
    public void initNewObject() {
      
        if(bandera == Boolean.FALSE){
            if (conversation.isTransient()) {
                conversation.begin();
            }
            bandera = Boolean.TRUE;
            equipoHospitalario= controller.getSelectEquipos().get(0);
            // TODO pendienta para inicializar el estado de editaod se deve mover
            if (editMode == Boolean.FALSE) {
                newObject = new MantenimientoEquipo();
            }
            
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
     * Genera un mensaje al contexto
     * 
     * @param severidad
     *            , Severidad del mensaje
     * @param mensaje
     *            Clave del mensaje
     */
    public void addMessage(Severity severidad, String mensaje) {
        facesContext.addMessage(null, new FacesMessage(severidad, "",mensaje));

    }
    /**
     * Devuelve el valor de editMode
     * @return El valor de editMode
     */
    public boolean isEditMode() {
        return editMode;
    }
    /**
     * Establece el valor de editMode
     * @param editMode El valor por establecer para editMode
     */
    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
    }
    /**
     * Devuelve el valor de bandera
     * @return El valor de bandera
     */
    public boolean isBandera() {
        return bandera;
    }
    /**
     * Establece el valor de bandera
     * @param bandera El valor por establecer para bandera
     */
    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
  
    /**
     * Devuelve el valor de listaMantenimiento
     * @return El valor de listaMantenimiento
     */
    public List<MantenimientoEquipo> getListaMantenimiento() {
        return listaMantenimiento;
    }
    /**
     * Establece el valor de listaMantenimiento
     * @param listaMantenimiento El valor por establecer para listaMantenimiento
     */
    public void setListaMantenimiento(List<MantenimientoEquipo> listaMantenimiento) {
        this.listaMantenimiento = listaMantenimiento;
    }
    /**
     * Devuelve el valor de selectMantenimiento
     * @return El valor de selectMantenimiento
     */
    public List<MantenimientoEquipo> getSelectMantenimiento() {
        if(selectMantenimiento==null){
            selectMantenimiento= new ArrayList<MantenimientoEquipo>();
        }
        return selectMantenimiento;
    }
    /**
     * Establece el valor de selectMantenimiento
     * @param selectMantenimiento El valor por establecer para selectMantenimiento
     */
    public void setSelectMantenimiento(List<MantenimientoEquipo> selectMantenimiento) {
        this.selectMantenimiento = selectMantenimiento;
    }
    /**
     * Establece el valor de newObject
     * @param newObject El valor por establecer para newObject
     */
    public void setNewObject(MantenimientoEquipo newObject) {
        this.newObject = newObject;
    }
  
    
    
    

}
