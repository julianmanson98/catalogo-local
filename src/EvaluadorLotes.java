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

        lector.close();
    }
}
