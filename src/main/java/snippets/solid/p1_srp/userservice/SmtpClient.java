package snippets.solid.p1_srp.userservice;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class SmtpClient {
    private final Smtp conf;
    String login;

    public static SmtpClient connect(Smtp conf, String login) {
        return new SmtpClient(conf, login);
    }

    public SmtpClient(Smtp conf, String login) {
        this.conf = conf;
        this.login = login;
    }

    public void send(MailMessage mailMessage) {
        conf.send(login, mailMessage);
    }
}
