public class RandomStrategy extends Strategy {
    public RandomStrategy(Dwarf owner) {
        owner_ = owner;
    }

    public boolean takeTreasure() {
        int r = (int) (Math.random() * 2);
        return r == 0;
    }
}
