package design.singleton;

public class Client {
    public static void main(String[] args) {
        EnumSingleton instance = EnumSingleton.PERSON;
        System.out.println(instance);
        instance.setName("me");
        instance.setAge(10);
        instance.setAddress("广州");
        System.out.println(instance);
    }
}
