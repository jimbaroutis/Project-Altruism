import java.util.ArrayList;

public class RequestDonationList  {
    private ArrayList <RequestDonation> rdEntities = new ArrayList<RequestDonation>();

    public RequestDonation get(int id)
    {
        boolean flag =false ;

        for(int i =0; i<rdEntities.size(); i++ )
        {
            if(rdEntities.get(i).getEntity().getID() == id )
            {
                flag = true;
                return rdEntities.get(i);

            }
        }

        try {
            if(flag ==false)
            {
                throw new ObjectDoesNotExist();
            }

        }catch (ObjectDoesNotExist e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void add(RequestDonation x, User y, Organization test){
        boolean flag = false;
        for (int i = 0 ; i<test.getEntityList().size(); i++ )
        {
                if (test.getEntityList().get(i).getID() == x.getEntity().getID()) {
                    flag = true;
                    break;

                }
        }
        try {
            if (!flag) {
                throw new ObjectDoesNotExist();
            }
        }catch (ObjectDoesNotExist e)
        {
            System.out.println(e.getMessage());
        }


        if(rdEntities.isEmpty()){
            RequestDonation requestd = new RequestDonation();
            requestd.setEntityRd(x.getEntity());
            requestd.modifyquantity(x.getQuantity());
            rdEntities.add(requestd);
            System.out.println(requestd.getEntity().getName()+" "+ requestd.getQuantity());
        }else {
            for (int j = 0; j < rdEntities.size(); j++) {
                if (rdEntities.get(j).getEntity().getID() == x.getEntity().getID()) {
                    rdEntities.get(j).modifyquantity(x.getQuantity());
                    flag = false;
                    break;
                }

            }
            if (flag){
                RequestDonation requestd = new RequestDonation();
                requestd.setEntityRd(x.getEntity());
                requestd.modifyquantity(x.getQuantity());
                rdEntities.add(requestd);
                System.out.println(requestd.getEntity().getName()+" "+ requestd.getQuantity());
            }

        }

        return;
    }


    public void remove(int id)
    {
        for(int i =0; i<rdEntities.size(); i++ )
        {
            boolean flag = true;
            try {
                if(rdEntities.get(i).getEntity().getID() == id )
                {
                    rdEntities.remove(i);
                }else throw new ObjectDoesNotExist();
            }catch (ObjectDoesNotExist e)
            {
                System.out.println(e.getMessage());
            }

        }

    }

    public void modify(int id , double quantity, User y, Organization org )
    {
        for(int i =0; i<rdEntities.size(); i++ )
        {
            try {
                if (rdEntities.get(i).getEntity().getID() == id) {
                    rdEntities.get(i).modifyquantity(quantity);
                } else throw new ObjectDoesNotExist();

            }catch (ObjectDoesNotExist e)
            {
                System.out.println(e.getMessage());
            }

        }
    }

    public void monitor()
    {
        System.out.println( "The Items are:");

        for(int i =0; i<rdEntities.size(); i++ )
        {
            System.out.println("Name" +rdEntities.get(i).getName() + "The quantity of this item is: "+rdEntities.get(i).getQuantity());
        }
    }

    public void reset()
    {
            rdEntities.clear();
    }
    public ArrayList<RequestDonation> getRdEntities(){
        return rdEntities;
    }

}
