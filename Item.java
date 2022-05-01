abstract class Item {

  int id;
  String name;
  int weight;
  String color;
  String type;


  public Item(int id, String name, int weight, String color, String type) {
    this.id = id;
    this.name = name;
    weight = weight;
    this.color = color;
    this.type = type;
  }

  public int Sum(Item item) {
    return this.weight + item.weight;
  }

  public boolean Compare(Item Item) {
    return Item.weight > this.weight;
  }

  @Override
  public String toString() {
    String op =
        "id = " + id + " name=" + name + " Weight =" + weight + " color = " + color + " Type"
            + type;
    return op;
  }

}

class Car extends Item {

  public Car(int id, String name, int weight, String color, String type) {
    super(id, name, weight, color, type);
  }


}

class Boat extends Item {

  public Boat(int id, String name, int weight, String color, String type) {
    super(id, name, weight, color, type);
  }


}

class Chair extends Item {

  public Chair(int id, String name, int weight, String color, String type) {
    super(id, name, weight, color, type);
  }

}

class Cup extends Item {

  String material;

  public Cup(int id, String name, String material) {
    super(id, name, 0, "", "");
    this.material = material;
  }

  @Override
  public String toString() {
    String op = "id = " + id + " name=" + name + " material=" + material;
    return op;
  }

}




