// import java.lang.Math;

/**
    A class of bags whose entries are stored in a fixed-size array.
    @author Frank M. Carrano, Timothy M. Henry
    @version 5.0
*/
public final class ArrayBag<T extends Comparable<? super T>> implements BagInterface<T>
{
	private final T[] bag;
	private int numberOfEntries;
   private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	/** Creates an empty bag whose initial capacity is 25. */
	public ArrayBag()
	{
		this(DEFAULT_CAPACITY);
	} // end default constructor

	/** Creates an empty bag having a given capacity.
	    @param desiredCapacity  The integer capacity desired. */
	public ArrayBag(int desiredCapacity)
	{
      if (desiredCapacity <= MAX_CAPACITY)
      {
         // The cast is safe because the new array contains null entries
         @SuppressWarnings("unchecked")
         T[] tempBag = (T[])new Comparable[desiredCapacity]; // Unchecked cast
         bag = tempBag;
         numberOfEntries = 0;
         integrityOK = true;
         // Test that contents are nulls - OK
         //      for (int index = 0; index < desiredCapacity; index++)
         //         System.out.print(bag[index] + " ");
         //      System.out.println();
      }
      else
         throw new IllegalStateException("Attempt to create a bag " +
                                         "whose capacity exceeds " +
                                         "allowed maximum.");
	} // end constructor

	/** Adds a new entry to this bag.
       @param newEntry  The object to be added as a new entry.
       @return  True if the addition is successful, or false if not. */
	public boolean add(T newEntry)
	{
		checkIntegrity();
      boolean result = true;
      if (isArrayFull())
      {
         result = false;
      }
      else
      {  // Assertion: result is true here
         bag[numberOfEntries] = newEntry;
         numberOfEntries++;
      } // end if

      return result;
	} // end add

	/** Retrieves all entries that are in this bag.
       @return  A newly allocated array of all the entries in this bag. */
   //	public <T> T[] toArray() //OK
	public T[] toArray() //OK
	{
		checkIntegrity();

      // The cast is safe because the new array contains null entries.
      @SuppressWarnings("unchecked")
      T[] result = (T[])new Comparable[numberOfEntries]; // Unchecked cast

      for (int index = 0; index < numberOfEntries; index++)
      {
         result[index] = bag[index];
      } // end for
      return result;
      // Note: The body of this method could consist of one return statement,
      // if you call Arrays.copyOf
	} // end toArray

	/** Sees whether this bag is empty.
       @return  True if this bag is empty, or false if not. */
	public boolean isEmpty()
	{
      return numberOfEntries == 0;
	} // end isEmpty

	/** Gets the current number of entries in this bag.
       @return  The integer number of entries currently in this bag. */
	public int getCurrentSize()
	{
      return numberOfEntries;
	} // end getCurrentSize

	/** Counts the number of times a given entry appears in this bag.
       @param anEntry  The entry to be counted.
       @return  The number of times anEntry appears in this ba. */
	public int getFrequencyOf(T anEntry)
	{
		checkIntegrity();
      int counter = 0;

      for (int index = 0; index < numberOfEntries; index++)
      {
         if (anEntry.equals(bag[index]))
         {
            counter++;
         } // end if
      } // end for

      return counter;
	} // end getFrequencyOf

	/** Tests whether this bag contains a given entry.
       @param anEntry  The entry to locate.
       @return  True if this bag contains anEntry, or false otherwise. */
   public boolean contains(T anEntry)
	{
		checkIntegrity();
      return getIndexOf(anEntry) > -1; // or >= 0
	} // end contains

	/** Removes all entries from this bag. */
	public void clear()
	{
      while (!isEmpty())
         remove();
	} // end clear

	/** Removes one unspecified entry from this bag, if possible.
       @return  Either the removed entry, if the removal
                was successful, or null. */
	public T remove()
	{
		checkIntegrity();
      T result = removeEntry(numberOfEntries - 1);
      return result;
	} // end remove

	/** Removes one occurrence of a given entry from this bag.
    @param anEntry  The entry to be removed.
    @return  True if the removal was successful, or false if not. */
	public boolean remove(T anEntry)
	{
		checkIntegrity();
      int index = getIndexOf(anEntry);
      T result = removeEntry(index);
      return anEntry.equals(result);
	} // end remove

   // Returns true if the array bag is full, or false if not.
	private boolean isArrayFull()
	{
		return numberOfEntries >= bag.length;
	} // end isArrayFull

 	// Locates a given entry within the array bag.
	// Returns the index of the entry, if located,
	// or -1 otherwise.
   // Precondition: checkInitialization has been called.
	private int getIndexOf(T anEntry)
	{
		int where = -1;
		boolean found = false;
		int index = 0;

      while (!found && (index < numberOfEntries))
		{
			if (anEntry.equals(bag[index]))
			{
				found = true;
				where = index;
			} // end if
         index++;
		} // end while

      // Assertion: If where > -1, anEntry is in the array bag, and it
      // equals bag[where]; otherwise, anEntry is not in the array.

		return where;
	} // end getIndexOf

   // Removes and returns the entry at a given index within the array.
   // If no such entry exists, returns null.
   // Precondition: 0 <= givenIndex < numberOfEntries.
   // Precondition: checkInitialization has been called.
	private T removeEntry(int givenIndex)
	{
		T result = null;

		if (!isEmpty() && (givenIndex >= 0))
		{
         result = bag[givenIndex];          // Entry to remove
         int lastIndex = numberOfEntries - 1;
         bag[givenIndex] = bag[lastIndex];  // Replace entry to remove with last entry
         bag[lastIndex] = null;             // Remove reference to last entry
         numberOfEntries--;
		} // end if

      return result;
	} // end removeEntry

   // Throws an exception if this object is not initialized.
   private void checkIntegrity()
   {
      if (!integrityOK)
         throw new SecurityException("ArrayBag object is corrupt.");
   } // end checkIntegrity

	public ResizableArrayBag<T> createResizableArrayBag() {
		ResizableArrayBag<T> newBag = new ResizableArrayBag<>(this.bag);
		return newBag;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ArrayBag<?>) {
			ArrayBag<T> otherBagParam = (ArrayBag<T>) obj;

			ArrayBag<T> otherBag = new ArrayBag<T>(otherBagParam.numberOfEntries);
			for(int i=0; i<otherBagParam.numberOfEntries; i++) {
				otherBag.add(otherBagParam.bag[i]);
			}

			for(int i=0; i<numberOfEntries; i++) {
				T item = this.bag[i];
				if(!otherBag.contains(item)) {
					return false;
				} else {
					otherBag.remove(item);
				}
			}
			if(otherBag.isEmpty()) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}

	}


	public boolean replace(T oldElement, T newElement) {
		return false;
		// YOUR HOMEWORK CODE HERE
	}

	public int removeEvery(T element) {
		return 0;
		// YOUR HOMEWORK CODE HERE
	}

   public BagInterface<T> getAllLessThan(T anObject) {
		BagInterface<T> newBag = new ArrayBag<>();
		for (int i = 0; i < numberOfEntries; i++) {
			T item = this.bag[i];
			if (anObject.compareTo(item) > 0) {
				newBag.add(this.bag[i]);
			}
		}
		return newBag;
	}

	// midterm
	public T getAnEntry() {
		if (numberOfEntries == 0) {
			return null;
		}
		double random = Math.random();
		random = random * numberOfEntries;
		int index = (int) random;
		return bag[index];
	}

} // end ArrayBag
