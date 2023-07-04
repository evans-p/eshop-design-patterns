package gr.evansp.setup.order.impl.persistence;

import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.order.def.models.OrderItem;
import gr.evansp.setup.order.def.persistence.OrderItemRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Implementation of {@link OrderItemRepository}.
 */
@SuppressWarnings({"unused", "deprecation", "rawtypes", "unchecked"})
public class OrderItemRepositoryImpl implements OrderItemRepository {


  @Override
  public OrderItem get(OrderItem orderItem) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      return session.get(OrderItem.class, orderItem);
    } catch (Exception e) {
      throw new DataException(e);
    }
  }

  @Override
  public List<OrderItem> getAll() throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
      String hql = "FROM gr.evansp.setup.order.def.models.OrderItem";
      Query query = session.createQuery(hql);
      return query.getResultList();
    } catch (Exception e) {
      throw new DataException(e);
    }
  }

  @Override
  public void save(OrderItem entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      session.persist(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(e);
    }
  }

  @Override
  public void update(OrderItem entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      session.merge(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(e);
    }
  }

  @Override
  public void delete(OrderItem entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      session.remove(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(e);
    }
  }
}
