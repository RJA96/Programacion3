package service;

import circularLinkedList.DoublyLinkedList;
import circularLinkedList.MyDobleIterator;

import java.util.List;

public class Service {

    //O(N) N = tamaño maximo de lista 'Pense que era O(N^2)
    // porque primero recorria la lista para cargar mi lista vinculada y luego otro recorrido para calcular el elemento de salida
    //ya no se utiliza, lo deje por la explicacion
    @Deprecated
    public void testDoble(List<Integer> integerList, Integer umbral) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        integerList.forEach(doublyLinkedList::insertBack);
        MyDobleIterator dobleIterator = doublyLinkedList.iterator();
        System.out.println("entrada: " + doublyLinkedList);
        System.out.println("salida: " + resolveSequence(dobleIterator, umbral));
    }

    //O(N) tamaño maximo de doublyLinkedList
    public void testDobleRefactor(DoublyLinkedList doublyLinkedList, Integer umbral) {
        MyDobleIterator dobleIterator = doublyLinkedList.iterator();
        System.out.println("entrada: " + doublyLinkedList);
        System.out.println("salida: " + resolveSequence(dobleIterator, umbral));
    }

    //O(N) N = tamaño maximo de lista
    private DoublyLinkedList resolveSequence(MyDobleIterator iterator, final Integer umbral) {
        DoublyLinkedList salida = new DoublyLinkedList();
        Integer suma = 0;
        while (iterator.hasNext()) {
            if ((iterator.get() < umbral)) {
                while (iterator.hasNext() && suma + iterator.get() <= umbral) {
                    suma += iterator.get();
                    if (suma + iterator.getNextForCalculeteSumOrsubtraction() > umbral) {
                        salida.insertBack(suma);
                        suma = 0;
                    }
                    iterator.next();
                }
                if (iterator.isLast() && suma + iterator.get() <= umbral) suma += iterator.get();
                if (!suma.equals(0)) salida.insertBack(suma);
            }
            if (iterator.hasNext()) {
                iterator.next();
            }
        }
        return salida;
    }

    //O(1)
    //Ya no se utiliza
    @Deprecated
    public void removeFirstElement(List<Integer> integerList) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        integerList.forEach(doublyLinkedList::insertBack);
        System.out.println("entrada" + doublyLinkedList);
        System.out.println("extraido elemento: " + doublyLinkedList.extractBack());
        System.out.println("salida" + doublyLinkedList);
    }

    //O(n) N= tamaño de la lista
    //Ya no se utiliza
    @Deprecated
    public Integer getIndex(List<Integer> integerList, Integer index) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        integerList.forEach(doublyLinkedList::insertBack);
        System.out.println("entrada: " + doublyLinkedList + " tamaño: " + doublyLinkedList.size());
        return doublyLinkedList.get(index);
    }
}
