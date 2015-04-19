package uk.hmrc;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * 
 * @author NARAYANA RAO
 *
 */
public class GenerateBill implements ShoppingVisitor {
    boolean itemDoesNotExist = false;
    int newQuantity = 0;

   // @Override
    public void visitShoppingCart(ShoppingCart shoppingCart) {
        for (int i = 0; i < shoppingCart.getShoppingItems().size(); i++) {
            shoppingCart.getShoppingItems().get(i).accept(this);
        }

        System.out.println("\nAmount to pay : £" + shoppingCart.getTotalBill().setScale(2, RoundingMode.HALF_UP));
    }

    public void visitCartItem(Item item) {
        //double itemCost = 0.0;
        BigDecimal itemCost = new BigDecimal(0.0);

        DiscountCalculation(item);

        if (!itemDoesNotExist) {
            itemCost = item.getPrice().multiply(BigDecimal.valueOf(newQuantity));

            item.getShoppingCart().setTotalBill(
                    item.getShoppingCart().getTotalBill().add(itemCost));

            System.out.println(item.getQuantity() + " x " +
                    item.getName().toUpperCase() +
                    " @ " + item.getPrice().setScale(2, RoundingMode.HALF_UP) + " - £" + itemCost.setScale(2, RoundingMode.HALF_UP));
        } else {
            throw new IllegalArgumentException("No such Item in Stock!");
        }

    }

    public void DiscountCalculation(Item item) {
        newQuantity = item.getQuantity();

        switch (ItemEnum.valueOf(item.getName())) {
            case Apple:
                 //Specifically checking buy 1 get 1 offer
                //Checking if there are odd apples, then 1 will be need to added explicitly
                if (item.getQuantity() > 1) {
                    newQuantity = item.getQuantity() - (item.getQuantity() / 2);
                }
                break;

            case Orange:
                //Specifically checking 3 for the price of 2
                if (item.getQuantity() > 2) {
                    newQuantity = item.getQuantity() - (item.getQuantity() / 3);
                }
                break;

            default:
                itemDoesNotExist = true;
                break;
        }
    }


}
