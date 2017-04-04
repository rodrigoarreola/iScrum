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


public class RequisitoDAO {

    private Log log = LogFactory.getLog(RequisitoDAO.class);


    public RequisitoDAO() {
    }


    public Requisito buscarPorId(Long idUsuario, boolean bloquear)
            throws ExcepcionInfraestructura {

        Requisito requ = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idUsuario + ", " + bloquear + ")");
        }


        try {
            if (bloquear) {
                requ = (Requisito)HibernateUtil.getSession()
                                                .load(Requisito.class,
                                                      idUsuario,
                                                      LockMode.UPGRADE);
            } else {
                requ = (Requisito)HibernateUtil.getSession()
                                                .load(Requisito.class,
                                                      idUsuario);
            }
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }

        return requ;
    }


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



    public boolean existeRequisito(String nombre)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRequisito(nombreRequisito)");
        }

        try {
//            String consultaCuentaUsuarios =
//            "select count(*) from Usuario u where u.credencial.nombreUsuario=?";
//
//            int resultado =
//            ((Integer) HibernateUtil.getSession()
//                           .find(consultaCuentaUsuarios,
//                                 nombreUsuario,
//                                 StringType.INSTANCE)
//                           .iterator()
//                           .next()).intValue();

			String hql = "from Requisito  where nombre = '" + nombre + "'";
      log.debug("Query existe" + hql);
			Query query = HibernateUtil.getSession().createQuery(hql);
			//query.setParameter("nombre",nombre);
			List results = query.list();
			int resultado = results.size();


            if (resultado == 0) {
               return false;
            }

            return true;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }


    public void hazPersistente(Requisito requisitos)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(usuario)");
        }

        try {

            HibernateUtil.getSession()
                         .saveOrUpdate(requisitos);

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
                  log.warn(ex);
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }


    public void hazTransitorio(Requisito requisito)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(requisito)");
        }

        try {
            HibernateUtil.getSession().delete(requisito);
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

}
