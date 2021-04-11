package dobleLinkedListCircular;

import java.util.Objects;

public class NodoDoble {

    public NodoDoble(Integer info) {
        this.info = info;
    }

    private Integer info;
    private NodoDoble next;
    private NodoDoble previous;

    public NodoDoble() {
        this.info = null;
        this.next = null;
        this.previous = null;
    }

    public NodoDoble(Integer o, NodoDoble next, NodoDoble previous) {
        this.setInfo(o);
        this.setNext(next);
        this.setPrevious(previous);
    }

    public NodoDoble getNext() {
        return next;
    }

    public void setNext(NodoDoble next) {
        this.next = next;
    }

    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public Boolean hasNext() {
        if (Objects.nonNull(next)) return Boolean.TRUE;
        else return Boolean.FALSE;
    }

    @Override
    public String toString() {
        return info.toString();
    }

    public void setPrevious(NodoDoble previous) {
        this.previous = previous;
    }

    public NodoDoble getPrevious() {
        return previous;
    }
}
