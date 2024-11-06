package org.example;

import java.util.ArrayList;
import java.util.List;

class Supermercado {
    private final List<Caja> cajas;
    private int recaudado;
    private final List<Cliente> clientes;


    // Constructor iniciando array para cajas y clientes
    public Supermercado(int numCajas, int numClientes) {
        this.cajas = new ArrayList<>();
        this.recaudado = 0;
        this.clientes = new ArrayList<>();

        // Inicializamos las cajas
        for (int i = 0; i < numCajas; i++) {
            cajas.add(new Caja(i + 1));
        }

        // Inicializamos los clientes
        for (int i = 0; i < numClientes; i++) {
            clientes.add(new Cliente(i + 1, this));
        }
        // entrar los clientes en bucle cada 0 a 5 segs...
        // cambiar constructor de supermercado

        /*while (true){
            long tiempoEspera = (long) (Math.random() * 5000);
            Thread.sleep(tiempoEspera);
            clientes.add(new Cliente(i + 1,this));
        }*/
    }

    public void seleccionarCaja(Cliente cliente) {
        // Seleccionamos aleatoriamente una caja para el cliente
        Caja caja = cajas.get((int) (Math.random() * cajas.size()));
        System.out.println("Cliente " + cliente.getId() + " se ha colocado en la cola de la caja " + caja.getId());
        caja.agregarCliente(cliente);
    }

    public void recaudar(int total) {
        recaudado += total;
    }

    public void iniciar() {
        // Iniciamos los threads de los clientes
        for (Cliente cliente : clientes) {
            cliente.start();
        }

        // Esperamos a que todos los clientes terminen
        for (Cliente cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Al finalizar, mostramos el total recaudado
        System.out.println("Total recaudado: " + recaudado + "€.");
    }
}