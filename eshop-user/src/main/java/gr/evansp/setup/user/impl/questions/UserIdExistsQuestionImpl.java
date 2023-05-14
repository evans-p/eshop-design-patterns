package gr.evansp.setup.user.impl.questions;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.questions.UserIdExistsQuestion;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class UserIdExistsQuestionImpl implements UserIdExistsQuestion {
  private User input;
  private boolean answer;

  @Override
  public User getInput() {
    return input;
  }

  @Override
  public void setInput(User input) {
    this.input = input;
  }

  @Override
  public void ask() throws LogicException, DataException {
    if (input == null) {
      throw new LogicException("Input cannot be null.");
    }
    if (input.getUserId() == null) {
      answer = false;
      return;
    }
    String hql = "FROM gr.evansp.setup.user.def.models.User U WHERE U.userId=" + input.getUserId();
    try (
        Session session = new Configuration().buildSessionFactory().openSession();
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

  public Boolean answer() {
    return answer;
  }
}
