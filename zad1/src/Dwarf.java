public class Dwarf extends Someone {
    private int bagId_;
    private Strategy strategy;
    private Bilbo bilbo_;

    public Dwarf(String n) {
        name_ = n;
    }

    public void setBagId(int id) {
        bagId_ = id;
    }

    public void setBilbo(Bilbo b) {
        bilbo_ = b;
    }

    public int getBagId() {
        return bagId_;
    }

    public Bilbo getBilbo() {
        return bilbo_;
    }

    public boolean takeTreasure() {
        return strategy.takeTreasure();
    }

    public void setStrategy(Strategy s) {
        strategy = s;
    }
}
