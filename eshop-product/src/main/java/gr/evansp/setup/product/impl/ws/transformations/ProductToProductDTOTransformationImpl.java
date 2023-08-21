package gr.evansp.setup.product.impl.ws.transformations;

import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.product.def.ws.models.ProductDTO;
import gr.evansp.setup.product.def.ws.transformations.ProductToProductDTOTransformation;

/**
 * Implementation of {@link ProductToProductDTOTransformation}.
 */
public class ProductToProductDTOTransformationImpl implements ProductToProductDTOTransformation {
    Product input;
    ProductDTO output;

    @Override
    public void setInput(Product input) {
        this.input = input;
    }

    @Override
    public ProductDTO getOutput() {
        return output;
    }

    @Override
    public void transform() {
        output = Factory.create(ProductDTO.class);

        output.setProductId(input.getProductId());
        output.setCategoryId(input.getCategoryId());
        output.setCharacteristics(input.getCharacteristics());
        output.setPrice(input.getPrice());
        output.setName(input.getName());
        output.setInventoryCount(input.getInventoryCount());
        output.setDescription(input.getDescription());
    }
}
