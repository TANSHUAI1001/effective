package design.builder;

public class Waiter {
    private MealBuilder mealBuilder;
    public void setMealBuilder(MealBuilder mb){
        this.mealBuilder = mb;
    }

    public Meal construct(){
        mealBuilder.buildFood();
        mealBuilder.buildDrink();
        return this.mealBuilder.getMeal();
    }
}
