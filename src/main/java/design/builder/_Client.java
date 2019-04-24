package design.builder;

public class _Client {
    public static void main(String[] args) {
        MealBuilder mb=(MealBuilder)_XMLUtil.getBean();
        Waiter waiter=new Waiter();
        waiter.setMealBuilder(mb);
        Meal meal=waiter.construct();
        System.out.println("Meal:Food="+meal.getFood()+",Drink="+meal.getDrink());
    }
}
