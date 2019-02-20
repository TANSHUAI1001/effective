package java8;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierAndConsumer {
    private int n;
    public SupplierAndConsumer(){
        this.n = 10;
    }

    public void count(int num){
        for (int i = 0; i < num; i++) {
            this.n++;
        }
        System.out.println(n);
    }

    public int multiple(int x){
        return x * n;
    }

    public static void main(String[] args) {
        Supplier<SupplierAndConsumer> supplier = SupplierAndConsumer::new;

        supplier.get().count(10);

        Consumer<SupplierAndConsumer> consumer = s -> {
            s.count(5);
            System.out.println(s.multiple(10));
        };

        consumer.accept(new SupplierAndConsumer());

        Consumer<Integer> consumer1 = x -> System.out.println(x * 2);

        Consumer<Integer> consumer2 = x -> System.out.println(x * 3);

        consumer1.andThen(consumer2).accept(5);
    }

}
