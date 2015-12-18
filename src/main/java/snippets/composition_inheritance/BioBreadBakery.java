package snippets.composition_inheritance;

import snippets.composition_inheritance.bakery.BioBread;
import snippets.composition_inheritance.bakery.Bread;
import snippets.composition_inheritance.bakery.Ingredient;
import snippets.composition_inheritance.bakery.Ingredients;
import snippets.composition_inheritance.bakery.WhiteBread;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class BioBreadBakery extends Bakery {
    @Override
    protected Ingredients prepareIngredients() {
        return Ingredients.with(
                Ingredient.BioFlour,
                Ingredient.BioFlour,
                Ingredient.BioFlour,
                Ingredient.Water,
                Ingredient.Water,
                Ingredient.Water,
                Ingredient.Salt);
    }

    @Override
    protected Bread bakeTheBread(Ingredients ingredients) {
        BioBread bread = new BioBread();
        for (Ingredient ingredient : ingredients.list()) {
            bread.fill(ingredient);
        }
        bread.letTheBioAct();
        return bread;
    }
}
