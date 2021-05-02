package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class TreeNodeImpl extends Tree {

  private Integer valor;
  private Tree izquierda;
  private Tree derecha;

  public TreeNodeImpl(int valor) {
    this.valor = valor;
    this.izquierda = null;
    this.derecha = null;
  }

  public TreeNodeImpl(List<Integer> list) {
    list.forEach(this::add);
  }


  @Override
  public void add(Integer element) {
    if (Objects.isNull(valor)) {
      valor = element;
      return;
    }
    if (element < valor) {
      if (Objects.isNull(izquierda)) {
        izquierda = new TreeNodeImpl(element);
      } else {
        izquierda.add(element);
      }
    } else {
      if (Objects.isNull(derecha)) {
        derecha = new TreeNodeImpl(element);
      } else {
        derecha.add(element);
      }
    }
  }

  @Override
  public Tree getRoot() {
    return this;
  }

  @Override
  public Tree getLeft() {
    return izquierda;
  }

  @Override
  public void setLeft(Tree left) {
    this.izquierda = left;
  }

  @Override
  public Tree getRight() {
    return derecha;
  }

  @Override
  public void setRight(Tree right) {
    this.derecha = right;
  }

  @Override
  public Integer getValor() {
    return valor;
  }

  @Override
  public void setValue(Integer value) {
    this.valor = value;
  }

  @Override
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

  @Override
  public boolean isEmpty() {
    if (Objects.isNull(valor)) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public void insert(Integer element) {
    if (element < valor) {
      if (Objects.nonNull(izquierda)) {
        izquierda.insert(element);
      } else {
        izquierda = new TreeNodeImpl(element);
      }
    } else {
      if (Objects.nonNull(derecha)) {
        derecha.insert(element);
      } else {
        derecha = new TreeNodeImpl(element);
      }
    }
  }

  @Override
  public void delete(Integer element) {
    delate(this, element);
  }

  private void delate(Tree tree, Integer integer) {

    if (Objects.nonNull(izquierda) && integer < tree.getValor()) {
      if (izquierda.getValor().equals(integer)) {
        if (Objects.isNull(izquierda.getLeft()) && Objects.isNull(izquierda.getRight())) {
          tree.setLeft(null);
        } else if (Objects.nonNull(izquierda.getLeft()) && Objects.isNull(izquierda.getRight())) {
          tree.setLeft(izquierda.getLeft());
        } else if (Objects.nonNull(izquierda.getLeft()) && Objects.nonNull(izquierda.getRight())) {
          Integer minNodeTreeOfRight = getMinimumElementInTree(derecha);
          delete(minNodeTreeOfRight);
          tree.setValue(minNodeTreeOfRight);
        }
        //aca falta el caso que no sea hoja solamente
      } else {
        izquierda.delete(integer);
      }
    } else if (Objects.nonNull(derecha) && integer > tree.getValor()) {
      if (derecha.getValor().equals(integer)) {
        if (Objects.isNull(derecha.getLeft()) && Objects.isNull(derecha.getRight())) {
          tree.setRight(null);
        }
      } else {
        derecha.delete(integer);
      }
    }
    if (valor.equals(integer)) {
      if (Objects.nonNull(derecha) && Objects.nonNull(izquierda)) {
        Integer minNodeTreeOfRight = getMinimumElementInTree(derecha);
        delete(minNodeTreeOfRight);
        tree.setValue(minNodeTreeOfRight);
      }
    }

  }

  @Override
  public Integer getMinimumElementInTree(Tree tree) {
    if (Objects.nonNull(tree.getLeft())) {
      tree.getMinimumElementInTree(tree.getLeft());
    }
    return tree.getValor();
  }

  @Override
  public void delateLeaf(Tree tree, Tree leaf) {
    if (leaf.getValor() < tree.getValor()) {
      if (tree.getLeft().equals(leaf)) {
        tree.setLeft(null);
      } else {
        delateLeaf(tree.getLeft(), leaf);
      }
    } else if (leaf.getValor() > tree.getValor()) {
      if (tree.getRight().equals(leaf)) {
        tree.setRight(null);
      } else {
        delateLeaf(tree.getRight(), leaf);
      }
    }

  }

  @Override
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

  @Override
  public void printPosOrder() {

  }

  @Override
  public void printPreOrder() {
    printPreorder(this);
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

  @Override
  public void printInOrder() {

  }

  @Override
  public List getLongestBranch() {
    return getLongestBranch(this);
  }

  private List getLongestBranch(Tree tree) {
    if (this.valor == null) {
      List<Integer> output = new ArrayList<>();
      return output;
    }
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
// Recursive call on root.right
    if (Objects.nonNull(tree.getRight())) {
      right = getLongestBranch(tree.getRight());
    }
    if (Objects.nonNull(tree.getLeft())) {
      left = getLongestBranch(tree.getLeft());
    }

    if (right.size() < left.size()) {
      left.add(tree.getValor());
      Collections.reverse(left);
      return left;
    } else {
      right.add(tree.getValor());
      Collections.reverse(right);
      return right;
    }
  }

  @Override
  public List getFrontera() {
    return null;
  }

  @Override
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

  @Override
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TreeNodeImpl)) {
      return false;
    }
    TreeNodeImpl treeNode = (TreeNodeImpl) o;
    return Objects.equals(getValor(), treeNode.getValor()) && Objects
        .equals(izquierda, treeNode.izquierda) && Objects.equals(derecha, treeNode.derecha);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getValor(), izquierda, derecha);
  }
}
