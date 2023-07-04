package gr.evansp.setup.order.impl.questions;

import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.order.def.questions.NextOrderIdQuestion;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

/**
 * Implementation of {@link NextOrderIdQuestion}.
 */
@SuppressWarnings({"unused", "deprecation", "rawtypes"})
public class NextOrderIdQuestionImpl implements NextOrderIdQuestion {
  private Long answer;

  @Override
  public void ask() throws DataException {

    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      NativeQuery query = session.createNativeQuery("SELECT NEXTVAL('ORDER_ID_SEQUENCE');");
      answer = (Long) query.uniqueResult();
    } catch (Exception e) {
      throw new DataException(e);
    }
  }

  @Override
  public Long answer() {
    return answer;
  }
}
