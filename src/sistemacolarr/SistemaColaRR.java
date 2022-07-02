/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemacolarr;

import javax.swing.JOptionPane;

/**
 *
 * @author beraxes
 */
public class SistemaColaRR {

    proceso frente;
    proceso cola;

    public SistemaColaRR() {
        frente = null;
        cola = null;
    }

    public void colarProceso() {
        String n = JOptionPane.showInputDialog("Ingrese nombre de proceso: ");
        int ti = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tiempo estimado de ejecucion: "));
        if (frente == null) {
            frente = new proceso();
            frente.registrarProceso(n, ti);
            cola = frente;
        } else if (frente != null) {
            proceso tmp = new proceso();
            tmp.registrarProceso(n, ti);
            cola.setSiguiente(tmp);
            cola = tmp;
        }
    }

    public void atenderProceso() {
        int tiempoPermitido = 10;
        proceso temporal = frente, aux;
        if (temporal != null) {
            if (temporal.et > 0) {
                temporal.mostrarProc();
                temporal.setEt(temporal.getEt() - tiempoPermitido);
                if (temporal.et > 0) {
                    cola.setSiguiente(temporal);
                    cola = temporal;
                } else {
                    aux = temporal;
                    temporal = null;
                    temporal = aux.getSiguiente();

                }

            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }

}
