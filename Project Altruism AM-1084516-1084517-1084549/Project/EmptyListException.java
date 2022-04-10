public class EmptyListException extends Exception{

    public EmptyListException()
    {
        super("This array is Empty");
    }

    public EmptyListException (String message) {
        super(message);

    }

}
