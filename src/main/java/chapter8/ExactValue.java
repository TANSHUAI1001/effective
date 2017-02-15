package chapter8;

/**
 * Created by shuai on 2017/2/13.
 */
public class ExactValue {
    public static void main(String []args){
        double funds = 1.00;
        int itemsBought = 0;
        for(double price = .10; funds >= price; price += .10){
//            funds *= 100;
//            price *= 100;
            funds -= price;
//            price /= 100;
//            funds /= 100;
            itemsBought++;
            System.out.println(funds);
        }
        System.out.println(itemsBought+" items");
        System.out.println("charge: "+funds);
        System.out.println(100.0 - 99.1);
        System.out.println((100.0 - 99.1)+" "+(100.0 - 99.1 == 3.0 - 2.1)+" "+(3.0 - 2.1));
    }
}
