package snippets.composition_inheritance.bakery;

import java.util.EnumSet;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Bread {

    private boolean isOverCooked = Math.random() * 100 > 90;
    private EnumSet<Ingredient> composedOf = EnumSet.noneOf(Ingredient.class);

    public boolean isOverCooked() {
        return isOverCooked;
    }

    public void fill(Ingredient ingredient) {
        composedOf.add(ingredient);
    }

    public boolean isBroken() {
        return Math.random() * 100 > 90;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
