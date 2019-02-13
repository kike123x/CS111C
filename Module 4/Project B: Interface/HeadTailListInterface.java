/** An interface for the ADT head-tail list.
 *  <p>
 *  Entries in a list can be accessed via their positions which begin with 0.
 *  <p>
 *  Only the entry currently at the beginning or at the end of the list can be removed.
 *  <p>
 *  New entries can only be added to either the beginning or the end of the list.
 *  @author Brian Nguyen
 *  @version 1.0
 */
public interface HeadTailListInterface<T> {

  /** Adds a new entry to the front of this list.
   *  All current entries in this list are shifted to the next higher position.
   *  The list's size is increased by 1.
   *  @param newEntry  The object to be added as a new head of this list. */
  public void addFront(T newEntry);

  /** Adds a new entry to the back of this list.
   *  The list's size is increased by 1.
   *  @param newEntry  The object to be added as a new tail of this list. */
  public void addBack(T newEntry);

  /** Removes the current head (entry at position 0) of this list.
   *  All remaining entries in this list are shifted to the next lower position.
   *  The list's size is decreased by 1.
   *  @return  Either a reference to the removed entry, or null if the list is currently empty. */
  public T removeFront();

  /** Removes the current tail (entry at position size() - 1) of this list.
   *  The list's size is decreased by 1.
   *  @return  Either a reference to the removed entry, or null if the list is currently empty. */
  public T removeBack();

  /** Retrieves the entry at a given position in this list.
   *  @param position  An integer that indicates the position of the desired entry.
   *  @return  A reference to the desired entry at given position.
   *  @throws  IndexOutOfBoundsException if position is out of range (position &lt; 0 || position &gt;= size()). */
  public T getEntry(int position);

  /** Prints out all entries in this list. */
  public void display();

  /** Checks whether this list contains a given entry.
   *  @param entry  The entry to look for in the list.
   *  @return  The number of times a given entry appears in the list. */
  public int contains (T entry);

  /** Checks whether this list is empty.
   *  @return  True if the list is empty, or false if not. */
  public boolean isEmpty();

  /** Gets the number of entries in this list.
   *  @return  The number of entries currently in the list. */
  public int size();

  /** Removes all entries from this list. */
  public void clear();

} // end HeadTailListInterface
