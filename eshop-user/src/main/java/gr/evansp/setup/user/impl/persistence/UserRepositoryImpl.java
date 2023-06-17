package gr.evansp.setup.user.impl.persistence;

import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.persistence.UserRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

/**
 * Implementation of {@link UserRepository}.
 */
@SuppressWarnings({"deprecation", "unused", "rawtypes", "unchecked"})
public class UserRepositoryImpl implements UserRepository {
  @Override
  public User get(User user) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
      session.beginTransaction();
      User result = session.get(User.class, user.getUserId());
      session.close();
      return result;
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public List<User> getAll() throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
      String hql = "FROM gr.evansp.setup.user.def.models.User";
      Query query = session.createQuery(hql);
      return query.getResultList();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public void save(User entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
      session.beginTransaction();
      session.persist(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public void update(User entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
      session.beginTransaction();
      session.merge(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public void delete(User entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
      session.beginTransaction();
      session.remove(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }
}
