package gr.evansp.dao;

import gr.evansp.ecb.Entity;

import java.util.List;

/**
 * Generic DAO interface.
 *
 * @param <T>
 */
public interface DAO<T extends Entity> {
  /**
   * gets an Entity form the database based on its Id.
   *
   * @param id id of the entity
   * @return the entith
   */
  public T get(Long id);


  /**
   * Gets all instances of the entity
   *
   * @return A list with all the instances of the entity.
   */
  public List<T> getAll();

  /**
   * Saves a new entity to the database.
   *
   * @param entity The entity to save.
   */
  public void save(T entity);

  /**
   * Updates an entity.
   *
   * @param entity entity to update
   */
  public void update(T entity);

  /**
   * Deletes the specified entity
   *
   * @param object the entity to delete
   */
  public void delete(T object);
}
