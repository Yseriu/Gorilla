/**
 * Created by Yseriu on 10/04/2016.
 */
public class Exe {
    public static void main(String[] args)
    {
        Gorilla gorilla = new Gorilla(new Fenetre());
        gorilla.afficher();
        gorilla.play(50, 40);
    }
}
