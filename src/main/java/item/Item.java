package item;

public abstract class Item {
     String itemId;
     Double price;

    public Item(String itemId, Double price){
        this.itemId=itemId;
        this.price=price;
    }

    public Double getPrice() {
        return price;
    }

    public String getItemId(){
        return itemId;
    }
}
