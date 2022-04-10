public class ObjectDoesNotExist extends Exception{

    public ObjectDoesNotExist()
    {
        super("This Object does not exists in the Array");
    }

    public ObjectDoesNotExist (String message) {
        super(message);

    }

}
