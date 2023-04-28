public class Main {
  public static void main(String[] args) {
//    User user = Factory.create(User.class);
//    UserProfile userProfile = Factory.create(UserProfile.class);
//    Address address = Factory.create(Address.class);
//
//    Random random = new Random();
//
//    address.setAddressId(random.nextLong());
//    address.setUserProfile(userProfile);
//    address.setStreetName("Καραμπλιά");
//    address.setStreetNumber("4");
//    address.setPostalCode("17121");
//    address.setCity("Αθήνα");
//    address.setCountry("Ελλάδα");
//
//    user.setUserId(random.nextLong());
//    user.setEmail("email@example.com");
//    user.setPassword("123");
//
//    userProfile.setUserId(user.getUserId());
//    userProfile.setFirstName("Evans");
//    userProfile.setLastName("P");
//    userProfile.setPhoneNo("6978418570");
//    userProfile.setDateAdded(Calendar.getInstance().getTime());
//    userProfile.setDateLastModified(Calendar.getInstance().getTime());
//    userProfile.setAddresses(Set.of(address));
//
//    user.setUserProfile(userProfile);
//
//    Session session = new Configuration().configure().buildSessionFactory().openSession();
//    session.beginTransaction();
//
//    session.persist(user);
//
//    session.getTransaction().commit();
//    session.close();
//
//    if ((session == null) || (!session.isOpen())) {
//      session = new Configuration().configure().buildSessionFactory().openSession();
//    }
//    session.beginTransaction();
//    User returned = session.get(User.class, user.getUserId());
//    session.close();
////    System.out.println(returned);
//
//    for (Address address1 : userProfile.getAddresses()) {
//      System.out.println(address1.equals(address));
//    }
  }
}
