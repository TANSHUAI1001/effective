package design.builder;

public class ConcreteMealBuilderA extends MealBuilder {
    @Override
    public void buildFood() {
        this.meal.setFood("鸡腿");
    }

    @Override
    public void buildDrink() {
        this.meal.setDrink("可乐");
    }
}
