import java.util.*;

public class ListDeque<T> implements DequeInterface<T> {
  private List<T> list;

  public ListDeque() {
    list = new LinkedList<T>();
  }

  public void addToFront(T newEntry) {
    list.add(0, newEntry);
  }

  public void addToBack(T newEntry) {
    list.add(list.size(), newEntry);
  }

  public T removeFront() {
    if (list.size() == 0) {
      throw new EmptyQueueException();
    } else {
      return list.remove(0);
    }
  }

  public T removeBack() {
    if (list.size() == 0) {
      throw new EmptyQueueException();
    } else {
      return list.remove(list.size()-1);
    }
  }

  public T getFront() {
    if (list.size() == 0) {
      throw new EmptyQueueException();
    } else {
      return list.get(0);
    }
  }

  public T getBack() {
    if (list.size() == 0) {
      throw new EmptyQueueException();
    } else {
      return list.get(list.size()-1);
    }
  }

  public boolean isEmpty() {
    return list.size() == 0;
  }

  public void clear() {
    list.clear();
  }
}