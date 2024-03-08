import java.util.ArrayList;

public class Bilbo extends Someone {
    private ArrayList<Bag> bags;
    private boolean runningProcess = false;

    public Bilbo() {
        bags = new ArrayList<Bag>();
    }

    public Bag getBag(int id) {
        if (id >= bags.size()) return null;
        else return bags.get(id);
    }

    public void rozdziel(ArrayList<Treasure> skarby, ArrayList<Dwarf> krasnoludy, ArrayList<Bag> worki) {
        if (runningProcess) return;
        runningProcess = true;
        bags.addAll(worki);
        int m = worki.size(), bid = 0;
        int sk = skarby.size(), sid = 0;
        while (sid < sk) {
            for (Dwarf d : krasnoludy) {
                d.setBagId(bid);
                d.setBilbo(this);
                boolean bad = false;
                while (d.takeTreasure() && sid < sk && !bad) {
                    if (skarby.get(sid).getSize() + getBag(bid).getContentSize() > getBag(bid).getSize()) {
                        // overload bag
                        for (Treasure t : getBag(bid).getContent()) {
                            addTreasure(t); // adding t to Bilbo
                        }
                        getBag(bid).clear();
                        bad = true;
                    } else {
                        getBag(bid).addTreasure(skarby.get(sid++));
                    }
                }
                if (!bad) {
                    for (Treasure t : getBag(bid).getContent()) {
                        d.addTreasure(t);
                    }
                    getBag(bid).clear();
                }
                bid++;
            }
            bid = 0;
        }
        for (Dwarf d : krasnoludy) {
            System.out.printf("Krasnolud, name = %s has: ", d.getName());
            for (Treasure t : d.getTreasures()) {
                System.out.printf("[skarb, name = %s, rozmiar = %d]", t.getName(), t.getSize());
            }
            System.out.println();
        }
        System.out.printf("Bilbo has: ");
        for (Treasure t : getTreasures()) {
            System.out.printf("[skarb, name = %s, rozmiar = %d]", t.getName(), t.getSize());
        }
        System.out.println();
        runningProcess = false;
    }
}
