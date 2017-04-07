package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * Esta clase es usada para representar un requisito del Backlog
 *
 * 
 *
 * @author Luis Fernando Herrera Pimentel / Rodrigo Enrique Arreola Pozo
 * @version 1.0
 */
public class Requisito extends ClaseBase
        implements Serializable {

    private Long id;
    private String nombre;
    private String descripcion;


    public Requisito() {
    }

    public Requisito(Long id){
        this.id = id;
    }
    public Requisito(String descripcion){
        this.descripcion = descripcion;
    }

    public Requisito(String nombre, String descripcion){
        this.nombre=nombre;
        this.descripcion=descripcion;
    }

    /**
     * Regresa el id del requisito.
     * @return Long
     */
    public Long getId() {
        return this.id;
    }


    /**
     * Regresa el nombre del requisito.
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del requisito.
     * @return void
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /**
     * Regresa la descripci�n del requisito.
     * @return String
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Establece la descripci�n del requisito.
     * @return void
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }







}
