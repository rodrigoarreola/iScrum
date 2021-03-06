package edu.uag.iidis.scec.vista;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para la eliminacion de un requisito
 *
 * @author Luis Fernando Herrera Pimentel
 */
public final class FormaEliminarRequ
        extends ValidatorForm {

          private String nombre;
          private String descripcion;

          public void setNombre(String nombre) {
              this.nombre = nombre;
          }

          public String getNombre() {
              return (this.nombre);
          }


          public void setDescripcion(String descripcion) {
              this.descripcion = descripcion;
          }

          public String getDescripcion() {
              return (this.descripcion);
          }


          public void reset(ActionMapping mapping,
                            HttpServletRequest request) {
              nombre=null;
              descripcion=null;
          }


          public ActionErrors validate(ActionMapping mapping,
                                       HttpServletRequest request) {

              // Ejecuta las validaciones proporcionadas por Struts-Validator
              ActionErrors errores = super.validate(mapping, request);

              // Validaciones no cubiertas por Struts-Validator

              return errores;
    }

}
