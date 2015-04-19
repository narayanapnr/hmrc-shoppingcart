package uk.hmrc;

/**
 * 
 * @author NARAYANA RAO
 *
 */
public interface ShoppingVisitor {
    public void visitShoppingCart(ShoppingCart shoppingCart);
    public void visitCartItem(Item cartItem);
}
