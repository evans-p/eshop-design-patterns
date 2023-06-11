package gr.evansp.setup.product.impl.persistence;

import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.persistence.CharacteristicRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

/**
 * Implementation of {@link CharacteristicRepository}.
 */
@SuppressWarnings({"unused", "deprecation", "rawtypes", "unchecked"})
public class CharacteristicRepositoryImpl implements CharacteristicRepository {

  @Override
  public Characteristic get(Long characteristicId, Long productId, Long categoryId) throws DataException {
    if (characteristicId == null) {
      return null;
    }
    if (productId == null) {
      return null;
    }
    if (categoryId == null) {
      return null;
    }
    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession();) {

      session.beginTransaction();
      Characteristic characteristic = session.get(Characteristic.class,
          new CharacteristicPK(characteristicId, productId, categoryId));
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

  @Setter
  @Getter
  @AllArgsConstructor
  private static class CharacteristicPK {
    private Long productId;
    private Long categoryId;
    private Long characteristicId;
  }
}
