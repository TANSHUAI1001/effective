package core;

import java.util.Random;

public class PseudoRandom {

    static void test(){
        Random random = new Random();
        System.out.print("random: ");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%3d ",random.nextInt(100));
        }

        Random pseudo = new Random(47);
        System.out.print("pseudo: ");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%3d ",pseudo.nextInt(100));
        }

        System.out.println("");
    }
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            test();
        }
    }
}
