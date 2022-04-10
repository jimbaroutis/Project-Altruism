import java.util.ArrayList;

public class Donator extends User{

    private ArrayList <Offers> offersList =new ArrayList<Offers>() ;

    // Wrapper Methods

    //this is the  wrapper method add in Donatator
    public void add(Offers x,RequestDonation y,Organization org){

         // this if structure checks if the unaltered offers x object passed is the same with the last object in the offersList array

        if (!offersList.isEmpty())  {

            if (offersList.get(offersList.size()-1) == x) //if so it deletes it and then reinserts it with the new RequestDonation object

            {

                offersList.remove(offersList.size()-1);
            }
        }

        Offers d = new Offers();
        x.add(y,this,org);
        d= x;
        offersList.add(d);
    }

    //this is the  wrapper method commit in Donatator
    public void commit(Organization org){

        for (int i = 0; i<offersList.size(); i++){

            offersList.get(i).commit(org);
        }
        offersList.clear();
    }

    public ArrayList<Offers> getOffersList(){
        return offersList;
    }

    public double getDonationAmount(Entity entity){
        double amount = 0;

        for (int i = 0; i<offersList.size(); i++ ){

            for (int j = 0; j<offersList.get(i).getRdEntities().size(); j++){

                if (entity.getID() == offersList.get(i).getRdEntities().get(j).getEntity().getID()){
                    amount  = amount + offersList.get(i).getRdEntities().get(j).getQuantity();
                }
            }
        }
        return amount;
    }

}

