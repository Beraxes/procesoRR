/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacolarr;

/**
 *
 * @author beraxes
 */
public class proceso {

    private String nombre;
    private int et;
    public proceso siguiente;

    public proceso() {
        nombre = "";
        et = 0;
        siguiente = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEt() {
        return et;
    }

    public void setEt(int et) {
        this.et = et;
    }

    public proceso getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(proceso siguiente) {
        this.siguiente = siguiente;
    }

    public void registrarProceso(String nomb, int t) {
        setNombre(nomb);
        setEt(t);
    }

    public void mostrarProc() {
        System.out.println("#########################################");
        System.out.println("Nombre del proceso: " + getNombre());
        System.out.println("Tiempo estimado de ejecucion: " + getEt());
        System.out.println("#########################################");
    }
}
