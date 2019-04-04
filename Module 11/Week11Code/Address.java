public class Address {
  private int strNum, zipCode;
  private String strName, city, state;

  public Address(int strNum, String strName, String city, String state, int zipCode) {
    this.strNum = strNum;
    this.strName = strName;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
  }

  @Override
  public int hashCode() {
    return Object.hash(strNum, strName, city, state, zipCode);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Address) {
      Address otherAddress = (Address) obj;
      return strNum == otherAddress.strNum &&
             strName.equals(otherAddress.strName) &&
             city.equals(otherAddress.city) &&
             state.equals(otherAddress.state) &&
             zipCode == otherAddress.zipCode;
    } else {
      return false;
    }
  }

}