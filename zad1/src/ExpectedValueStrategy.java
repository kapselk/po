public class ExpectedValueStrategy extends Strategy {
    public ExpectedValueStrategy(Dwarf owner) {
        owner_ = owner;
    }

    public boolean takeTreasure() {
        Bag b = getOwner().getBilbo().getBag(0);
        int sum = 0, cnt = 0;
        for (int id = 0; b != null; b = getOwner().getBilbo().getBag(++id)) {
            for (Treasure t : b.getContent()) {
                sum += t.getSize();
                cnt++;
            }
        }
        b = getOwner().getBilbo().getBag(getOwner().getBagId());
        int rem = b.getSize() - b.getContentSize();
        return cnt * rem >= sum;
    }
}
