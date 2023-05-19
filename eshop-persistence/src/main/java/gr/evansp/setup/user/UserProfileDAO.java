package gr.evansp.setup.user;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.user.def.models.UserProfile;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Implementation of {@link DAO} for {@link UserProfile}
 */
public class UserProfileDAO implements DAO<UserProfile> {
  @Override
  public UserProfile get(Long id) throws DataException {
    if (id == null) {
      return null;
    }
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession();) {

      session.beginTransaction();
      UserProfile userProfile = (UserProfile) session.get(UserProfile.class, id);
      session.close();
      return userProfile;
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public List<UserProfile> getAll() throws DataException {
    try (
        Session session = new Configuration().buildSessionFactory().openSession();
    ) {

      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<UserProfile> cq = cb.createQuery(UserProfile.class);
      Root<UserProfile> rootEntry = cq.from(UserProfile.class);
      CriteriaQuery<UserProfile> all = cq.select(rootEntry);

      TypedQuery<UserProfile> allQuery = session.createQuery(all);
      return allQuery.getResultList();
    } catch (Exception e) {
      throw new DataException(e.getStackTrace().toString());
    }
  }

  @Override
  public void save(UserProfile entity) throws DataException {
    try (Session session = new Configuration().buildSessionFactory().openSession();) {

      session.beginTransaction();
      session.persist(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(e.getStackTrace().toString());
    }
  }

  @Override
  public void update(UserProfile entity) throws DataException {
    try (Session session = new Configuration().buildSessionFactory().openSession();) {

      session.beginTransaction();
      session.merge(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(e.getStackTrace().toString());
    }
  }

  @Override
  public void delete(UserProfile entity) throws DataException {
    try (Session session = new Configuration().buildSessionFactory().openSession();) {

      session.beginTransaction();
      session.remove(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(e.getStackTrace().toString());
    }
  }
}
