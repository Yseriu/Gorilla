import javax.swing.*;
import java.awt.*;

public class Fenetre extends JPanel {
    private JFrame fen = new JFrame("Ma fenetre");
    private EnsembleCaracteres caracteres;
    public Fenetre(){
        fen.setSize(800,600);
        fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        caracteres=new EnsembleCaracteres();
        fen.add(this); 
        fen.setVisible(true);
    }
    public void afficherCaracteres(EnsembleCaracteres e){
        caracteres = e;
        fen.repaint();
    }
    public int getNbColonnes(){
        return fen.getSize().width/this.getGraphics().getFontMetrics().charWidth('#');
    }
    public int getNbLignes(){
        return fen.getSize().height/this.getGraphics().getFontMetrics().getHeight();
    }
    @Override
    public void paint(Graphics g) {
        int ligne = this.getGraphics().getFontMetrics().getHeight();
        int colonne=this.getGraphics().getFontMetrics().charWidth('#');
        for(CaracterePositionne p:caracteres.caracteres){
            g.drawString(Character.toString(p.c), 
				(int) (p.x*colonne+0.5), 
				(int) ((getNbLignes()-p.y-1)*ligne+0.5));
        }
    }
    
    public void pause(int temps){
        try{
            Thread.sleep(temps);
        }
        catch(InterruptedException e){}
    }
}

