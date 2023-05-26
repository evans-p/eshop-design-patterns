package gr.evansp.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public enum HibernateConfiguration {
  INSTANCE;

  private final Configuration configuration = new Configuration().configure();
  private final SessionFactory factory = configuration.buildSessionFactory();

  public SessionFactory getFactory() {
    return factory;
  }
}
