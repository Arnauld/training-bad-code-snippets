package snippets.composition_inheritance;

import snippets.composition_inheritance.bakery.Bread;
import snippets.composition_inheritance.bakery.Ingredients;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public abstract class Bakery {

    public void produceBread() {
        Ingredients ingredients = prepareIngredients();
        Bread bread = bakeTheBread(ingredients);
        if (checkQuality(bread)) {
            putBreadOnDisplay(bread);
        }
    }

    public void putBreadOnDisplay(Bread bread) {
        System.out.println(bread + "available");
    }

    public boolean checkQuality(Bread bread) {
        if(bread.isOverCooked())
            return false;
        if(bread.isBroken())
            return false;
        return true;
    }

    protected abstract Ingredients prepareIngredients();

    protected abstract Bread bakeTheBread(Ingredients ingredients);
}
