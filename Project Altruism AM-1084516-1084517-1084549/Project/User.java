abstract class User {
    private String name;
    private String phone;
    public void setName (String name) // give string name
    {
        this.name=name;
    }
    public String getName () // return name
    {
        return name;
    }
    public void setPhone (String phone) // assign a value to the phone
    {
        this.phone=phone;
    }
    public String getPhone () // return the number of the phone
    {
        return phone;
    }
}                            
