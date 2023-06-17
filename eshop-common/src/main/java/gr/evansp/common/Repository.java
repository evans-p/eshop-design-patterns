package gr.evansp.common;

import gr.evansp.exceptions.DataException;

import java.util.List;

/**
 * Base interface for the repository pattern
 */
public interface Repository<M extends Entity> extends Entity {

  /**
   * Gets Entity by key.
   *
   * @param product
   * @return
   * @throws DataException
   */
  M get(M product) throws DataException;

  /**
   * Gets all entities.
   *
   * @return all entities.
   * @throws DataException
   */
  List<M> getAll() throws DataException;

  /**
   * Saves a new Entity to the DB.
   *
   * @param entity Entity to save.
   * @throws DataException
   */
  void save(M entity) throws DataException;

  /**
   * Updates an existing Entity.
   *
   * @param entity Entity to update.
   * @throws DataException
   */
  void update(M entity) throws DataException;

  /**
   * Deletes an Entity
   *
   * @param entity Entity to delete
   * @throws DataException
   */
  void delete(M entity) throws DataException;
}
