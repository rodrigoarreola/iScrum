package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

/**
 * Esta clase es usada para establecer diversas acciones para los requisitos del Backlog
 *
 *
 *
 * @author Luis Fernando Herrera Pimentel / Rodrigo Enrique Arreola Pozo
 * @version 1.3
 */



public final class MCURegistrarBack
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarBack.class);


    /**
     * Metodo que regresa  un action forward para establecer el destino del path
     * @return ActionForward
     */
    public ActionForward solicitarRegistro(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistro");
        }

        return (mapping.findForward("exito"));

    }

    /**
     *Metodo que regresa  un action forward y con este metodo permite el listado de los requisitos
     * @return ActionForward
     */

    public ActionForward solicitarListarRequisitos(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarListarRequisitos");
        }

        // Verifica si la acci�n fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acci�n fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        FormaListadoRequisitos forma = (FormaListadoRequisitos)form;

        ManejadorRequisitos mr = new ManejadorRequisitos();
        Collection resultado = mr.listarRequisitos(); //Metodo utilizado para Listar los requisitos

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setRequisitos( resultado );
            }
            return (mapping.findForward("exito"));
        } else {
            log.error("Ocurri� un error de infraestructura");
            errores.add(ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("errors.infraestructura"));
            saveErrors(request, errores);
            return ( mapping.findForward("fracaso") );
        }

    }

    /**
     * Regresa  un action forward y con este metodo permite el agregar un nuevo  requisito
     * @return ActionForward
     */


    public ActionForward procesarRegistroBack(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistro");
        }

        // Verifica si la acci�n fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acci�n fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }


        // Se obtienen los datos para crear el requisito
        //
        FormaNuevoBacklog forma = (FormaNuevoBacklog)form;


        Requisito requisito = new Requisito(forma.getNombre(), //get + name del input
                          forma.getDescripcion());

        ManejadorRequisitos mr = new ManejadorRequisitos();
        int resultado = mr.crearRequisito(requisito); //metodo utilizado para crear un requisito
        log.debug( + resultado);

        ActionMessages errores = new ActionMessages();
        switch (resultado) {
            case 0:
                return (mapping.findForward("exito"));

            case 1:
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.nombreRequisitoYaExiste",
                                               forma.getNombre()));
                saveErrors(request, errores);
                return (mapping.getInputForward());

            case 3:
                log.error("Ocurri� un error de infraestructura");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));
                saveErrors(request, errores);
                return (mapping.getInputForward());

            default:
                log.warn("ManejadorUsuario.crearUsuario regres� reultado inesperado");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));
                saveErrors(request, errores);
                return (mapping.getInputForward());
        }
    }





}
