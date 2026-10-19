import java.util.Scanner;

/**
 * CAT-005 - Evaluador de Lotes de Inventario y Promedios de Costeo.
 *
 * Audita un lote de ingresos al Catálogo Local: clasifica cada producto
 * según su costo base, calcula el costo promedio del lote y cuenta
 * cuántos productos son de "Categoría Alta".
 */
public class EvaluadorLotes {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        // ===== Variables base del producto =====
        String nombreProducto = "";
        double costoBase = 0.0;

        // ===== Límites de las categorías de costo =====
        final double LIMITE_INFERIOR_MEDIA = 10000.0;
        final double LIMITE_SUPERIOR_MEDIA = 50000.0;

        // ===== Variables del lote =====
        int limiteLote = 0;
        double acumuladorCostoTotal = 0.0;
        int contadorCategoriaAlta = 0;
        double costoPromedio = 0.0;

        System.out.println("=============================================");
        System.out.println("   CATÁLOGO LOCAL - AUDITORÍA DE LOTE");
        System.out.println("=============================================");
        System.out.print("¿Cuántos productos ingresarán al lote? ");
        limiteLote = lector.nextInt();
        lector.nextLine(); // Limpia el salto de línea que deja nextInt()

        // ===== Ciclo: inicialización, condición atada al límite del lote, incremento =====
        for (int numeroProducto = 1; numeroProducto <= limiteLote; numeroProducto++) {
            System.out.println();
            System.out.println("--- Producto " + numeroProducto + " de " + limiteLote + " ---");
            System.out.print("Nombre del producto: ");
            nombreProducto = lector.nextLine();
            System.out.print("Costo base: $");
            costoBase = lector.nextDouble();
            lector.nextLine(); // Limpia el salto de línea que deja nextDouble()

            // Clasificación en tiempo real con else if y operadores relacionales / lógicos
            if (costoBase < LIMITE_INFERIOR_MEDIA) {
                System.out.println(">> ALERTA: " + nombreProducto + " -> Categoría Baja");
            } else if (costoBase >= LIMITE_INFERIOR_MEDIA && costoBase <= LIMITE_SUPERIOR_MEDIA) {
                System.out.println(">> ALERTA: " + nombreProducto + " -> Categoría Media");
            } else if (costoBase > LIMITE_SUPERIOR_MEDIA) {
                System.out.println(">> ALERTA: " + nombreProducto + " -> Categoría Alta");
                contadorCategoriaAlta++;
            }

            acumuladorCostoTotal += costoBase;
        }

        // ===== Resultados del lote =====
        System.out.println();
        System.out.println("=============================================");
        System.out.println("              RESUMEN DEL LOTE");
        System.out.println("=============================================");

        if (limiteLote > 0) {
            // Promedio: acumulador total dividido entre el límite del lote (resultado decimal)
            costoPromedio = acumuladorCostoTotal / limiteLote;

            System.out.printf("%-30s %,14d%n", "Productos ingresados:", limiteLote);
            System.out.printf("%-30s $%,13.2f%n", "Costo total del lote:", acumuladorCostoTotal);
            System.out.printf("%-30s $%,13.2f%n", "Costo promedio por producto:", costoPromedio);
            System.out.printf("%-30s %,14d%n", "Productos de Categoría Alta:", contadorCategoriaAlta);
        } else {
            System.out.println("El lote no tiene productos; no se puede calcular el promedio.");
        }
        System.out.println("=============================================");

        lector.close();
    }
}
