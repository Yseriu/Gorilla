public class CaracterePositionne {

    double x,y;
    char c;

    public CaracterePositionne(double a, double b, char d)
    {
        x=a;
        y=b;
        c=d;
    }

    public void decaler(double x, double y) {
        this.x += x;
        this.y += y;
    }
}
