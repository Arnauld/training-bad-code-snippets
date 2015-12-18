package snippets.solid.p5_dip;

import snippets.solid.p5_dip.orderprocessor.Order;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class OrderProcessorRefactored {

    public interface DiscountCalculator {
        double calculateDiscount(Order order);
    }

    public interface Taxes {
        double findTaxAmount(Order order);
    }

    private final DiscountCalculator discountCalculator;
    private final Taxes taxes;

    public OrderProcessorRefactored(DiscountCalculator discountCalculator, Taxes taxes) {
        this.discountCalculator = discountCalculator;
        this.taxes = taxes;
    }

    public double calculateTotal(Order order, Connection cnx) throws SQLException {
        double itemTotal = order.getItemTotal();
        double discountAmount = discountCalculator.calculateDiscount(order);
        double taxAmount = taxes.findTaxAmount(order);
        double total = itemTotal - discountAmount + taxAmount;
        return total;
    }
}