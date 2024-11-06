package org.example;

class Cliente extends Thread {
    private final int id;
    private final Supermercado supermercado;
    private final int aPagar;

    public Cliente(int id, Supermercado supermercado) {
        this.id = id;
        this.supermercado = supermercado;
        this.aPagar = (int) (Math.random() * (150 - 30 + 1) + 30); // valor aleatorio entre 30 y 150
    }

    @Override
    public void run() {
        try {
            // el cliente esta comprando
            System.out.println("Cliente " + id + " está comprando...");
            Thread.sleep((long) (Math.random() * (20000 - 5000 + 1)) + 5000); // tiempo aleatorio comprando entre 5 y 20 segundos

            // el cliente elige una caja aleatoria
            supermercado.seleccionarCaja(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pagar() {
        System.out.println("Cliente " + id + " ha pagado " + aPagar + "€.");
        supermercado.recaudar(aPagar);
    }

    public long getId() {
        return id;
    }
}
