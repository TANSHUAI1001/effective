package design.builder;

public class ConcreteMealBuilderB extends MealBuilder {
    @Override
    public void buildFood() {
        this.meal.setFood("排骨");
    }

    @Override
    public void buildDrink() {
        this.meal.setDrink("炖汤");
    }
}
