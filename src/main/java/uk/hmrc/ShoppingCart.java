package uk.hmrc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author NARAYANA RAO
 *
 */
public class ShoppingCart implements ShoppingCartElement {

    private BigDecimal totalBill = new BigDecimal(0.0);

    private List<Item> shoppingItems = new ArrayList();

    public void addShoppingItem(Item shoppingCartItem) {
        shoppingCartItem.setShoppingCart(this);
        shoppingItems.add(shoppingCartItem);
    }

    public List<Item> getShoppingItems() {
        return shoppingItems;
    }

    public void setShoppingItems(List<Item> shoppingItems) {
        this.shoppingItems = shoppingItems;
    }

    public BigDecimal getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(BigDecimal totalBill) {
        this.totalBill = totalBill;
    }

    public void accept(ShoppingVisitor shoppingVisitor) {
        shoppingVisitor.visitShoppingCart(this);
    }

}
