package gr.evansp.setup.product.impl.questions;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.product.def.questions.NextCategoryIdQuestion;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

public class NextCategoryIdQuestionImpl implements NextCategoryIdQuestion {
  private Long answer;

  @Override
  public void ask() throws DataException, LogicException {

    try (
        Session session = HibernateConfiguration.INSTANCE.getFactory().openSession();
    ) {

      NativeQuery query = session.createNativeQuery("SELECT NEXTVAL('CATEGORY_ID_SEQUENCE');");
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
