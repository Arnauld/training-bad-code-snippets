package snippets.solid.p1_srp.userservice;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
