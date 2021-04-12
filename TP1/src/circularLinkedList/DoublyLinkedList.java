package circularLinkedList;

import java.util.Objects;

public class DoublyLinkedList implements Iterable<Integer> {

    private NodoDoble head, tail;
    private Integer size = 0;

    //O(1)
    public void addNode(Integer info) {
        if (Objects.isNull(head)) {
            NodoDoble newNode = new NodoDoble(info, null, null);
            head = tail = newNode;
        } else {
            NodoDoble newNode = new NodoDoble(info);
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
            tail.setNext(head);
            head.setPrevious(tail);
        }
        size++;
    }

    //O(1)
    public Integer extractFront() {
        if (Objects.nonNull(head)) {
            Integer integer = head.getInfo();
            tail.setNext(head.getNext());
            head = head.getNext();
            head.setPrevious(tail);
            size--;
            return integer;
        } else return null;
    }

    //O(1)
    public boolean isEmpty() {
        return size.equals(0);
    }

    //O(1)
    public int size() {
        return size;
    }

    //O(n) N=index, codicion que index>size
    public Integer get(Integer index) {
        if (index < size) {
            if (index.equals(0)) {
                return head.getInfo();
            } else {
                MyDobleIterator dobleIterator = this.iterator();
                while (!index.equals(0)) {
                    dobleIterator.next();
                    index--;
                }
                return dobleIterator.get();
            }
        } else return null;
    }

    //remplaze el print por el toString O(n) n = cantidad de elementos
    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("[");
        NodoDoble current = head;
        Integer aux = size;
        while (aux != 0) {
            toString.append(current.getInfo());
            current = current.getNext();
            aux--;
            if (aux != 0) {
                toString.append(", ");
            }
        }
        toString.append("]");
        return toString.toString();
    }

    //O(1)
    @Override
    public MyDobleIterator iterator() {
        return new MyDobleIterator(head);
    }

}

