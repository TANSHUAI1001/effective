package calculation;

import java.math.BigDecimal;

public class Insurance {
    public static void main(String[] args) {
//       calRate(4000,3,449,12_000);
//       calRate(4000,4,918,16_000);
//       calRate(4000,5,1407,20_000);

//       calRate(4000,10,4145,40_000);
//       calRateFull(4000,10,4145,40_000);
//       calRateFull(4000,15,7024,40_000);
//       calRateFull(4000,20,10121,40_000);
//       calRateFull(4000,25,14280,40_000);
//       calRateFull(4000,30,19463,40_000);

        //pessimistic
//        calRateFull(4_000,30,4_754,40_000);
        //pessimistic death
//        calRateFull(4_000,30,156_130 - 40_000,40_000);

        //optimism
//        calRateFull(4_000,30,156_130 - 40_000,40_000);
        calRateFull(4_000,75,3_195_390 - 40_000,40_000);

    }

    public static double calRate(double partial,int years,double profit,double total){
        BigDecimal ins;
        double diff = profit,temp = 0,rate = 0;
        for (BigDecimal i = new BigDecimal(1.00); i.doubleValue()< 1.20; i = i.add(new BigDecimal(0.001))) {
            ins = BigDecimal.ZERO;
            for (int j = 1; j <= years; j++) {
                ins = ins.add(new BigDecimal(partial).multiply(accumulation(i,j)));
            }

            temp = Math.abs(profit - (ins.subtract(new BigDecimal(total))).doubleValue());
            if(temp < diff){
                diff = temp;
                rate = i.doubleValue();
            }
        }
        System.out.println("======"+partial+" * "+years+"======");
        System.out.println("rate:"+rate+"\ndiff:"+diff);
        return rate;
    }

    public static double calRateFull(double partial,int years,double profit,double total){
        BigDecimal ins;
        double diff = profit,temp = 0,rate = 0;
        for (BigDecimal i = new BigDecimal(1.00); i.doubleValue()< 1.20; i = i.add(new BigDecimal(0.00001))) {
            ins = BigDecimal.ZERO;
            int actual_years = (int) (total/partial);
            for (int j = 1; j <= actual_years; j++) {
                ins = ins.add(new BigDecimal(partial).multiply(accumulation(i,years - j + 1)));
            }

            temp = Math.abs(profit - (ins.subtract(new BigDecimal(total))).doubleValue());
            if(temp < diff){
                diff = temp;
                rate = i.doubleValue();
            }
        }
        System.out.println("======"+partial+" * "+years+"======");
        System.out.println("rate:"+rate+"\ndiff:"+diff);
        return rate;
    }

    public static BigDecimal accumulation(BigDecimal rate,int year){
        BigDecimal acc = BigDecimal.ONE;
        for (int i = 0; i < year; i++) {
            acc = acc.multiply(rate);
        }
        return acc;
    }
}
