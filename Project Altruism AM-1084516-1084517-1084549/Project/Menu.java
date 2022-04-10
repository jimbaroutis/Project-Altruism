import java.util.Scanner;

public class Menu{
    private int usertype = 0;

    public User login(Organization org)  {
        boolean userloop = true;
        System.out.println("****************************************");
        System.out.println("****************************************");
        System.out.println("Welcome to Save The Children \nPlease type your phone number ");
        Scanner choice = new Scanner(System.in);
        String phone = choice.nextLine();
        while (userloop) {
            if (phone.equals(org.getAdmin().getPhone()) ) {
                usertype = 1;
                return org.getAdmin();
            }
            for (int i = 0; i < org.getDonatorList().size(); i++) {
                if (phone.equals(org.getDonatorList().get(i).getPhone())) {
                    usertype = 2;
                    return org.getDonatorList().get(i);
                }
            }
            for (int i = 0; i < org.getBeneficiaryList().size(); i++) {
                if (phone.equals(org.getBeneficiaryList().get(i).getPhone())) {
                    usertype = 3;
                    return org.getBeneficiaryList().get(i);
                }
                userloop = false;
            }
            break;
        }
        if (usertype == 0) {
            System.out.println("There is no account with this phone number.\nDo you want to sing up? (y/n)");
            phone = choice.nextLine();
            if (phone.equals("y") || phone.equals("Y")) {
                boolean regchoice = true;
                System.out.println("Donator - Beneficiary (d/b)");
                while (regchoice) {
                    phone = choice.nextLine();
                    if (phone.equals("d") || phone.equals("D")) {
                        //add donator
                        Donator newDonator = new Donator();
                        System.out.println("Please provide a phone number");
                        phone = choice.nextLine();
                        newDonator.setPhone(phone);
                        System.out.println("Please provide a name");
                        phone = choice.nextLine();
                        newDonator.setName(phone);
                        org.insertDonator(newDonator);

                        usertype = 2;
                        System.out.println("Thank you for registering");

                        return newDonator;
                    } else if (phone.equals("b") || phone.equals("B")) {
                        //add beneficiary
                        Beneficiary newBeneficiary = new Beneficiary();
                        System.out.println("Please provide a phone number");
                        phone = choice.nextLine();
                        newBeneficiary.setPhone(phone);
                        System.out.println("Please provide a name");
                        phone = choice.nextLine();
                        newBeneficiary.setName(phone);
                        System.out.println("Please provide number of people");
                        phone = choice.nextLine();
                        newBeneficiary.setNoPeson(Integer.parseInt(phone));
                        org.insertBeneficiary(newBeneficiary);
                        
                        System.out.println("Thank you for registering");
                        usertype =3;
                        return newBeneficiary;
                    } else {
                        System.out.println("Please type again your answer");
                    }

                }

            }else if(phone.equals("n") || phone.equals("N")){
                System.out.println("See you next time");
                return null;
            }
        }
        //exception
        return null;
    }
    public void menu(Organization org, User x) throws  NumberFormatException {
        boolean level1 = true;
        boolean level2 = true;
        boolean level3 = true;
        Scanner scn = new Scanner(System.in);

        if (x == null){
            return;
        }
        int inp;
        String inps;
        double inpd;
        int inpint;
        Donator don ;
        switch (usertype) {
            case 1:
                //case admin
                while (level1){
                    System.out.println("Choose from these choices");
                    System.out.println("-------------------------\n");
                    System.out.println("1 - View");
                    System.out.println("2 - Monitor Organization");
                    System.out.println("3 - Back");
                    System.out.println("4 - Logout");
                    System.out.println("5 - Exit");
                    System.out.println("Please type in your answers");
                    inps = scn.nextLine();
                       inpint = 0;

                       try{
                         inpint = Integer.parseInt(inps);
                    }catch (NumberFormatException e)
                    {
                        System.out.println("Enter again the value must be a number");
                    }


                    try{
                        if(inpint >6 || inpint<0 ) {

                            throw new WrongSelectionException();
                        }
                    }catch (WrongSelectionException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    switch (inpint){


                        case 1:

                            level2 = true;

                            while (level2==true) {
                                int number = 0;


                                for (int i = 0; i < org.getEntityList().size(); i++) {

                                    if (org.getEntityList().get(i).getDetails().startsWith("Material")) {
                                        number++;
                                    }
                                }
                                System.out.println("1.Material " + number);

                                number = 0;

                                for (int i = 0; i < org.getEntityList().size(); i++) {

                                    if (org.getEntityList().get(i).getDetails().startsWith("Service")) {
                                        number++;
                                    }
                                }
                                System.out.println("2.Service " + number);
                                level3 = true;
                                while (level3) {
                                    System.out.println("-------------------------");
                                    System.out.println("Select Category you want to see\n");
                                        inps = scn.nextLine();
                                    try{
                                        inpint = Integer.parseInt(inps);
                                    }catch (NumberFormatException e)
                                    {
                                        System.out.println("Enter Again the value must be a number");
                                    }

                                    try {
                                        if (inpint == 1) {
                                            number = 0;
                                            for (int i = 0; i < org.getEntityList().size(); i++) {
                                                if (org.getEntityList().get(i).getDetails().startsWith("Material")) {
                                                    number++;
                                                    System.out.println(number + ". " + org.getEntityList().get(i).getName() + " (index " + i + " )");

                                                }

                                            }
                                            System.out.println("Please Select a material (input index)");
                                            inps = scn.nextLine();
                                            try{
                                                inpint = Integer.parseInt(inps);
                                            }catch (NumberFormatException e)
                                            {
                                                System.out.println("Enter Again the value must be a number");
                                            }

                                            System.out.println("Material " + org.getEntityList().get(inpint).getName() + " is chosen");
                                            System.out.println("Do you want to see the details or back to type selection (1/2)");

                                            String inps2 ;
                                            inps2 = scn.nextLine();
                                            int inpint2 =0;

                                            try{
                                                inpint2 = Integer.parseInt(inps2);
                                            }catch (NumberFormatException e)
                                            {
                                                System.out.println("Enter Again the value must be a number");
                                            }


                                            try {
                                                if (inpint2  == 1) {

                                                    System.out.println(org.getEntityList().get(inpint).getName() + " " + org.getEntityList().get(inpint).getDetails());
                                                    System.out.println("Do you want to make another selection or go back to menu (1/2)");
                                                    inps = scn.nextLine();
                                                    try{
                                                        inpint = Integer.parseInt(inps);
                                                    }catch (NumberFormatException e)
                                                    {
                                                        System.out.println("Enter Again the value must be a number");
                                                    }
                                                    try {
                                                        if (inpint ==  1) {
                                                            level3 = false;

                                                        } else if (inpint == 2) {
                                                            level3 = false;
                                                            level2 = false;
                                                        }else if (inpint >2 || inpint <=0)
                                                        {
                                                            throw new WrongSelectionException();
                                                        }
                                                    }
                                                    catch (WrongSelectionException e)
                                                    {
                                                        System.out.println(e.getMessage());
                                                    }

                                                } else if (inpint2  == 2) {
                                                    continue;
                                                }else if (inpint2 >2 || inpint2 <=0)
                                                {
                                                    throw new WrongSelectionException();
                                                }
                                            }
                                            catch (WrongSelectionException e) {
                                                System.out.println(e.getMessage());
                                            }
                                        } else if (inpint == 2) {
                                            number = 0;

                                            for (int i = 0; i < org.getEntityList().size(); i++) {

                                                if (org.getEntityList().get(i).getDetails().startsWith("Service")) {
                                                    number++;
                                                    System.out.println(number + ". " + org.getEntityList().get(i).getName() + " (index " + i + " )");
                                                }

                                            }
                                            System.out.println("Please Select a Service (input index)");
                                            inps = scn.nextLine();
                                            try{
                                                inpint = Integer.parseInt(inps);
                                            }catch (NumberFormatException e)
                                            {
                                                System.out.println("Enter Again the value must be a number");
                                            }

                                            System.out.println("Service " + org.getEntityList().get(inpint).getName() + " is chosen");

                                            level3 = true;

                                            while (level3) {

                                                System.out.println("Do you want to see the details or back to type selection (1/2)");

                                                String inps2 ;
                                                inps2 = scn.nextLine();
                                                int inpint2 =0;

                                                try{
                                                    inpint2 = Integer.parseInt(inps2);
                                                }catch (NumberFormatException e)
                                                {
                                                    System.out.println("Enter Again the value must be a number");
                                                }

                                                try {
                                                    if (inpint2 == 1) {

                                                        System.out.println(org.getEntityList().get(inpint).getName() + " " + org.getEntityList().get(inpint).getDetails());
                                                        System.out.println("Do you want to make another selection or go back to menu (1/2)");
                                                        inps = scn.nextLine();
                                                        try{
                                                            inpint = Integer.parseInt(inps);
                                                        }catch (NumberFormatException e)
                                                        {
                                                            System.out.println("Enter Again the value must be a number");
                                                        }

                                                        try {
                                                            if (inpint == 1) {
                                                                level3 = false;
                                                            } else if (inpint == 2) {
                                                                level3 = false;
                                                                level2 = false;
                                                            }else
                                                            {
                                                                throw new WrongSelectionException();
                                                            }
                                                        }catch (WrongSelectionException e)
                                                        {
                                                            System.out.println(e.getMessage());
                                                        }
                                                    } else if (inpint2 == 2) {
                                                        level3 = false;
                                                    }else if (inpint2 >2 || inpint2 <=0)
                                                    {
                                                        throw new WrongSelectionException();
                                                    }
                                                }catch (WrongSelectionException e)
                                                {
                                                    System.out.println(e.getMessage());
                                                }
                                            }
                                        }else if (inpint >2 || inpint <=0)
                                        {
                                            throw new WrongSelectionException();
                                        }
                                    }catch (WrongSelectionException e )
                                    {
                                        System.out.println(e.getMessage());
                                    }
                                }
                            }
                            break;
                        case 2:

                            level2 = true;

                            while (level2==true) {

                                System.out.println (" Choose from these three options");
                                System.out.println (" 1.List Beneficiaries");
                                System.out.println (" 2.List Donators");
                                System.out.println (" 3.Reset Beneficiaries receivedList");
                                System.out.println (" 4.GO Back to menu");
                                inps = scn.nextLine();

                                try{
                                    inpint = Integer.parseInt(inps);
                                }catch (NumberFormatException e)
                                {
                                    System.out.println("Enter Again the value must be a number");
                                }


                                try {
                                    if (inpint >4 || inpint<=0 )
                                    {
                                       throw new WrongSelectionException();
                                    }
                                }catch (WrongSelectionException e)
                                {
                                    System.out.println(e.getMessage());

                                }

                                switch (inpint) {

                                    case 1:

                                        level3=true;
                                        while (level3){
                                            org.listBeneficiaries();
                                            System.out.println("Please choose a beneficiary (input index)");
                                            String inps3 ;
                                            inps3 = scn.nextLine();
                                            int inpint1 =0;

                                            try{
                                                inpint1 = Integer.parseInt(inps3);
                                            }catch (NumberFormatException e)
                                            {
                                                System.out.println("Enter Again the value must be a number");
                                            }

                                            try{
                                                if(inpint1< 0 || inpint1>org.getDonatorList().size() )
                                                {
                                                    throw new  WrongSelectionException();
                                                }

                                            }catch (WrongSelectionException e) {
                                                System.out.println(e.getMessage());
                                            }

                                            System.out.println(org.getBeneficiaryList().get(inpint1).getName()+" is chosen");

                                            System.out.println("Do you want to see the benefits that he has received (1) or claer them all (2) or delete the beneficiary(3)? \n You can also go back to menu?  (1/2/3/4)");

                                            String inps2 ;
                                            inps2 = scn.nextLine();
                                            int inpint2 =0;

                                            try{
                                                inpint2 = Integer.parseInt(inps2);
                                            }catch (NumberFormatException e)
                                            {
                                                System.out.println("Enter Again the value must be a number");
                                            }

                                            try {
                                                if (inpint2  == 1){

                                                    for (int i = 0; i < org.getBeneficiaryList().get(inpint1).getReceivedList().size(); i++){
                                                        for (int j = 0; j<org.getBeneficiaryList().get(inpint1).getReceivedList().get(i).getRdEntities().size(); j++){
                                                            int number=0;
                                                            number++;
                                                            System.out.println(number + " "+org.getBeneficiaryList().get(inpint1).getReceivedList().get(i).getRdEntities().get(j).getName()+" "+
                                                                    org.getBeneficiaryList().get(inpint1).getReceivedList().get(i).getRdEntities().get(j).getQuantity());
                                                        }
                                                    }

                                                    level2 = false;

                                                }
                                                else if (inpint2  == 2){

                                                    System.out.println("Are you sure you want to delete the receivedList of this beneficiary (y/n)");

                                                    inps = scn.nextLine();

                                                    try {
                                                        if (inps.equals("Y")|| inps.equals("y"))
                                                        {
                                                            org.getBeneficiaryList().get(inpint1).getReceivedList().clear();

                                                        }else if (inps.equals("N")|| inps.equals("n"))
                                                        {
                                                            level2=false;

                                                        }else if (inps != "null")
                                                        {
                                                            throw new WrongSelectionException();
                                                        }
                                                    }catch (WrongSelectionException e)
                                                    {
                                                        System.out.println(e.getMessage());
                                                    }
                                                }
                                                else if (inpint2 == 3){
                                                   System.out.println("Are you sure you want to delete this beneficiary (y/n)");

                                                    inps = scn.nextLine();

                                                    try {
                                                        if (inps.equals("Y")|| inps.equals("y"))
                                                        {
                                                            org.removeBeneficiary(org.getBeneficiaryList().get(inpint1));

                                                        }else if (inps.equals("N")|| inps.equals("n"))
                                                        {
                                                            level3=false;
                                                        }else if (inps != "null")
                                                        {
                                                            throw new WrongSelectionException();
                                                        }
                                                    }catch (WrongSelectionException e)
                                                    {
                                                        System.out.println(e.getMessage());
                                                    }

                                                }else if (inpint2 == 4)
                                                {
                                                    level3 = false;
                                                }else if (inpint2 <1 || inpint2 >4)
                                                {
                                                    throw new WrongSelectionException();
                                                }
                                            }catch (WrongSelectionException e){
                                                System.out.println(e.getMessage());
                                            }
                                        }

                                        break;

                                    case 2:
                                        level3=true;
                                        while (level3){

                                            org.listDonators();
                                            System.out.println("Please choose one donator");
                                            inps = scn.nextLine();

                                            int inpint1 =0;

                                            try{
                                                inpint1 = Integer.parseInt(inps);
                                            }catch (NumberFormatException e)
                                            {
                                                System.out.println("Enter Again the value must be a number");
                                            }

                                            try{
                                                if(inpint1< 0 || inpint1>org.getDonatorList().size() )
                                                {
                                                    throw new  WrongSelectionException();
                                                }

                                            }catch (WrongSelectionException e) {
                                                System.out.println(e.getMessage());
                                            }

                                            System.out.println(org.getDonatorList().get(inpint1).getName()+" is chosen");

                                            System.out.println("Do you want to see the offers that he is willing to make or delete the donator?\nYou can also go back to menu? (1/2/3)");

                                            String inps6 ;

                                            inps6 = scn.nextLine();
                                            int inpint8 =0;

                                            try{
                                                inpint8 = Integer.parseInt(inps6);
                                            }catch (NumberFormatException e)
                                            {
                                                System.out.println("Enter Again the value must be a number");
                                            }

                                            try{
                                                if(inpint8 < 1 || inpint8 >3 )
                                                {
                                                    throw new  WrongSelectionException();
                                                }
                                            }  catch (WrongSelectionException e) {
                                                System.out.println(e.getMessage());
                                            }

                                            switch (inpint8 ){

                                                case 1 :
                                                    int number = 0;
                                                    if (org.getDonatorList().get(inpint1).getOffersList().isEmpty()){
                                                        System.out.println("There are no offers in the list");
                                                    }
                                                    for (int i = 0; i < org.getDonatorList().get(inpint1).getOffersList().size(); i++){
                                                        for (int j = 0; j<org.getDonatorList().get(inpint1).getOffersList().get(i).getRdEntities().size(); j++){
                                                            number = 0;
                                                            number++;
                                                            System.out.println(number + " "+org.getDonatorList().get(inpint1).getOffersList().get(i).getRdEntities().get(j).getName()+" "+
                                                                    org.getDonatorList().get(inpint1).getOffersList().get(i).getRdEntities().get(j).getQuantity());
                                                        }
                                                    }
                                                    System.out.println("Do you want to make another selection or go back to menu (1/2)");


                                                    inps = scn.nextLine();

                                                    try{
                                                        inpint = Integer.parseInt(inps);
                                                    }catch (NumberFormatException e)
                                                    {
                                                        System.out.println("Enter Again the value must be a number");
                                                    }


                                                    try{
                                                        if (inpint < 1 || inpint> 2){
                                                            throw new WrongSelectionException();
                                                        }
                                                    }catch (WrongSelectionException e){
                                                        System.out.println(e.getMessage());
                                                    }

                                                    if (inpint == 1){
                                                        continue;
                                                    }else if (inpint== 2){
                                                        level3 = false;
                                                        level2 = false;
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("Are you sure you want to delete this donator (y/n)");

                                                    inps = scn.nextLine();

                                                    try {
                                                        if (inps.equals("Y")|| inps.equals("y"))
                                                        {
                                                            System.out.println("The Donator has been removed");
                                                            org.removeDonator(org.getDonatorList().get(inpint1));
                                                            level3 =false;

                                                        }else if (inps.equals("N")|| inps.equals("n"))
                                                        {
                                                            level3=false;
                                                        }else if (inps != "null")
                                                        {
                                                            throw new WrongSelectionException();
                                                        }
                                                    }catch (WrongSelectionException e)
                                                    {
                                                        System.out.println(e.getMessage());
                                                    }

                                                   break;
                                                case 3:
                                                    continue;

                                            }

                                        }
                                        break;

                                    case 3:
                                        level3=true;
                                        while (level3)

                                        {
                                            System.out.println("Are you sure you want to delete all the received items from every Beneficiary (y/n)");
                                            inps = scn.nextLine();

                                            try {
                                                if (inps.equals("Y")|| inps.equals("y"))
                                                {
                                                    for (int i = 0; i<org.getBeneficiaryList().size(); i++)
                                                    {
                                                        org.getBeneficiaryList().get(i).ClearReceivedList();
                                                        System.out.println("All the received items from every Beneficiary are deleted");
                                                        level3 = false;
                                                    }
                                                }else if (inps.equals("N")|| inps.equals("n"))
                                                {
                                                    level3=false;
                                                }else if (inps != "null")
                                                {
                                                    throw new WrongSelectionException();
                                                }
                                            }catch (WrongSelectionException e)
                                            {
                                                System.out.println(e.getMessage());
                                            }

                                        }
                                        break;
                                    case 4:
                                        level2=false;

                                }
                            }

                            break;
                        case 3:

                            continue;
                        case 4:
                            this.menu(org,this.login(org));
                            level1 = false;
                            break;
                        case 5:
                            level1= false;
                            break;
                    }
                }


                break;
            case 2:
                Offers off = new Offers();
                while (level1){
                    System.out.println("Choose from these choices");
                    System.out.println("-------------------------\n");
                    System.out.println("1 - Add Offer");
                    System.out.println("2 - Show Offers");
                    System.out.println("3 - Commit");
                    System.out.println("4 - Back");
                    System.out.println("5 - Logout");
                    System.out.println("6 - Exit");
                    System.out.println("Please type in your answers");
                    inps = scn.nextLine();
                    inpint = 0;
                    try{
                        inpint = Integer.parseInt(inps);
                    }catch (NumberFormatException e)
                    {
                        System.out.println("Enter Again the value must be a number");
                    }



                    try{
                        if( inpint < 1 ||  inpint>6 )
                        {
                            throw new  WrongSelectionException();
                        }
                    }  catch (WrongSelectionException e) {
                        System.out.println(e.getMessage());
                    }

                    switch ( inpint){
                        case 1:
                            level2 = true;

                            while (level2){

                                RequestDonation rqd = new RequestDonation();
                                level3= true;
                                System.out.println("Material or Services (m/s)");
                                inps = scn.nextLine();
                                try{
                                    if (inps.equals("m") || inps.equals("M")){
                                        while (level3){
                                            System.out.println("-------------------------\n");

                                            int number = 0;
                                            for (int i = 0; i<org.getEntityList().size(); i++){
                                                if (org.getEntityList().get(i).getDetails().startsWith("Material")){
                                                    number++;
                                                    System.out.println(number +". "+org.getEntityList().get(i).getName()+"   "+ org.getEntityAmount(org.getEntityList().get(i).getID())+" (index "+i+" )");
                                                }
                                            }

                                            System.out.println("Please choose one material (input index from list)");
                                            String inps2 ;
                                            inps2 = scn.nextLine();
                                            int inpint2 =0;



                                            try{
                                                inpint2 = Integer.parseInt(inps2);
                                            }catch (NumberFormatException e)
                                            {
                                                System.out.println("Enter Again the value must be a number");

                                            }



                                            System.out.println("Material " + org.getEntityList().get(inpint2).getName()+ " is chosen\n"+

                                                    org.getEntityList().get(inpint2 ).getDetails()+"\nDo you want to make a donation? (y/n)");
                                            scn.nextLine();
                                            inps = scn.nextLine();

                                            try{
                                                if (inps.equals("y") || inps.equals("Y")){
                                                    System.out.println("Please provide the size of the donation");
                                                    inpd = scn.nextDouble();
                                                    scn.nextLine();
                                                    rqd.setEntityRd(org.getEntityList().get(inpint2));
                                                    rqd.modifyquantity(inpd);
                                                    System.out.println(rqd.getEntity() +" "+ rqd.getQuantity());
                                                    ((Donator)x).add(off, rqd, org);
                                                    //off.getRdEntities().clear();
                                                    System.out.println("Do you want to make an other an other offer or go back to the menu? (1/2)");
                                                    scn.nextLine();

                                                    inps2 = scn.nextLine();
                                                    inpint=2;
                                                    try{
                                                        inpint2 = Integer.parseInt(inps2);
                                                    }catch (NumberFormatException e)
                                                    {
                                                        System.out.println("Enter Again the value must be a number");
                                                    }

                                                    try{
                                                        if ( inpint2 < 1 ||  inpint2 > 2){
                                                            throw new WrongSelectionException();
                                                        }
                                                    }catch (WrongSelectionException e){
                                                        System.out.println(e.getMessage());
                                                    }
                                                    if ( inpint2== 1){
                                                        level3 = false;
                                                    }else if( inpint2 == 2){
                                                        level2 = false;
                                                        level3 = false;
                                                    }else {
                                                        level2 = false;
                                                        level3 = false;
                                                    }


                                                }else if (inps.equals("n") || inps.equals("N")){

                                                    System.out.println("Do you want to make an other an other offer or go back to the menu? (1/2)");
                                                    inps = scn.nextLine();
                                                    try{
                                                        inpint = Integer.parseInt(inps);
                                                    }catch (NumberFormatException e)
                                                    {
                                                        System.out.println("Enter Again the value must be a number");
                                                    }

                                                    try{
                                                        if (inpint < 1 || inpint > 2){
                                                            throw new WrongSelectionException();
                                                        }
                                                    }catch (WrongSelectionException e){
                                                        System.out.println(e.getMessage());
                                                    }
                                                    if (inpint== 1){
                                                        level3 = false;
                                                    }else if(inpint == 2){
                                                        level2 = false;
                                                        level3 = false;
                                                    }else {
                                                        level2 = false;
                                                        level3 = false;
                                                    }
                                                } else if (inps != "null"){

                                                    throw new WrongSelectionException();
                                                }
                                            }catch (WrongSelectionException e)
                                            {
                                                System.out.println(e.getMessage());
                                            }

                                        }
                                    }else if (inps.equals("s") || inps.equals("S")){

                                        System.out.println("-------------------------\n");
                                        int number = 0;
                                        for (int i = 0; i<org.getEntityList().size(); i++){
                                            if (org.getEntityList().get(i).getDetails().startsWith("Service")){
                                                number++;
                                                System.out.println(number +". "+org.getEntityList().get(i).getName()+"   "+ org.getEntityAmount(org.getEntityList().get(i).getID())+" (index "+i+" )");
                                            }
                                        }

                                        System.out.println("Please choose one service (input index from list)");

                                       // scn.nextLine();
                                        String inps2 ;
                                        inps2 = scn.next();
                                        int inpint2 =0;

                                        try{
                                            inpint2 = Integer.parseInt(inps2);
                                        }catch (NumberFormatException e)
                                        {
                                            System.out.println("Enter Again the value must be a number");

                                        }


                                        System.out.println("Service " + org.getEntityList().get(inpint2).getName()+ " is chosen\n"+
                                                org.getEntityList().get(inpint2).getDetails()+"\nDo you want to make a donation? (y/n)");
                                        scn.nextLine();
                                        inps = scn.nextLine();
                                        try{
                                            RequestDonation rqd2 = new RequestDonation();
                                            if (inps.equals("y") || inps.equals("Y")){
                                                System.out.println("Please provide the number of hours you want to provide");

                                                inpd = scn.nextDouble();
                                                Service srv = new Service();
                                                srv = (Service)org.getEntityList().get(inpint2);
                                                rqd2.setEntityRd(srv);
                                                rqd2.modifyquantity(inpd);
                                                ((Donator)x).add(off, rqd2, org);
                                                System.out.println("Do you want to make an other an other offer or go back to the menu? (1/2)");
                                                scn.nextLine();
                                                inps = scn.nextLine();

                                                try{
                                                    inpint = Integer.parseInt(inps);
                                                }catch (NumberFormatException e)
                                                {
                                                    System.out.println("Enter Again the value must be a number");
                                                }


                                                try{
                                                    if (inpint  < 1 || inpint  > 2){
                                                        throw new WrongSelectionException();
                                                    }
                                                }catch (WrongSelectionException e){
                                                    System.out.println(e.getMessage());
                                                }
                                                rqd2 = null;
                                                if (inpint  == 1){
                                                    level3 = false;
                                                }else if(inpint  == 2){
                                                    level2 = false;
                                                    level3 = false;
                                                }else {
                                                    level2 = false;
                                                    level3 = false;
                                                }


                                            }else if (inps.equals("n") || inps.equals("N")){
                                                System.out.println("Do you want to make an other an other offer or go back to the menu? (1/2)");

                                                inps = scn.nextLine();

                                                try{
                                                    inpint = Integer.parseInt(inps);
                                                }catch (NumberFormatException e)
                                                {
                                                    System.out.println("Enter Again the value must be a number");
                                                }


                                                try{
                                                    if (inpint < 1 || inpint > 2){
                                                        throw new WrongSelectionException();
                                                    }
                                                }catch (WrongSelectionException e){
                                                    System.out.println(e.getMessage());
                                                }
                                                if (inpint == 1){
                                                    level3 = false;
                                                }else if(inpint == 2){
                                                    level2 = false;
                                                    level3 = false;
                                                }else {
                                                    level2 = false;
                                                    level3 = false;
                                                }
                                            } else if (inps != "null"){
                                                throw new WrongSelectionException();
                                            }
                                        }catch (WrongSelectionException e)
                                        {
                                            System.out.println(e.getMessage());
                                        }

                                    } else if (inps != "null")
                                    {
                                        throw new WrongSelectionException();
                                    }

                                }catch (WrongSelectionException e)
                                {
                                    System.out.println(e.getMessage());
                                }

                            }
                            break;
                        case 2:
                            level2 = true;
                            while(level2){
                                int number = 0;
                                for (int i = 0; i<((Donator)x).getOffersList().size(); i++){
                                    for (int j = 0; j<((Donator)x).getOffersList().get(i).getRdEntities().size(); j++){
                                        number++;
                                        System.out.println( number+ " "+ ((Donator)x).getOffersList().get(i).getRdEntities().get(j).getEntity().getName() + " "+
                                                ((Donator)x).getDonationAmount(((Donator)x).getOffersList().get(i).getRdEntities().get(j).getEntity())+" (index "+i+" "+j+ " )" );
                                    }
                                }
                                System.out.println("You can delete or modify the offers on the screen (1/2)\nYou can also reset or commit all the present offers (3/4)\n You can also go back (5)");
                                inps = scn.nextLine();

                                try{
                                    inpint = Integer.parseInt(inps);
                                }catch (NumberFormatException e)
                                {
                                    System.out.println("Enter Again the value must be a number");
                                }


                                try{
                                    if (inpint < 1 || inpint > 5){
                                        throw new WrongSelectionException();
                                    }
                                }catch (WrongSelectionException e){
                                    System.out.println(e.getMessage());
                                }


                                switch (inpint){
                                    case 1:
                                        System.out.println("Please choose an offer to delete (input the index)\nFirst number");
                                        int r = scn.nextInt();
                                        System.out.println("Second number");
                                        int k = scn.nextInt();

                                        System.out.println("Offer " + ((Donator)x).getOffersList().get(r).getRdEntities().get(k).getEntity().getName()+ " is chosen\nDo you want to delete it? (y/n)");
                                        scn.nextLine();
                                        inps = scn.nextLine();
                                        try{
                                            if (inps.equals("y") || inps.equals("Y")){
                                                ((Donator)x).getOffersList().get(r).getRdEntities().remove(k);
                                                System.out.println("The offer is deleted\nDo you want to delete another offer or go back to the menu? (1/2)");

                                                inps = scn.nextLine();

                                                try{
                                                    inpint = Integer.parseInt(inps);
                                                }catch (NumberFormatException e)
                                                {
                                                    System.out.println("Enter Again the value must be a number");
                                                }


                                                try{
                                                    if (inpint < 1 || inpint> 2){
                                                        throw new WrongSelectionException();
                                                    }

                                                }catch (WrongSelectionException e){
                                                    System.out.println(e.getMessage());
                                                }
                                                if (inpint == 1){
                                                    continue;
                                                }else if(inpint == 2){
                                                    level2 = false;
                                                }else {
                                                    level2 = false;
                                                }

                                            }else if (inps.equals("n") || inps.equals("N")){
                                                System.out.println("Do you want to delete another offer or go back to the menu? (1/2)");

                                                inps = scn.nextLine();
                                                try{
                                                    inpint = Integer.parseInt(inps);
                                                }catch (NumberFormatException e)
                                                {
                                                    System.out.println("Enter Again the value must be a number");
                                                }


                                                try{
                                                    if (inpint< 1 || inpint > 2){
                                                        throw new WrongSelectionException();
                                                    }
                                                }catch (WrongSelectionException e){
                                                    System.out.println(e.getMessage());
                                                }
                                                if (inpint == 1){
                                                    continue;
                                                }else if(inpint == 2){
                                                    level2 = false;
                                                }else {
                                                    level2 = false;
                                                }

                                            }  else if (inps != "null")
                                            {
                                                throw new WrongSelectionException();
                                            }

                                        }catch (WrongSelectionException e)
                                        {
                                            System.out.println(e.getMessage());
                                        }

                                        break;
                                    case 2:
                                        System.out.println("Please choose an offer to delete (input the index)\nFirst number");
                                        int r1 = scn.nextInt();
                                        System.out.println("Second number");
                                        int k1 = scn.nextInt();
                                        System.out.println("Offer " + ((Donator)x).getOffersList().get(r1).getRdEntities().get(k1).getEntity().getName()+ " is chosen\nDo you want to modify it? (y/n)");
                                        scn.nextLine();
                                        inps = scn.nextLine();

                                        try{
                                            if (inps.equals("y") || inps.equals("Y")){
                                                System.out.println("Please provide the new quantity");
                                                inpd = scn.nextDouble();
                                                ((Donator)x).getOffersList().get(r1).modify(((Donator)x).getOffersList().get(r1).getRdEntities().get(k1).getEntity().getID(), inpd, x, org);
                                                System.out.println("The offer is modified\nDo you want to modify another offer or go back to the menu? (1/2)");

                                                scn.nextLine();
                                                inps = scn.nextLine();

                                                try{
                                                    inpint = Integer.parseInt(inps);
                                                }catch (NumberFormatException e)
                                                {
                                                    System.out.println("Enter Again the value must be a number");
                                                }

                                                try{
                                                    if (inpint< 1 || inpint > 2){
                                                        throw new WrongSelectionException();
                                                    }
                                                }catch (WrongSelectionException e){
                                                    System.out.println(e.getMessage());
                                                }

                                                if (inpint == 1){
                                                    continue;
                                                }else if(inpint== 2){
                                                    level2 = false;
                                                }else {
                                                    level2 = false;
                                                }
                                            }else if (inps.equals("n") || inps.equals("N")){
                                                System.out.println("Do you want to modify another offer or go back to the menu? (1/2)");


                                                scn.nextLine();
                                                inps = scn.nextLine();

                                                try{
                                                    inpint = Integer.parseInt(inps);
                                                }catch (NumberFormatException e)
                                                {
                                                    System.out.println("Enter Again the value must be a number");
                                                }

                                                try{
                                                    if (inpint < 1 || inpint > 2){
                                                        throw new WrongSelectionException();
                                                    }
                                                }catch (WrongSelectionException e){
                                                    System.out.println(e.getMessage());
                                                }
                                                if (inpint == 1){
                                                    continue;
                                                }else if(inpint == 2){
                                                    level2 = false;
                                                }else {
                                                    level2 = false;
                                                }

                                            } else if (inps != "null")
                                            {
                                                throw new WrongSelectionException();
                                            }
                                        }catch (WrongSelectionException e){

                                            System.out.println(e.getMessage());
                                        }


                                        break;
                                    case 3:
                                        System.out.println("Are you sure that you want to delete all the offers? (y/n)");
                                        scn.nextLine();
                                        inps = scn.nextLine();
                                        try{
                                            if (inps.equals("y") || inps.equals("Y")){
                                                ((Donator)x).getOffersList().clear();
                                                off.getRdEntities().clear();
                                                System.out.println("The offers have been deleted (press enter)");
                                                inps = scn.nextLine();
                                                level2 = false;

                                            }else if (inps.equals("n") || inps.equals("N")){
                                                System.out.println("Do you want to modify another offer or go back to the menu? (1/2)");
                                                inps = scn.nextLine();

                                                try{
                                                    inpint = Integer.parseInt(inps);
                                                }catch (NumberFormatException e)
                                                {
                                                    System.out.println("Enter Again the value must be a number");
                                                }

                                                try{
                                                    if (inpint < 1 || inpint > 2){
                                                        throw new WrongSelectionException();
                                                    }
                                                }catch (WrongSelectionException e){
                                                    System.out.println(e.getMessage());
                                                }
                                                if (inpint == 1){
                                                    continue;
                                                }else if(inpint == 2){
                                                    level2 = false;
                                                }else {
                                                    level2 = false;
                                                }

                                            }else if (inps != "null")
                                            {
                                                    throw new WrongSelectionException();
                                            }
                                        }catch (WrongSelectionException e)
                                        {
                                            System.out.println(e.getMessage());
                                        }

                                        break;
                                    case 4:
                                        System.out.println("Are you sure you want to commit these offers (y/n)");
                                        scn.nextLine();
                                        inps = scn.nextLine();
                                        try{
                                            if (inps.equals("y") || inps.equals("Y")){
                                                ((Donator)x).commit(org);
                                                System.out.println("The offers have been committed (press enter)");
                                                inps = scn.nextLine();
                                                level2 = false;

                                            }else if (inps.equals("n") || inps.equals("N")){
                                                System.out.println("Do you want to modify another offer or go back to the menu? (1/2)");
                                                inps = scn.nextLine();
                                                try{
                                                    inpint = Integer.parseInt(inps);
                                                }catch (NumberFormatException e)
                                                {
                                                    System.out.println("Enter Again the value must be a number");
                                                }


                                                try{
                                                    if (  inpint < 1 ||  inpint > 2){
                                                        throw new WrongSelectionException();
                                                    }
                                                }catch (WrongSelectionException e){
                                                    System.out.println(e.getMessage());
                                                }
                                                if (  inpint == 1){
                                                    continue;
                                                }else if(  inpint == 2){
                                                    level2 = false;
                                                }else {
                                                    level2 = false;
                                                }

                                            }else if (inps != "null")
                                            {
                                                throw new WrongSelectionException();
                                            }
                                        }catch (WrongSelectionException e){
                                            System.out.println(e.getMessage());
                                        }
                                        break;
                                    case 5:
                                        level2 = false;
                                        break;

                                }
                            }
                            break;
                        case 3:
                            System.out.println("Are you sure you want to commit all offers (y/n)");

                            inps = scn.nextLine();;
                            try{
                                if (inps.equals("y") || inps.equals("Y")){
                                    ((Donator)x).commit(org);
                                    System.out.println("The offers have been committed (press enter)");
                                    inps = scn.nextLine();
                                    level2 = false;

                                }else if (inps.equals("n") || inps.equals("N")) {
                                    continue;
                                } else if (inps != "null")
                                {
                                    throw new WrongSelectionException();
                                }
                            }catch (WrongSelectionException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 4:
                            continue;
                        case 5:
                            this.menu(org,this.login(org));
                            level1 = false;
                            break;
                        case 6:
                            level1= false;
                            break;
                    }
                }


                break;
            case 3:
                Requests rq = new Requests();
                while (level1){
                    System.out.println("Choose from these choices");
                    System.out.println("-------------------------\n");
                    System.out.println("1 - Add Request");
                    System.out.println("2 - Show Requests");
                    System.out.println("3 - Commit");
                    System.out.println("4 - Back");
                    System.out.println("5 - Logout");
                    System.out.println("6 - Exit");
                    System.out.println("Please type in your answers");
                    inps = scn.nextLine();
                    inpint = 0;
                    try{
                        inpint = Integer.parseInt(inps);
                    }catch (NumberFormatException e)
                    {
                        System.out.println("Enter Again the value must be a number");
                    }

                    try{
                        if( inpint < 1 ||  inpint>6 )
                        {
                            throw new  WrongSelectionException();
                        }
                    }  catch (WrongSelectionException e) {
                        System.out.println(e.getMessage());
                    }

                    switch (inpint){

                        case 1:
                            level2 = true;
                            while (level2){

                                RequestDonation rqd3 = new RequestDonation();
                                System.out.println("Material or Services (m/s)");
                                inps = scn.nextLine();

                                try {
                                    if (inps.equals("m") || inps.equals("M")){
                                        int number = 0;
                                        System.out.println("-------------------------\n");
                                        for (int i = 0; i<org.getEntityList().size(); i++){
                                            if (org.getEntityList().get(i).getDetails().startsWith("Material")){
                                                number++;
                                                System.out.println(number +". "+org.getEntityList().get(i).getName()+"   "+ org.getEntityAmount(org.getEntityList().get(i).getID())+" (index "+i+" )");
                                            }
                                        }
                                        System.out.println("Please choose one material (input index from list)");
                                        inps = scn.nextLine();

                                        inpint =0;
                                        try{
                                            inpint = Integer.parseInt(inps);
                                        }catch (NumberFormatException e)
                                        {
                                            System.out.println("Enter Again the value must be a number");
                                        }

                                        System.out.println("Material " + org.getEntityList().get(inpint).getName()+ " is chosen\n"+
                                                org.getEntityList().get(inpint).getDetails()+"\nDo you want to make a request? (y/n)");
                                       scn.nextLine();
                                        inps = scn.nextLine();
                                        try {
                                            if (inps.equals("y") || inps.equals("Y")){
                                                System.out.println("Please provide the size of the request");
                                                inpd = scn.nextDouble();
                                                rqd3.modifyquantity(inpd);
                                                rqd3.setEntityRd(org.getEntityList().get(inpint));
                                                ((Beneficiary)x).add(rq, rqd3, org);
                                                System.out.println("Do you want to make another request or go back to the menu? (1/2)");
                                                scn.nextLine();
                                                inps = scn.nextLine();
                                                rqd3 = null;

                                                try{
                                                    inpint = Integer.parseInt(inps);
                                                }catch (NumberFormatException e)
                                                {
                                                    System.out.println("Enter Again the value must be a number");
                                                }

                                                try{
                                                    if(inpint >2 || inpint<1 ) {
                                                        int a = Integer.parseInt("inp");
                                                        throw new WrongSelectionException();
                                                    }
                                                }catch (WrongSelectionException e)
                                                {
                                                    System.out.println(e.getMessage());
                                                }

                                                if (inpint == 1){
                                                    level3 = false;
                                                }else if(inpint == 2){
                                                    level2 = false;
                                                    level3 = false;
                                                }else {
                                                    level2 = false;
                                                    level3 = false;
                                                }


                                            }else if (inps.equals("n") || inps.equals("N")){
                                                rqd3 = null;
                                                System.out.println("Do you want to make another request or go back to the menu? (1/2)");
                                                scn.nextLine();
                                                inps = scn.nextLine();

                                                try{
                                                    inpint = Integer.parseInt(inps);
                                                }catch (NumberFormatException e)
                                                {
                                                    System.out.println("Enter Again the value must be a number");
                                                }

                                                try{
                                                    if(inpint >2 || inpint<1 ) {
                                                        int a = Integer.parseInt("inp");
                                                        throw new WrongSelectionException();
                                                    }
                                                }catch (WrongSelectionException e)
                                                {
                                                    System.out.println(e.getMessage());
                                                }

                                                if (inpint  == 1){
                                                    level3 = false;
                                                }else if(inpint  == 2){
                                                    level2 = false;
                                                    level3 = false;
                                                }else {
                                                    level2 = false;
                                                    level3 = false;
                                                }
                                            }else if (inps != "null"){

                                                throw new WrongSelectionException();
                                            }
                                        }catch (WrongSelectionException e)
                                        {
                                            System.out.println(e.getMessage());
                                        }

                                    }else if (inps.equals("s") || inps.equals("S")) {
                                        System.out.println("-------------------------\n");
                                        int number = 0;
                                        for (int i = 0; i < org.getEntityList().size(); i++) {
                                            if (org.getEntityList().get(i).getDetails().startsWith("Service")) {
                                                number++;
                                                System.out.println(number + ". " + org.getEntityList().get(i).getName() + "   " + org.getEntityAmount(org.getEntityList().get(i).getID())+ " (index "+ i+" )");
                                            }
                                        }
                                        System.out.println("Please choose one service (input index from list)");
                                        inps = scn.nextLine();

                                        inpint =0;
                                        try{
                                            inpint = Integer.parseInt(inps);
                                        }catch (NumberFormatException e)
                                        {
                                            System.out.println("Enter Again the value must be a number");
                                        }

                                        inp = scn.nextInt();
                                        System.out.println("Service " + org.getEntityList().get(inpint).getName() + " is chosen\n" +
                                                org.getEntityList().get(inpint).getDetails() + "\nDo you want to make a request? (y/n)");
                                        scn.nextLine();
                                        inps = scn.nextLine();

                                        try {
                                            if (inps.equals("y") || inps.equals("Y")){
                                                System.out.println("Please provide the number of hours requested");

                                                inpd = scn.nextDouble();
                                                rqd3.modifyquantity(inpd);
                                                rqd3.setEntityRd(org.getEntityList().get(inp));
                                                ((Beneficiary)x).add(rq, rqd3, org);
                                                System.out.println(((Beneficiary)x).getRequestsList().get(0).getRdEntities().get(0).getName());
                                                System.out.println("Do you want to make an other another request or go back to the menu? (1/2)");
                                                rqd3 = null;
                                                scn.nextLine();
                                                inps = scn.nextLine();
                                                try{
                                                    inpint = Integer.parseInt(inps);
                                                }catch (NumberFormatException e)
                                                {
                                                    System.out.println("Enter Again the value must be a number");
                                                }

                                                try{
                                                    if(inpint >2 || inpint<1 ) {
                                                        throw new WrongSelectionException();
                                                    }
                                                }catch (WrongSelectionException e)
                                                {
                                                    System.out.println(e.getMessage());
                                                }


                                                if ( inpint == 1){
                                                    level3 = false;
                                                }else if( inpint == 2){
                                                    level2 = false;
                                                    level3 = false;
                                                }else {
                                                    level2 = false;
                                                    level3 = false;
                                                }


                                            }else if (inps.equals("n") || inps.equals("N")){
                                                rqd3 = null;
                                                System.out.println("Do you want to make an other another request or go back to the menu? (1/2)");
                                                inps = scn.nextLine();

                                                try{
                                                    inpint = Integer.parseInt(inps);
                                                }catch (NumberFormatException e)
                                                {
                                                    System.out.println("Enter Again the value must be a number");
                                                }

                                                try{
                                                    if(inpint >2 || inpint<1 ) {
                                                        throw new WrongSelectionException();
                                                    }
                                                }catch (WrongSelectionException e)
                                                {
                                                    System.out.println(e.getMessage());
                                                }

                                                if (inpint== 1){
                                                    level3 = false;
                                                }else if(inpint== 2){
                                                    level2 = false;
                                                    level3 = false;
                                                }else {
                                                    level2 = false;
                                                    level3 = false;
                                                }

                                            }else if (inps != "null")
                                            {
                                                throw new WrongSelectionException();
                                            }
                                        }catch (NumberFormatException e)
                                        {
                                            System.out.println("Enter Again the value must be a number");
                                        }

                                    }else if (inps != "null")
                                    {
                                        throw new WrongSelectionException();
                                    }
                                }catch (WrongSelectionException e){
                                    System.out.println(e.getMessage());
                                }

                            }

                            break;
                        case 2:
                            level2 = true;
                            while (level2){
                                System.out.println("-------------------------\n");
                                int number = 0;
                                for (int i = 0; i<((Beneficiary)x).getRequestsList().size(); i++){
                                    for (int j = 0; j<((Beneficiary)x).getRequestsList().get(i).getRdEntities().size(); j++){
                                        number++;
                                        System.out.println(number+" "+((Beneficiary)x).getRequestsList().get(i).getRdEntities().get(j).getName()+" "+ ((Beneficiary)x).getRequestsList().get(i).getRdEntities().get(j).getQuantity()+ " (index "+
                                                i+" "+j+" )");
                                    }
                                }

                                System.out.println("You can delete or modify the requests on the screen (1/2)\nYou can also reset or commit all the present requests (3/4)\n You can also go back (5)");

                                inps = scn.nextLine();
                                inpint = 0;
                                try{
                                    inpint = Integer.parseInt(inps);
                                }catch (NumberFormatException e)
                                {
                                    System.out.println("Enter Again the value must be a number");
                                }

                                try{
                                    if( inpint < 1 ||  inpint>5 )
                                    {
                                        throw new  WrongSelectionException();
                                    }
                                }  catch (WrongSelectionException e) {
                                    System.out.println(e.getMessage());
                                }


                                switch (inpint){
                                    case 1:
                                        System.out.println("Please choose a request to delete (input the index)\nFirst number");
                                        int r = scn.nextInt();

                                        System.out.println("Second number");

                                        int k = scn.nextInt();

                                        System.out.println("Request " + ((Beneficiary)x).getRequestsList().get(r).getRdEntities().get(k).getEntity().getName()+ " is chosen\nDo you want to delete it? (y/n)");
                                        scn.nextLine();
                                        inps = scn.nextLine();

                                        try {
                                            if (inps.equals("y") || inps.equals("Y")){
                                                ((Beneficiary)x).getRequestsList().get(r).getRdEntities().remove(k);
                                                System.out.println("The requests is deleted\nDo you want to delete another an other offer or go back to the menu? (1/2)");

                                                inps = scn.nextLine();

                                                try{
                                                    inpint = Integer.parseInt(inps);
                                                }catch (NumberFormatException e)
                                                {
                                                    System.out.println("Enter Again the value must be a number");
                                                }

                                                try{
                                                    if(inpint >2 || inpint<1 ) {
                                                        int a = Integer.parseInt("inp");
                                                        throw new WrongSelectionException();
                                                    }
                                                }catch (WrongSelectionException e)
                                                {
                                                    System.out.println(e.getMessage());
                                                }

                                                    if (inpint == 1){
                                                        continue;
                                                    }else if(inpint == 2){
                                                        level2 = false;
                                                    }else {
                                                        level2 = false;
                                                    }

                                            }else if (inps.equals("n") || inps.equals("N")){
                                                System.out.println("Do you want to delete another request or go back to the menu? (1/2)");


                                                inps = scn.nextLine();

                                                try{
                                                    inpint = Integer.parseInt(inps);
                                                }catch (NumberFormatException e)
                                                {
                                                    System.out.println("Enter Again the value must be a number");
                                                }

                                                try{
                                                    if(inpint >2 || inpint<1 ) {
                                                        int a = Integer.parseInt("inp");
                                                        throw new WrongSelectionException();
                                                    }
                                                }catch (WrongSelectionException e)
                                                {
                                                    System.out.println(e.getMessage());
                                                }

                                                if (inpint == 1){
                                                    continue;
                                                }else if(inpint == 2){
                                                    level2 = false;
                                                }else {
                                                    level2 = false;
                                                }

                                            }else if (inps != "null")
                                            {
                                                throw new WrongSelectionException();
                                            }
                                        }catch (WrongSelectionException e) {
                                            System.out.println(e.getMessage());
                                        }

                                        break;
                                    case 2:
                                        System.out.println("Please choose a request to modify (input the index)\nFirst number");
                                        int r1 = scn.nextInt();
                                        System.out.println("Second number");
                                        int k1 = scn.nextInt();
                                        System.out.println("Request " + ((Beneficiary)x).getRequestsList().get(r1).getRdEntities().get(k1).getEntity().getName()+ " is chosen\nDo you want to modify it? (y/n)");
                                        scn.nextLine();
                                        inps = scn.nextLine();
                                        try {
                                            if (inps.equals("y") || inps.equals("Y")){
                                                System.out.println("Please provide the new quantity");
                                                inpd = scn.nextDouble();
                                                ((Beneficiary)x).getRequestsList().get(r1).modify(((Beneficiary)x).getRequestsList().get(r1).getRdEntities().get(k1).getEntity().getID(), inpd, x, org);
                                                System.out.println("The Request is modified\nDo you want to modify another request or go back to the menu? (1/2)");

                                                scn.nextLine();
                                                inps = scn.nextLine();

                                                try{
                                                    inpint = Integer.parseInt(inps);
                                                }catch (NumberFormatException e)
                                                {
                                                    System.out.println("Enter Again the value must be a number");
                                                }

                                                try{
                                                    if(inpint >2 || inpint<1 ) {
                                                        int a = Integer.parseInt("inp");
                                                        throw new WrongSelectionException();
                                                    }
                                                }catch (WrongSelectionException e)
                                                {
                                                    System.out.println(e.getMessage());
                                                }

                                                if (inpint == 1){
                                                    continue;
                                                }else if(inpint == 2){
                                                    level2 = false;
                                                }else {
                                                    level2 = false;
                                                }
                                            }else if (inps.equals("n") || inps.equals("N")){
                                                System.out.println("Do you want to modify another request or go back to the menu? (1/2)");

                                                inps = scn.nextLine();
                                                try{
                                                    inpint = Integer.parseInt(inps);
                                                }catch (NumberFormatException e)
                                                {
                                                    System.out.println("Enter Again the value must be a number");
                                                }

                                                try{
                                                    if(inpint >2 || inpint<1 ) {
                                                        throw new WrongSelectionException();
                                                    }
                                                }catch (WrongSelectionException e)
                                                {
                                                    System.out.println(e.getMessage());
                                                }

                                                if (inpint == 1){
                                                    continue;
                                                }else if(inpint == 2){
                                                    level2 = false;
                                                }else {
                                                    level2 = false;
                                                }

                                            }else if (inps != "null")
                                            {
                                                throw new WrongSelectionException();
                                            }
                                        }catch (WrongSelectionException e) {
                                            System.out.println(e.getMessage());
                                        }

                                        break;
                                    case 3:

                                        System.out.println("Are you sure that you want to delete all the requests (y/n)");
                                        inps = scn.nextLine();


                                        try {

                                            if (inps.equals("y") || inps.equals("Y")){
                                                ((Beneficiary)x).getRequestsList().clear();
                                                rq.getRdEntities().clear();
                                                System.out.println("The requests have been deleted (press enter)");
                                                inps = scn.nextLine();
                                                level2 = false;

                                            }else if (inps.equals("n") || inps.equals("N")){
                                                System.out.println("Do you want to modify another request or go back to the menu? (1/2)");

                                                inps = scn.nextLine();
                                                try{
                                                    inpint = Integer.parseInt(inps);
                                                }catch (NumberFormatException e)
                                                {
                                                    System.out.println("Enter Again the value must be a number");
                                                }

                                                try{
                                                    if(inpint >2 || inpint<1 ) {
                                                        throw new WrongSelectionException();
                                                    }
                                                }catch (WrongSelectionException e)
                                                {
                                                    System.out.println(e.getMessage());
                                                }

                                                if (inpint == 1){
                                                    continue;
                                                }else if(inpint == 2){
                                                    level2 = false;
                                                }else {
                                                    level2 = false;
                                                }

                                            }else if (inps != "null")
                                            {
                                                throw new WrongSelectionException();
                                            }
                                        }catch (WrongSelectionException e) {
                                            System.out.println(e.getMessage());
                                        }

                                        break;
                                    case 4:
                                        System.out.println("Are you sure you want to commit these requests (y/n)");
                                        inps = scn.nextLine();
                                        try {
                                            if (inps.equals("y") || inps.equals("Y")){
                                                ((Beneficiary)x).commit(org);
                                                System.out.println("The requests have been committed (press enter)");
                                                inps = scn.nextLine();
                                                level2 = false;

                                            }else if (inps.equals("n") || inps.equals("N")){
                                                System.out.println("Do you want to modify another request or go back to the menu? (1/2)");

                                                inps = scn.nextLine();
                                                try{
                                                    inpint = Integer.parseInt(inps);
                                                }catch (NumberFormatException e)
                                                {
                                                    System.out.println("Enter Again the value must be a number");
                                                }

                                                try{
                                                    if(inpint >2 || inpint<1 ) {
                                                        int a = Integer.parseInt("inp");
                                                        throw new WrongSelectionException();
                                                    }
                                                }catch (WrongSelectionException e)
                                                {
                                                    System.out.println(e.getMessage());

                                                }
                                                if (inpint == 1){
                                                    continue;
                                                }else if(inpint == 2){
                                                    level2 = false;
                                                }else {
                                                    level2 = false;
                                                }

                                            }else if (inps != "null")
                                            {
                                                throw new WrongSelectionException();
                                            }
                                        }catch (WrongSelectionException e) {
                                            System.out.println(e.getMessage());
                                        }

                                        break;
                                    case 5:
                                        level2 = false;
                                        break;
                                }

                            }
                            break;
                        case 3:
                            System.out.println("Are you sure you want to commit all the requests (y/n)");
                            scn.nextLine();
                            inps = scn.nextLine();;

                            try {
                                if (inps.equals("y") || inps.equals("Y")){
                                    ((Beneficiary)x).commit(org);
                                    rq.getRdEntities().clear();
                                    System.out.println("The requests have been committed (press enter)");
                                    inps = scn.nextLine();
                                    level2 = false;

                                }else if (inps.equals("n") || inps.equals("N")) {
                                    continue;
                                }else if (inps != "null")
                                {
                                    throw new WrongSelectionException();
                                }

                            }catch (WrongSelectionException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 4:
                            continue;

                        case 5:
                            this.menu(org,this.login(org));
                            level1 = false;
                            break;
                        case 6:

                            level1= false;
                            break;
                    }
                }
                break;
        }
    }

}
