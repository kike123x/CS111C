import java.util.EmptyStackException;

public final class DequeStack<T> implements StackInterface<T> {
  private DequeInterface<T> deque;

  public DequeStack() {
    deque = new LinkedDeque<T>();
  }

  public void push(T newEntry) {
    deque.addToFront(newEntry);
  }

  public T pop() {
    if (deque.isEmpty()) {
      throw new EmptyStackException();
    } else {
      return deque.removeFront();
    }
  }

  public T peek() {
    if (deque.isEmpty()) {
      throw new EmptyStackException();
    } else {
      return deque.getFront();
    }
  }

  public boolean isEmpty() {
    return deque.isEmpty();
  }

  public void clear() {
    deque.clear();
  }
}