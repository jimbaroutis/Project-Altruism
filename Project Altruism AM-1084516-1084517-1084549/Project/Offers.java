public class Offers extends RequestDonationList{

    public void commit(Organization x){
        Offers noffer = new Offers();
        noffer = this;
        x.getCurrentDonations().add(noffer);

    }
}
