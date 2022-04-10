import java.util.ArrayList;

public class Requests extends RequestDonationList {

    public boolean validRequestDonation(RequestDonation x, Beneficiary y) {

        if (x.getEntity().getDetails().startsWith("Material")) {
            int i;
            int j;
            double amount = 0;
            int mp = y.getnoPerson();
            if (!y.getReceivedList().isEmpty()) {
                for (i = 0; i < y.getReceivedList().size(); i++) {
                    for (j = 0; j < y.getReceivedList().get(i).getRdEntities().size(); j++) {
                        if (y.getReceivedList().get(i).getRdEntities().get(j).getEntity().getID() == x.getEntity().getID())
                            amount = amount + y.getReceivedList().get(i).getRdEntities().get(j).getQuantity();
                        break;
                    }
                }
            }else if (y.getReceivedList().isEmpty()){
                amount = 0;
            }

            if (mp == 1) {
                if (amount + x.getQuantity() < ((Material) x.getEntity()).getLevels().get(0)) {

                    return true;
                }
                return false;
            }
            if (mp == 2) {
                if (amount + x.getQuantity() < ((Material) x.getEntity()).getLevels().get(1)) {

                    return true;
                }
                return false;
            }
            if (mp == 3) {
                if (amount + x.getQuantity() < ((Material) x.getEntity()).getLevels().get(2)) {

                    return true;
                }
                return false;
            }

        }
        return true;
    }
    public void add(RequestDonation x, User y, Organization org){
        for (int i = 0; i <org.getCurrentDonations().size(); i++){
            for (int j = 0; j<org.getCurrentDonations().get(i).getRdEntities().size(); j++){
                if (org.getCurrentDonations().get(i).getRdEntities().get(j).Compare(x)){
                    try {
                        if (org.getCurrentDonations().get(i).getRdEntities().get(j).getQuantity() >= x.getQuantity()) {
                            if (this.validRequestDonation(x, (Beneficiary) y)) {
                                super.add(x,y,org);


                            }else throw new BeneficiaryMoreEntityException();
                        }else throw new OverdoseNegativeException();
                    }catch (BeneficiaryMoreEntityException e)
                    {
                        System.out.println(e.getMessage());

                    }catch (OverdoseNegativeException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        try {

        if (org.getCurrentDonations().isEmpty()) {
            throw new EmptyListException();
        }
        }catch (EmptyListException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void commit(Beneficiary y, Organization org){

        RequestDonationList rqdl = new RequestDonationList();
        for (int i = 0; i<this.getRdEntities().size(); i++){

            for (int e = 0; e<org.getCurrentDonations().size(); e++){

                for (int j = 0; j<org.getCurrentDonations().get(e).getRdEntities().size(); j++){

                    if (org.getCurrentDonations().get(e).getRdEntities().get(j).Compare(this.getRdEntities().get(i))){

                        try {
                            if (org.getCurrentDonations().get(e).getRdEntities().get(j).getQuantity() >= this.getRdEntities().get(i).getQuantity()) {

                                try {
                                    if (this.validRequestDonation(this.getRdEntities().get(i), y)) {

                                        double z = org.getCurrentDonations().get(e).getRdEntities().get(j).getQuantity();
                                        double b = this.getRdEntities().get(j).getQuantity();
                                        double c = z - b;
                                        org.getCurrentDonations().get(e).getRdEntities().get(j).modifyquantity(c);
                                        rqdl.getRdEntities().add(this.getRdEntities().get(i));
                                        y.getReceivedList().add(rqdl);



                                    }else throw new BeneficiaryMoreEntityException();

                                }catch (BeneficiaryMoreEntityException a)
                                {
                                    System.out.println(a.getMessage());
                                }

                            }else throw new OverdoseNegativeException();
                        }catch (OverdoseNegativeException a){

                            System.out.println(a.getMessage());
                        }

                    }

                }
            }
        }
    }
    public void modify(int id, double quantity, User y, Organization org)
    {
        for (int i = 0; i<org.getCurrentDonations().size(); i++)
        {
            for (int j = 0; j<org.getCurrentDonations().get(i).getRdEntities().size(); j++)
            {
                if (org.getCurrentDonations().get(i).getRdEntities().get(j).Compare(this.get(id)))
                {
                    try {
                        if (org.getCurrentDonations().get(i).getRdEntities().get(j).getQuantity() >= this.get(id).getQuantity()+quantity)
                        {
                            try {
                                RequestDonation nrd = new RequestDonation();
                                nrd.modifyquantity(quantity);
                                nrd.setEntityRd(this.get(id).getEntity());
                                if (this.validRequestDonation(nrd, (Beneficiary) y)) {
                                    super.modify(id, quantity, y, org);


                                } else throw new BeneficiaryMoreEntityException();
                            }catch (BeneficiaryMoreEntityException e)
                            {
                                System.out.println(e.getMessage());
                            }
                        }else throw new OverdoseNegativeException();

                    }catch (OverdoseNegativeException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

}
