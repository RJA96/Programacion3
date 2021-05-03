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
    Tree treeNode = new Tree(list);

    treeNode.printPreOrder();
    System.out.println("elemento Maximo: " + treeNode.getMaxElem());
    System.out.println("Altura: " + treeNode.getHeight());
    System.out.println("Rama mas larga: " + treeNode.getLongestBranch());
    System.out.println("Elementos al nivel 3: " + treeNode.getElementAtLevel(3));
    //TODO falta frontera
    System.out.println("Frontera: " + treeNode.getFrontera());
    System.out.println();

    treeNode.printPreOrder();
    System.out.println("añado 23");
    treeNode.add(23);
    System.out.println("añado 3");
    treeNode.add(3);
    treeNode.printPreOrder();
    System.out.println("elimino 6");
    treeNode.delete(6);
    treeNode.printPreOrder();
    System.out.println("elimino 30");
    treeNode.delete(30);
    treeNode.printPreOrder();

    System.out.println("elemento Maximo: " + treeNode.getMaxElem());
    System.out.println("Altura: " + treeNode.getHeight());
    System.out.println("Rama mas larga: " + treeNode.getLongestBranch());
    System.out.println("Elementos al nivel 2: " + treeNode.getElementAtLevel(2));
    System.out.println("Frontera: " + treeNode.getFrontera());
    System.out.println();

    System.out.println("añado 65");
    treeNode.add(65);
    treeNode.printPreOrder();
    System.out.println("elimino 5");
    treeNode.delete(5);
    treeNode.printPreOrder();
    System.out.println("elimino 15");
    treeNode.delete(15);
    treeNode.printPreOrder();
    System.out.println("añado 55");
    treeNode.add(55);
    treeNode.printPreOrder();
    System.out.println("elemento Maximo: "+ treeNode.getMaxElem());
    System.out.println("Altura: "+treeNode.getHeight());
    System.out.println("Rama mas larga: "+treeNode.getLongestBranch());
    System.out.println("Elementos al nivel 2: " +treeNode.getElementAtLevel(2));
    System.out.println("Frontera: " + treeNode.getFrontera());
  }

}
