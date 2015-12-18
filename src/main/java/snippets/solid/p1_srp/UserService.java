package snippets.solid.p1_srp;

import snippets.solid.p1_srp.userservice.Database;
import snippets.solid.p1_srp.userservice.MailMessage;
import snippets.solid.p1_srp.userservice.Smtp;
import snippets.solid.p1_srp.userservice.SmtpClient;
import snippets.solid.p1_srp.userservice.User;
import snippets.solid.p1_srp.userservice.ValidationException;

/**
 * Copied and adapted from
 * http://blog.gauffin.org/2012/05/11/solid-principles-with-real-world-examples/
 */
public class UserService {

    private final String smtplogin;
    private Database _database;

    public UserService(String smtplogin) {
        this.smtplogin = smtplogin;
        _database = Database.getInstance();
    }

    public void register(String email, String password)
    {
        if (!email.contains("@"))
            throw new ValidationException("Email is not an email!");

        User user = new User(email, password);
        _database.save(user);

        SmtpClient _smtpClient = SmtpClient.connect(Smtp.getConf(), smtplogin);
        _smtpClient.send(new MailMessage("mysite@nowhere.com", email) {{
            subject = "HEllo fool!";
        }});
    }
}
