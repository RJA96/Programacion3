package grafo;

public class GrafoNoDirigido<T, V> extends GrafoDirigido<T, V> {

    /**
     * Complejidad: O((N + M)*2), Siendo N = cantidadDeVertices y M = cantidadDeArcosDelVertice. multiplicado por 2
     * porque llama a agregar arco dos veces.
     */
    @Override
    public void agregarArco(int verticeId1, int verticeId2, V etiqueta) {
        super.agregarArco(verticeId1, verticeId2, etiqueta);
        super.agregarArco(verticeId2, verticeId1, etiqueta);
    }

    /**
     * Complejidad: O((N + M)*2), Siendo N = cantidadDeVertices y M = cantidadDeArcos multiplicado por 2 porque llama a
     * borrar arco 2 veces.
     */
    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        super.borrarArco(verticeId1, verticeId2);
        super.borrarArco(verticeId2, verticeId1);
    }

}
