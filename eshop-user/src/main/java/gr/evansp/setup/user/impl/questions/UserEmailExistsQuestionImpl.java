package gr.evansp.setup.user.impl.questions;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.hibernate.HibernateConfiguration;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.questions.UserEmailExistsQuestion;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserEmailExistsQuestionImpl implements UserEmailExistsQuestion {
    @Getter
    @Setter
    private User input;
    private boolean answer;

    @SuppressWarnings({"deprecation", "rawtypes"})
    @Override
    public void ask() throws LogicException, DataException {
        if (input == null) {
            throw new LogicException("Input cannot be null.");
        }
        if (input.getEmail() == null) {
            answer = false;
            return;
        }
        try (Session session = HibernateConfiguration.INSTANCE.getFactory().openSession()) {
            String hql = "FROM gr.evansp.setup.user.def.models.User U WHERE U.email=:mail AND U.email!=:mail";
            Query query = session.createQuery(hql);
            query.setParameter("mail", input.getEmail());
            List results = query.getResultList();
            if (results.isEmpty()) {
                answer = false;
                return;
            }
            answer = true;
        } catch (Exception e) {
            throw new DataException(e);
        }
    }

    public Boolean answer() {
        return answer;
    }
}
