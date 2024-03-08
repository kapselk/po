import java.util.ArrayList;

abstract class Someone {
    private ArrayList<Treasure> treasures_;
    protected String name_;

    public Someone() {
        treasures_ = new ArrayList<Treasure>();
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures_;
    }

    public void addTreasure(Treasure treasure) {
        treasures_.add(treasure);
    }

    public String getName() {
        return name_;
    }
}
