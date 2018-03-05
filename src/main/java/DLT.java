import java.util.*;

public class DLT {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018,Calendar.MARCH,3,20,30,00);
        long seed = calendar.getTime().getTime();
        // (1000 * 60 * 60 * 24);
        System.out.println(calendar.getTime().getTime());
        System.out.println(seed);
        Random random = new Random(seed);
        ArrayList<Integer> frontBase = new ArrayList<>();
        for (int i = 1; i <= 35 ; i++) {
            frontBase.add(i);
        }
        ArrayList<Integer> endBase = new ArrayList<>();
        for (int i = 1; i <= 12 ; i++) {
            endBase.add(i);
        }
        int front[] = new int[5], end[] = new int[2];
        for (int i = 0; i < 5; i++) {
            int index = random.nextInt(35 - i);
            front[i] = frontBase.remove(index);
            System.out.print(front[i]+" ");
        }
        System.out.print("| ");
        for (int i = 0; i < 2; i++) {
            int index = random.nextInt(12 - i);
            end[i] = endBase.remove(index);
            System.out.print(end[i]+" ");
        }
        System.out.println("");
        Arrays.sort(front);
        Arrays.sort(end);
        System.out.print(Arrays.toString(front));
        System.out.print(Arrays.toString(end));

    }

}
