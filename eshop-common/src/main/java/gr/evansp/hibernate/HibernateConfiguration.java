package gr.evansp.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public enum HibernateConfiguration {
  INSTANCE;

  private Configuration configuration = new Configuration().configure();
  private SessionFactory factory = configuration.buildSessionFactory();
  private Session session;

  public SessionFactory getFactory() {
    return factory;
  }
}
