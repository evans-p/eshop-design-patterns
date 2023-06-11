package gr.evansp.setup.product.impl.persistence;

import gr.evansp.common.DAO;
import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.product.def.models.Characteristic;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings({"unused", "deprecation", "rawtypes", "unchecked"})
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
      throw new DataException(Arrays.toString(e.getStackTrace()));
    }
  }

  @Override
  public List<Characteristic> getAll() throws DataException {
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
      String hql = "gr.evansp.setup.product.def.models.Characteristic";
      Query query = session.createQuery(hql);
      return query.getResultList();
    } catch (Exception e) {
      throw new DataException(Arrays.toString(e.getStackTrace()));
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
