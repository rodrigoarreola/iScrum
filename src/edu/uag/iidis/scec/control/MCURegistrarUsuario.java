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
 * Esta clase es usada para establecer diversas acciones para el manejo de los usuarios
 *
 *
 *
 * @author Daniel Esteban Nandayapa
 * @version 1.1
 */




public final class MCURegistrarUsuario
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);

    /**
     * Metodo que regresa  un action forward para establecer el destino del path y acciones del registro
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


		/* incluir ciudades      */
		FormaNuevaPersona forma = (FormaNuevaPersona)form;
		ManejadorCiudades mr = new ManejadorCiudades();
        Collection resultado = mr.listarCiudades();

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
				log.error(">>>>> asignando ciudades a formanuevapersona");
                forma.setCiudades ( resultado );
            }
        } else {
            log.error("Ocurri� un error de infraestructura");
            errores.add(ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("errors.infraestructura"));
            saveErrors(request, errores);
        }


	/* incluir ciudades      */


        return (mapping.findForward("exito"));
    }

    /**
     * Metodo que regresa  un action forward para establecer el proceso de registro de usuarios
     * @return ActionForward
     */

    public ActionForward procesarRegistro(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarRegistro");
        }

        // Verifica si la acci�n fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acci�n fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }


        // Se obtienen los datos para procesar el registro
        FormaNuevaPersona forma = (FormaNuevaPersona)form;

        NombrePersona nombrePersona = new NombrePersona(forma.getPrefijo(),
                                                        forma.getNombre(),
                                                        forma.getApellidoPaterno(),
                                                        forma.getApellidoMaterno(),
                                                        forma.getPosfijo(),
                                                        forma.getIniciales());

        Credencial credencial = new Credencial (forma.getNombreUsuario(),
                                                forma.getClaveAcceso());

        Usuario usuario = new Usuario(nombrePersona, credencial);

        ManejadorUsuarios mu = new ManejadorUsuarios();
        int resultado = mu.crearUsuario(usuario);

        ActionMessages errores = new ActionMessages();
        switch (resultado) {
            case 0:
                return (mapping.findForward("exito"));

            case 1:
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.nombreUsuarioYaExiste",
                                               forma.getNombreUsuario()));
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
