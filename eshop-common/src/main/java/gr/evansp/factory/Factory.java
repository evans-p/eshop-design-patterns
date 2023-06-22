package gr.evansp.factory;

import gr.evansp.common.Entity;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Main factory of the application. Follows the abstract factory DP.
 * Can create only new objects that are tagged by the interfaces below:
 * [Entity]
 */
@SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
public class Factory {
  private static final String BASE_PACKAGE_NAME = "gr";
  private static final Map<Class, Class> interfaceToClassMap = new HashMap<>();


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
    if (type.isInterface())
      return getImplementationByInterface(type);
    return createImplementation(type);
  }

  /**
   * A method that receive a class and returns an instance of the class provided.
   *
   * @param type the class
   * @return Instance of the class provided.
   */
  private static <M extends Entity> M getImplementationByInterface(Class<M> type) {
    if (!interfaceToClassMap.containsKey(type)) {
      fillInterfaceToClassMap();
    }

    try {
      return (M) interfaceToClassMap.get(type).getConstructor().newInstance();
    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException
             | InvocationTargetException e) {
      //EMPTY
    }
    return null;
  }


  private static <M extends Entity> M createImplementation(Class<M> type) {
    try {
      return type.getConstructor().newInstance();
    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException
             | InvocationTargetException e) {
      //EMPTY
      e.printStackTrace();
    }
    return null;
  }

  private static void fillInterfaceToClassMap() {
    Reflections reflections = new Reflections(new ConfigurationBuilder()
        .setUrls(ClasspathHelper.forPackage(BASE_PACKAGE_NAME))
        .setScanners(new SubTypesScanner(false)));
    Set<Class<?>> classes = reflections.getSubTypesOf(Object.class);
    for (Class clazz : classes) {
      if (!clazz.isInterface()) {
        for (Class c : clazz.getInterfaces()) {
          if (!interfaceToClassMap.containsKey(c)) {
            interfaceToClassMap.put(c, clazz);
          }
        }
      }
    }
  }
}