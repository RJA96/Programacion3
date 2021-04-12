package service;

import dobleLinkedListCircular.DoublyLinkedList;
import dobleLinkedListCircular.MyDobleIterator;

import java.util.List;

public class Service {

    public void testDoble(List<Integer> integerList, Integer umbral) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        integerList.forEach(doublyLinkedList::addNode);
        MyDobleIterator dobleIterator = doublyLinkedList.iterator();
        System.out.println(doublyLinkedList);
        System.out.println(resolveSequence(dobleIterator, umbral));
    }

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
                if (iterator.isLast() && suma + iterator.get() <= umbral) suma +=iterator.get();
                if (!suma.equals(0)) salida.addNode(suma);
            }
            if (iterator.hasNext()) {
                iterator.next();
            }
        }
        return salida;
    }
}
