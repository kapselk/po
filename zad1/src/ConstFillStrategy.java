public class ConstFillStrategy extends Strategy {

    private int maxFilling;

    public ConstFillStrategy(Dwarf owner, int maxFillingPercent) {
        owner_ = owner;
        maxFilling = maxFillingPercent;
    }

    public boolean takeTreasure() {
        Bag b = getOwner().getBilbo().getBag(getOwner().getBagId());
        // contentSize / size <= maxFilling/100  <==> contentSize * 100 <= size * maxFilling
        return 100 * b.getContentSize() <= b.getSize() * maxFilling;
    }
}
