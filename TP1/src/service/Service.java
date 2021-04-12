package service;

import circularLinkedList.DoublyLinkedList;
import circularLinkedList.MyDobleIterator;

import java.util.List;

public class Service {

    //O(N*N) N = tamaño maximo de lista
    public void testDoble(List<Integer> integerList, Integer umbral) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        integerList.forEach(doublyLinkedList::addNode);
        MyDobleIterator dobleIterator = doublyLinkedList.iterator();
        System.out.println("entrada: " + doublyLinkedList);
        System.out.println("salida: " + resolveSequence(dobleIterator, umbral));
    }

    //O(N*N) N = tamaño maximo de lista
    private DoublyLinkedList resolveSequence(MyDobleIterator iterator, final Integer umbral) {
        DoublyLinkedList salida = new DoublyLinkedList();
        Integer suma = 0;
        while (iterator.hasNext()) {
            if ((iterator.get() < umbral)) {
                while (iterator.hasNext() && suma + iterator.get() <= umbral) {
                    suma += iterator.get();
                    if (suma + iterator.getNext() > umbral) {
                        salida.addNode(suma);
                        suma = 0;
                    }
                    iterator.next();
                }
                if (iterator.isLast() && suma + iterator.get() <= umbral) suma += iterator.get();
                if (!suma.equals(0)) salida.addNode(suma);
            }
            if (iterator.hasNext()) {
                iterator.next();
            }
        }
        return salida;
    }

    //O(1)
    public void removeFirstElement(List<Integer> integerList) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        integerList.forEach(doublyLinkedList::addNode);
        System.out.println("entrada" + doublyLinkedList);
        System.out.println("extraido elemento: " + doublyLinkedList.extractFront());
        System.out.println("salida" + doublyLinkedList);

    }

    //O(n) N= tamaño de la lista
    public Integer getIndex(List<Integer> integerList, Integer index) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        integerList.forEach(doublyLinkedList::addNode);
        System.out.println("entrada: " + doublyLinkedList + " tamaño: " + doublyLinkedList.size());
        return doublyLinkedList.get(index);
    }
}
