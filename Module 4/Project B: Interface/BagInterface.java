public interface BagInterface<T to extends Comparable<? super T>> {


  /** Create a new list using all entries in this bag, ordered from smallest to largest.
   *  @return A newly created list where its size equals getCurrentSize(). */
  public ListInterface<T> createOrderedList();

  /** Creates a new bag containing a given number of random entries from this bag.
   *  @param count The desired number of random entries to be removed from this bag and added to the new bag.
   *  @return A newly created bag containing given number of random entries from this bag.
   *  @throws IndexOutOfBoundException if count is out of range (count < 1 || count > getCurrentSize()). */
  public BagInterface<T> splitBag(int count);

  /** Checks whether this bag is at full capacity.
   *  @return True if getCurrentSize() equals the bag's max capacity, or false if otherwise. */
  public boolean isFull();

} // end BagInterface
