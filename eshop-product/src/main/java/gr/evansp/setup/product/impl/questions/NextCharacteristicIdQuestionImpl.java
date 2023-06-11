package gr.evansp.setup.product.impl.questions;

import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.product.def.questions.NextCharacteristicIdQuestion;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;

/**
 * Implementation of {@link NextCharacteristicIdQuestion}
 */
@SuppressWarnings({"unused", "deprecation", "rawtypes"})
public class NextCharacteristicIdQuestionImpl implements NextCharacteristicIdQuestion {
  private Long answer;

  @Override
  public void ask() throws DataException {

    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {

      NativeQuery query = session.createNativeQuery("SELECT NEXTVAL('CHARACTERISTIC_ID_SEQUENCE');");
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
