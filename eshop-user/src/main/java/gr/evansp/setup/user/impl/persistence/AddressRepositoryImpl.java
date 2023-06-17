package gr.evansp.setup.user.impl.persistence;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.user.def.models.Address;
import gr.evansp.setup.user.def.persistence.AddressRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

/**
 * Implementation of {@link DAO} for {@link Address}
 */
@SuppressWarnings({"unused", "unchecked", "deprecation", "rawtypes"})
public class AddressRepositoryImpl implements AddressRepository {

  @Override
  public Address get(Address address) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      Address result = session.get(Address.class, address);
      session.close();
      return result;
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public List<Address> getAll() throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
      String hql = "FROM gr.evansp.setup.user.def.models.Address";
      Query query = session.createQuery(hql);
      return query.getResultList();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public void save(Address entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      session.persist(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public void update(Address entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      session.merge(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public void delete(Address entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      session.remove(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }
}
