package gr.evansp.setup.product.impl.persistence;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.product.def.models.Characteristic;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.List;

public class CharacteristicDAO implements DAO<Characteristic> {
  @Override
  public Characteristic get(Long id) throws DataException {
    if (id == null) {
      return null;
    }
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession();) {

      session.beginTransaction();
      Characteristic characteristic = (Characteristic) session.get(Characteristic.class, id);
      session.close();
      return characteristic;
    } catch (Exception e) {
      throw new DataException(e.getStackTrace().toString());
    }
  }

  @Override
  public List<Characteristic> getAll() throws DataException {
    try (
        Session session = HibernateConfiguration.INSTANCE.getFactory().openSession();
    ) {

      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Characteristic> cq = cb.createQuery(Characteristic.class);
      Root<Characteristic> rootEntry = cq.from(Characteristic.class);
      CriteriaQuery<Characteristic> all = cq.select(rootEntry);

      TypedQuery<Characteristic> allQuery = session.createQuery(all);
      return allQuery.getResultList();
    } catch (Exception e) {
      throw new DataException(e.getStackTrace().toString());
    }
  }

  @Override
  public void save(Characteristic entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession();) {

      session.beginTransaction();
      session.persist(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public void update(Characteristic entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession();) {

      session.beginTransaction();
      session.merge(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public void delete(Characteristic entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession();) {

      session.beginTransaction();
      session.remove(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }
}
