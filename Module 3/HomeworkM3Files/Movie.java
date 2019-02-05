public class Movie implements Comparable<Movie>{
  private String name;
  private int releaseYear;

  @Override
  public int compareTo(Movie other) {
    int nameComparison = this.name.toLowerCase().compareTo(other.name.toLowerCase());
    if (nameComparison == 0) {
      return Integer.compare(this.releaseYear, other.releaseYear);
    } else {
      return nameComparison;
    }
  }
}