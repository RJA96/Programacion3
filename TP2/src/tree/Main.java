package tree;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>() {
      {
        add(15);
        add(4);
        add(1);
        add(25);
        add(50);
        add(6);
        add(7);
        add(20);
        add(5);
        add(30);
      }
    };
    Tree treeNode = new TreeNodeImpl(list);

    treeNode.printPreOrder();
    System.out.println();
    System.out.println("elemento Maximo: " + treeNode.getMaxElem());
    System.out.println("Altura: " + treeNode.getHeight());
    System.out.println("Rama mas larga: " + treeNode.getLongestBranch());
    System.out.println("Elementos al nivel 3: " + treeNode.getElementAtLevel(3));
    System.out.println("Frontera: " + treeNode.getFrontera());
  }

}
