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
        int tiempoPermitido = 5;
        proceso temporal = frente, aux;
        if (frente != null) {
            if (frente == cola) {
                while (temporal.getEt() > 0) {
                    JOptionPane.showMessageDialog(null, "tiempo faltante para terminar la ejecucion del proceso: " + temporal.getEt());
                    temporal.setEt(temporal.getEt() - tiempoPermitido);
                }

            } else if (temporal != null && temporal.getEt() > 0) {
                temporal.mostrarProc();
                temporal.setEt(temporal.getEt() - tiempoPermitido);
                if (temporal.getEt() > 0) {
                    frente = temporal.getSiguiente();
                    cola.setSiguiente(temporal);
                    JOptionPane.showMessageDialog(null, "tiempo faltante para terminar la ejecucion del proceso: " + temporal.getEt());
                    cola = temporal;
                } else {
                    JOptionPane.showMessageDialog(null, "Se termino la ejecucion de este proceso");
                    frente = temporal.getSiguiente();
                    temporal = frente;
                    cola = frente;
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay procesos que atender");
        }
    }

    public static void main(String[] args) {
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("1 Agregar proceso \n 2 atender proceso \n 3 salir"));
        SistemaColaRR objetoProcesador = new SistemaColaRR();
        do {
            if (opcion == 1) {
                objetoProcesador.colarProceso();
            } else if (opcion == 2) {
                objetoProcesador.atenderProceso();

            } else {
                System.exit(0);
            }

            opcion = Integer.parseInt(JOptionPane.showInputDialog("1 Agregar proceso \n 2 atender proceso \n 3 salir"));
        } while (opcion >= 1 && opcion <= 2);

    }

}
