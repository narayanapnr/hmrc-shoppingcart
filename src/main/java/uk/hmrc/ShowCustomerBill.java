package uk.hmrc;

import java.math.BigDecimal;

/**
 * 
 * @author NARAYANA RAO
 *
 */
public class ShowCustomerBill {
    static BigDecimal appleCost = new BigDecimal(0.60);
    static BigDecimal orangeCost = new BigDecimal(0.25);

    public static void main(String[] args) {
        appleCost.setScale(2, BigDecimal.ROUND_HALF_UP);
        orangeCost.setScale(2, BigDecimal.ROUND_HALF_UP);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addShoppingItem(new Item("Apple", 0, appleCost));
        shoppingCart.addShoppingItem(new Item("Orange", 0, orangeCost));

        shoppingCart.accept(new GenerateBill());

        shoppingCart = new ShoppingCart();
        shoppingCart.addShoppingItem(new Item("Apple", 1, appleCost));
        shoppingCart.addShoppingItem(new Item("Orange", 1, orangeCost));

        shoppingCart.accept(new GenerateBill());

        shoppingCart = new ShoppingCart();
        shoppingCart.addShoppingItem(new Item("Apple", 2, appleCost));
        shoppingCart.addShoppingItem(new Item("Orange", 2, orangeCost));

        shoppingCart.accept(new GenerateBill());

        shoppingCart = new ShoppingCart();
        shoppingCart.addShoppingItem(new Item("Apple", 2, appleCost));
        shoppingCart.addShoppingItem(new Item("Orange", 3, orangeCost));

        shoppingCart.accept(new GenerateBill());

        shoppingCart = new ShoppingCart();
        shoppingCart.addShoppingItem(new Item("Apple", 3, appleCost));
        shoppingCart.addShoppingItem(new Item("Orange", 3, orangeCost));

        shoppingCart.accept(new GenerateBill());

        shoppingCart = new ShoppingCart();
        shoppingCart.addShoppingItem(new Item("Apple", 4, appleCost));
        shoppingCart.addShoppingItem(new Item("Orange", 3, orangeCost));

        shoppingCart.accept(new GenerateBill());

      
    }
}
