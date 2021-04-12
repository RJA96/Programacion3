package circularLinkedList;

import java.util.Objects;

public class NodoDoble {

    private Integer info;
    private NodoDoble next;
    private NodoDoble previous;

    //O(1)
    public NodoDoble(Integer info) {
        this.info = info;
    }

    //O(1)
    public NodoDoble(Integer o, NodoDoble next, NodoDoble previous) {
        this.setInfo(o);
        this.setNext(next);
        this.setPrevious(previous);
    }

    //O(1)
    public NodoDoble getNext() {
        return next;
    }

    //O(1)
    public void setNext(NodoDoble next) {
        this.next = next;
    }

    //O(1)
    public Integer getInfo() {
        return info;
    }

    //O(1)
    public void setInfo(Integer info) {
        this.info = info;
    }

    //O(1)
    public Boolean hasNext() {
        if (Objects.nonNull(next)) return Boolean.TRUE;
        else return Boolean.FALSE;
    }

    //O(1)
    @Override
    public String toString() {
        return info.toString();
    }

    //O(1)
    public void setPrevious(NodoDoble previous) {
        this.previous = previous;
    }

    //O(1)
    public NodoDoble getPrevious() {
        return previous;
    }
}
