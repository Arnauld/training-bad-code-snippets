package snippets.composition_inheritance;

import snippets.composition_inheritance.bakery.Bread;
import snippets.composition_inheritance.bakery.Ingredient;
import snippets.composition_inheritance.bakery.Ingredients;
import snippets.composition_inheritance.bakery.WhiteBread;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class WhiteBreadBakery extends Bakery {
    @Override
    protected Ingredients prepareIngredients() {
        return Ingredients.with(
                Ingredient.WhiteFlour,
                Ingredient.WhiteFlour,
                Ingredient.WhiteFlour,
                Ingredient.Water,
                Ingredient.Water,
                Ingredient.Water,
                Ingredient.Salt,
                Ingredient.BakingPowder);
    }

    @Override
    protected Bread bakeTheBread(Ingredients ingredients) {
        WhiteBread wb = new WhiteBread();
        for (Ingredient ingredient : ingredients.list()) {
            wb.fill(ingredient);
        }
        wb.letTheBakingPowderActs();
        return wb;
    }
}
