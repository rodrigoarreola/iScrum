package edu.uag.iidis.scec.pruebas;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.extensions.TestSetup;
import junit.textui.TestRunner;

import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.persistencia.*;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;

import java.util.*;


public class DashboardDAOTest extends TestCase {

    private static DashboardDAO dao = null;


    protected void setUp() throws Exception {
        dao = new DashboardDAO();
    }

    protected void tearDown() {
        dao = null;
    }


    public void testBuscarLogin() throws Exception {
        HibernateUtil.beginTransaction();
        try {
            Collection result = dao.buscarLogin("ravenclaw","holita");
            HibernateUtil.commitTransaction();

            assertTrue(result.size() > 0); //acierta

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public void testBuscarLoginInvalido() throws Exception {
        HibernateUtil.beginTransaction();
        try {
            Collection result = dao.buscarLogin("ravenclaw","");
            HibernateUtil.commitTransaction();

            assertTrue(result.size() == 0);

        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }



    public static Test suite() {

       TestSetup suite = new TestSetup(new TestSuite(LoginDAOTest.class)) {

            protected void setUp(  ) throws Exception {
                // Se ejecuta al inicio de la suite de pruebas
                dao = new LoginDAO();
            }

            protected void tearDown(  ) throws Exception {
                // se ejecuta al final de la suite
                dao = null;
            }
        };

        return suite;
    }

    public static void main(String[] args) throws Exception {
        TestRunner.run( suite() );
    }

}
