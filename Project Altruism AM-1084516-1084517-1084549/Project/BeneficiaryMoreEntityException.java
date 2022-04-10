public class BeneficiaryMoreEntityException extends Exception{

    public BeneficiaryMoreEntityException(){
        super("This Quantity is not allowed to you due to smaller number of persons in your family");
    }
    public BeneficiaryMoreEntityException(String message){
        super(message);
    }

}