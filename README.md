# Catálogo Local

Programas en Java básico para el sistema de Catálogo Local.

| Issue | Programa | Archivo |
|-------|----------|---------|
| CAT-004 | Módulo de Ventas Iterativo con Estadísticas de Catálogo | `src/ModuloVentas.java` |
| CAT-005 | Evaluador de Lotes de Inventario y Promedios de Costeo | `src/EvaluadorLotes.java` |

## CAT-004 · Módulo de Ventas

Caja registradora que procesa varios artículos en una sola transacción.

- Ciclo `while` que mantiene la caja abierta hasta elegir **Finalizar compra**.
- Menú con `if / else if` y 3 productos del catálogo: básico ($15,000), medio ($35,000) y premium ($60,000).
- Descuento del 10% solo si el total bruto supera $100,000.
- IVA del 19% (constante) sobre el valor con descuento.
- Porcentaje de artículos premium con cast `(double)` y validación para evitar la división por cero.

## CAT-005 · Evaluador de Lotes

Auditoría de un lote de ingresos al catálogo.

- Pregunta cuántos productos ingresarán al lote.
- Ciclo `for` atado al límite del lote: pide nombre y costo base de cada producto.
- Clasificación en tiempo real con `else if` y `&&`:
  - Costo < $10,000 → Categoría Baja
  - Costo entre $10,000 y $50,000 → Categoría Media
  - Costo > $50,000 → Categoría Alta
- Al final imprime el costo promedio (con decimales) y cuántos productos fueron de Categoría Alta.

## Cómo ejecutar

Desde la carpeta del proyecto:

```bash
javac -encoding UTF-8 -d out src/*.java

java -cp out ModuloVentas
java -cp out EvaluadorLotes
```

## Historial de commits

Cada issue se desarrolló en 3 commits, visibles con `git log --oneline`:

- **CAT-004:** 1) Variables base · 2) Creación del ciclo y menú · 3) Cálculo de porcentajes finales
- **CAT-005:** 1) Variables base y tamaño del lote · 2) Ciclo y clasificación · 3) Promedio y conteo de Categoría Alta
