abstract class Entity {


    private String name;
    private String description ;
    private int id;

    public void setEntity(String name,String description, int id)
    {
        this.name=name;
        this.description = description;
        this.id=id;
    }

    public String getEntityInfo()
    {
        return  " donation name " +name+ " description: " +description + " id:" +id;
    }

    // this method returns all the information for one entity.
    public String toString()
    {
        return  getEntityInfo()+ getDetails();
    }

    public int getID ()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    abstract String getDetails();


}
