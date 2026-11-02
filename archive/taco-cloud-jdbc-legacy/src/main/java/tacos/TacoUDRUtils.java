package tacos;

public class TacoUDRUtils {
    public static IngredientUDT toIngredientUDT(Ingredient ingredient) {
        if (ingredient == null) return null;
        return new IngredientUDT(ingredient.getId(), ingredient.getName(), ingredient.getType());
    }
}
