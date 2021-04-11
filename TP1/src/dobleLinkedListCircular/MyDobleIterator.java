package dobleLinkedListCircular;

import java.util.Iterator;
import java.util.Objects;

public class MyDobleIterator implements Iterator<Integer> {

    private NodoDoble cursorHead;
    private NodoDoble cursorTail;

    public MyDobleIterator(final NodoDoble first) {
        this.cursorHead = first;
        this.cursorTail = first.getPrevious();
    }

    @Override
    public boolean hasNext() {
        if (Objects.nonNull(cursorTail)) {
            return this.cursorHead != this.cursorTail;
        } else {
            return Objects.nonNull(cursorHead);
        }
    }

    @Override
    public Integer next() {
        Integer info = this.cursorHead.getInfo();
        this.cursorHead = this.cursorHead.getNext();
        return info;
    }

    /* Metodos adicionales que podemos agregar si queremos */

    public Integer get() {
        return this.cursorHead.getInfo();
    }

    public Integer getNext() {
        if (Objects.nonNull(cursorHead.getNext()))
            return this.cursorHead.getNext().getInfo();
        else return 0;
    }

    public void move() {
        this.cursorHead = this.cursorHead.getNext();
    }

}
