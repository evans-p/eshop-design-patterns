import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Category;

public class Main {
  public static void main(String[] args) {
    Category category = Factory.create(Category.class);
    System.out.println(category);
  }
}
