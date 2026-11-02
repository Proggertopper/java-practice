import java.util.ArrayList;
import java.util.List;

public class Order {

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    private List<Item> items ;

    Order(List<Item> items){
        this.items = items;
    }



}
