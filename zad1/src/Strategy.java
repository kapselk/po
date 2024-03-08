abstract class Strategy {
    protected Dwarf owner_;

    public abstract boolean takeTreasure();

    public Dwarf getOwner() {
        return owner_;
    }
}

;
