import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Baptiste Barbieri on 10/04/2016.
 */
public class Gorilla {
    private ArrayList<Movable> movables;
    private ArrayList<Touchable> obstacles;
    private Projectile projectile;
    private ArrayList<Affichable> affichables;
    private Fenetre f;
    private int score;

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
    }

    public void register(Obstacle obstacle)
    {
        this.obstacles.add(obstacle);
        this.affichables.add(obstacle);
    }

    public void register(Projectile projectile)
    {
        if (this.projectile != null)
        {
            this.affichables.remove(this.projectile);
            this.movables.remove(this.projectile);
        }
        this.projectile = projectile;
        this.affichables.add(projectile);
        this.movables.add(projectile);
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

    public void incrementeScore(int v)
    {
        this.score += v;
    }

    public int getScore() {
        return score;
    }

    public void play()
    {
        this.afficher();
        int angle = Integer.parseInt(JOptionPane.showInputDialog(null, "Votre score " + this.score + "\n Avec quel angle lancer la bombe ?", "Choix de l'angle de lancé", JOptionPane.QUESTION_MESSAGE));
        int force = Integer.parseInt(JOptionPane.showInputDialog(null, "Votre score " + this.score + "\n Avec quel force lancer la bombe ?", "Choix de la force de lancé", JOptionPane.QUESTION_MESSAGE));
        this.play(force, angle);
    }

    public void end() {
        JOptionPane.showMessageDialog(null, "La partie est finie.\nVotre socre est " + this.score);
    }
}
