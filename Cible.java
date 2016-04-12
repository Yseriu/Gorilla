/**
 * Created by Baptiste Barbieri on 12/04/2016.
 */
public class Cible extends Obstacle {
    private int value;
    private Gorilla game;

    public Cible(Gorilla game, double x, double y, String[] sprite, int value) {
        super(x, y, sprite);
        this.value = value;
        this.game = game;
    }

    public Cible(Gorilla game, double x, double y, String[] sprite) {
        this(game, x, y, sprite, 1);
    }

    @Override
    public boolean estTouche(CaracterePositionne c) {
        if (super.estTouche(c)) {
            this.game.incrementeScore(this.value);
            return true;
        }
        return false;
    }
}
