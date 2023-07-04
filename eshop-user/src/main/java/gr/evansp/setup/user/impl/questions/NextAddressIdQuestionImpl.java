package gr.evansp.setup.user.impl.questions;

import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.user.def.questions.NextAddressIdQuestion;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

/**
 * Implementation of {@link NextAddressIdQuestion}
 */
@SuppressWarnings({"unused", "deprecation", "rawtypes"})
public class NextAddressIdQuestionImpl implements NextAddressIdQuestion {
  private Long answer;

  @Override
  public void ask() throws DataException {

    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
      NativeQuery query = session.createNativeQuery("SELECT NEXTVAL('ADDRESS_ID_SEQUENCE');");
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
