package snippets.composition_inheritance.bakery;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Ingredients {
    private final Ingredient[] ingredients;

    public static Ingredients with(Ingredient... ingredients) {
        return new Ingredients(ingredients);
    }

    public Ingredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public List<Ingredient> list() {
        return Arrays.asList(ingredients);
    }

}
