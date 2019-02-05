public class OvernightParcel extends Parcel {
  private boolean signatureRequired;

  public OvernightParcel(String id, int weight, boolean signReq) {
    super(id, weight);
    this.signatureRequired = signReq;
  }

  @Override
  public String toString() {
    return super.toString() + "\nSignature Required: " + this.signatureRequired;
  }
}