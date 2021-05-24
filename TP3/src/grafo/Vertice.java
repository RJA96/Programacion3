package grafo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Vertice<T, V> {

    private int id;
    private T value;
    private List<Arco<V>> arcos;

    /**
     * O(1) setea id e instancia una nueva LinkedList
     */
    public Vertice(int id) {
        this.id = id;
        this.arcos = new LinkedList<>();
    }

    /**
     * O(1) setea id, valor e instancia una nueva LinkedList
     */
    public Vertice(int id, T value) {
        this.id = id;
        this.value = value;
        this.arcos = new LinkedList<>();
    }

    /**
     * O(N) N = cantidad de arcos ya que revisa si previamente no existe ese arco
     */
    public void addArco(Integer vertice, V etiqueta) {
        if (!existsArco(vertice)) {
            arcos.add(new Arco(this.id, vertice, etiqueta));
        }
    }

    /**
     * O(N) N = cantidad de arcos
     */
    public boolean existsArco(Integer verticeId) {
        return this.arcos.stream()
                .anyMatch(arc -> arc.getVerticeDestino() == verticeId);
    }

    /**
     * O(N) N = cantidad de arcos
     */
    public void removeArco(int VerticeId) {
        this.arcos = arcos.stream()
                .filter(arc -> arc.getVerticeDestino() != VerticeId)
                .collect(Collectors.toList());
    }

    /**
     * O(1) Iterator de los vertices de los arcos
     */
    public Iterator<Integer> getVerticesDeArcos() {
        return arcos.stream().map(Arco::getVerticeDestino).iterator();
    }

    /**
     * O(1) devuelve el id
     */
    public Integer getId() {
        return id;
    }

    /**
     * O(1) setea el id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * O(1) devuelve el valor
     */
    public T getValue() {
        return value;
    }

    /**
     * O(1) setea el valor
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * O(1) devuelve el iterator de los arcos
     */
    public Iterator<Arco<V>> getArcos() {
        return arcos.iterator();
    }

    /**
     * O(N) obtiene el arco para un vertice adyacente
     */
    public Arco getArco(int verticeId2) {
        return arcos.stream()
                .filter(x -> x.getVerticeOrigen() == this.id && x.getVerticeDestino() == verticeId2)
                .findFirst()
                .orElse(null);
    }

    /**
     * O(1) devuelve la cantidad de arcos
     */
    public int getArcosSize() {
        return this.arcos.size();
    }
}
