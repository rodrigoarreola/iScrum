package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.criterion.Example;
import org.hibernate.type.*;
import org.hibernate.classic.*;

import edu.uag.iidis.scec.modelo.Usuario;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

/**
 * Clase en la cual se maneja la persistencia de los datos de los usuarios
 *
 * @author Luis Fernando Herrera Pimentel / Rodrigo Enrique Arreola Pozo
 * @version 1.3
 */

public class UsuarioDAO {

    private Log log = LogFactory.getLog(UsuarioDAO.class);


    public UsuarioDAO() {
    }

    /**
     * Metodo que regresa  un usuario a partir de la busqueda por su id
     * @param idUsuario El parámetro contiene el id del usuario a buscar
     * @param bloquear El parámetro contiene un booleano para saber si esta bloqueado
     * @return Usuario
     */

    public Usuario buscarPorId(Long idUsuario, boolean bloquear)
            throws ExcepcionInfraestructura {

        Usuario usuario = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idUsuario + ", " + bloquear + ")");
        }


        try {
            if (bloquear) {
                usuario = (Usuario)HibernateUtil.getSession()
                                                .load(Usuario.class,
                                                      idUsuario,
                                                      LockMode.UPGRADE);
            } else {
                usuario = (Usuario)HibernateUtil.getSession()
                                                .load(Usuario.class,
                                                      idUsuario);
            }
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }

        return usuario;
    }

    /**
     * Metodo que regresa  un usuario a partir de la busqueda por su id
     * @param nombreUsuario El parámetro contiene el nombre del usuario a buscar
     * @return Usuario
     */

    public Usuario buscarPorNombreUsuario(String nombreUsuario)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorNombreUsuario(" + nombreUsuario + ")");
        }

        Usuario usuario = null;
        try {
            List usuarios = HibernateUtil.getSession()
                    .createQuery("from Usuario u where u.credencial.nombreUsuario=:nombreUsuario")
                    .setString("nombreUsuario", nombreUsuario)
                    .list();

            if ((usuarios != null) && (usuarios.size() > 0)) {
                usuario = (Usuario)usuarios.get(0);
            }

            if (usuario == null) {
                if (log.isDebugEnabled()) {
                    log.debug(">buscarPorNombreUsuario(" + nombreUsuario + ")");
                }
            }
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }

        return usuario;
    }

    /**
     * Metodo que regresa  todos los usuarios
     * @return Collection con los usuarios
     */


    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection usuarios;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            usuarios = HibernateUtil.getSession()
                                    .createCriteria(Usuario.class)
                                    .list();
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }
        return usuarios;
    }

    /**
     * Metodo que regresa  una list de usuarios a partir de su busqueda
     * @param usuarioEjemplo El parámetro contiene el usuario
     * @return List
     */

    public List buscarPorEjemplo(Usuario usuarioEjemplo)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        List usuarios;
        try {
            usuarios = HibernateUtil.getSession()
                                    .createCriteria(Usuario.class)
                                    .add(Example.create(usuarioEjemplo))
                                    .list();
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }
        return usuarios;
    }
    /**
     * Metodo que regresa  un booleano a partir de si existe o no un usuario
     * @param nombreUsuario El parámetro contiene el nombre del usuario a buscar
     * @return boolean
     */

    public boolean existeUsuario(String nombreUsuario)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeUsuario(nombreUsuario)");
        }

        try {

			String hql = "select u.credencial.nombreUsuario from Usuario u where u.credencial.nombreUsuario =:nombreUsuario";
			Query query = HibernateUtil.getSession().createQuery(hql);
			query.setParameter("nombreUsuario",nombreUsuario);
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
    /**
     * Metodo que permite agregar a la base de datos
     * @param nombreUsuario El parámetro contiene el nombre del usuario a buscar
     *
     */

    public void hazPersistente(Usuario usuario)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(usuario)");
        }

        try {

            HibernateUtil.getSession()
                         .saveOrUpdate(usuario);

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

    /**
     * Metodo que permite eliminar a la base de datos
     * @param nombreUsuario El parámetro contiene el nombre del usuario a buscar
     *
     */

    public void hazTransitorio(Usuario usuario)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(usuario)");
        }

        try {
            HibernateUtil.getSession().delete(usuario);
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }

}
