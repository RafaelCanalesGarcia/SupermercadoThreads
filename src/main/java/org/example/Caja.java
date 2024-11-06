package org.example;

import java.util.LinkedList;
import java.util.Queue;

class Caja {
    private final int id;
    private final Queue<Cliente> cola;

    public int getId() {
        return id;
    }

    // Constructor de caja con su cola individual
    public Caja(int id) {
        this.id = id;
        this.cola = new LinkedList<>();
    }

    public synchronized void agregarCliente(Cliente cliente) {
        cola.add(cliente);
        atenderCliente();
    }

    public synchronized void atenderCliente() {
        if (!cola.isEmpty()) {
            Cliente cliente = cola.poll(); // Atendemos al primer cliente de la cola
            System.out.println("Caja " + id + " está atendiendo al cliente " + cliente.getId());
            try {
                // Simulamos el tiempo de atención (pago)
                Thread.sleep((long) (Math.random() * (5000 - 2000 + 1)) + 2000); // Tiempo aleatorio entre 2 y 5 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cliente.pagar();
        }
    }
}
