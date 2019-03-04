import java.util.Arrays;

public class ArrayHeadTailList<T> implements HeadTailListInterface<T> {
  private T[] listArray;
  private int numberOfElements;

  public ArrayHeadTailList(int desiredCapacity) {
    if (desiredCapacity > 0) {
      listArray = (T[]) new Object[desiredCapacity];
      numberOfElements = 0;
    } else {
      throw new IllegalStateException("Invalid list size");
    }
  }

  public void addFront(T newEntry) {
    if (numberOfElements == listArray.length) {
      int newLength = 2 * listArray.length;
      T[] tempList = (T[]) new Object[newLength];
      tempList[0] = newEntry;
      int i = 0;
      while(i < numberOfElements) {
        tempList[i+1] = listArray[i];
        i++;
      }
      listArray = tempList;

    } else {
      int i = numberOfElements-1;
      while(i >= 0) {
        listArray[i+1] = listArray[i];
        i--;
      }
      listArray[0] = newEntry;
    }
    numberOfElements++;
  }

  public void addBack(T newEntry) {
    if (numberOfElements == listArray.length) {
      int newLength = 2 * listArray.length;
      listArray = Arrays.copyOf(listArray, newLength);
    }
    listArray[numberOfElements] = newEntry;
    numberOfElements++;
  }

  public T removeFront() {
    if (numberOfElements == 0) {
      return null;
    } else {
      T temp = listArray[0];
      int i = 0;
      while (i < numberOfElements - 1) {
        listArray[i] = listArray[i+1];
        i++;
      }
      listArray[numberOfElements-1] = null;
      numberOfElements--;
      return temp;
    }
  }

  public T removeBack() {
    if (numberOfElements == 0) {
      return null;
    } else {
      T temp = listArray[numberOfElements-1];
      listArray[numberOfElements-1] = null;
      numberOfElements--;
      return temp;
    }
  }

  public void clear() {
    while(numberOfElements > 0) {
      listArray[numberOfElements-1] = null;
      numberOfElements--;
    }
  }

  public int contains(T anEntry) {
    for(int i = 0; i < numberOfElements; i++) {
      if (listArray[i].equals(anEntry)) {
        return i;
      }
    }
    return -1;
  }

  public void display() {
    System.out.print(numberOfElements);
    System.out.print(" elements; capacity = ");
    System.out.print(listArray.length);
    if (numberOfElements > 0) {
      System.out.print(" [");
      int i = 0;
      while(i < numberOfElements) {
        System.out.print(listArray[i]);
        if (i != numberOfElements-1) {
          System.out.print(", ");
        }
        i++;
      }
      System.out.println("]");
    }
  }

  public T getEntry(int givenPosition) {
    if (givenPosition < 0 || givenPosition >= numberOfElements) {
      return null;
    } else {
      return listArray[givenPosition];
    }
  }

  public boolean isEmpty() {
    return numberOfElements == 0;
  }

  public int size() {
    return numberOfElements;
  }
}
