import java.util.NoSuchElementException;
/**
 * A class to represent a linked list of nodes.
 */
public class LinkedList<T> implements Iterable<T> {
  /** the first node of the list, or null if the list is empty */
  private LLNode<T> firstNode;
  
  /**
   * Creates an initially empty linked list
   */
  public LinkedList() {
    firstNode = null;
  }
  
  /**
   * Returns the first node.
   * @return the first node of the list
   */
  protected LLNode<T> getFirstNode() {
    return firstNode;
  }
  /**
   * Changes the front node.
   * @param node  the node that will be the first node of the new linked list
   */
  protected void setFirstNode(LLNode<T> node) {
    this.firstNode = node;
  }
  /**
   * Return whether the list is empty
   * @return true if the list is empty
   */
  public boolean isEmpty() {
    return (getFirstNode() == null);
  }
  
  /**
   * Add an element to the front of the linked list
   * @param element the element we are adding to the front
   */
  public void addToFront(T element) {
    setFirstNode(new LLNode<T>(element, getFirstNode()));
  }
  
  /**
   * Removes and returns the element at the front of the linked list
   * @return the element removed from the front of the linked list
   * @throws NoSuchElementException if the list is empty
   */
  public T removeFromFront() {
    if (isEmpty())
      throw new NoSuchElementException();
    else {
      T save = getFirstNode().getElement();
      setFirstNode(getFirstNode().getNext());
      return save;
    }
  }
  /**
   * Returns the length of the linked list
   * @return the number of nodes in the list
   */
  public int length() {
    int count = 0;
    LLNode<T> nodeptr = getFirstNode();
    while (nodeptr != null) {
      count++;
      nodeptr = nodeptr.getNext();
    }
    return count;
  }
  
  /**
   * Return an iterator for this list
   * @return the iterator for the list
   */
  @Override
  public LinkedListIterator<T> iterator() {
    return new LinkedListIterator<T>(getFirstNode());
  }
  
  /**
   * Prints the contents of a list to System.out.
   * @param list the list to print
   * @param <S> the type of the element
   */
  public static <S> String printList(LinkedList<S> list) {
    String s = "";
    for (S element : list) {
      s += element + " ";
    }
    return s;
  }

  
  //--------------------------------------------------------------------------------------------------------------
  
  
  /**
   * Move the first element of the list back a number of spaces.
   * @param n the number of spaces the first element will move back
   */
  public void moveBack(int n) {
    if (this.length() > n && n > 0) {
      LLNode<T> firstNode = this.getFirstNode();
      LLNode<T> nodeptr = this.getFirstNode().getNext();
      this.removeFromFront();
      for (int i = 0; i < n -1; i++)
        nodeptr = nodeptr.getNext();
      firstNode.setNext(nodeptr.getNext());
      nodeptr.setNext(firstNode);
    }
  }
    
  /**
   * Move the first element to the end of the list
   */
  public void moveFirstToLast() {
    this.moveBack(this.length() - 1);
  }
  
  /**
   * Move the last element to the front of the list
   */
  public void moveLastToFirst()  {
    for(int i = 0; i < this.length() - 1; i++)
      this.moveFirstToLast();
  }
  
  /**
   * Reverse all the elements in the list
   */
  public void reverseList() {
    for(int i = this.length() - 1; i > 0; i--)
      this.moveBack(i);
  }
  
  /**
   * Reverse the first k number of elements in a list
   * @param k Reverse the elements up to the kth element
   */
  public void reverseFirstK(int k) {
  
    if (this.length() > k) {
      for(int i = k - 1; i > 0; i--)
        this.moveBack(i);
    }
  }
}
