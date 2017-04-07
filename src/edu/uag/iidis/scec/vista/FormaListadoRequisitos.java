package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el registro de un nuevo requisito
 *
 * @author Luis Fernando Herrera Pimentel / Rodrigo Enrique Arreola Pozo
 * @version 1.3
 */
public final class FormaListadoRequisitos
        extends ValidatorForm {

    private Collection requisito;
    private int contador;


    public void setRequisitos(Collection requisito) {
        this.requisito = requisito;
        if (requisito != null) {
          this.contador = requisito.size();
        } else
          this.contador = -1;
    }

    public Collection getRequisito() {
        return (this.requisito);
    }

    public int getContador() {
        return (this.contador);
    }


    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        requisito=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
