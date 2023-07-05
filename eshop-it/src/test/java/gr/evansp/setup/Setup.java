package gr.evansp.setup;

import gr.evansp.factory.Factory;
import gr.evansp.setup.order.def.models.Cart;
import gr.evansp.setup.order.def.models.CartItem;
import gr.evansp.setup.product.def.models.Category;
import gr.evansp.setup.product.def.models.Characteristic;
import gr.evansp.setup.product.def.models.Product;
import gr.evansp.setup.user.def.models.Address;
import gr.evansp.setup.user.def.models.User;
import gr.evansp.setup.user.def.models.UserProfile;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Random;
import java.util.Set;

/**
 * Creates sample Persistent Objects.
 */
public class Setup {
  private static final Random r = new Random();

  public static CartItem createSampleCartItem(Long cartId, Long productId, Long categoryId) {
    CartItem cartItem = Factory.create(CartItem.class);

    cartItem.setCartId(cartId);
    cartItem.setCategoryId(categoryId);
    cartItem.setProductId(productId);
    cartItem.setCount(2L);

    return cartItem;
  }

  public static Cart createSampleCart(Long cartId) {
    Cart cart = Factory.create(Cart.class);
    cart.setCartId(cartId);
    return cart;
  }

  public static User createSampleUser() {
    User user = Factory.create(User.class);
    user.setEmail(generateRandomNumber() + "example@example.com");
    user.setPassword("@@1213TEstTesd@@");
    user.setUserProfile(createSampleUserProfile(null));
    return user;
  }

  public static Address createSampleAddress(Long addressId, Long userId) {
    Address address = Factory.create(Address.class);

    address.setUserId(userId);
    address.setAddressId(addressId);
    address.setCity("CIty");
    address.setCountry("Country");
    address.setStreetNumber("123");
    address.setStreetName("StreetName");
    address.setPostalCode("12345");

    return address;
  }

  public static UserProfile createSampleUserProfile(Long id) {
    UserProfile userProfile = Factory.create(UserProfile.class);

    userProfile.setUserId(id);
    userProfile.setFirstName("Evans");
    userProfile.setLastName("Poulakis");
    userProfile.setPhoneNo("1234567890");
    return userProfile;
  }

  public static Category createSampleCategory(Long id) {
    Category category = Factory.create(Category.class);
    category.setCategoryId(id);
    category.setName("Category Name");
    return category;
  }

  public static Characteristic createSampleCharacteristic(Long productId, Long characteristicId,
                                                          Long categoryId) {
    Characteristic characteristic = Factory.create(Characteristic.class);

    characteristic.setCharacteristicId(characteristicId);
    characteristic.setProductId(productId);
    characteristic.setCategoryId(categoryId);
    characteristic.setName("Characteristic Name");
    characteristic.setValue("Characteristic Value");

    return characteristic;
  }

  public static Product createSampleProduct(Long productId, Long categoryId) {
    Product product = Factory.create(Product.class);

    product.setName("ProductName");
    product.setSKU("SKU");
    product.setProductId(productId);
    product.setCharacteristics(Set.of(createSampleCharacteristic(productId, null, categoryId)));
    product.setCategoryId(categoryId);
    product.setDateAdded(Calendar.getInstance().getTime());
    product.setDateLastModified(Calendar.getInstance().getTime());
    product.setPrice(BigDecimal.TEN);
    product.setInventoryLimit(100);
    product.setInventoryCount(100);

    return product;
  }

  public static int generateRandomNumber() {
    int low = 1;
    int high = 10000;
    return r.nextInt(high - low) + low;
  }
}
