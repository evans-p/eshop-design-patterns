package gr.evansp.setup.user;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.setup.user.def.models.Address;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * Implementation of {@link DAO} for {@link Address}
 */
public class AddressDAO implements DAO<Address> {
  @Override
  public Address get(Long id) throws DataException {
    if (id == null) {
      return null;
    }
    try (Session session = new Configuration().buildSessionFactory().openSession();) {

      session.beginTransaction();
      Address address = (Address) session.get(Address.class, id);
      session.close();
      return address;
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public List<Address> getAll() throws DataException {
    try (
        Session session = new Configuration().buildSessionFactory().openSession();
    ) {

      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Address> cq = cb.createQuery(Address.class);
      Root<Address> rootEntry = cq.from(Address.class);
      CriteriaQuery<Address> all = cq.select(rootEntry);

      TypedQuery<Address> allQuery = session.createQuery(all);
      return allQuery.getResultList();
    } catch (Exception e) {
      throw new DataException(e.getStackTrace().toString());
    }
  }

  @Override
  public void save(Address entity) throws DataException {
    try (Session session = new Configuration().buildSessionFactory().openSession();) {

      session.beginTransaction();
      session.persist(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public void update(Address entity) throws DataException {
    try (Session session = new Configuration().buildSessionFactory().openSession();) {

      session.beginTransaction();
      session.merge(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public void delete(Address entity) throws DataException {
    try (Session session = new Configuration().buildSessionFactory().openSession();) {

      session.beginTransaction();
      session.remove(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }
}
