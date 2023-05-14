package gr.evansp.setup.user.impl.questions;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.setup.user.def.questions.NextUserIdQuestion;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class NextUserIdQuestionImpl implements NextUserIdQuestion {
  private Long answer;

  @Override
  public void ask() throws DataException, LogicException {

    try (
        Session session = new Configuration().buildSessionFactory().openSession();
    ) {

      NativeQuery query = session.createNativeQuery("SELECT NEXTVAL('USER_ID_SEQUENCE');");
      answer = (Long) query.uniqueResult();
    } catch (Exception e) {
      throw new DataException(e.getStackTrace().toString());
    }
  }

  @Override
  public Long answer() {
    return answer;
  }
}
