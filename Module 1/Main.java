public class Main {
  public static void main(String[] args) {
    Parcel x = new Parcel("ATL123");
    Parcel y = new OvernightParcel("NYC456", 2, true);
    y.setWeight(15);
    System.out.println(y.toString());

    System.out.println(checkEmail("a@h.co.uk"));
  }

  public static boolean checkEmail(String email) {
    String[] splitArr = email.split("@");
    if (splitArr.length == 2 && splitArr[0].length() > 0) {
      String[] domain = splitArr[1].split("\\.", 2);
      if (domain[0].length() > 0 && domain[1].length() >= 3) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }
}