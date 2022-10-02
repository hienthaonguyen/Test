public class Repository {
    private String itemName = null;
    private int groupCount = 0;
    private double groupPrice = 0;
    private int numAvailable = 0;

    // no-arg constructor - constructor doesn't accept any arguments/ parameters
    public Repository() {

    }

    // constructor with parameters: items' names, group of counts, group of prices,
    // and available number
    public Repository(String itemName, int groupCount, double groupPrice, int numAvailable) {
        this.itemName = itemName;
        this.groupCount = groupCount;
        this.groupPrice = groupPrice;
        this.numAvailable = numAvailable;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getGroupCount() {
        return groupCount;
    }

    public void setGroupCount(int groupCount) {
        this.groupCount = groupCount;
    }

    public double getGroupPrice() {
        return groupPrice;
    }

    public void setGroupPrice(double groupPrice) {
        this.groupPrice = groupPrice;
    }

    public int getNumAvailable() {
        return numAvailable;
    }

    public void setNumAvailable(int numAvailable) {
        this.numAvailable = numAvailable;
    }

}
