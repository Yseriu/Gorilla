/**
 * Created by Yseriu on 10/04/2016.
 */
public abstract class Movable {

    private int x;
    private int y;
    protected double vitesseX;
    protected double vitesseY;
    protected double gravity;
    // wind postitif => acceleration vers la droite
    protected double wind;

    public Movable(int x, int y, double wind, double gravity) {
        this.x = x;
        this.y = y;

        this.gravity = gravity;
        this.wind = wind;
    }

    public Movable(int x, int y, double wind) {
        this(x, y, wind, 0.98);
    }

    public Movable(int x, int y) {
        this(x, y, 0);
    }

    public void setSpeeds(double force, double angle)
    {
        this.vitesseX= force * Math.cos(angle / 180 * Math.PI);
        this.vitesseY= force * Math.sin(angle / 180 * Math.PI);
    }

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

    protected void decaler(double x, double y)
    {
        this.incrementX(x);
        this.incrementY(y);
    }

    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }
}
