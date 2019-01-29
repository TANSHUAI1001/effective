package bases.innerclass;

public class Ordinary {

    private static class ExOrdinary{

    }

    private class NOrdinary{

    }

    public static void main(String[] args) {
        NOrdinary nOrdinary = new Ordinary().new NOrdinary();
        ExOrdinary exOrdinary = new Ordinary.ExOrdinary();
    }
}
