package grafo;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GrafoDirigido<T, V> implements Grafo<T, V> {

    protected List<Vertice<T, V>> vertices;
    protected Integer cantidadArcos = 0;

    public GrafoDirigido() {
        this.vertices = new LinkedList<>();
    }

    /**
     * Complejidad: O(N) Siendo N = cantidadDeVertices.
     */
    @Override
    public void agregarVertice(int verticeId, T value) {
        if (!contieneVertice(verticeId)) {
            vertices.add(new Vertice(verticeId, value));
        }
    }

    /**
     * Complejidad: O((N * 2) * M), Siendo N = cantidadDeVertices y M = cantidadDeArcos.
     */
    @Override
    public void borrarVertice(int verticeId) {
        int size = vertices.size();
        vertices = vertices.stream()
                .filter(tVertice -> tVertice.getId() != verticeId)
                .collect(Collectors.toList());
        if (size != vertices.size()) {
            vertices.forEach(x -> x.removeArco(verticeId));
        }
    }

    /**
     * Complejidad: O(N + O(2) + M), Siendo N = cantidadDeVertices y M = cantidadDeArcosDelVertice
     */
    @Override
    public void agregarArco(int verticeId1, int verticeId2, V etiqueta) {
        List<Vertice<T, V>> collect = vertices.stream()
                .filter(x -> x.getId() == verticeId1 || x.getId() == verticeId2)
                .collect(Collectors.toList());
        if (collect.size() > 1) { // Encontro ambos vertices
            Vertice<T, V> vertice = collect.stream()
                    .filter(x -> x.getId() == verticeId1)
                    .findFirst()
                    .get();
            if (!existeArco(verticeId1, verticeId2)) {
                vertice.addArco(verticeId2, etiqueta); // Agregamos el arco
                cantidadArcos++;
            }
        }

    }

    /**
     * Complejidad: O(N), Siendo N = cantidadDeVertices
     */
    protected Vertice<T, V> findVertice(int verticeId) {
        return vertices.stream()
                .filter(vertice -> vertice.getId() == verticeId)
                .findFirst()
                .orElse(null);
    }

    /**
     * Complejidad: O(N + M), Siendo N = cantidadDeVertices y M = cantidadDeArcos
     */
    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        Vertice<T, V> vertice = findVertice(verticeId1);
        if (Objects.nonNull(vertice)) {
            vertice.removeArco(verticeId2);
            cantidadArcos--;
        }
    }

    /**
     * Complejidad: O(N), Siendo N = cantidadDeVertices.
     */
    @Override
    public boolean contieneVertice(int verticeId) {
        return vertices.stream().anyMatch(x -> x.getId() == verticeId);
    }

    /**
     * Complejidad: O(N + M), Siendo N cantidadDeVertices y M = cantidadDeArcos.
     */
    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        Vertice<T, V> vertice = findVertice(verticeId1);
        if (Objects.isNull(vertice)) {
            return false;
        }
        return vertice.existsArco(verticeId2);
    }

    /**
     * Complejidad: O(N + M) Siendo N = cantidadDeVertices y M = cantidadDeArcos.
     */
    @Override
    public T obtenerArco(int verticeId1, int verticeId2) {
        Vertice<T, V> vertice = findVertice(verticeId1);
        return Objects.nonNull(vertice) ? (T) vertice.getArco(verticeId2).getEtiqueta() : null;
    }

    /**
     * Complejidad: O(N), Siendo N = cantidadDeVertices
     */
    @Override
    public T obtenerVertice(int verticeId) {
        Vertice<T, V> vertice = findVertice(verticeId);
        return Objects.nonNull(vertice) ? vertice.getValue() : null;
    }

    /**
     * Complejidad: O(1) Accede a vertices.size()
     */
    @Override
    public int cantidadVertices() {
        return vertices.size();
    }

    /**
     * Complejidad: O(1), Accede a la variable
     */
    @Override
    public int cantidadArcos() {
        return this.cantidadArcos;
    }

    /**
     * Complejidad: O(N), Siendo N = cantidadDeVertices
     */
    @Override
    public Iterator<Integer> obtenerVertices() {
        return vertices.stream().map(Vertice::getId).collect(Collectors.toList()).iterator();
    }

    /**
     * Complejidad: O(N), Siendo N = cantidad de vertices
     */
    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        Vertice<T, V> vertice = findVertice(verticeId);
        return Objects.nonNull(vertice) ? vertice.getVerticesDeArcos() : Collections.emptyIterator();
    }

    /**
     * Complejidad: O(N), Siendo N = cantidad de vertices
     */
    @Override
    public Iterator<Arco<V>> obtenerArcos() {
        return new ArcoIterator<>(vertices.stream()
                .map(Vertice::getArcos)
                .collect(Collectors.toList()));
    }

    /**
     * Complejidad: O(N + M), Siendo N = cantidadDeVertices y M = cantidadDeArcos.
     */
    @Override
    public Iterator<Arco<V>> obtenerArcos(int verticeId) {
        Vertice<T, V> vertice = findVertice(verticeId);
        if (Objects.nonNull(vertice)) {
            return vertice.getArcos();
        }
        return Collections.emptyIterator();
    }
}
