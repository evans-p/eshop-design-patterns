package gr.evansp.setup.product.impl.persistence;

import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.persistence.CategoryRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * implementation of {@link CategoryRepository}.
 */
@SuppressWarnings({"unused", "deprecation", "rawtypes", "unchecked"})
public class CategoryRepositoryImpl implements CategoryRepository {
  @Override
  public Category get(Category category) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      Category result = session.get(Category.class, category.getCategoryId());
      session.close();
      return result;
    } catch (Exception e) {
      throw new DataException(e);
    }
  }

  @Override
  public List<Category> getAll() throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
      String hql = "FROM gr.evansp.setup.product.def.models.Category";
      Query query = session.createQuery(hql);
      return query.getResultList();
    } catch (Exception e) {
      throw new DataException(e);
    }
  }

  @Override
  public void save(Category entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      session.persist(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(e);
    }
  }

  @Override
  public void update(Category entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      session.merge(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(e);
    }
  }

  @Override
  public void delete(Category entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      session.remove(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(e);
    }
  }
}
