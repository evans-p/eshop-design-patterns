package gr.evansp.setup.product.impl.questions;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.questions.CategoryIdExistsQuestion;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryIdExistsQuestionImpl implements CategoryIdExistsQuestion {
  private Category input;
  private boolean answer;

  @Override
  public Category getInput() {
    return input;
  }

  @Override
  public void setInput(Category input) {
    this.input = input;
  }

  @Override
  public void ask() throws LogicException, DataException {
    if (input == null) {
      throw new LogicException("Input cannot be null.");
    }
    if (input.getCategoryId() == null) {
      answer = false;
      return;
    }

    String hql = "FROM gr.evansp.setup.product.def.models.Category U WHERE U.categoryId=" + input.getCategoryId();

    try (
        Session session = HibernateConfiguration.INSTANCE.getFactory().openSession();
    ) {
      Query query = session.createQuery(hql);
      List results = query.getResultList();
      if (results.isEmpty()) {
        answer = false;
        return;
      }
      answer = true;
    } catch (Exception e) {
      throw new DataException(e.getStackTrace().toString());
    }
  }

  @Override
  public Boolean answer() {
    return answer;
  }
}
