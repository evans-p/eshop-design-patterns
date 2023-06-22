package gr.evansp.setup.order.impl.persistence;

import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.order.def.models.CartItem;
import gr.evansp.setup.order.def.persistence.CartItemRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

/**
 * Implementation of {@link CartItemRepository}
 */
@SuppressWarnings({"unused", "deprecation", "rawtypes", "unchecked"})
public class CartItemRepositoryImpl implements CartItemRepository {

  @Override
  public CartItem get(CartItem cartItem) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      CartItem result = session.get(CartItem.class, cartItem);
      session.close();
      return result;
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public List<CartItem> getAll() throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
      String hql = "FROM gr.evansp.setup.order.def.models.CartItem";
      Query query = session.createQuery(hql);
      return query.getResultList();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public void save(CartItem entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      session.persist(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public void update(CartItem entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      session.merge(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public void delete(CartItem entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      session.remove(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }
}
