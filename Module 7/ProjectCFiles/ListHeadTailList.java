import java.util.*;

public class ListHeadTailList<T> implements HeadTailListInterface<T> {
  private List<T> list;

  public ListHeadTailList() {
    // default to capacity of 10
    list = new ArrayList<T>();
  }

  public ListHeadTailList(int desiredCapacity) {
    list = new ArrayList<T>(desiredCapacity);
  }

  public void addFront(T newEntry) {
    list.add(0, newEntry);
  }

  public void addBack(T newEntry) {
    list.add(newEntry);
  }

  public T removeFront() {
    if (list.size() > 0) return list.remove(0);
    return null;
  }

  public T removeBack() {
    if (list.size() > 0) return list.remove(list.size()-1);
    return null;
  }

  public void clear() {
    list.clear();
  }

  public int contains(T anEntry) {
    return list.indexOf(anEntry);
  }

  public void display() {
    System.out.print(list.size());
    System.out.print(" elements; capacity N/A  ");
    if (list.size() > 0) {
      System.out.print("[");
      int i = 0;
      while (i < list.size()) {
        System.out.print(list.get(i));
        if (i != list.size() - 1) {
          System.out.print(", ");
        }
        i++;
      }
      System.out.println("]");
    }
  }

  public T getEntry(int givenPosition) {
    if (givenPosition < 0 || givenPosition >= list.size()) {
      return null;
    }
    return list.get(givenPosition);
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  public int size() {
    return list.size();
  }
}