package tree;

import java.util.List;


public abstract class Tree {

  public abstract void add(Integer element);

  public abstract Integer getMinimumElementInTree(Tree tree);

  protected abstract void delateLeaf(Tree tree, Tree leaf);

  public abstract Tree getRoot();

  public abstract Tree getLeft();

  public abstract void setLeft(Tree left);

  public abstract Tree getRight();

  public abstract void setRight(Tree right);

  public abstract Integer getValor();

  public abstract void setValue(Integer value);

  //ejecicio 6
  public abstract boolean hasElem(Integer element);

  public abstract boolean isEmpty();

  public abstract void insert(Integer element);

  public abstract void delete(Integer element);

  public abstract int getHeight();

  public abstract void printPosOrder();

  public abstract void printPreOrder();

  public abstract void printInOrder();

  public abstract List getLongestBranch();

  public abstract List getFrontera();

  public abstract List<Integer> getElementAtLevel(Integer integer);

  public abstract Integer getMaxElem();


}
