package thinking.chapter15;

import java.lang.reflect.Constructor;

/**
 * Created by shuai on 2017/2/3.
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;
    private String name;

    public Coffee() {
    }
    public Coffee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String args[]){
        try {
            //newInstance: 弱类型。低效率。只能调用无参构造。
            //new: 强类型。相对高效。能调用任何public构造。
            Coffee c = Coffee.class.newInstance();
            c = new Coffee("sb");
            Class cls = Class.forName("thinking.chapter15.Coffee");
            Object obj = cls.newInstance(); // return Object type
            System.out.println(c);
            System.out.println(cls == Coffee.class);
            System.out.println(obj);

            Constructor<Coffee> constructor = Coffee.class.getConstructor();
            Coffee c1 = constructor.newInstance();
            System.out.println(c1);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
    }
}
