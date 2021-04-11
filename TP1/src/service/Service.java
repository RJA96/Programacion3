package service;

import linkedList.MyIterator;
import linkedList.MySimpleLinkedList;

import java.util.ArrayList;
import java.util.List;

public class Service {

  public void test1() {
    List<Integer> list =
        new ArrayList<Integer>() {
          {
            add(1);
            add(2);
            add(3);
          }
        };
    MySimpleLinkedList mySimpleLinkedList = new MySimpleLinkedList();
    mySimpleLinkedList.insertList(list);
    Integer one = mySimpleLinkedList.get(1);
    Integer two = mySimpleLinkedList.get(2);
    Integer three = mySimpleLinkedList.get(3);
    mySimpleLinkedList.extractFront();
    System.out.println(mySimpleLinkedList);
  }

  public void test(Integer umbral) {
    List<Integer> list =
        new ArrayList<Integer>() {
          {
            add(3);
            add(5);
            add(2);
            add(7);
            add(19);
            add(14);
            add(28);
          }
        };
    MySimpleLinkedList entrada = new MySimpleLinkedList();
    entrada.insertList(list);
    MyIterator iterator = entrada.iterator();
    MySimpleLinkedList salida = resolveIterator(iterator, umbral);
    System.out.println(entrada);
    System.out.println(salida);
  }

  private MySimpleLinkedList resolveIterator(MyIterator iterator, Integer umbral) {
    MySimpleLinkedList salida = new MySimpleLinkedList();
    Integer suma = 0;
    while (iterator.hasNext()) {
      if ((iterator.get() < umbral)) {
        while (iterator.hasNext() && suma + iterator.get() <= umbral ) {
          suma += iterator.get();
          if (suma + iterator.getNext() > umbral) {
            salida.insertFront(suma);
            suma = 0;
          }
          iterator.next();
        }
        if (!suma.equals(0)) salida.insertFront(suma);
      }
      if (iterator.hasNext()) {
        iterator.next();
      }
    }
    return salida;
  }
}
