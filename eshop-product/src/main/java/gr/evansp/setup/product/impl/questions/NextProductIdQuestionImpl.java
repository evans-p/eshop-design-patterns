package gr.evansp.setup.product.impl.questions;

import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.product.def.questions.NextProductIdQuestion;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

@SuppressWarnings({"unused", "deprecation", "rawtypes"})
public class NextProductIdQuestionImpl implements NextProductIdQuestion {
  private Long answer;

  @SuppressWarnings("nls")
  @Override
  public void ask() throws DataException {

    try (
        Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()
    ) {

      NativeQuery query = session.createNativeQuery("SELECT NEXTVAL('PRODUCT_ID_SEQUENCE');");
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
