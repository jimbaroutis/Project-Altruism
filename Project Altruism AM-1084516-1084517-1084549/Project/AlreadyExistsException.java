public class AlreadyExistsException extends Exception{

 public AlreadyExistsException ()
 {
     super("This Object already exists in the Array");
 }

 public AlreadyExistsException (String message) {
     super(message);

 }

}
