package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(15, 4, 1, 25, 50, 6, 7, 20, 5, 30));

    Tree treeNode = new Tree(list);

    treeNode.printPreOrder();
    System.out.println("elemento Maximo: " + treeNode.getMaxElem());
    System.out.println("Altura: " + treeNode.getHeight());
    System.out.println("Rama mas larga: " + treeNode.getLongestBranch());
    System.out.println("Elementos al nivel 3: " + treeNode.getElementAtLevel(3));
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

    System.out.println("Print Pre Order");
    treeNode.printPreOrder();
    System.out.println("PrintInOrder");
    treeNode.printInOrder();
    System.out.println("Print Post Order");
    treeNode.printPosOrder();

    //Casos de delete presentados en la correcion
    System.out.println();
    System.out.println("CASOS DE PRUEBA EN EL DELATE");
    System.out.println("Arbol Vacio");
    Tree treeVacio = new Tree(new ArrayList<>());
    treeVacio.printPreOrder();
    System.out.println("intenta eliminar un valor");
    treeVacio.delete(10);
    treeVacio.printPreOrder();

    System.out.println("Arbol solo raiz");
    List<Integer> pruebaEliminarRaiz = new ArrayList<>(Arrays.asList(10));
    Tree treeRaizEliminar = new Tree(pruebaEliminarRaiz);
    treeRaizEliminar.printPreOrder();
    treeRaizEliminar.delete(10);
    treeRaizEliminar.printPreOrder();

    System.out.println("Arbol con 2 elementos (funciona borrando tanto raiz como segundo elemento)");
    List<Integer> pruebaEliminar2Elementos = new ArrayList<>(Arrays.asList(10,2));
    Tree treeEliminar2Elementos = new Tree(pruebaEliminar2Elementos);
    treeEliminar2Elementos.printPreOrder();
    treeEliminar2Elementos.delete(10);
    treeEliminar2Elementos.printPreOrder();

    System.out.println("Arbol con 3 elementos");
    List<Integer> pruebaEliminar3Elementos = new ArrayList<>(Arrays.asList(10,2,5));
    Tree treeEliminar3Elementos = new Tree(pruebaEliminar3Elementos);
    treeEliminar3Elementos.printPreOrder();
    treeEliminar3Elementos.delete(10);
    treeEliminar3Elementos.printPreOrder();

    System.out.println("Arbol con 3 elementos caso 2");
    List<Integer> pruebaEliminar3ElementosB = new ArrayList<>(Arrays.asList(10,11,12));
    Tree treeEliminar3ElementosB = new Tree(pruebaEliminar3ElementosB);
    treeEliminar3ElementosB.printPreOrder();
    treeEliminar3ElementosB.delete(10);
    treeEliminar3ElementosB.printPreOrder();

    System.out.println("Arbol con 5 elementos");
    List<Integer> pruebaEliminar5Elementos = new ArrayList<>(Arrays.asList(2,6,9,10,12));
    Tree treeEliminar5Elementos = new Tree(pruebaEliminar5Elementos);
    treeEliminar5Elementos.printPreOrder();
    treeEliminar5Elementos.delete(10);
    treeEliminar5Elementos.printPreOrder();
    System.out.println("Tiene el elemento 12: " + treeEliminar5Elementos.hasElement(12));
    System.out.println("Tiene el elemento 10: " + treeEliminar5Elementos.hasElement(10));
  }

}
