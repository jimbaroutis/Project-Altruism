public class WrongSelectionException extends Exception{


    public WrongSelectionException()
    {
        super("The choice you made is invalid");
    }

    public WrongSelectionException (String message) {
        super(message);

    }

}

