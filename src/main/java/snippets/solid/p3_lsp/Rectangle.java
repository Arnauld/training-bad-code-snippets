package snippets.solid.p3_lsp;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Rectangle {
    private int width, height;

    public void setDimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int area() {
        return width * height;
    }
}
