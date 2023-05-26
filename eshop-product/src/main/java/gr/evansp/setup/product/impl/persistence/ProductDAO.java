package gr.evansp.setup.product.impl.persistence;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.product.def.models.Product;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.List;


public class ProductDAO implements DAO<Product> {
  @Override
  public Product get(Long id) throws DataException {
    if (id == null) {
      return null;
    }
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession();) {

      session.beginTransaction();
      Product product = (Product) session.get(Product.class, id);
      session.close();
      return product;
    } catch (Exception e) {
      throw new DataException(e.getStackTrace().toString());
    }
  }

  @Override
  public List<Product> getAll() throws DataException {
    try (
        Session session = HibernateConfiguration.INSTANCE.getFactory().openSession();
    ) {

      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Product> cq = cb.createQuery(Product.class);
      Root<Product> rootEntry = cq.from(Product.class);
      CriteriaQuery<Product> all = cq.select(rootEntry);

      TypedQuery<Product> allQuery = session.createQuery(all);
      return allQuery.getResultList();
    } catch (Exception e) {
      throw new DataException(e.getStackTrace().toString());
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
}
