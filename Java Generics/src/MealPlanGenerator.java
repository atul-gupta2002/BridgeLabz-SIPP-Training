import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// MealPlan Interface
interface MealPlan {
    void mealDetails();
}

// Implementations
class VegetarianMeal implements MealPlan {
    public void mealDetails() {
        System.out.println("Vegetarian Meal: Paneer, Vegetables, Rice.");
    }
}

class VeganMeal implements MealPlan {
    public void mealDetails() {
        System.out.println("Vegan Meal: Tofu, Greens, Quinoa.");
    }
}

class KetoMeal implements MealPlan {
    public void mealDetails() {
        System.out.println("Keto Meal: Chicken, Avocado, Nuts.");
    }
}

class HighProteinMeal implements MealPlan {
    public void mealDetails() {
        System.out.println("High Protein Meal: Eggs, Fish, Protein Shake.");
    }
}

// Generic Meal Class
class Meal<T extends MealPlan> {
    private List<T> mealList = new ArrayList<>();

    void addMeal(T meal) {
        mealList.add(meal);
    }

    void showMeals() {
        for (T meal : mealList) {
            meal.mealDetails();
        }
    }

    // Generic method for personalized meal plan
    public static <T extends MealPlan> void generateMealPlan(List<T> meals) {
        System.out.println("Your Personalized Meal Plan:");
        for (T meal : meals) {
            meal.mealDetails();
        }
    }
}

// Main Class
public class MealPlanGenerator {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegPlan = new Meal<>();
        vegPlan.addMeal(new VegetarianMeal());

        Meal<VeganMeal> veganPlan = new Meal<>();
        veganPlan.addMeal(new VeganMeal());

        Meal<KetoMeal> ketoPlan = new Meal<>();
        ketoPlan.addMeal(new KetoMeal());

        System.out.println("Showing Vegetarian Meal Plan:");
        vegPlan.showMeals();

        System.out.println("\nShowing Vegan Meal Plan:");
        veganPlan.showMeals();

        System.out.println("\nGenerating Personalized Mixed Meal Plan:");
        List<MealPlan> mixedPlan = Arrays.asList(
                new VegetarianMeal(),
                new HighProteinMeal(),
                new KetoMeal()
        );
        Meal.generateMealPlan(mixedPlan);
    }
}

