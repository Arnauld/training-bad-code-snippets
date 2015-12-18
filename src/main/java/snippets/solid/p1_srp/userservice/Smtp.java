package snippets.solid.p1_srp.userservice;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Smtp {
    public static Smtp getConf() {
        return new Smtp();
    }

    public void send(String login, MailMessage mailMessage) {

    }
}
