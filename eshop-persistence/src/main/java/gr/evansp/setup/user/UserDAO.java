package gr.evansp.setup.user;

import gr.evansp.exceptions.DataException;
import gr.evansp.setup.DAO;
import gr.evansp.setup.user.def.models.User;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

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
    Session session = null;
    try {
      session = new Configuration().buildSessionFactory().openSession();
      session.beginTransaction();
      User user = (User) session.get(User.class, id);
      session.close();
      return user;
    } catch (Exception e) {
      throw new DataException(e.getStackTrace().toString());
    } finally {
      if ((session != null) && session.isOpen()) {
        session.close();
        return null;
      }
    }
  }

  @Override
  public List<User> getAll() throws DataException {
    Session session = null;
    try {
      session = new Configuration().buildSessionFactory().openSession();
      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<User> cq = cb.createQuery(User.class);
      Root<User> rootEntry = cq.from(User.class);
      CriteriaQuery<User> all = cq.select(rootEntry);

      TypedQuery<User> allQuery = session.createQuery(all);
      return allQuery.getResultList();
    } catch (Exception e) {
      throw new DataException(e.getStackTrace().toString());
    } finally {
      return null;
    }
  }

  @Override
  public boolean save(User entity) throws DataException {
    Session session = null;
    boolean result = false;
    try {
      session = new Configuration().buildSessionFactory().openSession();
      session.beginTransaction();
      session.persist(entity);
      session.getTransaction().commit();
      session.close();
      return true;
    } catch (Exception e) {
      throw new DataException(e.getStackTrace().toString());
    } finally {
      if ((session != null) && session.isOpen()) {
        session.close();
        return result;
      }
    }
  }

  @Override
  public boolean update(User entity) throws DataException {
    Session session = null;
    boolean result = false;
    try {
      session = new Configuration().buildSessionFactory().openSession();
      session.beginTransaction();
      session.merge(entity);
      session.getTransaction().commit();
      session.close();
      return true;
    } catch (Exception e) {
      throw new DataException(e.getStackTrace().toString());
    } finally {
      if ((session != null) && session.isOpen()) {
        session.close();
        return result;
      }
    }
  }

  @Override
  public boolean delete(User entity) throws DataException {
    Session session = null;
    boolean result = false;
    try {
      session = new Configuration().buildSessionFactory().openSession();
      session.beginTransaction();
      session.remove(entity);
      session.getTransaction().commit();
      session.close();
      return true;
    } catch (Exception e) {
      throw new DataException(e.getStackTrace().toString());
    } finally {
      if ((session != null) && session.isOpen()) {
        session.close();
        return result;
      }
    }
  }
}
