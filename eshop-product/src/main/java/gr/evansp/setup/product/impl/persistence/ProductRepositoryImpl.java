package gr.evansp.setup.product.impl.persistence;

import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.persistence.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

/**
 * Implementation of {@link ProductRepository}.
 */
@SuppressWarnings({"unused", "deprecation", "rawtypes", "unchecked"})
public class ProductRepositoryImpl implements ProductRepository {
  @Override
  public Product get(Long productId, Long categoryId) throws DataException {
    if (productId == null) {
      return null;
    }

    if (categoryId == null) {
      return null;
    }
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      Product product = session.get(Product.class, new ProductPK(productId, categoryId));
      session.close();
      return product;
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public List<Product> getAll() throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
      String hql = "gr.evansp.setup.product.def.models.Product";
      Query query = session.createQuery(hql);
      return query.getResultList();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public void save(Product entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession();) {

      session.beginTransaction();
      session.persist(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public void update(Product entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession();) {

      session.beginTransaction();
      session.merge(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public void delete(Product entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession();) {

      session.beginTransaction();
      session.remove(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Setter
  @Getter
  @AllArgsConstructor
  private static class ProductPK {
    private Long productId;
    private Long categoryId;
  }
}
