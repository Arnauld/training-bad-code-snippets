package snippets.solid.p5_dip.orderprocessor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class Resources {
    public PreparedStatement push(PreparedStatement preparedStatement) {
        return preparedStatement;
    }

    public ResultSet push(ResultSet resultSet) {
        return resultSet;
    }

    public void dispose() {

    }
}
