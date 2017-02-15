package thinking.chapter15;

/**
 * Created by shuai on 2017/2/3.
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;
    private String name;

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String args[]){
        try {
            Coffee c = Coffee.class.newInstance();
            System.out.println(c.toString());
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
