package cluster; /**
 * Created by shuai on 2018/5/26.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Clustering {
    public static void main(String[] args) {

        List<City> citys = new ArrayList<City>();

        City city0 = new City();
        city0.setName("北 京");
        city0.setX(116.28);
        city0.setY(39.54);
        citys.add(city0);


        City city1 = new City();
        city1.setName("上 海");
        city1.setX(121.29);
        city1.setY(31.14);
        citys.add(city1);

        City city2 = new City();
        city2.setName("天 津");
        city2.setX(117.11);
        city2.setY(39.09);
        citys.add(city2);

        City city3 = new City();
        city3.setName("重 庆");
        city3.setX(106.32);
        city3.setY(29.32);
        citys.add(city3);


        City city4 = new City();
        city4.setName("哈尔滨");
        city4.setX(126.41);
        city4.setY(45.45);
        citys.add(city4);


        City city5 = new City();
        city5.setName("长 春");
        city5.setX(125.19);
        city5.setY(43.52);
        citys.add(city5);


        City city6 = new City();
        city6.setName("南 京");
        city6.setX(118.50);
        city6.setY(32.02);
        citys.add(city6);

        City city7 = new City();
        city7.setName("武 汉");
        city7.setX(114.21);
        city7.setY(30.37);
        citys.add(city7);


        City city8 = new City();
        city8.setName("台 北");
        city8.setX(121.31);
        city8.setY(25.03);
        citys.add(city8);

        City city9 = new City();
        city9.setName("香 港");
        city9.setX(114.10);
        city9.setY(22.18);
        citys.add(city9);

        SingleLink sing = new SingleLink(citys);
        List<Set<City>> list = sing.compute();
        for (Set<City> list0 : list) {
            System.out.println("=============");
            for (City city : list0) {
                System.out.println(city.getName() + " : (" + city.getX()+","+city.getY()+")");
            }
        }
    }

}

