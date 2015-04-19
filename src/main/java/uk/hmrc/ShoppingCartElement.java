package uk.hmrc;

/**
 * 
 * @author NARAYANA RAO
 *
 */
public interface ShoppingCartElement {
    public void accept(ShoppingVisitor shoppingVisitor);
}
