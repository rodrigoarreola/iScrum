package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.criterion.Example;
import org.hibernate.type.*;
import org.hibernate.classic.*;

import edu.uag.iidis.scec.modelo.Requisito;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

/**
 * Clase en la cual se maneja la persistencia de los datos de los requisitos
 *
 * @author Luis Fernando Herrera Pimentel / Rodrigo Enrique Arreola Pozo
 * @version 1.3
 */

public class RequisitoDAO {

    private Log log = LogFactory.getLog(RequisitoDAO.class);


    public RequisitoDAO() {
    }

    /**
     * Metodo que regresa  un requisito a partir de la busqueda por su nombre
     * @param nombreRequisitos El parámetro contiene el nombre del requisito a buscar
     * @return Requisito
     */
    public Requisito buscarPorNombreRequisito(String nombreRequisito)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorNombreRequisito(" + nombreRequisito + ")");
        }

        Requisito requ = null;
        try {
            List requisitos = HibernateUtil.getSession()
                    .createQuery("from Requisito u where u.id.nombreUsuario=:nombreUsuario")
                    .setString("nombreUsuario", nombreRequisito)
                    .list();

            if ((requ != null) && (requisitos.size() > 0)) {
                requ = (Requisito)requisitos.get(0);
            }

            if (requ == null) {
                if (log.isDebugEnabled()) {
                    log.debug(">buscarPorNombreRequisito(" + nombreRequisito + ")");
                }
            }
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }

        return requ;
    }

    /**
     * Metodo que regresa  un requisito a partir de la busqueda por su descripcion
     * @param nombreRequisitos El parámetro contiene la descripcion del requisito a buscar
     * @return Requisito
     */

    public Requisito buscarPorNombreDescripcion(String nombreRequisito)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorNombreDescripcion(" + nombreRequisito + ")");
        }

        Requisito requ = null;
        try {
            List requisitos = HibernateUtil.getSession()
                    .createQuery("from Requisito where descripcion='"+nombreRequisito+"'")
                    .list();

            if ((requisitos != null) && (requisitos.size() > 0)) {
              log.debug("Rodri es una putita");
                requ = (Requisito)requisitos.get(0);

            }

            if (requ == null) {
                if (log.isDebugEnabled()) {
                    log.debug(">buscarPorNombreDescripcion(" + nombreRequisito + ")");
                }
            }
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return requ;
    }


    /**
     * Metodo que regresa  una colleccion  a partir de la busqueda de todos los requisitos
     * @return Collection
     */

      public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection requisitos;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            requisitos = HibernateUtil.getSession()
                                    .createCriteria(Requisito.class)
                                    .list();
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }
        return requisitos;
    }


    /**
     * Metodo que permite a un requisito ser guardado en la base de datos
     *  @param requisitos El parámetro requisitos contiene el nombre y descripcion del mismo
     */

    public void hazPersistente(Requisito requisitos)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(usuario)");
        }

        try {

            HibernateUtil.getSession()
                         .saveOrUpdate(requisitos); // Guardado del requisito

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
                  log.warn(ex);
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }


        /**
         * Metodo que permite a un requisito ser eliminado en la base de datos
         *  @param requisitos El parámetro requisitos contiene el nombre y descripcion del mismo
         */

    public void hazTransitorio(Requisito requisito)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(requisito)");
        }

        try {
            HibernateUtil.getSession().delete(requisito); //eliminacion del requisito
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

}
