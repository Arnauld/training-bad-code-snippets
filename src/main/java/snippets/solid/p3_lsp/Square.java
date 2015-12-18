package snippets.solid.p3_lsp;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Square extends Rectangle {
    @Override
    public void setDimension(int width, int height) {
        if (width != height)
            throw new IllegalArgumentException();
        super.setDimension(width, width);
    }
}
