import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Dwarf> krasnoludy = new ArrayList<Dwarf>();
        ArrayList<Bag> worki = new ArrayList<Bag>();
        ArrayList<Treasure> skarby = new ArrayList<Treasure>();

        for (int i = 0; i < 10; i++) {
            krasnoludy.add(new Dwarf(String.format("Krasnolud %d", i+1)));
            Strategy s;
            if (i % 3 == 0) {
                s = new RandomStrategy(krasnoludy.get(i));
            } else if (i % 3 == 1) {
                s = new ExpectedValueStrategy(krasnoludy.get(i));
            } else {
                s = new ConstFillStrategy(krasnoludy.get(i), 70);
            }
            krasnoludy.get(i).setStrategy(s);
        }

        for (int i = 0; i < 10; i++) {
            worki.add(new Bag((int) (Math.random() * 20 + 1)));
        }

        for (int i = 0; i < 20; i++) {
            skarby.add(new Treasure((int) (Math.random() * 10 + 1), String.format("S%d", i+1)));
        }

        Bilbo b = new Bilbo();
        b.rozdziel(skarby, krasnoludy, worki);
    }
}