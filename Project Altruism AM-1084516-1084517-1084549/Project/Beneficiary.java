import java.util.ArrayList;

public class Beneficiary extends User {

   private int noPerson=1;

    private ArrayList <RequestDonationList> receivedList = new ArrayList<RequestDonationList>();

    private ArrayList<Requests> requestsList = new ArrayList<Requests>();


    public void setNoPeson(int x)
    {
        this.noPerson = x;
    }

    public ArrayList<RequestDonationList> getReceivedList()
    {
        return receivedList;
    }

    public void ClearReceivedList()
    {
        try{
            if (receivedList.isEmpty())
            {
              throw new EmptyListException();
            }
        }catch (EmptyListException e)
        {
            System.out.println("receivedList array is already empty\n");
        }

        receivedList.clear();
    }

    public int getnoPerson(){
        return noPerson;
    }

    public ArrayList<Requests> getRequestsList(){
        return requestsList;
    }

    // Wrapper Methods

    // this wrapper method adds requests in requestsList
    public void add(Requests x,RequestDonation y, Organization org){
        if (!requestsList.isEmpty()){
            if (requestsList.get(requestsList.size()-1) == x){
                requestsList.remove(requestsList.size()-1);
            }
        }

        Requests d = new Requests();
        x.add(y,this,org);
        d= x;
        requestsList.add(d);
    }

    // this wrapper method commits all the objects from the array requestsList in the array receivedList and after the commitment clears it.
    public void commit(Organization org){
        for (int i = 0; i<requestsList.size(); i++) {
            requestsList.get(i).commit(this, org);

            System.out.println("test8");
        }
        requestsList.clear();
    }

}
