package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Tree {

  private Integer valor;
  private Tree izquierda;
  private Tree derecha;

  /*
  Complejidad O(1)
  Solo setea un valor a cada atributo
  */
  public Tree(int valor) {
    this.valor = valor;
    this.izquierda = null;
    this.derecha = null;
  }

  /*
    Complejidad O(n) siendo N el tamaño de la lista
    Siempre recorrera todos los elementos, ya que por cada uno llama al metodo add()
  */
  public Tree(List<Integer> list) {
    list.forEach(this::add);
  }

  /*
      Complejidad O(n) siendo N el ultimo elemento de la rama
      En el peor de los casos sera el menor o mayor elemento de una rama y se seteara en ese lugar
   */
  public void add(Integer element) {
    if (Objects.isNull(valor)) {
      valor = element;
      return;
    }
    if (element < valor) {
      if (Objects.isNull(izquierda)) {
        izquierda = new Tree(element);
      } else {
        izquierda.add(element);
      }
    } else {
      if (Objects.isNull(derecha)) {
        derecha = new Tree(element);
      } else {
        derecha.add(element);
      }
    }
  }


  /*
    Complejidad O(1)
    devuelve la rame de la izquierda
   */
  private Tree getLeft() {
    return izquierda;
  }

  /*
      Complejidad O(1)
      setea la rama de la izquierda
     */
  private void setLeft(Tree left) {
    this.izquierda = left;
  }

  /*
      Complejidad O(1)
      devuelve la rame de la derecha
   */
  private Tree getRight() {
    return derecha;
  }

  /*
      Complejidad O(1)
      setea la rame de la derecha
   */
  private void setRight(Tree right) {
    this.derecha = right;
  }

  /*
      Complejidad O(1)
      devuelve el valor del arbol
   */
  public Integer getValor() {
    return valor;
  }

  /*
      Complejidad O(1)
      setea el valor del arbol
   */
  private void setValue(Integer value) {
    this.valor = value;
  }

  /*
      Complejidad O(n) siendo n la altura del arbol
      en el peor de los casos recorrera todas las ramas en busqueda del elemento
  */
  public boolean hasElem(Integer element) {
    if (element.equals(valor)) {
      return true;
    } else if (element < valor) {
      if (Objects.nonNull(izquierda)) {
        izquierda.hasElem(element);
      } else {
        return false;
      }

    } else {
      if (Objects.nonNull(derecha)) {
        derecha.hasElem(element);
      } else {
        return false;
      }
    }
    return false;
  }

  /*
      Complejidad O(1)
      Ya que solo revisa si el valor es null
  */
  public boolean isEmpty() {
    if (Objects.isNull(valor)) {
      return true;
    } else {
      return false;
    }
  }

  /*
      Complejidad O(N) siendo N la altura del árbol
      en el peor de los casos el elemento se encontrara al final del arbol
  */
  public void delete(Integer element) {
    delete(this, element);
  }

  /*
        Complejidad O(N) siendo N la altura del árbol
        en el peor de los casos el elemento se encontrara al final del arbol
   */
  private void delete(Tree tree, Integer integer) {

    if (Objects.nonNull(tree.getLeft()) && integer < tree.getValor()) {
      if (tree.getLeft().getValor().equals(integer)) {
        if (Objects.isNull(tree.getLeft().getLeft()) && Objects.isNull(tree.getLeft().getRight())) {
          tree.setLeft(null);
        } else if (Objects.nonNull(tree.getLeft().getLeft()) && Objects
            .isNull(tree.getLeft().getRight())) {
          tree.setLeft(tree.getLeft().getLeft());
        } else if (Objects.isNull(tree.getLeft().getLeft())) {
          tree.setLeft(tree.getLeft().getRight());
        } else {
          Integer minNodeTreeOfRight = getMinimumElementInTree(tree.getLeft().getRight());
          delete(tree.getRight(), minNodeTreeOfRight);
          tree.getLeft().setValue(minNodeTreeOfRight);
        }
      } else {
        tree.getLeft().delete(tree.getLeft(), integer);
      }
    } else if (Objects.nonNull(tree.getRight()) && integer > tree.getValor()) {
      if (tree.getRight().getValor().equals(integer)) {
        if (Objects.isNull(tree.getRight().getLeft()) && Objects
            .isNull(tree.getRight().getRight())) {
          tree.setRight(null);
        } else if (Objects.nonNull(tree.getRight().getLeft()) && Objects
            .isNull(tree.getRight().getRight())) {
          tree.setRight(tree.getRight().getLeft());
        } else if (Objects.isNull(tree.getRight().getLeft())) {
          tree.setLeft(tree.getLeft().getRight());
        } else {
          Integer minNodeTreeOfRight = getMinimumElementInTree(tree.getRight().getRight());
          delete(tree.getRight(), minNodeTreeOfRight);
          tree.getRight().setValue(minNodeTreeOfRight);
        }
      } else {
        tree.getLeft().delete(tree.getRight(), integer);
      }
    }
    if (tree.getValor().equals(integer)) {
      if (Objects.nonNull(tree.getLeft()) && Objects.nonNull(tree.getRight())) {
        Integer minNodeTreeOfRight = getMinimumElementInTree(tree.getRight());
        delete(tree, minNodeTreeOfRight);
        tree.setValue(minNodeTreeOfRight);
      }
    }

  }

  /*
        Complejidad O(N) siendo N la altura del árbol
        busca el minimo elemento para un arbol dado recorriendo toda la altura
   */
  public Integer getMinimumElementInTree(Tree tree) {
    if (Objects.nonNull(tree.getLeft())) {
      return tree.getMinimumElementInTree(tree.getLeft());
    }

    return tree.getValor();
  }

  /*
        Complejidad O(N) siendo N la altura del árbol
        recorre el arbol buscando la rama com mas altura.
   */
  public int getHeight() {
    return getHeight(this);
  }

  private int getHeight(Tree tree) {
    if (tree == null) {
      return 0;
    } else {
      return (1 + Math.max(getHeight(tree.getLeft()), getHeight(tree.getRight())));
    }

  }

  /*
        Complejidad O(N) siendo N la altura del árbol
        recorre el arbol imprimiendo cada uno de sus elementos
   */
  public void printPosOrder() {
    printPosOrder(this);
    System.out.println();
  }

  /*
        Complejidad O(N) siendo N la altura del árbol
        recorre el arbol imprimiendo cada uno de sus elementos
   */
  private void printPosOrder(Tree tree) {
    if (Objects.nonNull(tree)) {
      printPosOrder(tree.getLeft());
      printPosOrder(tree.getRight());
      //Visit the node by Printing the node data
      System.out.printf("%d ", tree.getValor());
    }
  }

  /*
        Complejidad O(N) siendo N la altura del árbol
        recorre el arbol imprimiendo cada uno de sus elementos
   */
  public void printInOrder() {
    printInOrder(this);
    System.out.println();
  }

  /*
        Complejidad O(N) siendo N la altura del árbol
        recorre el arbol imprimiendo cada uno de sus elementos
   */
  private void printInOrder(Tree tree) {
    if (tree == null) {
      return;
    }
    printInOrder(tree.getLeft());

    System.out.print(tree.getValor() + " ");
    /* now recur on right subtree */
    printInOrder(tree.getRight());
  }

  /*
        Complejidad O(N) siendo N la altura del árbol
        recorre el arbol imprimiendo cada uno de sus elementos
   */
  public void printPreOrder() {
    printPreorder(this);
    System.out.println();
  }

  /*
        Complejidad O(N) siendo N la altura del árbol
        recorre el arbol imprimiendo cada uno de sus elementos
   */
  private void printPreorder(Tree tree) {
    if (tree == null) {
      System.out.print("- ");
      return;
    }

    System.out.print(tree.getValor() + " ");

    printPreorder(tree.getLeft());

    /* now recur on right subtree */
    printPreorder(tree.getRight());
  }

  /*
        Complejidad O(N) siendo N la altura del árbol
        recorre el arbol buscando la rama mas larga
   */
  public List<Integer> getLongestBranch() {
    List<Integer> result = getLongestBranch(this);
    Collections.reverse(result);
    return result;
  }

  /*
        Complejidad O(N) siendo N la altura del árbol
        recorre el arbol buscando la rama mas larga
   */
  private List<Integer> getLongestBranch(Tree tree) {
    if (this.valor == null) {
      List<Integer> output = new ArrayList<>();
      return output;
    }
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    if (Objects.nonNull(tree.getRight())) {
      right = getLongestBranch(tree.getRight());
    }
    if (Objects.nonNull(tree.getLeft())) {
      left = getLongestBranch(tree.getLeft());
    }

    if (right.size() < left.size()) {
      left.add(tree.getValor());

      return left;
    } else {
      right.add(tree.getValor());

      return right;
    }
  }

  /*
        Complejidad O(N) siendo N la altura del árbol
        recorre el arbol buscando el ultimo nodo de cada rama
   */
  public List getFrontera() {
    return getFrontera(this);
  }

  /*
        Complejidad O(N) siendo N la altura del árbol
        recorre el arbol buscando el ultimo nodo de cada rama
   */
  private List getFrontera(Tree tree) {
    List<Integer> frontera = new ArrayList<>();
    if (Objects.isNull(tree.getRight()) && Objects.isNull(tree.getLeft())) {
      frontera.add(tree.getValor());
    } else if (Objects.nonNull(tree.getLeft()) && Objects.isNull(tree.getRight())) {
      frontera.addAll(getFrontera(tree.getLeft()));
    } else if (Objects.isNull(tree.getLeft())) {
      frontera.addAll(getFrontera(tree.getRight()));
    } else {
      frontera.addAll(getFrontera(tree.getLeft()));
      frontera.addAll(getFrontera(tree.getRight()));
    }
    return frontera;
  }

  /*
        Complejidad O(N) siendo N el valor pasado como parametro
        recorre el arbol obteniendo todos los elementos en un nivel
   */
  public List<Integer> getElementAtLevel(Integer integer) {
    return getElementsLevel(integer, this);
  }

  /*
         Complejidad O(N) siendo N el valor pasado como parametro
         recorre el arbol obteniendo todos los elementos en un nivel
   */
  private List<Integer> getElementsLevel(Integer level, Tree tree) {
    List<Integer> list = new ArrayList<>();

    if (Objects.isNull(tree)) {
      return list;
    }

    if (level.equals(0)) {
      list.add(tree.getValor());
    } else if (level > 0) {
      list.addAll(getElementsLevel(level - 1, tree.getLeft()));
      list.addAll(getElementsLevel(level - 1, tree.getRight()));
    }

    return list;
  }

  /*
         Complejidad O(N) siendo N el tamaño de la rama de la derecha
         recorre la rama de la derecha buscando el elemento mayor
   */
  public Integer getMaxElem() {
    return getMaxElem(this);
  }

  /*
           Complejidad O(N) siendo N el tamaño de la rama de la derecha
           recorre la rama de la derecha buscando el elemento mayor
  */
  private Integer getMaxElem(Tree tree) {
    if (Objects.isNull(tree.getValor())) {
      return null;
    } else {
      if (Objects.nonNull(tree.getRight())) {
        return getMaxElem(tree.getRight());
      } else {
        return tree.getValor();
      }
    }
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Tree)) {
      return false;
    }
    Tree tree = (Tree) o;
    return Objects.equals(getValor(), tree.getValor()) && Objects
        .equals(izquierda, tree.izquierda) && Objects.equals(derecha, tree.derecha);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getValor(), izquierda, derecha);
  }
}
