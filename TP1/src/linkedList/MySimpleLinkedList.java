package linkedList;

import java.util.List;
import java.util.Objects;

public class MySimpleLinkedList implements Iterable<Integer> {

  private Node first;

  private Integer size = 0;

  public MySimpleLinkedList() {
    this.first = null;
  }

  public void insertFront(Integer o) {
    Node tmp = new Node(o, null);
    tmp.setNext(this.first);
    this.first = tmp;
    size++;
  }

  public Integer extractFront() {
    if (!isEmpty()) {
      Integer aux = first.getInfo();
      this.first = first.getNext();
      size--;
      return aux;
    } else return null;
  }

  public boolean isEmpty() {
    if (Objects.nonNull(this.first)) return Boolean.FALSE;
    else return Boolean.TRUE;
  }

  public Integer get(Integer index) {
    if (!this.isEmpty()) {
      MyIterator iterator = this.iterator();
      while (index > 1) {
        iterator.next();
        index--;
      }
      return iterator.get();
    }
    return null;
  }

  public int getSize() {
    return this.size;
  }

  public void insertList(List<Integer> integerList) {
    integerList.forEach(this::insertFront);
  }

  public void print(int n) {
    System.out.println(this.get(n));
  }

  private static Node getReverse(final Node node) {
    Node prev = null;
    Node current = node;
    Node next;
    while (current != null) {
      next = current.getNext();
      current.setNext(prev);
      prev = current;
      current = next;
    }
    return prev;
  }

  @Override
  public MyIterator iterator() {
    Node aux = new Node();
    aux.setInfo(first.getInfo());
    aux.setNext(first.getNext());
    return new MyIterator(getReverse(aux));
  }

}
