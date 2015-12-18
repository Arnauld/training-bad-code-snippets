package snippets.solid.p4_isp;

import snippets.solid.p4_isp.multifunctionprinter.EmailAddress;
import snippets.solid.p4_isp.multifunctionprinter.Page;
import snippets.solid.p4_isp.multifunctionprinter.PhoneNumber;

import java.sql.PreparedStatement;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public interface MultiFunctionPrinter {
    void fax(Page page, PhoneNumber number);


    void scan(Page page, EmailAddress address);


    void call(PhoneNumber number);


    void copy(Page page, int number);


    void print(Page page);
}
