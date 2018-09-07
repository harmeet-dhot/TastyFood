package cart;

public class Cart
{
    public int m_item_id;
    public String mitemname;
    public int mitemdisplayprice, mitemofferprice;
    public int menuItemQuantity;

    public Cart(int m_item_id, String mitemname, int mitemdisplayprice, int mitemofferprice, int menuItemQuantity)
    {
        this.m_item_id = m_item_id;
        this.mitemname = mitemname;
        this.mitemdisplayprice = mitemdisplayprice;
        this.mitemofferprice = mitemofferprice;
        this.menuItemQuantity = menuItemQuantity;
    }
}