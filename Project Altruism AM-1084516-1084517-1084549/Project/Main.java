public class Main {
    private static Beneficiary BeneficiaryGeorge = new Beneficiary();
    private static Beneficiary BeneficiaryJohn = new Beneficiary();

    private static Donator DonatorBill = new Donator();

    private static RequestDonationList rql = new RequestDonationList();
    private static Requests rq = new Requests();
    private static RequestDonation rqd = new RequestDonation();

    private static Organization org = new Organization();

    private static Material milk = new Material();
    private static Material sugar = new Material();
    private static Material rice = new Material();

    private static Service MedicalSupport = new Service();
    private static Service NurserySupport = new Service();
    private static Service BabySitting = new Service();

    private static Admin admin = new Admin();

    public static void main(String[] args) throws Exception {
        milk.setEntity("Milk", "Milk is MiLK", 1);
        milk.SetMeterial(10,23,40);

        sugar.setEntity("Sugar", "Sugar is Sugar", 2);

        sugar.SetMeterial(40,80,120);

        rice.setEntity("Rice" , "Rice is RIce", 3);
        rice.SetMeterial(80,160,240);

        org.addEntity(milk);
        org.addEntity(sugar);
        org.addEntity(rice);

        MedicalSupport.setEntity("MedicalSupport", "Doctor helper ", 4);
        NurserySupport.setEntity("NurserySupport", "Nurse helper", 5);
        BabySitting.setEntity("BabySitting", "BabySitting help", 6);


        org.addEntity(MedicalSupport);
        org.addEntity(NurserySupport);
        org.addEntity(BabySitting);


        admin.setPhone("1000");
        admin.setName("Le admin");

        BeneficiaryGeorge.setPhone("1111");
        BeneficiaryGeorge.setName("George");
        BeneficiaryGeorge.setNoPeson(1);


        BeneficiaryJohn.setPhone("2222");
        BeneficiaryJohn.setName("John");
        BeneficiaryJohn.setNoPeson(2);

        DonatorBill.setPhone("0000");
        DonatorBill.setName("Bill");

        org.setAdmin(admin);
        org.insertBeneficiary(BeneficiaryGeorge);
        org.insertBeneficiary(BeneficiaryJohn);
        org.insertDonator( DonatorBill);

        Menu menu = new Menu();
        menu.menu(org, menu.login(org));
        return;
    }
}
