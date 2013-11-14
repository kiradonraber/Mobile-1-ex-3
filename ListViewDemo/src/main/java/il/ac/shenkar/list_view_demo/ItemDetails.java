package il.ac.shenkar.list_view_demo;

/**
 * Created by tomerweller on 10/21/13.
 */
public class ItemDetails {

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getItemDescription() {
        return itemDescription;
    }
    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    private String name ;
    private String itemDescription;
}