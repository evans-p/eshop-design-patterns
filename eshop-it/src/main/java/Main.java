import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Random;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Random random = new Random();

    Category category = Factory.create(Category.class);
    Product product = Factory.create(Product.class);
    Characteristic characteristic = Factory.create(Characteristic.class);

    category.setCategoryId(random.nextLong());
    category.setName("Category");
    category.setDescription("Category Description1");

    product.setProductId(random.nextLong());
    product.setName("Product1");
    product.setSKU("SKU");
    product.setDescription("Product Description");
    product.setCategory(category);
    product.setDateAdded(Calendar.getInstance().getTime());
    product.setDateLastModified(Calendar.getInstance().getTime());
    product.setInventoryCount(100);
    product.setInventoryLimit(100);
    product.setPrice(BigDecimal.TEN);

    characteristic.setCharacteristicId(random.nextLong());
    characteristic.setName("Characterisitic");
    characteristic.setValue("Value");
    characteristic.setProduct(product);

    product.setCharacteristics(Set.of(characteristic));

    System.out.println(product);
    System.out.println(category);
    System.out.println(characteristic);

    Configuration configuration = new Configuration().configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();

    Session session = sessionFactory.openSession();
    session.beginTransaction();

    session.persist(category);
    session.getTransaction().commit();
    session.close();

    session = sessionFactory.openSession();
    session.beginTransaction();
    session.persist(product);
    session.getTransaction().commit();
    session.close();
  }
}
