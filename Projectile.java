/**
 * Created by Baptiste Barbieri on 10/04/2016.
 */
public class Projectile implements Affichable, Movable{

    private int x;
    private int y;
    protected double vitesseX;
    protected double vitesseY;
    protected double gravity;
    // wind postitif => acceleration vers la droite
    protected double wind;

    public void setSpeeds(double force, double angle)
    {
        this.vitesseX= force * Math.cos(angle / 180 * Math.PI);
        this.vitesseY= force * Math.sin(angle / 180 * Math.PI);
    }

    @Override
    public void bouger() {
        double deltaT =1/( Math.sqrt( vitesseX* vitesseX+ vitesseY *vitesseY ));
        this.decaler(vitesseX*deltaT, vitesseY*deltaT);
        this.accelerate();
    }

    protected void accelerate()
    {
        this.vitesseX += wind;
        this.vitesseY -= gravity;
    }

    private void incrementY(double v)
    {
        this.x += v;
    }
    private void incrementX(double v)
    {
        this.y += v;
    }

    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }

    private EnsembleCaracteres ensembleCaracteres;

    public Projectile(int x, int y, double wind, double gravity, EnsembleCaracteres ensembleCaracteres) {
        this.x = x;
        this.y = y;

        this.gravity = gravity;
        this.wind = wind;
        this.setEnsembleCaracteres(ensembleCaracteres);
        this.ensembleCaracteres.decaler(x, y);
    }

    public Projectile(int x, int y, double wind, EnsembleCaracteres ensembleCaracteres) {
        this(x, y, wind, 0.98, ensembleCaracteres);
    }

    public Projectile(int x, int y, EnsembleCaracteres ensembleCaracteres) {
        this(x, y, 0, ensembleCaracteres);
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

    protected void decaler(double x, double y) {
        this.incrementX(x);
        this.incrementY(y);
        this.ensembleCaracteres.decaler(x, y);
    }


}
