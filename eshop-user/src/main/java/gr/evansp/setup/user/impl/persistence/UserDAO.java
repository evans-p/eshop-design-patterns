package gr.evansp.setup.user.impl.persistence;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.user.def.models.User;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.List;

/**
 * Implementation of {@link DAO} for {@link User}
 */
public class UserDAO implements DAO<User> {
  @Override
  public User get(Long id) throws DataException {
    if (id == null) {
      return null;
    }
    try (
        Session session = HibernateConfiguration.INSTANCE.getFactory().openSession();
    ) {

      session.beginTransaction();
      User user = (User) session.get(User.class, id);
      session.close();
      return user;
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public List<User> getAll() throws DataException {
    try (
        Session session = HibernateConfiguration.INSTANCE.getFactory().openSession();
    ) {

      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<User> cq = cb.createQuery(User.class);
      Root<User> rootEntry = cq.from(User.class);
      CriteriaQuery<User> all = cq.select(rootEntry);

      TypedQuery<User> allQuery = session.createQuery(all);
      return allQuery.getResultList();
    } catch (Exception e) {
      throw new DataException(e.getStackTrace().toString());
    }
  }

  @Override
  public void save(User entity) throws DataException {
    try (
        Session session = HibernateConfiguration.INSTANCE.getFactory().openSession();
    ) {

      session.beginTransaction();
      session.persist(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(e.getStackTrace().toString());
    }
  }

  @Override
  public void update(User entity) throws DataException {
    try (
        Session session = HibernateConfiguration.INSTANCE.getFactory().openSession();
    ) {

      session.beginTransaction();
      session.merge(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(e.getStackTrace().toString());
    }
  }

  @Override
  public void delete(User entity) throws DataException {
    try (
        Session session = HibernateConfiguration.INSTANCE.getFactory().openSession();
    ) {

      session.beginTransaction();
      session.remove(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }
}
