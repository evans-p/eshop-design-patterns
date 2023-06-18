package gr.evansp.setup.order.impl.questions;

import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.order.def.questions.NextCartIdQuestion;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;

/**
 * Implementation of {@link NextCartIdQuestion}.
 */
@SuppressWarnings({"unused", "deprecation", "rawtypes"})
public class NextCartIdQuestionImpl implements NextCartIdQuestion {
    private Long answer;

    @Override
    public void ask() throws DataException {

        try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

            NativeQuery query = session.createNativeQuery("SELECT NEXTVAL('CART_ID_SEQUENCE');");
            answer = (Long) query.uniqueResult();
        } catch (Exception e) {
            throw new DataException(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public Long answer() {
        return answer;
    }
}
