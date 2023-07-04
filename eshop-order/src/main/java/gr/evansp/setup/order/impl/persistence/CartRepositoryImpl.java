package gr.evansp.setup.order.impl.persistence;

import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.order.def.models.Cart;
import gr.evansp.setup.order.def.persistence.CartRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

/**
 * Implementation of {@link CartRepository}
 */
@SuppressWarnings({"unused", "deprecation", "rawtypes", "unchecked"})
public class CartRepositoryImpl implements CartRepository {

    @Override
    public Cart get(Cart cart) throws DataException {
        try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

            session.beginTransaction();
            Cart result = session.get(Cart.class, cart.getCartId());
            session.close();
            return result;
        } catch (Exception e) {
            throw new DataException(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public List<Cart> getAll() throws DataException {
        try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
            String hql = "FROM gr.evansp.setup.order.def.models.Cart";
            Query query = session.createQuery(hql);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataException(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public void save(Cart entity) throws DataException {
        try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new DataException(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public void update(Cart entity) throws DataException {
        try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new DataException(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public void delete(Cart entity) throws DataException {
        try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

            session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new DataException(Arrays.toString(e.getStackTrace()));
        }
    }
}
