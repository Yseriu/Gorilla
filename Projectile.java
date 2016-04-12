/**
 * Created by Yseriu on 10/04/2016.
 */
public class Projectile extends Movable implements Affichable{

    private EnsembleCaracteres ensembleCaracteres;

    public Projectile(int x, int y, double wind, double gravity, EnsembleCaracteres ensembleCaracteres) {
        super(x, y, wind, gravity);
        this.setEnsembleCaracteres(ensembleCaracteres);
        this.ensembleCaracteres.decaler(x, y);
    }

    public Projectile(int x, int y, double wind, EnsembleCaracteres ensembleCaracteres) {
        super(x, y, wind);
        this.setEnsembleCaracteres(ensembleCaracteres);
        this.ensembleCaracteres.decaler(x, y);
    }

    public Projectile(int x, int y, EnsembleCaracteres ensembleCaracteres) {
        super(x, y);
        this.setEnsembleCaracteres(ensembleCaracteres);
        this.ensembleCaracteres.decaler(x, y);
    }

    public EnsembleCaracteres getEnsembleCaracteres() {
        return ensembleCaracteres;
    }

    protected void setEnsembleCaracteres(EnsembleCaracteres ensembleCaracteres) {
        this.ensembleCaracteres = ensembleCaracteres;
    }

    public boolean touche(Touchable t)
    {
        for (CaracterePositionne c : this.ensembleCaracteres.caracteres)
        {
            if (t.estTouche(c))
                return true;
        }
        return false;
    }

    public boolean touche(Fenetre f)
    {
        for (CaracterePositionne c : this.ensembleCaracteres.caracteres)
        {
            if (c.x <= 0 || c.x >= f.getNbColonnes()
                    || c.y <= 0 || c.y >= f.getNbLignes())
                return true;
        }
        return false;
    }

    @Override
    protected void decaler(double x, double y) {
        super.decaler(x, y);
        this.ensembleCaracteres.decaler(x, y);
    }


}
