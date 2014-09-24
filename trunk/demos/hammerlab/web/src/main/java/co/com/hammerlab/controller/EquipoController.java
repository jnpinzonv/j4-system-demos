package co.com.hammerlab.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DualListModel;

import co.com.hammerlab.ejb.EquipoHospitalarioBean;
import co.com.hammerlab.ejb.ParametrosBean;
import co.com.hammerlab.model.AdquisicionEquipo;
import co.com.hammerlab.model.CategoriasParametros;
import co.com.hammerlab.model.Empresa;
import co.com.hammerlab.model.EquipoHospitalario;
import co.com.hammerlab.model.EquipoInfoTecnica;
import co.com.hammerlab.model.EstadoEquipo;
import co.com.hammerlab.model.FuncionamientoEquipo;
import co.com.hammerlab.model.ManualesEquipo;
import co.com.hammerlab.model.ParametrosGenerales;
import co.com.hammerlab.model.PlanosEquipo;
import co.com.hammerlab.model.RecomendacionesEquipo;
import co.com.hammerlab.model.TipoManteEquipo;
import co.com.hammerlab.util.ConstantesUtil;

@Named("equipoController")
@ConversationScoped
public class EquipoController implements Serializable {

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
    private EquipoHospitalario newObject;
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
    private EquipoHospitalarioBean equipoHospitalarioBean;

    @Inject
    private ParametrosBean parametrosBean;
    
    @Inject
    private EmpresaController empresaController;
    
    private AdquisicionEquipo adquisicionEquipo;

    private EquipoInfoTecnica infoTecnica;

    private EstadoEquipo estadoEquipo;

    private FuncionamientoEquipo funcionamientoEquipo;

    private PlanosEquipo planosEquipo;

    private ManualesEquipo manualesEquipo;

    private RecomendacionesEquipo recomendacionesEquipo;

    private TipoManteEquipo tipoManteEquipoPre;
    
    private TipoManteEquipo tipoManteEquipoCorr;

    private Map<String, String> ubicacionList;
    
    private List<String> tecnologiaList;
    
    private DualListModel<String> recomendacionesList= new DualListModel<String>();
    
    private String accion;
    
    /**
     * 
     */
    private List<EquipoHospitalario> listaEquipos;

    /**
     * 
     */
    private List<EquipoHospitalario> selectEquipos;
    
    private List<Empresa>  listaEmpresa;
    
    ArrayList <String> target = new ArrayList<String>();

    /**
     * Inicializa el bakend bean de control
     */
    public void initNewObject() {
      
        if(bandera == Boolean.FALSE){
            if (conversation.isTransient()) {
                conversation.begin();
            }
            bandera = Boolean.TRUE;
            
            // TODO pendienta para inicializar el estado de editaod se deve mover
            if (editMode == Boolean.FALSE) {
                newObject = new EquipoHospitalario();
            }
            ubicacionList= new TreeMap<String, String>();
            tecnologiaList= new ArrayList<String>();
            for (ParametrosGenerales element : parametrosBean.getAllCategoria(CategoriasParametros.UBICACION)) {
                ubicacionList.put(element.getPropiedad(),element.getPropiedad());                
            }
            for (ParametrosGenerales elemen :parametrosBean.getAllCategoria(CategoriasParametros.TECNOLOGIA)) {
                tecnologiaList.add(elemen.getPropiedad());
            }
            
            ArrayList< String> source = new ArrayList<String>();
           
            for (ParametrosGenerales element : parametrosBean.getAllCategoria(CategoriasParametros.RECOMENDACIONES)) {
               source.add(element.getPropiedad());
            }
            
            recomendacionesList.setSource(source);
            recomendacionesList.setTarget(target);
            adquisicionEquipo= new AdquisicionEquipo();
            infoTecnica= new EquipoInfoTecnica();
            estadoEquipo= new EstadoEquipo();
            funcionamientoEquipo= new FuncionamientoEquipo();
            planosEquipo= new PlanosEquipo();
            manualesEquipo= new ManualesEquipo();
            recomendacionesEquipo= new RecomendacionesEquipo();
            tipoManteEquipoPre= new TipoManteEquipo();
            tipoManteEquipoCorr= new TipoManteEquipo();
            
            listaEmpresa= new ArrayList<Empresa>();
            
        }
        busqueda();
        
    }

   
    
    

    public void busqueda() {
        listaEquipos = equipoHospitalarioBean.getAll();
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
        newObject = equipoHospitalarioBean.getByID(selectEquipos.get(0).getId());
        return ConstantesUtil.CREAR_ACTU;
    }

    public String initVistaModo() {
        newObject = equipoHospitalarioBean.getByID(selectEquipos.get(0).getId());
        return ConstantesUtil.VER;
    }

    public String initCrearModo() {
        return ConstantesUtil.CREAR_ACTU;
    }

    public String cancelar() {
        return ConstantesUtil.ATRAS;
    }

    public String reiniciar() {
        return ConstantesUtil.ATRAS;
    }
    
    public void cargarEmpresa(){
        if(accion!=null){
            listaEmpresa.clear();
            listaEmpresa.add(empresaController.getEmpresaSelect());
            empresaController.setEmpresaSelect(null);
        }
    }

    /**
     * Actualiza un objeto en la base de datos
     * 
     * @return Retorna regla de nevagacion
     */
    public String actualizar() {
        try {
            equipoHospitalarioBean.update(newObject);
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
     * 
     * @param id
     *            Identificador del objeto a eliminar
     * @return Retorna regla de nevagacion
     */
    public void eliminar(Long idObject) {
        try {
            equipoHospitalarioBean.delete(idObject);
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Empresa Eliminada!", "Exito!!"));
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            addMessage(FacesMessage.SEVERITY_ERROR, errorMessage);

        }
    }

    /**
     * Registra un nuevo objeto en Base de datos
     * 
     * @return Retorna regla de nevagacion
     * @throws Exception
     *             Lanza una excepcion si hay un error en la transacciòn
     */
    public String crear() {
        try {          
            StringBuilder nuevo= new StringBuilder();
            for (String recomendaciones : target) {
                nuevo.append(recomendaciones);
                nuevo.append(",");
            }
            equipoHospitalarioBean.save(tipoManteEquipoCorr,tipoManteEquipoPre,recomendacionesEquipo,manualesEquipo,adquisicionEquipo,estadoEquipo,infoTecnica,funcionamientoEquipo,planosEquipo,newObject);
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!", "Se guardo un registro de una Empresa"));
            initNewObject();
            busqueda();
            return ConstantesUtil.ATRAS;
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            addMessage(FacesMessage.SEVERITY_ERROR, errorMessage);

        }
        return ConstantesUtil.ATRAS;
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
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
     * Devuelve el valor de adquisicionEquipo
     * 
     * @return El valor de adquisicionEquipo
     */
    public AdquisicionEquipo getAdquisicionEquipo() {
        return adquisicionEquipo;
    }

    /**
     * Establece el valor de adquisicionEquipo
     * 
     * @param adquisicionEquipo
     *            El valor por establecer para adquisicionEquipo
     */
    public void setAdquisicionEquipo(AdquisicionEquipo adquisicionEquipo) {
        this.adquisicionEquipo = adquisicionEquipo;
    }

    /**
     * Devuelve el valor de infoTecnica
     * 
     * @return El valor de infoTecnica
     */
    public EquipoInfoTecnica getInfoTecnica() {
        return infoTecnica;
    }

    /**
     * Establece el valor de infoTecnica
     * 
     * @param infoTecnica
     *            El valor por establecer para infoTecnica
     */
    public void setInfoTecnica(EquipoInfoTecnica infoTecnica) {
        this.infoTecnica = infoTecnica;
    }

    /**
     * Devuelve el valor de estadoEquipo
     * 
     * @return El valor de estadoEquipo
     */
    public EstadoEquipo getEstadoEquipo() {
        return estadoEquipo;
    }

    /**
     * Establece el valor de estadoEquipo
     * 
     * @param estadoEquipo
     *            El valor por establecer para estadoEquipo
     */
    public void setEstadoEquipo(EstadoEquipo estadoEquipo) {
        this.estadoEquipo = estadoEquipo;
    }

    /**
     * Devuelve el valor de funcionamientoEquipo
     * 
     * @return El valor de funcionamientoEquipo
     */
    public FuncionamientoEquipo getFuncionamientoEquipo() {
        return funcionamientoEquipo;
    }

    /**
     * Establece el valor de funcionamientoEquipo
     * 
     * @param funcionamientoEquipo
     *            El valor por establecer para funcionamientoEquipo
     */
    public void setFuncionamientoEquipo(FuncionamientoEquipo funcionamientoEquipo) {
        this.funcionamientoEquipo = funcionamientoEquipo;
    }

    /**
     * Devuelve el valor de planosEquipo
     * 
     * @return El valor de planosEquipo
     */
    public PlanosEquipo getPlanosEquipo() {
        return planosEquipo;
    }

    /**
     * Establece el valor de planosEquipo
     * 
     * @param planosEquipo
     *            El valor por establecer para planosEquipo
     */
    public void setPlanosEquipo(PlanosEquipo planosEquipo) {
        this.planosEquipo = planosEquipo;
    }

    /**
     * Devuelve el valor de manualesEquipo
     * 
     * @return El valor de manualesEquipo
     */
    public ManualesEquipo getManualesEquipo() {
        return manualesEquipo;
    }

    /**
     * Establece el valor de manualesEquipo
     * 
     * @param manualesEquipo
     *            El valor por establecer para manualesEquipo
     */
    public void setManualesEquipo(ManualesEquipo manualesEquipo) {
        this.manualesEquipo = manualesEquipo;
    }

    /**
     * Devuelve el valor de recomendacionesEquipo
     * 
     * @return El valor de recomendacionesEquipo
     */
    public RecomendacionesEquipo getRecomendacionesEquipo() {
        return recomendacionesEquipo;
    }

    /**
     * Establece el valor de recomendacionesEquipo
     * 
     * @param recomendacionesEquipo
     *            El valor por establecer para recomendacionesEquipo
     */
    public void setRecomendacionesEquipo(RecomendacionesEquipo recomendacionesEquipo) {
        this.recomendacionesEquipo = recomendacionesEquipo;
    }

    /**
     * Devuelve el valor de tipoManteEquipoPre
     * @return El valor de tipoManteEquipoPre
     */
    public TipoManteEquipo getTipoManteEquipoPre() {
        return tipoManteEquipoPre;
    }

    /**
     * Establece el valor de tipoManteEquipoPre
     * @param tipoManteEquipoPre El valor por establecer para tipoManteEquipoPre
     */
    public void setTipoManteEquipoPre(TipoManteEquipo tipoManteEquipoPre) {
        this.tipoManteEquipoPre = tipoManteEquipoPre;
    }

    /**
     * Devuelve el valor de tipoManteEquipoCorr
     * @return El valor de tipoManteEquipoCorr
     */
    public TipoManteEquipo getTipoManteEquipoCorr() {
        return tipoManteEquipoCorr;
    }

    /**
     * Establece el valor de tipoManteEquipoCorr
     * @param tipoManteEquipoCorr El valor por establecer para tipoManteEquipoCorr
     */
    public void setTipoManteEquipoCorr(TipoManteEquipo tipoManteEquipoCorr) {
        this.tipoManteEquipoCorr = tipoManteEquipoCorr;
    }

    /**
     * Establece el valor de newObject
     * 
     * @param newObject
     *            El valor por establecer para newObject
     */
    public void setNewObject(EquipoHospitalario newObject) {
        this.newObject = newObject;
    }

    /**
     * Devuelve el valor de listaEquipos
     * 
     * @return El valor de listaEquipos
     */
    public List<EquipoHospitalario> getListaEquipos() {
        return listaEquipos;
    }

    /**
     * Establece el valor de listaEquipos
     * 
     * @param listaEquipos
     *            El valor por establecer para listaEquipos
     */
    public void setListaEquipos(List<EquipoHospitalario> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    /**
     * Devuelve el valor de selectEquipos
     * 
     * @return El valor de selectEquipos
     */
    public List<EquipoHospitalario> getSelectEquipos() {
        if (selectEquipos == null) {
            selectEquipos = new ArrayList<EquipoHospitalario>();
        }
        return selectEquipos;
    }

    /**
     * Establece el valor de selectEquipos
     * 
     * @param selectEquipos
     *            El valor por establecer para selectEquipos
     */
    public void setSelectEquipos(List<EquipoHospitalario> selectEquipos) {
        this.selectEquipos = selectEquipos;
    }

    /**
     * Devuelve el valor de ubicacionList
     * 
     * @return El valor de ubicacionList
     */
    public Map<String, String> getUbicacionList() {
        return ubicacionList;
    }

    /**
     * Establece el valor de ubicacionList
     * 
     * @param ubicacionList
     *            El valor por establecer para ubicacionList
     */
    public void setUbicacionList(Map<String, String> ubicacionList) {
        this.ubicacionList = ubicacionList;
    }

    /**
     * Devuelve el valor de tecnologiaList
     * @return El valor de tecnologiaList
     */
    public List<String> getTecnologiaList() {
        return tecnologiaList;
    }

    /**
     * Establece el valor de tecnologiaList
     * @param tecnologiaList El valor por establecer para tecnologiaList
     */
    public void setTecnologiaList(List<String> tecnologiaList) {
        this.tecnologiaList = tecnologiaList;
    }

    /**
     * Devuelve el valor de recomendacionesList
     * @return El valor de recomendacionesList
     */
    public DualListModel<String> getRecomendacionesList() {
        return recomendacionesList;
    }

    /**
     * Establece el valor de recomendacionesList
     * @param recomendacionesList El valor por establecer para recomendacionesList
     */
    public void setRecomendacionesList(DualListModel<String> recomendacionesList) {
        this.recomendacionesList = recomendacionesList;
    }

    /**
     * Devuelve el valor de accion
     * @return El valor de accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * Establece el valor de accion
     * @param accion El valor por establecer para accion
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }
    
    /**
     * Devuelve el valor de newUsuario
     * 
     * @return El valor de newUsuario
     */
    public EquipoHospitalario getNewObject() {
        return newObject;
    }





    /**
     * Devuelve el valor de listaEmpresa
     * @return El valor de listaEmpresa
     */
    public List<Empresa> getListaEmpresa() {
        return listaEmpresa;
    }





    /**
     * Establece el valor de listaEmpresa
     * @param listaEmpresa El valor por establecer para listaEmpresa
     */
    public void setListaEmpresa(List<Empresa> listaEmpresa) {
        this.listaEmpresa = listaEmpresa;
    }

   
   

}
