import java.util.*;

public class App2 {
    public static void main(String[] args) throws Exception {
        List<Monster> monsters = new ArrayList<Monster>();

        monsters.add(new Monster("おばけキノコ",10,false));
        monsters.add(new Monster("ゴブリン",25,false));
        monsters.add(new Monster("ドラゴン",120, true));

        for (Monster m : monsters) {
            System.out.println("名前: " + m.name() + " HP: " + m.hp() + " ボス？: " + m.isBoss() );
        }
    }
}
