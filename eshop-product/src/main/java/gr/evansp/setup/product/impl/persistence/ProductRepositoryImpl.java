package gr.evansp.setup.product.impl.persistence;

import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.persistence.ProductRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Implementation of {@link ProductRepository}.
 */
@SuppressWarnings({"unused", "deprecation", "rawtypes", "unchecked"})
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public Product get(Product product) throws DataException {
        try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

            session.beginTransaction();
            Product result = session.get(Product.class, product);
            session.close();
            return result;
        } catch (Exception e) {
            throw new DataException(e);
        }
    }

    @Override
    public List<Product> getAll() throws DataException {
        try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
            String hql = "FROM gr.evansp.setup.product.def.models.Product";
            Query query = session.createQuery(hql);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataException(e);
        }
    }

    @Override
    public List<Product> getByCategory(Long categoryId) throws DataException {
        try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
            String hql = "FROM gr.evansp.setup.product.def.models.Product WHERE categoryId =: id";
            Query query = session.createQuery(hql);
            query.setParameter("id", categoryId);
            return query.getResultList();
        } catch (Exception e) {
            throw new DataException(e);
        }
    }

    @Override
    public void save(Product entity) throws DataException {
        try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new DataException(e);
        }
    }

    @Override
    public void update(Product entity) throws DataException {
        try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new DataException(e);
        }
    }

    @Override
    public void delete(Product entity) throws DataException {
        try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

            session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new DataException(e);
        }
    }
}
