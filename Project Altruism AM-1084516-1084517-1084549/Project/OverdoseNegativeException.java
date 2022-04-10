public class OverdoseNegativeException extends Exception{

    public OverdoseNegativeException(){
        super("Overdose or Negative quantity");
    }

    public OverdoseNegativeException(String message){
        super(message);
    }

}