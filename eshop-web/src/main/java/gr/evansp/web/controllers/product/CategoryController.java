package gr.evansp.web.controllers.product;

import gr.evansp.exceptions.DataException;
import gr.evansp.exceptions.LogicException;
import gr.evansp.exceptions.RuleException;
import gr.evansp.factory.Factory;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.ws.operations.GetAllCategoriesWsOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

  private final String CATEGORY_BASE_URL = "/category";

  GetAllCategoriesWsOperation allCategoriesWsOperation = Factory.create(GetAllCategoriesWsOperation.class);

  @GetMapping(CATEGORY_BASE_URL + "/all")
  public List<Category> getAllCategories() {
    try {
      allCategoriesWsOperation.execute();
      return allCategoriesWsOperation.getCategories();
    } catch (DataException | LogicException | RuleException e) {
      throw new RuntimeException(e);
    }
  }
}
