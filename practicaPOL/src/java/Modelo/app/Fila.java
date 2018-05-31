/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.app;

/**
 *
 * @author Personal
 */
public class Fila {
    private Tarea tarea;
    private int duracion;

    public Fila() {
    }

    public Fila(Tarea tarea, int duracion) {
        this.tarea = tarea;
        this.duracion = duracion;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
