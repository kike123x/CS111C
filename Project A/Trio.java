public class Trio<T> {

  private T item1;
  private T item2;
  private T item3;

  public Trio(T firstThing, T secondThing, T thirdThing) {
    this.item1 = firstThing;
    this.item2 = secondThing;
    this.item3 = thirdThing;
  }

  public Trio(T thing) {
    this(thing, thing, thing);
  }

  public T getItem1() {
    return item1;
  }

  public T getItem2() {
    return item2;
  }

  public T getItem3() {
    return item3;
  }

  public void setItem1(T item) {
    this.item1 = item;
  }

  public void setItem2(T item) {
    this.item2 = item;
  }

  public void setItem3(T item) {
    this.item3 = item;
  }

  @Override
  public String toString() {
    return item1.toString() + "\t" + item2.toString() + "\t" + item3.toString();
  }

  public int contains(T item) {
    int count = 0;
    if (item1.equals(item)) {
      count++;
    }
    if (item2.equals(item)) {
      count++;
    }
    if (item3.equals(item)) {
      count++;
    }
    return count;
  }

  public boolean hasDuplicates() {
    if (item1.equals(item2))
      return true;
    else if (item2.equals(item3))
      return true;
    else if (item1.equals(item3))
      return true;
    else
      return false;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Trio<?>) {
      Trio<?> otherTrio = (Trio<?>) other;

      T otherItem1 = (T) otherTrio.getItem1();
      T otherItem2 = (T) otherTrio.getItem2();
      T otherItem3 = (T) otherTrio.getItem3();

      if (item1.equals(otherItem1)) {
        if (item2.equals(otherItem2)) {
          if (item3.equals(otherItem3)) {
          return true;
          }
        } else if (item2.equals(otherItem3)) {
          if (item3.equals(otherItem2)) {
            return true;
          }
        }
      } else if (item1.equals(otherItem2)) {
        if (item2.equals(otherItem3)) {
          if (item3.equals(otherItem1)) {
            return true;
          }
        } else if (item2.equals(otherItem1)) {
          if (item3.equals(otherItem3)) {
            return true;
          }
        }
      } else if (item1.equals(otherItem3)) {
        if (item2.equals(otherItem1)) {
          if (item3.equals(otherItem2)) {
            return true;
          }
        } else if (item2.equals(otherItem2)) {
          if (item3.equals(otherItem1)) {
            return true;
          }
        }
      }
    }
    return false;
  }

}