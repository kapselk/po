import java.util.ArrayList;

public class Bag {
    private int size_;
    private ArrayList<Treasure> content_;

    private int contentSize_ = 0;

    public Bag(int size) {
        size_ = size;
        content_ = new ArrayList<Treasure>();
    }

    public int getSize() {
        return size_;
    }

    public ArrayList<Treasure> getContent() {
        return content_;
    }

    public void addTreasure(Treasure treasure) {
        content_.add(treasure);
        contentSize_ += treasure.getSize();
    }

    public int getContentSize() {
        return contentSize_;
    }

    public void clear() {
        content_.clear();
        contentSize_ = 0;
    }
}
