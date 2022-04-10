
import java.util.ArrayList;

class Organization {


    private String name;
    private Admin admin;
    private  ArrayList<Entity> entityList = new ArrayList<Entity>();
    private ArrayList<Donator> donatorList = new ArrayList<Donator>();
    private ArrayList<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();
    private ArrayList<RequestDonationList> currentDonations = new ArrayList<RequestDonationList>();

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void addEntity(Entity entity)  {

        if (entityList.isEmpty()){
            entityList.add(entity);
            return;
        }
        boolean flag = false;
        for (int i = 0; i<entityList.size(); i++){
            try {

                if (entityList.get(i).getID() == entity.getID()) {
                    throw new AlreadyExistsException();

                } else {
                    flag = true;

                }
            }catch (AlreadyExistsException e)
            {
                System.out.println(e.getMessage());
            }
        }
        if (flag){
            entityList.add(entity);
        }
    }

    public void removeEntity(Entity entity) {

        boolean flag = false;

        for (int i = 0; i<entityList.size(); i++){
            try {

                if (entityList.get(i).getID() == entity.getID()) {
                    throw new ObjectDoesNotExist();

                } else {
                    flag = true;

                }
            }catch (ObjectDoesNotExist e)
            {
                System.out.println(e.getMessage());
            }
        }
        if (flag){
            entityList.remove(entity);
        }
    }

    public void insertDonator(Donator donator) {
        if (donatorList.isEmpty()){
            donatorList.add(donator);
            return;
        }
        boolean flag = false;
        for (int i = 0; i<donatorList.size(); i++) {
            try {
                if (donatorList.get(i) == donator) {
                    throw new AlreadyExistsException();

                } else {
                    flag = true;
                }
            }catch (AlreadyExistsException e)
                {
                    System.out.println(e.getMessage());
                }
        }
        if (flag){
            donatorList.add(donator);
        }
    }
    public void removeDonator(Donator donator){

        boolean flag = true;
        for (int i = 0; i<donatorList.size(); i++) {
            try {
                if (donatorList.get(i) == donator) {
                    throw new ObjectDoesNotExist();

                }
            }catch (ObjectDoesNotExist e)
            {
                System.out.println(e.getMessage());
            }
        }
        if (flag){
            donatorList.remove(donator);
        }

    }

    public void insertBeneficiary(Beneficiary beneficiary) {
        if (beneficiaryList.isEmpty()){
            beneficiaryList.add(beneficiary);
            return;
        }
        boolean flag = false;
        for (int i = 0; i<beneficiaryList.size(); i++){
            try {
                if (beneficiaryList.get(i) == beneficiary) {
                    throw new AlreadyExistsException();

                } else {
                    flag = true;

                }
            }catch (AlreadyExistsException e )
            {
                System.out.println(e.getMessage());
            }
        }
        if (flag){
            beneficiaryList.add(beneficiary);
        }
    }

    public void removeBeneficiary(Beneficiary beneficiary){

        boolean flag = false;

        for (int i = 0; i<beneficiaryList.size(); i++){
            try {
                if (beneficiaryList.get(i) == beneficiary) {
                    throw new ObjectDoesNotExist();

                } else {
                    flag = true;
                }
            }catch (ObjectDoesNotExist e )
            {
                System.out.println(e.getMessage());
            }
        }
        if (flag){
            beneficiaryList.remove(beneficiary);
        }

    }

    public void listEntities(){

        try {
            if( entityList.isEmpty())
            {
              throw new EmptyListException();
            }
        }catch (EmptyListException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("Entities are : ");
        System.out.println("1.Materials are : ");
        int amount = 0;
        for( int i = 0; i<entityList.size(); i++)
        {

            if (entityList.get(i).getDetails().startsWith("Material")){
                amount++;

                System.out.println( amount  +" "+ entityList.get(i).getName()+" "+ entityList.get(i).getDetails()+" (index "+ i+" )");
            }

        }
        amount = 0;
        for( int i = 0; i<entityList.size(); i++)
        {
            System.out.println("1.Materials are : ");

            if (entityList.get(i).getDetails().startsWith("Service")){

                System.out.println( amount  +" "+ entityList.get(i).getName()+" "+ entityList.get(i).getDetails()+" (index "+ i+" )");
            }

        }
    }

    public void listBeneficiaries(){

        try {
            if( beneficiaryList.isEmpty())
            {
                throw new EmptyListException();
            }
        }catch (EmptyListException e)
        {
            System.out.println(e.getMessage());
        }


        System.out.println("Beneficiaries: ");

        for(int i = 0; i<beneficiaryList.size(); i++ ){
            System.out.println( beneficiaryList.get(i).getName()+" (index "+i+ " )");
        }
    }

    public void listDonators() {

        try {
            if( donatorList.isEmpty())
            {
                throw new EmptyListException();
            }
        }catch (EmptyListException e)
        {
            System.out.println(e.getMessage());
        }

        System.out.println("Donators: ");

        for (int i = 0; i<donatorList.size(); i++ ) {

            System.out.println( donatorList.get(i).getName() + " (index " + i+" )");
        }
    }

    public ArrayList <Entity> getEntityList(){
        return entityList;
    }

    public ArrayList<Donator> getDonatorList()
    {
        return donatorList;
    }

    public ArrayList <Beneficiary> getBeneficiaryList(){
        return beneficiaryList;
    }
    public ArrayList<RequestDonationList> getCurrentDonations(){return currentDonations;}

    public void insert(RequestDonationList x){
        currentDonations.add(x);
    }

    //returns the total amount of all entities donated in the organization
    public double getEntityAmount(int id){
        double amount = 0;
        for (int i = 0; i<currentDonations.size(); i++ ){
            for (int j = 0 ; j<currentDonations.get(i).getRdEntities().size(); j++){
                if (currentDonations.get(i).getRdEntities().get(j).getEntity().getID() == id){
                    amount = amount + currentDonations.get(i).getRdEntities().get(j).getQuantity();
                }
            }
        }
        return amount;
    }

}