package grafo;

import java.util.Iterator;
import java.util.List;

public class VerticeIterator<T> implements Iterator<T> {

    private Iterator<T> vertices;

    public VerticeIterator(List<T> list) {
        this.vertices = list.iterator();
    }

    /**
     * O(1) retorna true/false dependiendo si hay siguiente
     */
    @Override
    public boolean hasNext() {
        return vertices.hasNext();
    }

    /**
     * O(1) retorna el vertice siguiente
     */
    @Override
    public T next() {
        return vertices.next();
    }
}
