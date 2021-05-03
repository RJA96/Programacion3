package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Tree {

  private Integer valor;
  private Tree izquierda;
  private Tree derecha;

  public Tree(int valor) {
    this.valor = valor;
    this.izquierda = null;
    this.derecha = null;
  }

  public Tree(List<Integer> list) {
    list.forEach(this::add);
  }


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


  public Tree getRoot() {
    return this;
  }

  public Tree getLeft() {
    return izquierda;
  }


  public void setLeft(Tree left) {
    this.izquierda = left;
  }


  public Tree getRight() {
    return derecha;
  }


  public void setRight(Tree right) {
    this.derecha = right;
  }


  public Integer getValor() {
    return valor;
  }


  public void setValue(Integer value) {
    this.valor = value;
  }


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


  public boolean isEmpty() {
    if (Objects.isNull(valor)) {
      return true;
    } else {
      return false;
    }
  }


  public void insert(Integer element) {
    if (element < valor) {
      if (Objects.nonNull(izquierda)) {
        izquierda.insert(element);
      } else {
        izquierda = new Tree(element);
      }
    } else {
      if (Objects.nonNull(derecha)) {
        derecha.insert(element);
      } else {
        derecha = new Tree(element);
      }
    }
  }


  public void delete(Integer element) {
    delete(this, element);
  }

  private void delete(Tree tree, Integer integer) {

    if (Objects.nonNull(tree.getLeft()) && integer < tree.getValor()) {
      if (tree.getLeft().getValor().equals(integer)) {
        if (Objects.isNull(tree.getLeft().getLeft()) && Objects.isNull(tree.getLeft().getRight())) {
          tree.setLeft(null);
        } else if (Objects.nonNull(tree.getLeft().getLeft()) && Objects.isNull(tree.getLeft().getRight())) {
          tree.setLeft(tree.getLeft().getLeft());
        } else if (Objects.isNull(tree.getLeft().getLeft()) && Objects.nonNull(tree.getLeft().getRight())) {
          tree.setLeft(tree.getLeft().getRight());
        }else if (Objects.nonNull(tree.getLeft().getLeft()) && Objects.nonNull(tree.getLeft().getRight())) {
          Integer minNodeTreeOfRight = getMinimumElementInTree(tree.getLeft().getRight());
          delete(tree.getRight(), minNodeTreeOfRight);
          tree.getLeft().setValue(minNodeTreeOfRight);
        }
      } else {
        tree.getLeft().delete(tree.getLeft(),integer);
      }
    } else if (Objects.nonNull(tree.getRight()) && integer > tree.getValor()) {
      if (tree.getRight().getValor().equals(integer)) {
        if (Objects.isNull(tree.getRight().getLeft()) && Objects.isNull(tree.getRight().getRight())) {
          tree.setRight(null);
        } else if (Objects.nonNull(tree.getRight().getLeft()) && Objects.isNull(tree.getRight().getRight())) {
          tree.setRight(tree.getRight().getLeft());
        }
        else if (Objects.isNull(tree.getRight().getLeft()) && Objects.nonNull(tree.getRight().getRight())) {
          tree.setLeft(tree.getLeft().getRight());
        }else if (Objects.nonNull(tree.getRight().getLeft()) && Objects.nonNull(tree.getRight().getRight())) {
          Integer minNodeTreeOfRight = getMinimumElementInTree(tree.getRight().getRight());
          delete(tree.getRight(), minNodeTreeOfRight);
          tree.getRight().setValue(minNodeTreeOfRight);
        }
      } else {
        tree.getLeft().delete(tree.getRight(),integer);
      }
    }
    if (valor.equals(integer)) {
      if (Objects.nonNull(tree.getLeft()) && Objects.nonNull(tree.getRight())) {
        Integer minNodeTreeOfRight = getMinimumElementInTree(tree.getRight());
        delete(tree, minNodeTreeOfRight);
        tree.setValue(minNodeTreeOfRight);
      }
    }

  }


  public Integer getMinimumElementInTree(Tree tree) {
    if (Objects.nonNull(tree.getLeft())) {
       return tree.getMinimumElementInTree(tree.getLeft());
    }

    return tree.getValor();
  }


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


  public void printPosOrder() {

  }


  public void printPreOrder() {
    printPreorder(this);
    System.out.println();
  }

  private void printPreorder(Tree node) {
    if (node == null) {
      System.out.print("- ");
      return;
    }

    System.out.print(node.getValor() + " ");

    printPreorder(node.getLeft());

    /* now recur on right subtree */
    printPreorder(node.getRight());
  }


  public void printInOrder() {

  }


  public List<Integer> getLongestBranch() {
    List<Integer> result = getLongestBranch(this);
    Collections.reverse(result);
    return result;
  }

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


  public List getFrontera() {
    List<Integer> frontera = new ArrayList<>();
    return null;
  }

  public List getFrontera(Tree tree) {
    List<Integer> frontera = new ArrayList<>();
    return null;
  }

  public List<Integer> getElementAtLevel(Integer integer) {
    return getElementsLevel(integer, this);
  }

  private List<Integer> getElementsLevel(Integer level, Tree tree) {
    List<Integer> list = new ArrayList<>();

    if (tree == null) {
      return list;
    }

    if (level == 0) {
      list.add(tree.getValor());
    } else if (level > 0) {
      list.addAll(getElementsLevel(level - 1, tree.getLeft()));
      list.addAll(getElementsLevel(level - 1, tree.getRight()));
    }

    return list;
  }


  public Integer getMaxElem() {
    return getMaxElem(this);
  }

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


  public int hashCode() {
    return Objects.hash(getValor(), izquierda, derecha);
  }
}
