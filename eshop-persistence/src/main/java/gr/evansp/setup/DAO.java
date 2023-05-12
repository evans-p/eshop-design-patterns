package gr.evansp.setup;

import gr.evansp.common.Entity;
import gr.evansp.exceptions.DataException;

import java.util.List;

/**
 * Generic DAO interface.
 *
 * @param <T>
 */
public interface DAO<T extends Entity> {
  /**
   * gets an Entity from the database based on its Id.
   *
   * @param id id of the entity
   * @return the entity
   */
  public T get(Long id) throws DataException;


  /**
   * Gets all instances of the entity
   *
   * @return A list with all the instances of the entity.
   */
  public List<T> getAll() throws DataException;

  /**
   * Saves a new entity to the database.
   *
   * @param entity The entity to save.
   */
  public void save(T entity) throws DataException;

  /**
   * Updates an entity.
   *
   * @param entity entity to update
   */
  public void update(T entity) throws DataException;

  /**
   * Deletes the specified entity
   *
   * @param entity the entity to delete
   */
  public void delete(T entity) throws DataException;
}
