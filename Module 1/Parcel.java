public class Parcel {
  private String id;
  private int weight;
  private static final int DEFAULT_WEIGHT = 5;

  public Parcel(String id, int weight) {
    this.id = id;
    this.weight = weight;
  }

  public Parcel(String id) {
    this(id, DEFAULT_WEIGHT);
  }

  public int getWeight() {
    return this.weight;
  }

  public void setWeight(int weight) {
    if (weight > 0) {
      this.weight = weight;
    }
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    if (id.length() > 0) {
      this.id = id;
    }
  }

  @Override
  public String toString() {
    return "Parcel ID: " + this.id + "\nWeight: " + this.weight;
  }

  @Override
  public boolean equals(Object x) {
    if (x instanceof Parcel) {
      return this.id == ((Parcel) x).getId() && this.weight == ((Parcel) x).getWeight();
    } else {
      return false;
    }
  }

}
