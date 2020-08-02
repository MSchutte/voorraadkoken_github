package voorraadkoken.domain;

public class Product {
  String name;
  int hoeveelheid;
  String eenheid;

  public String getProductName() {
    return name;
  }

  public int getHoeveelheid() {
    return hoeveelheid;
  }

  public String getProductEenheid() {
    return eenheid;
  }
}