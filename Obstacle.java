/**
 * Created by Yseriu on 10/04/2016.
 */
public class Obstacle implements Touchable, Affichable {

    public EnsembleCaracteres e;

    public Obstacle(double x, double y, String[] sprite) {
        this.e = new EnsembleCaracteres(sprite);
        this.e.decaler(x, y);
    }

    @Override
    public boolean estTouche(CaracterePositionne c) {
        for (CaracterePositionne c2 : this.e.caracteres)
        {
            // System.out.println("Compraring " + c2.x + " to " + c.x + " and " + c2.y + " to " + c.y);
            if (c2.x > c.x && c2.x < c.x + 1
                    && c2.y > c.y && c2.y < c.x + 1)
                return true;
        }
        return false;
    }

    @Override
    public EnsembleCaracteres getEnsembleCaracteres() {
        return this.e;
    }
}
