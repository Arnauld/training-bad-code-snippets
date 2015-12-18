package snippets.solid.p5_dip;

import snippets.solid.p5_dip.orderprocessor.Country;
import snippets.solid.p5_dip.orderprocessor.DiscountCalculator;
import snippets.solid.p5_dip.orderprocessor.Order;
import snippets.solid.p5_dip.orderprocessor.Resources;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static snippets.solid.p5_dip.orderprocessor.Country.UK;
import static snippets.solid.p5_dip.orderprocessor.Country.US;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class OrderProcessor {
    public double calculateTotal(Order order, Connection cnx) throws SQLException {
        double itemTotal = order.getItemTotal();
        double discountAmount = DiscountCalculator.calculateDiscount(order);
        double taxAmount = 0.0d;
        if (order.getCountry() == US)
            taxAmount = findTaxAmount(order, cnx);
        else if (order.getCountry() == UK)
            taxAmount = findVatAmount(order, cnx);
        double total = itemTotal - discountAmount + taxAmount;
        return total;
    }

    private double findVatAmount(Order order, Connection cnx) throws SQLException {
        Resources r = new Resources();
        try {
            PreparedStatement statement = r.push(cnx.prepareStatement("select amount from vat where country=?"));
            statement.setString(1, order.getCountry().name());
            ResultSet resultSet = r.push(statement.executeQuery());
            return resultSet.getDouble(1);
        }finally {
            r.dispose();
        }
    }
    private double findTaxAmount(Order order, Connection cnx) throws SQLException {
        Resources r = new Resources();
        try {
            PreparedStatement statement = r.push(cnx.prepareStatement("select amount from tax where country=?"));
            statement.setString(1, order.getCountry().name());
            ResultSet resultSet = r.push(statement.executeQuery());
            return resultSet.getDouble(1);
        }finally {
            r.dispose();
        }
    }
}