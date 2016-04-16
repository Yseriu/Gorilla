import java.util.ArrayList;

class EnsembleCaracteres {

	ArrayList<CaracterePositionne> caracteres;

	EnsembleCaracteres()
	{
		caracteres = new ArrayList<CaracterePositionne>();
	}

    public EnsembleCaracteres(String[] sprite)
    {
        this();
        for (int i = 0; i < sprite.length; i++)
        {
            for (int j = 0; j < sprite[i].length(); j++)
            {
                if (sprite[i].charAt(j) != ' ')
                    this.caracteres.add(new CaracterePositionne(j, sprite.length - i, sprite[i].charAt(j)));
            }
        }
    }

	public void ajouteCar(double x, double y, char c)
	{
		caracteres.add(new CaracterePositionne(x,y,c));
	}

	public void vider()
    {
        caracteres.clear();
    }

    public void decaler(double x, double y)
    {
        for (CaracterePositionne c : caracteres)
        {
            c.decaler(x, y);
        }
    }

    public EnsembleCaracteres fusion(EnsembleCaracteres e)
    {
        EnsembleCaracteres ans = new EnsembleCaracteres();
        for (CaracterePositionne c : this.caracteres)
            ans.caracteres.add(c);
        for (CaracterePositionne c : e.caracteres)
            ans.caracteres.add(c);
        return ans;
    }
}
