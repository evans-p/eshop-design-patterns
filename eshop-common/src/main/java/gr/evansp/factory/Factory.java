package gr.evansp.factory;

import gr.evansp.common.Entity;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Main factory of the application. Follows the abstract factory DP.
 * Can create only new objects that are tagged by the interfaces below:
 * [Boundary, Control, Entity]
 */
public class Factory {
  private static final String BASE_PACKAGE_NAME = "gr";

  //TODO: Move to a more appropriate place...
  static {
    System.out.println("Configuring hibernate...");
    new Configuration().configure();
  }

  /**
   * private noArgs constructor.
   */
  private Factory() {
    //EMPTY
  }

  /**
   * Main Factory method.
   *
   * @param type the class of the object to be created.
   * @return an instance of the class provided.
   */
  public static <M extends Entity> M create(Class<M> type) {
    return getClassImplementation(type);
  }

  /**
   * A method that receives a package name, as a string, and returns all the
   * classes and interfaces in the package provided.
   *
   * @param packageName the name of a package. Example: gr.evansp.setup.
   * @return a set of all the classes and interfaces in the package provided.
   */
  private static Set<Class> findAllClasses(String packageName) {
    Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
    return reflections.getSubTypesOf(Object.class)
        .stream()
        .collect(Collectors.toSet());
  }

  /**
   * A method that receive a class and returns an instance of the class provided.
   *
   * @param type the class
   * @return Instance of the class provided.
   */
  private static <M extends Entity> M getClassImplementation(Class<M> type) {
    Set<Class> classes = findAllClasses(BASE_PACKAGE_NAME);

    for (Class clazz : classes) {
      if (clazz.isInterface()) {
        continue;
      }

      if (Arrays.asList(clazz.getInterfaces()).contains(type)) {
        try {
          return (M) clazz.getConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException
                 | InvocationTargetException e) {
          System.out.println("Failed to create object");
        }
      }
    }
    return null;
  }
}
