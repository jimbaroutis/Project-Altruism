public class RequestDonation {
    private Entity entity;
    private double quantity;
    public Entity getEntity()
    {
        return entity;
    }
    public void modifyquantity(double quantity)
    {
        this.quantity=quantity;
    }
    public double getQuantity()
    {
        return quantity;
    }
    public String getName()
    {
        return entity.getName();
    }
    public void setEntityRd(Entity entity)
    {
        this.entity =entity;
    }

    // comparator -> compares two entities if they are the same.
    public boolean Compare(RequestDonation x){
        if(x.getEntity().getID()==this.getEntity().getID())return true;
        else return false;
    }
}
