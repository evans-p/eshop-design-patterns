package gr.evansp.setup.product.def.persistence;

import gr.evansp.common.Repository;
import gr.evansp.exceptions.DataException;
import gr.evansp.setup.product.def.models.Characteristic;

/**
 * Repository for {@link Characteristic}
 */
public interface CharacteristicRepository extends Repository<Characteristic> {
  Characteristic get(Long characteristicId, Long productId, Long categoryId) throws DataException;
}
