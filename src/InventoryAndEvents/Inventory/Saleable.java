package InventoryAndEvents.Inventory;

/**
   Describes any class whose objects can be sold.
*/
public interface Saleable
{
   /**
      Computes the price of the object.
      @return the price
   */
   double getPrice();
   int getQuantity();
}
