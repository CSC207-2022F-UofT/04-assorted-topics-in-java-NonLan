/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */

import java.util.ArrayList;
import java.util.List;

public class DrivableTrader<D> extends Trader {
    private final List<D> inventory;
    private final List<D> wishlist;

    /* Constructor initializes  self.money just like superclass,
    * but inventory and wishlist must be of type List<D>. */
    public DrivableTrader(List<D> inventory, List<D> wishlist, int money) {
        super(money);
        this.inventory = inventory;
        this.wishlist = wishlist;
    }

    public DrivableTrader(int money) {
        super(money);
        this.inventory = new ArrayList<D>();
        this.wishlist = new ArrayList<D>();
    }

    /*
    * The sellingPrice returned should also be overridden. The selling price
    * should be equal to the:
    * Object's price + Object's max speed
    * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
    */
    @Override
    public int getSellingPrice(Object object) {
        if (object instanceof Tradable) {
            return ((Tradable) object).getPrice() + ((Drivable) object).getMaxSpeed();
        } else {
            return Tradable.MISSING_PRICE;
        }
    }


}
