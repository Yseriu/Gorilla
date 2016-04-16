/**
 * Created by Baptiste Barbieri on 10/04/2016.
 */
public class Exe {
    public static final int xProj = 7;
    public static final int yProj = 3;
    public static final String[] sProj = new String[]{"/ \\", "\\#/"};
    public static void main(String[] args)
    {
        int nbTours = 3;
        if (args.length > 0) {
            try {
                nbTours = Integer.max(Integer.parseInt(args[1]), nbTours);
            } catch (NumberFormatException e) {
                Exe.paramError();
            }
        }
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
        gorilla.register(new Cible(gorilla, 58, 17, new String[]{"+-+", "|3|", "+-+"}, 3));
        gorilla.register(new Projectile(xProj, yProj, new EnsembleCaracteres(sProj)));
        gorilla.afficher();
        for (int i = 0; i < nbTours; i++)
        {
            gorilla.play();
            gorilla.register(new Projectile(xProj, yProj, new EnsembleCaracteres(sProj)));
        }
        gorilla.end();
    }

    public static void paramError()
    {
        System.out.println("Utilisation : $ java -jar gorilla [nbTours]");
    }
}
