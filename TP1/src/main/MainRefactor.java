package main;

import circularLinkedList.DoublyLinkedList;
import service.Service;

import java.util.ArrayList;
import java.util.List;

public class MainRefactor {


    public static void main(String[] args) {
        Service service = new Service();
        List<Integer> list = new ArrayList<>();
        System.out.println("test 1, umbral: 10");
        DoublyLinkedList test1 = new DoublyLinkedList();
        service.testDobleRefactor(test1, 10);
        System.out.println();

        DoublyLinkedList test2 = new DoublyLinkedList();
        test2.insertFront(3);
        test2.insertFront(2);
        test2.insertFront(1);
        System.out.println("test 2, umbral: 10");
        service.testDobleRefactor(test2, 10);
        System.out.println();

        System.out.println("test 3, umbral: 2");
        service.testDobleRefactor(test2, 2);
        System.out.println();

        DoublyLinkedList test4 = new DoublyLinkedList();
        test4.insertBack(3);
        test4.insertBack(5);
        test4.insertBack(2);
        test4.insertBack(7);
        test4.insertBack(19);
        test4.insertBack(14);
        test4.insertBack(28);
        System.out.println("test 4, umbral: 10");
        service.testDobleRefactor(test4, 10);
        System.out.println();

        DoublyLinkedList test5 = new DoublyLinkedList();
        test5.insertBack(3);
        test5.insertBack(5);
        test5.insertBack(4);
        test5.insertBack(2);
        test5.insertBack(7);
        test5.insertBack(15);
        test5.insertBack(14);
        test5.insertBack(28);
        System.out.println("test 5, umbral: 15");
        service.testDobleRefactor(test5, 15);
        System.out.println();

        System.out.println("remover primer elemento");
        System.out.println("entrada" + test5);
        System.out.println("extraido elemento: " + test5.extractBack());
        System.out.println("salida" + test5 + " tamaño: " + test5.size());
        System.out.println();

        System.out.println("remover ultimo elemento");
        System.out.println("entrada" + test5);
        System.out.println("extraido elemento: " + test5.extractFront());
        System.out.println("salida" + test5 + " tamaño: " + test5.size());
        System.out.println();

        System.out.println("encontrar elemento index 3");
        System.out.println("entrada" + test5 + " tamaño: " + test5.size());
        System.out.println("elemento en indice 3: " + test5.get(3));
        System.out.println();

        System.out.println("insertar front elemento '12'");
        System.out.println("entrada" + test5);
        test5.insertFront(12);
        System.out.println("salida" + test5 + " tamaño: " + test5.size());
        System.out.println();

        System.out.println("insertar back elemento '55'");
        System.out.println("entrada" + test5);
        test5.insertBack(55);
        System.out.println("salida" + test5 + " tamaño: " + test5.size());
        System.out.println();

    }

}
