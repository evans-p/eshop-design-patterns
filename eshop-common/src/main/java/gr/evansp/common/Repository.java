package gr.evansp.common;

import gr.evansp.exceptions.DataException;

import java.util.List;

/**
 * Base interface for the repository pattern
 */
public interface Repository<M extends Entity> extends Entity {

  /**
   * Gets Entity by key.
   */
  M get(M entity) throws DataException;

  /**
   * Gets all entities.
   *
   * @return all entities.
   */
  List<M> getAll() throws DataException;

  /**
   * Saves a new Entity to the DB.
   *
   * @param entity Entity to save.
   */
  void save(M entity) throws DataException;

  /**
   * Updates an existing Entity.
   *
   * @param entity Entity to update.
   */
  void update(M entity) throws DataException;

  /**
   * Deletes an Entity
   *
   * @param entity Entity to delete
   */
  void delete(M entity) throws DataException;
}
