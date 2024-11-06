package org.example;
import java.util.*;
public class PSPUT02Supermercat_rcanales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leemos el número de cajas y clientes
        System.out.print("Introduce el número de cajas: ");
        int numCajas = scanner.nextInt();

        System.out.print("Introduce el número de clientes: ");
        int numClientes = scanner.nextInt();

        // Creamos el supermercado con las cajas y clientes indicados
        Supermercado supermercado = new Supermercado(numCajas, numClientes);

        // Iniciamos el proceso
        supermercado.iniciar();
    }
}