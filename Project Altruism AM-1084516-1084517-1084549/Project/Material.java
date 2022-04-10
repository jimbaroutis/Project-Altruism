import java.util.ArrayList;

public class Material extends Entity{

    private double Level1;
    private double Level2;
    private double Level3;

    public void SetMeterial(double Level1 ,double Level2, double Level3)
    {
        this.Level1= Level1;
        this.Level2= Level2;
        this.Level3 =Level3;
    }
    // returns levels with an array for simplified code.
    public ArrayList<Double> getLevels(){
        ArrayList<Double> levels = new ArrayList<Double>();
        levels.add(Level1);
        levels.add(Level2);
        levels.add(Level3);
        return levels;
    }

    public String getDetails()
    {
        return "Material " + " Level 1 is " +Level1 + " Level 2 is " +Level2 + " Level 3 is " +Level3;
    }
}