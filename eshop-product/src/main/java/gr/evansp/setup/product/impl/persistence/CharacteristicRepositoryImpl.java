package gr.evansp.setup.product.impl.persistence;

import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.persistence.CharacteristicRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Implementation of {@link CharacteristicRepository}.
 */
@SuppressWarnings({"unused", "deprecation", "rawtypes", "unchecked"})
public class CharacteristicRepositoryImpl implements CharacteristicRepository {

  @Override
  public Characteristic get(Characteristic characteristic) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
      session.beginTransaction();
      Characteristic result = session.get(Characteristic.class,
          characteristic);
      session.close();
      return result;
    } catch (Exception e) {
      throw new DataException(e);
    }
  }

  @Override
  public List<Characteristic> getAll() throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
      String hql = " FROM gr.evansp.setup.product.def.models.Characteristic";
      Query query = session.createQuery(hql);
      return query.getResultList();
    } catch (Exception e) {
      throw new DataException(e);
    }
  }

  @Override
  public void save(Characteristic entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      session.persist(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(e);
    }
  }

  @Override
  public void update(Characteristic entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      session.merge(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(e);
    }
  }

  @Override
  public void delete(Characteristic entity) throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      session.beginTransaction();
      session.remove(entity);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DataException(e);
    }
  }
}
