package gr.evansp.setup;

import gr.evansp.common.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class AbstractDAO<T extends Entity> implements DAO<T> {
  private Configuration configuration;
  private Session session;
  private SessionFactory factory;

}
