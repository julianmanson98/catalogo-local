import java.util.Scanner;

/**
 * CAT-004 - Módulo de Ventas Iterativo con Estadísticas de Catálogo.
 *
 * Caja registradora del Catálogo Local que procesa varios artículos
 * en una sola transacción, aplica descuento, calcula el IVA e imprime
 * la factura final con el porcentaje de artículos premium vendidos.
 */
public class ModuloVentas {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        // ===== Variables base de los productos del catálogo =====
        String nombreProductoBasico = "Producto Básico";
        double precioProductoBasico = 15000.0;

        String nombreProductoMedio = "Producto Medio";
        double precioProductoMedio = 35000.0;

        String nombreProductoPremium = "Producto Premium";
        double precioProductoPremium = 60000.0;

        // ===== Constantes de la transacción =====
        final double TASA_IVA = 0.19;
        final double TASA_DESCUENTO = 0.10;
        final double MONTO_MINIMO_DESCUENTO = 100000.0;
        final int OPCION_FINALIZAR = 4;

        // ===== Acumuladores y contadores de la transacción =====
        double totalBruto = 0.0;
        int cantidadArticulos = 0;
        int cantidadProductosBasicos = 0;
        int cantidadProductosMedios = 0;
        int cantidadProductosPremium = 0;
        int opcionSeleccionada = 0;

        System.out.println("=============================================");
        System.out.println("     CATÁLOGO LOCAL - CAJA REGISTRADORA");
        System.out.println("=============================================");

        // ===== Ciclo que mantiene la caja abierta hasta finalizar la compra =====
        while (opcionSeleccionada != OPCION_FINALIZAR) {
            System.out.println();
            System.out.println("------------------- MENÚ -------------------");
            System.out.printf("1. %-20s $%,12.2f%n", nombreProductoBasico, precioProductoBasico);
            System.out.printf("2. %-20s $%,12.2f%n", nombreProductoMedio, precioProductoMedio);
            System.out.printf("3. %-20s $%,12.2f%n", nombreProductoPremium, precioProductoPremium);
            System.out.println("4. Finalizar compra");
            System.out.print("Seleccione una opción: ");
            opcionSeleccionada = lector.nextInt();

            // Selección del producto con if / else if
            if (opcionSeleccionada == 1) {
                totalBruto += precioProductoBasico;
                cantidadProductosBasicos++;
                cantidadArticulos++;
                System.out.printf("Agregado: %s | Subtotal: $%,.2f%n", nombreProductoBasico, totalBruto);
            } else if (opcionSeleccionada == 2) {
                totalBruto += precioProductoMedio;
                cantidadProductosMedios++;
                cantidadArticulos++;
                System.out.printf("Agregado: %s | Subtotal: $%,.2f%n", nombreProductoMedio, totalBruto);
            } else if (opcionSeleccionada == 3) {
                totalBruto += precioProductoPremium;
                cantidadProductosPremium++;
                cantidadArticulos++;
                System.out.printf("Agregado: %s | Subtotal: $%,.2f%n", nombreProductoPremium, totalBruto);
            } else if (opcionSeleccionada == OPCION_FINALIZAR) {
                System.out.println("Cerrando la caja y generando la factura...");
            } else {
                System.out.println("Opción no válida. Elija un número del 1 al 4.");
            }
        }

        lector.close();
    }
}
