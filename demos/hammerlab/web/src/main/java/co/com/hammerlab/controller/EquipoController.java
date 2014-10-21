package co.com.hammerlab.controller;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.primefaces.event.FileUploadEvent;

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
import co.com.hammerlab.model.TipoMantenimiento;
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
     * Entidad sobre la que se gestiona la transaccion
     */
    private EquipoHospitalario newObjectCo;
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

    private AdquisicionEquipo adquisicionEquipoCo;

    private EquipoInfoTecnica infoTecnicaCo;

    private EstadoEquipo estadoEquipoCo;

    private FuncionamientoEquipo funcionamientoEquipoCo;

    private PlanosEquipo planosEquipoCo;

    private ManualesEquipo manualesEquipoCo;

    private RecomendacionesEquipo recomendacionesEquipoCo;

    private TipoManteEquipo tipoManteEquipoPreCo;

    private TipoManteEquipo tipoManteEquipoCorrCo;

    private Map<String, String> ubicacionList;

    private List<String> tecnologiaList;

    private List<String> decretoList;

    private String accion;

    private String razonSocial = "";
    /**
     * 
     */
    private List<EquipoHospitalario> listaEquipos;

    /**
     * 
     */
    private List<EquipoHospitalario> selectEquipos;

    /**
	 * 
	 */
    private List<Empresa> listaEmpresa;

   

    /**
     * Inicializa el bakend bean de control
     */
    public void initNewObject() {

        if (bandera == Boolean.FALSE) {
            if (conversation.isTransient()) {
                conversation.begin();
            }
            bandera = Boolean.TRUE;
            inicializarVariables();
        }
        busqueda();

    }

    /**
     * Inicializa los valores para el CRUD
     */
    private void inicializarVariables() {
        newObject = new EquipoHospitalario();
        ubicacionList = new TreeMap<String, String>();
        tecnologiaList = new ArrayList<String>();
        decretoList= new ArrayList<String>();
        for (ParametrosGenerales element : parametrosBean.getAllCategoria(CategoriasParametros.UBICACION)) {
            ubicacionList.put(element.getPropiedad(), element.getPropiedad());
        }
        for (ParametrosGenerales elemen : parametrosBean.getAllCategoria(CategoriasParametros.TECNOLOGIA)) {
            tecnologiaList.add(elemen.getPropiedad());
        }
        
        for (ParametrosGenerales elemen : parametrosBean.getAllCategoria(CategoriasParametros.DECRETO_4725)) {
            decretoList.add(elemen.getPropiedad());
        }

        StringBuilder var = new StringBuilder("");
        for (ParametrosGenerales element : parametrosBean.getAllCategoria(CategoriasParametros.RECOMENDACIONES)) {
            var.append(element.getPropiedad());
            var.append(" , ");
            var.append("\n");
        }

        adquisicionEquipo = new AdquisicionEquipo();
        infoTecnica = new EquipoInfoTecnica();
        estadoEquipo = new EstadoEquipo();
        funcionamientoEquipo = new FuncionamientoEquipo();
        planosEquipo = new PlanosEquipo();
        manualesEquipo = new ManualesEquipo();
        recomendacionesEquipo = new RecomendacionesEquipo();
        recomendacionesEquipo.setDetalle(var.toString());
        tipoManteEquipoPre = new TipoManteEquipo();
        tipoManteEquipoCorr = new TipoManteEquipo();

        newObjectCo = new EquipoHospitalario();
        adquisicionEquipoCo = new AdquisicionEquipo();
        infoTecnicaCo = new EquipoInfoTecnica();
        estadoEquipoCo = new EstadoEquipo();
        funcionamientoEquipoCo = new FuncionamientoEquipo();
        planosEquipoCo = new PlanosEquipo();
        manualesEquipoCo = new ManualesEquipo();
        recomendacionesEquipoCo = new RecomendacionesEquipo();
        tipoManteEquipoPreCo = new TipoManteEquipo();
        tipoManteEquipoCorrCo = new TipoManteEquipo();

        listaEmpresa = new ArrayList<Empresa>();
    }

    /**
     * 
     */
    public void busqueda() {

        if (!razonSocial.isEmpty() || !newObject.getUbicacion().isEmpty() || !newObject.getNombreEquipo().isEmpty()) {
            if (!razonSocial.isEmpty() && newObject.getUbicacion().isEmpty() && newObject.getNombreEquipo().isEmpty()) {
                listaEquipos = equipoHospitalarioBean.search("equipoHospitalario.getAllSearchRazon", razonSocial.toLowerCase());
            } else if (!razonSocial.isEmpty() && !newObject.getUbicacion().isEmpty() && newObject.getNombreEquipo().isEmpty()) {
                listaEquipos = equipoHospitalarioBean.search("equipoHospitalario.getAllSearchUbicacion", razonSocial.toLowerCase(),
                        newObject.getUbicacion());
            } else if (!razonSocial.isEmpty() && newObject.getUbicacion().isEmpty() && !newObject.getNombreEquipo().isEmpty()) {
                listaEquipos = equipoHospitalarioBean.search("equipoHospitalario.getAllSearchEquipo", razonSocial.toLowerCase(), newObject
                        .getNombreEquipo().toLowerCase());
            } else {
                listaEquipos = equipoHospitalarioBean.search("equipoHospitalario.getAllSearch", razonSocial.toLowerCase(),
                        newObject.getUbicacion(), newObject.getNombreEquipo().toLowerCase());
            }

        } else {
            listaEquipos = equipoHospitalarioBean.getAll();
        }
    }

    /**
     * 
     */
    public void agregarComentario() {
        if (newObjectCo.getNombreEquipo() != null) {
            newObject.setNombreEquipo(newObjectCo.getNombreEquipo());
        }
        if (newObjectCo.getDireccion() != null) {
            newObject.setDireccion(newObjectCo.getDireccion());
        }
        if (newObjectCo.getMarca() != null) {
            newObject.setMarca(newObjectCo.getMarca());
        }

        if (newObjectCo.getModelo() != null) {
            newObject.setModelo(newObjectCo.getModelo());
        }
        if (newObjectCo.getUbicacion() != null) {
            newObject.setUbicacion(newObjectCo.getUbicacion());
        }

        if (newObjectCo.getFabricante() != null) {
            newObject.setFabricante(newObjectCo.getFabricante());
        }
        if (newObjectCo.getRepresentanteCol() != null) {
            newObject.setRepresentanteCol(newObjectCo.getRepresentanteCol());
        }

        if (newObjectCo.getTelefono() != null) {
            newObject.setTelefono(newObjectCo.getTelefono());
        }

        if (infoTecnicaCo.getVoltaje() != null) {
            infoTecnica.setVoltaje(infoTecnicaCo.getVoltaje());
        }

        if (infoTecnicaCo.getInstalaciones() != null) {
            infoTecnica.setInstalaciones(infoTecnicaCo.getInstalaciones());
        }

        if (infoTecnicaCo.getVoltaje() != null) {
            infoTecnica.setVoltaje(infoTecnicaCo.getVoltaje());
        }

        if (infoTecnicaCo.getFrecuencia() != null) {
            infoTecnica.setFrecuencia(infoTecnicaCo.getFrecuencia());
        }

        if (infoTecnicaCo.getPotencia() != null) {
            infoTecnica.setPotencia(infoTecnicaCo.getPotencia());
        }

        if (infoTecnicaCo.getCapacidadPractica() != null) {
            infoTecnica.setCapacidadPractica(infoTecnicaCo.getCapacidadPractica());
        }

        if (infoTecnicaCo.getCapacidadTeorica() != null) {
            infoTecnica.setCapacidadTeorica(infoTecnicaCo.getCapacidadTeorica());
        }

        if (infoTecnicaCo.getTecnologia() != null) {
            infoTecnica.setTecnologia(infoTecnicaCo.getTecnologia());
        }

        if (infoTecnicaCo.getInsumos() != null) {
            infoTecnica.setInsumos(infoTecnicaCo.getInsumos());
        }

        if (adquisicionEquipoCo.getFechaAdquisicion() != null) {
            adquisicionEquipo.setFechaAdquisicion(adquisicionEquipoCo.getFechaAdquisicion());
        }

        if (adquisicionEquipoCo.getFechaInstalacion() != null) {
            adquisicionEquipo.setFechaInstalacion(adquisicionEquipoCo.getFechaInstalacion());
        }

        if (adquisicionEquipoCo.getAniosOperacion() != null) {
            adquisicionEquipo.setAniosOperacion(adquisicionEquipoCo.getAniosOperacion());
        }

        if (adquisicionEquipoCo.getPropiedadEquipo() != null) {
            adquisicionEquipo.setPropiedadEquipo(adquisicionEquipoCo.getPropiedadEquipo());
        }

        if (adquisicionEquipoCo.getAniosFueraServicio() != null) {
            adquisicionEquipo.setAniosFueraServicio(adquisicionEquipoCo.getAniosFueraServicio());
        }

        if (adquisicionEquipoCo.getRazon() != null) {
            adquisicionEquipo.setRazon(adquisicionEquipoCo.getRazon());
        }

        if (adquisicionEquipoCo.getGarantia() != null) {
            adquisicionEquipo.setGarantia(adquisicionEquipoCo.getGarantia());
        }
        if (adquisicionEquipoCo.getPeridoGarantia() != null) {
            adquisicionEquipo.setPeridoGarantia(adquisicionEquipoCo.getPeridoGarantia());
        }
        if (adquisicionEquipoCo.getCubrimientoGarantia() != null) {
            adquisicionEquipo.setCubrimientoGarantia(adquisicionEquipoCo.getCubrimientoGarantia());
        }
        if (adquisicionEquipoCo.getClasificacionDecreto() != null) {
            adquisicionEquipo.setClasificacionDecreto(adquisicionEquipoCo.getClasificacionDecreto());
        }
        if (adquisicionEquipoCo.getCalibracionPeriocidad() != null) {
            adquisicionEquipo.setCalibracionPeriocidad(adquisicionEquipoCo.getCalibracionPeriocidad());
        }
        if (adquisicionEquipoCo.getCalibracionTipo() != null) {
            adquisicionEquipo.setCalibracionTipo(adquisicionEquipoCo.getCalibracionTipo());
        }

        if (planosEquipoCo.getInstalacionUbicacion() != null) {
            planosEquipo.setInstalacionUbicacion(planosEquipoCo.getInstalacionUbicacion());
        }

        if (planosEquipoCo.getPartesUbicacion() != null) {
            planosEquipo.setPartesUbicacion(planosEquipoCo.getPartesUbicacion());
        }

        if (planosEquipoCo.getFuncionamientoUbicacion() != null) {
            planosEquipo.setFuncionamientoUbicacion(planosEquipoCo.getFuncionamientoUbicacion());
        }

        if (manualesEquipoCo.getServicioUbicacion() != null) {
            manualesEquipo.setServicioUbicacion(manualesEquipoCo.getServicioUbicacion());
        }

        if (manualesEquipoCo.getTecnicoUbicacion() != null) {
            manualesEquipo.setTecnicoUbicacion(manualesEquipoCo.getTecnicoUbicacion());
        }

        if (estadoEquipoCo.getCausa() != null) {
            estadoEquipo.setCausa(estadoEquipoCo.getCausa());
        }

        if (funcionamientoEquipoCo.getAnioFueraServicio() != null) {
            funcionamientoEquipo.setAnioFueraServicio(funcionamientoEquipoCo.getAnioFueraServicio());
        }

        if (funcionamientoEquipoCo.getCausa() != null) {
            funcionamientoEquipo.setCausa(funcionamientoEquipoCo.getCausa());
        }

        if (tipoManteEquipoPreCo.getCual() != null) {
            tipoManteEquipoPre.setCual(tipoManteEquipoPreCo.getCual());
        }

        if (tipoManteEquipoCorrCo.getCual() != null) {
            tipoManteEquipoCorr.setCual(tipoManteEquipoCorrCo.getCual());
        }

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

        cargarInformacion();

        return ConstantesUtil.CREAR_ACTU;
    }

    public String initVistaModo() {
        cargarInformacion();
        return ConstantesUtil.VER;
    }

    private void cargarInformacion() {
        newObject = equipoHospitalarioBean.getAllRelations(selectEquipos.get(0).getId());
        adquisicionEquipo = newObject.getAdquisicionEquipo();
        infoTecnica = newObject.getInfoTecnica();
        estadoEquipo = newObject.getEstadoEquipo();
        funcionamientoEquipo = newObject.getFuncionamientoEquipo();
        planosEquipo = newObject.getPlanosEquipo();
        manualesEquipo = newObject.getManualesEquipo();
        recomendacionesEquipo = newObject.getRecomendacionesEquipo();
        for (TipoManteEquipo element : newObject.getManteEquipo()) {
            if (element.getTipoMantenimiento().equals(TipoMantenimiento.PREVENTIVO)) {
                tipoManteEquipoPre = element;
                // Propio es TRUE
                if (tipoManteEquipoPre.getTipoContrato()==Boolean.TRUE) {
                    tipoManteEquipoPre.setValor("Propio");
                } else {
                    tipoManteEquipoPre.setValor("Contratado");
                }

            } else {
                tipoManteEquipoCorr = element;
                // Propio es TRUE
                if (tipoManteEquipoCorr.getTipoContrato()==Boolean.TRUE) {
                    tipoManteEquipoCorr.setValor("Propio");
                } else {
                    tipoManteEquipoCorr.setValor("Contratado");
                }
            }
        }
        
        listaEmpresa=new ArrayList<Empresa>();
        listaEmpresa.add(newObject.getEmpresa());
    }

    public String initCrearModo() {
        return ConstantesUtil.CREAR_ACTU;
    }

    public String cancelar() {
        inicializarVariables();
        selectEquipos=null;
        return ConstantesUtil.ATRAS;
    }

    public String reiniciar() {
        return ConstantesUtil.ATRAS;
    }

    public void cargarEmpresa() {
        if (accion != null) {
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
            equipoHospitalarioBean.update(recomendacionesEquipo, manualesEquipo, adquisicionEquipo, estadoEquipo, infoTecnica,
                    funcionamientoEquipo, planosEquipo);           
            newObject.setEmpresa(listaEmpresa.get(0));
            equipoHospitalarioBean.update(newObject);            
            tipoManteEquipoCorr.setTipoMantenimiento(TipoMantenimiento.CORRECTIVO);
            // Propio es TRUE
            if (tipoManteEquipoCorr.getValor().equals("Propio")) {
                tipoManteEquipoCorr.setTipoContrato(Boolean.TRUE);
            } else {
                tipoManteEquipoCorr.setTipoContrato(Boolean.FALSE);
            }           
            tipoManteEquipoPre.setTipoMantenimiento(TipoMantenimiento.PREVENTIVO);
            // Propio es TRUE
            if (tipoManteEquipoPre.getValor().equals("Propio")) {
                tipoManteEquipoPre.setTipoContrato(Boolean.TRUE);
            } else {
                tipoManteEquipoPre.setTipoContrato(Boolean.FALSE);
            }

            equipoHospitalarioBean.update(tipoManteEquipoCorr, tipoManteEquipoPre);
            editMode = Boolean.FALSE;
            inicializarVariables();
            busqueda();
            selectEquipos=null;
            razonSocial="";
            addMessage(FacesMessage.SEVERITY_INFO, "Se actualizo la información del equipo");
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
    public String eliminar() {

        try {
            for (EquipoHospitalario element : selectEquipos) {
                equipoHospitalarioBean.delete(element.getId());
            }

            if (selectEquipos.size() > 1) {
                addMessage(FacesMessage.SEVERITY_INFO, "Los Equipos Hospitalarios han sido eliminados");
            } else {
                addMessage(FacesMessage.SEVERITY_INFO, "El Equipo Hospitalario a sido eliminado");
            }
            busqueda();
            selectEquipos = null;

        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            addMessage(FacesMessage.SEVERITY_ERROR, errorMessage);

        }

        return "";
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
           
            equipoHospitalarioBean.save(recomendacionesEquipo, manualesEquipo, adquisicionEquipo, estadoEquipo, infoTecnica,
                    funcionamientoEquipo, planosEquipo,newObject);
            newObject.setRecomendacionesEquipo(recomendacionesEquipo);
            newObject.setManualesEquipo(manualesEquipo);
            newObject.setAdquisicionEquipo(adquisicionEquipo);
            newObject.setEstadoEquipo(estadoEquipo);
            newObject.setInfoTecnica(infoTecnica);
            newObject.setFuncionamientoEquipo(funcionamientoEquipo);
            newObject.setPlanosEquipo(planosEquipo);
            newObject.setEmpresa(listaEmpresa.get(0));
            equipoHospitalarioBean.update(newObject);

            tipoManteEquipoCorr.setEquipoHospitalario(newObject);
            tipoManteEquipoCorr.setTipoMantenimiento(TipoMantenimiento.CORRECTIVO);
            // Propio es TRUE
            if (tipoManteEquipoCorr.getValor().equals("Propio")) {
                tipoManteEquipoCorr.setTipoContrato(Boolean.TRUE);
            } else {
                tipoManteEquipoCorr.setTipoContrato(Boolean.FALSE);
            }

            tipoManteEquipoPre.setEquipoHospitalario(newObject);
            tipoManteEquipoPre.setTipoMantenimiento(TipoMantenimiento.PREVENTIVO);
            // Propio es TRUE
            if (tipoManteEquipoPre.getValor().equals("Propio")) {
                tipoManteEquipoPre.setTipoContrato(Boolean.TRUE);
            } else {
                tipoManteEquipoPre.setTipoContrato(Boolean.FALSE);
            }

            equipoHospitalarioBean.save(tipoManteEquipoCorr, tipoManteEquipoPre);

            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito!",
                    "Se guardo un registro de una Equipo hospitalario"));
            inicializarVariables();
            busqueda();
            razonSocial="";
            return ConstantesUtil.ATRAS;
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            addMessage(FacesMessage.SEVERITY_ERROR, errorMessage);
            return "";
        }
       
    }

    public void handleFileUpload(FileUploadEvent event) {
        newObject.setFotoEquipo(event.getFile().getContents());

        addMessage(FacesMessage.SEVERITY_INFO, event.getFile().getFileName() + " Fue cargado.");
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
     * Método encargado de llenar los datos necesarios para la generación del archivo JasperPrint.
     * 
     * @throws Exception
     *             Se genera cuando ocurre un error al generar el JasperPrint del reporte.
     */
    public void generarJasperPrint() {
        JasperPrint print = null;

        try {
            Map<String, Object> datosAdicionales = new TreeMap<String, Object>();

            // InputStream logoImpuestos = this.getClass().getResourceAsStream(ConstantesReportesEstadisticos.RUTA_LOGO);
            // datosAdicionales.put(ConstantesReportesEstadisticos.NOMBRE_PARAMETRO, logoImpuestos);

            // JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(puntosAtencion);

            // print = JasperFillManager.fillReport(obtenerPlantilla(), datosAdicionales, dataSource);
            print = JasperFillManager.fillReport(obtenerPlantilla(), datosAdicionales);

            enviarPDF(print);
            addMessage(FacesMessage.SEVERITY_INFO, "Se genero el informe");
        } catch (Exception e) {

            addMessage(FacesMessage.SEVERITY_ERROR, "Error al generar el informe");
        }
    }

    /**
     * Envía un xls como respuesta al cliente.
     * 
     * @param jasperPrint
     *            con el reporte xls.
     * @throws Exception
     *             Se genera cuando se presenta un error al exportar el reporte como archivo xls.
     */
    private void enviarPDF(JasperPrint jasperPrint) throws Exception {

        String fileName = "D://hammerlab//" + new Date().getTime() + ".pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint, fileName);

    }

    /**
     * Retorna la plantilla del reporte en un objeto <code>InputStream</code>.
     * 
     * @return La plantilla del reporte en forma de <code>InputStream</code>.
     */
    private InputStream obtenerPlantilla() {
        InputStream reportStream = null;
        String ubicacionPlantilla;

        ubicacionPlantilla = "/recuperacion.jasper";

        reportStream = this.getClass().getResourceAsStream(ubicacionPlantilla);
        return reportStream;
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
     * 
     * @return El valor de tipoManteEquipoPre
     */
    public TipoManteEquipo getTipoManteEquipoPre() {
        return tipoManteEquipoPre;
    }

    /**
     * Establece el valor de tipoManteEquipoPre
     * 
     * @param tipoManteEquipoPre
     *            El valor por establecer para tipoManteEquipoPre
     */
    public void setTipoManteEquipoPre(TipoManteEquipo tipoManteEquipoPre) {
        this.tipoManteEquipoPre = tipoManteEquipoPre;
    }

    /**
     * Devuelve el valor de tipoManteEquipoCorr
     * 
     * @return El valor de tipoManteEquipoCorr
     */
    public TipoManteEquipo getTipoManteEquipoCorr() {
        return tipoManteEquipoCorr;
    }

    /**
     * Establece el valor de tipoManteEquipoCorr
     * 
     * @param tipoManteEquipoCorr
     *            El valor por establecer para tipoManteEquipoCorr
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
     * 
     * @return El valor de tecnologiaList
     */
    public List<String> getTecnologiaList() {
        return tecnologiaList;
    }

    /**
     * Establece el valor de tecnologiaList
     * 
     * @param tecnologiaList
     *            El valor por establecer para tecnologiaList
     */
    public void setTecnologiaList(List<String> tecnologiaList) {
        this.tecnologiaList = tecnologiaList;
    }

    /**
     * Devuelve el valor de accion
     * 
     * @return El valor de accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * Establece el valor de accion
     * 
     * @param accion
     *            El valor por establecer para accion
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
     * 
     * @return El valor de listaEmpresa
     */
    public List<Empresa> getListaEmpresa() {
        return listaEmpresa;
    }

    /**
     * Establece el valor de listaEmpresa
     * 
     * @param listaEmpresa
     *            El valor por establecer para listaEmpresa
     */
    public void setListaEmpresa(List<Empresa> listaEmpresa) {
        this.listaEmpresa = listaEmpresa;
    }

    /**
     * Devuelve el valor de newObjectCo
     * 
     * @return El valor de newObjectCo
     */
    public EquipoHospitalario getNewObjectCo() {
        return newObjectCo;
    }

    /**
     * Establece el valor de newObjectCo
     * 
     * @param newObjectCo
     *            El valor por establecer para newObjectCo
     */
    public void setNewObjectCo(EquipoHospitalario newObjectCo) {
        this.newObjectCo = newObjectCo;
    }

    /**
     * Devuelve el valor de parametrosBean
     * 
     * @return El valor de parametrosBean
     */
    public ParametrosBean getParametrosBean() {
        return parametrosBean;
    }

    /**
     * Establece el valor de parametrosBean
     * 
     * @param parametrosBean
     *            El valor por establecer para parametrosBean
     */
    public void setParametrosBean(ParametrosBean parametrosBean) {
        this.parametrosBean = parametrosBean;
    }

    /**
     * Devuelve el valor de adquisicionEquipoCo
     * 
     * @return El valor de adquisicionEquipoCo
     */
    public AdquisicionEquipo getAdquisicionEquipoCo() {
        return adquisicionEquipoCo;
    }

    /**
     * Establece el valor de adquisicionEquipoCo
     * 
     * @param adquisicionEquipoCo
     *            El valor por establecer para adquisicionEquipoCo
     */
    public void setAdquisicionEquipoCo(AdquisicionEquipo adquisicionEquipoCo) {
        this.adquisicionEquipoCo = adquisicionEquipoCo;
    }

    /**
     * Devuelve el valor de infoTecnicaCo
     * 
     * @return El valor de infoTecnicaCo
     */
    public EquipoInfoTecnica getInfoTecnicaCo() {
        return infoTecnicaCo;
    }

    /**
     * Establece el valor de infoTecnicaCo
     * 
     * @param infoTecnicaCo
     *            El valor por establecer para infoTecnicaCo
     */
    public void setInfoTecnicaCo(EquipoInfoTecnica infoTecnicaCo) {
        this.infoTecnicaCo = infoTecnicaCo;
    }

    /**
     * Devuelve el valor de estadoEquipoCo
     * 
     * @return El valor de estadoEquipoCo
     */
    public EstadoEquipo getEstadoEquipoCo() {
        return estadoEquipoCo;
    }

    /**
     * Establece el valor de estadoEquipoCo
     * 
     * @param estadoEquipoCo
     *            El valor por establecer para estadoEquipoCo
     */
    public void setEstadoEquipoCo(EstadoEquipo estadoEquipoCo) {
        this.estadoEquipoCo = estadoEquipoCo;
    }

    /**
     * Devuelve el valor de funcionamientoEquipoCo
     * 
     * @return El valor de funcionamientoEquipoCo
     */
    public FuncionamientoEquipo getFuncionamientoEquipoCo() {
        return funcionamientoEquipoCo;
    }

    /**
     * Establece el valor de funcionamientoEquipoCo
     * 
     * @param funcionamientoEquipoCo
     *            El valor por establecer para funcionamientoEquipoCo
     */
    public void setFuncionamientoEquipoCo(FuncionamientoEquipo funcionamientoEquipoCo) {
        this.funcionamientoEquipoCo = funcionamientoEquipoCo;
    }

    /**
     * Devuelve el valor de planosEquipoCo
     * 
     * @return El valor de planosEquipoCo
     */
    public PlanosEquipo getPlanosEquipoCo() {
        return planosEquipoCo;
    }

    /**
     * Establece el valor de planosEquipoCo
     * 
     * @param planosEquipoCo
     *            El valor por establecer para planosEquipoCo
     */
    public void setPlanosEquipoCo(PlanosEquipo planosEquipoCo) {
        this.planosEquipoCo = planosEquipoCo;
    }

    /**
     * Devuelve el valor de manualesEquipoCo
     * 
     * @return El valor de manualesEquipoCo
     */
    public ManualesEquipo getManualesEquipoCo() {
        return manualesEquipoCo;
    }

    /**
     * Establece el valor de manualesEquipoCo
     * 
     * @param manualesEquipoCo
     *            El valor por establecer para manualesEquipoCo
     */
    public void setManualesEquipoCo(ManualesEquipo manualesEquipoCo) {
        this.manualesEquipoCo = manualesEquipoCo;
    }

    /**
     * Devuelve el valor de recomendacionesEquipoCo
     * 
     * @return El valor de recomendacionesEquipoCo
     */
    public RecomendacionesEquipo getRecomendacionesEquipoCo() {
        return recomendacionesEquipoCo;
    }

    /**
     * Establece el valor de recomendacionesEquipoCo
     * 
     * @param recomendacionesEquipoCo
     *            El valor por establecer para recomendacionesEquipoCo
     */
    public void setRecomendacionesEquipoCo(RecomendacionesEquipo recomendacionesEquipoCo) {
        this.recomendacionesEquipoCo = recomendacionesEquipoCo;
    }

    /**
     * Devuelve el valor de tipoManteEquipoPreCo
     * 
     * @return El valor de tipoManteEquipoPreCo
     */
    public TipoManteEquipo getTipoManteEquipoPreCo() {
        return tipoManteEquipoPreCo;
    }

    /**
     * Establece el valor de tipoManteEquipoPreCo
     * 
     * @param tipoManteEquipoPreCo
     *            El valor por establecer para tipoManteEquipoPreCo
     */
    public void setTipoManteEquipoPreCo(TipoManteEquipo tipoManteEquipoPreCo) {
        this.tipoManteEquipoPreCo = tipoManteEquipoPreCo;
    }

    /**
     * Devuelve el valor de tipoManteEquipoCorrCo
     * 
     * @return El valor de tipoManteEquipoCorrCo
     */
    public TipoManteEquipo getTipoManteEquipoCorrCo() {
        return tipoManteEquipoCorrCo;
    }

    /**
     * Establece el valor de tipoManteEquipoCorrCo
     * 
     * @param tipoManteEquipoCorrCo
     *            El valor por establecer para tipoManteEquipoCorrCo
     */
    public void setTipoManteEquipoCorrCo(TipoManteEquipo tipoManteEquipoCorrCo) {
        this.tipoManteEquipoCorrCo = tipoManteEquipoCorrCo;
    }

    /**
     * Devuelve el valor de razonSocial
     * 
     * @return El valor de razonSocial
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * Establece el valor de razonSocial
     * 
     * @param razonSocial
     *            El valor por establecer para razonSocial
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     * Devuelve el valor de decretoList
     * @return El valor de decretoList
     */
    public List<String> getDecretoList() {
        return decretoList;
    }

    /**
     * Establece el valor de decretoList
     * @param decretoList El valor por establecer para decretoList
     */
    public void setDecretoList(List<String> decretoList) {
        this.decretoList = decretoList;
    }

    
}
