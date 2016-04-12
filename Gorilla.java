import java.util.ArrayList;

/**
 * Created by Yseriu on 10/04/2016.
 */
public class Gorilla {
    private ArrayList<Movable> movables;
    private ArrayList<Touchable> obstacles;
    private Projectile projectile;
    private ArrayList<Affichable> affichables;
    private Fenetre f;

    public Gorilla(Fenetre f) {
        String [] sprite ={
                "               ()",
                "               /\\",
                "              |==|",
                "              ====",
                "               XX",
                "              xXXx",
                "              XXXX",
                "              XXXX",
                "              XXXX",
                "             xXXXXx",
                "             XXXXXX",
                "             XXXXXX",
                "            xXXXXXXx",
                "            XXXXXXXX",
                "           xXXXXXXXXx ",
                "           XXXXXXXXXX ",
                "          XXXXX  XXXXX",
                "         xXXXX ’ ’ XXXXx",
                "        XXXXXxxxxxxxXXXXX",
                "      xXXXXX ’’’’’’’’’ XXXXXx",
                "    xXXXXXX ’       ’ XXXXXXx",
                "   xxXXXXXXX         XXXXXXXxx ",
        };
        this.f = f;
        this.movables = new ArrayList<>();
        this.obstacles = new ArrayList<>();
        this.affichables = new ArrayList<>();
        this.register(new Obstacle(30, 0, sprite));
        this.projectile = new Projectile(7, 3, new EnsembleCaracteres(new String[]{"/ \\", "\\#/"}));
        this.affichables.add(this.projectile);
        this.movables.add(this.projectile);
    }

    public void register(Obstacle obstacle)
    {
        this.obstacles.add(obstacle);
        this.affichables.add(obstacle);
    }

    public void afficher()
    {
        EnsembleCaracteres e = new EnsembleCaracteres();
        for (Affichable a: affichables)
        {
            e = e.fusion(a.getEnsembleCaracteres());
        }
        this.f.afficherCaracteres(e);
    }

    public void play(double force, double angle) {
        this.projectile.setSpeeds(force, angle);
        while (!this.endTurn())
        {
            for(Movable m : this.movables)
                m.bouger();
            this.afficher();
            this.f.pause(110);
        }
        System.out.println("the end");
    }

    private boolean endTurn() {
        if (this.projectile.touche(this.f))
            return true;
        for (Touchable o : this.obstacles)
        {
            if (this.projectile.touche(o))
                return true;
        }
        return false;
    }
}
