public class Driver {
  public static void main(String[] args) {
    StackInterface<Integer> stack = new LinkedStack<>();
    stack.push(1);
    stack.push(12);
    stack.push(13);
    stack.push(12);
    stack.push(13);
    stack.push(14);
    stack.push(12);
    stack.push(13);
    stack.push(13);
    System.out.println(stack.countEntries(13));

  }
}