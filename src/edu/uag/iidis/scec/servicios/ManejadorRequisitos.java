package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Requisito;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.RequisitoDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorRequisitos {
    private Log log = LogFactory.getLog(ManejadorRequisitos.class);
    private RequisitoDAO dao;

    public ManejadorRequisitos() {
        dao = new RequisitoDAO();
    }


    public Collection listarRequisitos() {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">Ha jalado");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarTodos();
            log.debug(resultado);
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

    public void eliminarRequisito(String id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarRequisito(rol)");
        }
        try {
            HibernateUtil.beginTransaction();
            Requisito rol = dao.buscarPorNombreDescripcion(id);
            if (rol != null) {
              log.debug("Llego aca "+ rol);

              dao.hazTransitorio(rol);
            }
            HibernateUtil.commitTransaction();
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
        } finally {
            HibernateUtil.closeSession();
        }

    }

    public int crearRequisito(Requisito req) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarRequisito(req)");
        }

        try {
            HibernateUtil.beginTransaction();



               dao.hazPersistente(req);

               resultado = 0; // Exito. El requisito se creo satisfactoriamente.


            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();

            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            resultado = 2;    // Excepci�n. Falla en la infraestructura
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }
}
