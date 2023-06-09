package gr.evansp.setup.user.impl.questions;

import gr.evansp.exceptions.DataException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.user.def.questions.NextUserIdQuestion;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;


@SuppressWarnings({"unused", "deprecation", "rawtypes"})
public class NextUserIdQuestionImpl implements NextUserIdQuestion {
  private Long answer;


  @Override
  public void ask() throws DataException {

    try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
      NativeQuery query = session.createNativeQuery("SELECT NEXTVAL('USER_ID_SEQUENCE');");
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
