/**
 * Created by Baptiste Barbieri on 10/04/2016.
 */
public class Exe {
    public static void main(String[] args)
    {
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
                "           xXXXXXXXXx",
                "           XXXXXXXXXX",
                "          XXXXX  XXXXX",
                "         xXXXX ’ ’ XXXXx",
                "        XXXXXxxxxxxxXXXXX",
                "      xXXXXX ’’’’’’’’’ XXXXXx",
                "    xXXXXXX ’       ’ XXXXXXx",
                "   xxXXXXXXX         XXXXXXXxx ",
        };
        Gorilla gorilla = new Gorilla(new Fenetre());
        gorilla.register(new Obstacle(30, 0, sprite));
        gorilla.register(new Projectile(7, 3, new EnsembleCaracteres(new String[]{"/ \\", "\\#/"})));
        gorilla.afficher();
        gorilla.play(50, 40);
    }
}
