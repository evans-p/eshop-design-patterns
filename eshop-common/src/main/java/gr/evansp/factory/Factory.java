package gr.evansp.factory;

import gr.evansp.common.DAO;
import gr.evansp.common.Entity;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Main factory of the application. Follows the abstract factory DP.
 * Can create only new objects that are tagged by the interfaces below:
 * [Entity]
 */
public class Factory {
  private static final String BASE_PACKAGE_NAME = "gr";
  private static Map<Class, Class> interfaceToClassMap = new HashMap<>();
  private static Map<Class, Class> interfaceToDAOMap = new HashMap<>();

  static {
    fillInterfaceToDAOMap();
    System.out.println(interfaceToDAOMap);
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

  public static <M extends Entity> DAO<M> createPersistence(Class<M> type) {
    if (!interfaceToDAOMap.containsKey(type)) {
      fillInterfaceToDAOMap();
    }
    try {
      return (DAO<M>) interfaceToDAOMap.get(type).getConstructor().newInstance();
    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException
             | InvocationTargetException e) {
      //EMPTY
    }
    return null;
  }

  private static <M extends Entity> M createImplementation(Class<M> type) {
    try {
      return (M) type.getConstructor().newInstance();
    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException
             | InvocationTargetException e) {
      //EMPTY
    }
    return null;
  }

  private static <M extends Entity> void fillInterfaceToDAOMap() {
    Reflections reflections = new Reflections(new ConfigurationBuilder()
        .setUrls(ClasspathHelper.forPackage(BASE_PACKAGE_NAME))
        .setScanners(new SubTypesScanner(false)));
    Set<Class<?>> classes = reflections.getSubTypesOf(Object.class);
    for (Class clazz : classes) {
      if (clazz.isInterface()) {
        continue;
      }
      if (!Arrays.asList(clazz.getInterfaces()).contains(DAO.class)) {
        continue;
      }
      Type[] interfaces = clazz.getGenericInterfaces();
      for (Type interfaze : interfaces) {
        if (interfaze instanceof ParameterizedType) {
          Type[] genericTypes = ((ParameterizedType) interfaze).getActualTypeArguments();
          for (Type type1 : genericTypes) {
            interfaceToDAOMap.put((Class) type1, clazz);
          }
        }
      }
    }
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