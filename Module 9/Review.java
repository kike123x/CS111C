public class Review {


	public static void main(String[] args) {
    System.out.println(charCount("", 'I', 0));
  }

  public static int charCount(String word, char letter, int index) {
    if (index >= word.length()) return 0;
    else {
      boolean check = word.charAt(index) == letter;
      return check ? 1 + charCount(word, letter, index+1) : charCount(word, letter, index+1);
    }
  }

}