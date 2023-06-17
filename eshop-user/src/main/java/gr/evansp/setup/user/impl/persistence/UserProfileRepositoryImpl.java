package gr.evansp.setup.user.impl.persistence;

import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.user.def.models.UserProfile;
import gr.evansp.setup.user.def.persistence.UserProfileRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

/**
 * Implementation of {@link gr.evansp.common.Repository} for {@link UserProfile}.
 */
@SuppressWarnings({"unused", "unchecked", "deprecation", "rawtypes"})
public class UserProfileRepositoryImpl implements UserProfileRepository {
  @Override
  public UserProfile get(UserProfile userProfile) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      UserProfile result = session.get(UserProfile.class, userProfile.getUserId());
      session.close();
      return result;
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public List<UserProfile> getAll() throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
      String hql = "FROM gr.evansp.setup.user.def.models.UserProfile";
      Query query = session.createQuery(hql);
      return query.getResultList();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public void save(UserProfile entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
      session.beginTransaction();
      session.persist(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public void update(UserProfile entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
      session.beginTransaction();
      session.merge(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public void delete(UserProfile entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
      session.beginTransaction();
      session.remove(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }
}
