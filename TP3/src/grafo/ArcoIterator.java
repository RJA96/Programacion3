package grafo;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class ArcoIterator<T> implements Iterator<Arco<T>> {

    private List<Iterator<Arco<T>>> iteratorList;

    public ArcoIterator(List<Iterator<Arco<T>>> iteratorList) {
        this.iteratorList = iteratorList;
    }

    /**
     * O(1) retorna true/false dependiendo si hay siguiente
     */
    @Override
    public boolean hasNext() {
        return iteratorList.stream().anyMatch(Iterator::hasNext);
    }

    /**
     * O(1) retorna el Arco<T> siguiente en el iterador
     */
    @Override
    public Arco<T> next() {
        Optional<Iterator<Arco<T>>> first = iteratorList.stream()
                .filter(Iterator::hasNext)
                .findFirst();
        return first.map(Iterator::next).orElse(null);
    }
}
