/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiclerentalsystem;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Scanner;
import java.io.*;
//import java.text.ParseException;
//import java.time.LocalDateTime;

/**
 *
 * @author sharjeel sultan
 */
public class VehicleRentalSystem {
Vehicle newVehicle = new Vehicle();
	 vehicleAddition vadd = new vehicleAddition();
	 customerRegistration newCust = new customerRegistration();
	 Dated thedate = new Dated();
	 ReturnVehicle vret = new ReturnVehicle();
	//boolean log = false;                      //for checking purpose
	 ArrayList<customerRegistration> cList = new ArrayList<>();
	

    static Scanner in = new Scanner(System.in);
	public static int login(){
		
	//boolean log = false;
        System.out.print(" Enter user name => ");
        String userName = in.nextLine();

        System.out.print(" Enter password => ");
        String password = in.nextLine();

        if ("sharjeel".equals(userName) && "p123".equals(password)) {
            System.out.println("\n"+" User successfully logged-in.. "+"\n"+"\n"+"\n");
            return 1;
            //  log =true;
        } else {
            System.out.println("\n"+" In valid userName of password "+"\n");
            return 0;
            // log=false;
        }
    }
    
	public static void menu() {                                  //menu method
        System.out.println("----------------------------");
        System.out.println("Welcome to Vehicle Rental System!");
        System.out.println("----------------------------");
        System.out.println("Please enter a number to make your Selection accordingly");
        System.out.println("1. Add  Vehicle"); //add inventry
        System.out.println("2. VGarage"); //order item
        System.out.println("3. Book Vehicle"); //Show Inventory
        System.out.println("4. Return Vehicle"); //Show Orders
        System.out.println("5. Show Customers");
        System.out.println("6. Exit System");
        System.out.println("");
        System.out.print("> ");
    }
	
	void vplus(String name, String type, String make,  String model, double rateperday,boolean x) {
	
    	Vehicle nwvec = new Vehicle( name,  type,  make,  model,  rateperday, x);
    	System.out.println("________________________________________________");
    	System.out.print("\n"+" ~~~ New Vehicle has been successfully added ~~~"+"\n"+"\n");
    	System.out.println(nwvec.toString());
    	
    	vadd.vList.add(nwvec);
	}

    public String vehicleList() {
    	return
        ("Enter a proper number accordingly to add Vehicle from the following categories"+"\n"+"1. Van/bus"+"\n"+"2. Luxury"+"\n"+"3. Casual");    
    }

    public void customerCreation(String cname, String address, String cnic, Vehicle assignedVehicle, Date datebegin)
    {
    	customerRegistration newCustomer= new customerRegistration(cname, address, cnic,assignedVehicle,datebegin);
    	cList.add(newCustomer);
    	
    }
    //
    //
    //
    //////////// main fuction
    //
    //
    //

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        VehicleRentalSystem vren = new VehicleRentalSystem();
		
		//Vehicle v1 = new Vehicle("","","","",9,true);
		vren.vadd.defaultVehicle();
		Date curDate;
		Date RentDate;
		int swval;
		String name;
		String type;
		String make;
		String model;
		double rateperday;
		Vehicle assignedVehicle;
		Date datebegin;
		//boolean available;

		 int x =2;
	        while(x!=1)           
	        x=login();
		
	        do {
	        menu();
	        
	        swval = in.nextInt();
	        
	        switch(swval)   //switch value
	        {
	        case 1 :
	        	
	        	System.out.print("Enter Vehicle Name: ");
	        	name = in.next();
	        	//vren.newVehicle.setname(name);
	         
	        	System.out.println("Enter Type:       ");
	        	//vren.vadd.vTypeList();
	        	System.out.println(vren.vehicleList());
	        	type = in.next();
	        	if("1".equals(type)) {
	        		type = "van/bus";
	        	}

	        	else if("2".equals(type)) {
	        		type="Luxury";
	        	}

	        	else if("3".equals(type)) {
	        		type="Casual";
	        	}
	        	else {
	        		type="casual";
	        	}
	        	//vren.newVehicle.settype(type);
		        
	        	System.out.print("Enter body Make:    ");
	        	make = in.next();
	        	//vren.newVehicle.setmake(make);
		        
	        	System.out.print("Enter Model:        ");
	        	model = in.next();
	        	//vren.newVehicle.setmodel(model);
		    
	        	System.out.print("Enter Rate per Day: ");
	        	rateperday = in.nextDouble();
	        	//vren.newVehicle.setrate(rateperday);
	        
	    
	        	//Vehicle nwvec = new Vehicle(name, type, make,model,rateperday,true);
	        	/*
	        	System.out.println("________________________________________________");
	        	System.out.print(" ~~~ New Vehicle has been successfully added ~~~"+"\n");
	        	System.out.println(vren.newVehicle.toString());
	        */
	        	vren.vplus(name,type,make,model,rateperday,true);
	        	//vren.vadd.vList.add(vren.newVehicle);
	        	break;
	        	
	        case 2: 
	        	
	        	System.out.println("\n"+"                   V R E N T A L    G A R A G E                    ");
	        	System.out.println("______________________________________________________________________");
	        	for(int i = 0; i< vren.vadd.vList.size(); i++)
		        {
		            System.out.print(i+1 + "." + "\n");
		            System.out.println(vren.vadd.vList.get(i));
		        }
	        	break;
	        	
	                          			//  r e g i s t e r i n g    c u s t o m e r  &  v e h i c l e
	        	
	        case 3:         
	        	
	        	System.out.println("REGISTER THE CUSTOMER FIRST "+"\n");
	        	
	        	System.out.print("Enter cutomer's full name: ");
	        	String cname = in.next();
	        	//vren.newCust.setcname(cname);
	        	
	        	System.out.print("Enter customer's address:  ");
	        	String address = in.next();
	        	//vren.newCust.setaddress(address);
	        	
	        	System.out.print("Enter customer's cnic:     ");
	        	String cnic = in.next();
	        	//vren.newCust.setcnic(cnic);
	        		        	
	        	datebegin = new Date();
	        	//vren.newCust.assignedVehicle = null;  //not yet assigned

	        	System.out.println(" === customer registered successfully === ");
	        	System.out.println("");
	        	System.out.println("~~~~~~~~~ WELCOME TO OUR GARAGE  ~~~~~~~~");
	        	System.out.println("_________________________________________");
	        	
	        	System.out.println("You can choose a vehicle among following");
	        	System.out.println("");
	        	for(int i = 0; i< vren.vadd.vList.size(); i++)
		        {
		            System.out.print(i+1 + "." + "\n");
		            System.out.println(vren.vadd.vList.get(i));
		        }
	        	
	        	System.out.println("");
	        	System.out.print("enter a Vehicle number to select your desired vehicle : ");
	        	
	        	int selected = in.nextInt();
	        	assignedVehicle = vren.vadd.vList.get(selected-1);
	        	vren.vadd.vList.remove(selected-1);
	        	System.out.println(assignedVehicle.toString());
	        	System.out.println("Dated: "+vren.newCust.showDB()+"\n"+"\n");
	        	
	        	vren.customerCreation(cname,address,cnic,assignedVehicle,datebegin);
		
	        	break;
	        	
	        case 4 : 
	        	for(int i =0; i<vren.cList.size();i++)
	        	{
	        		System.out.print(i+1 + ": ");
	        		System.out.println(vren.cList.get(i));
	        	}
	        	int y = in.nextInt();
	        	y--;
	        	vren.vadd.vList.add(vren.cList.get(y).assignedVehicle);
	        	
	        	
	        	curDate = new Date();
	        	RentDate = vren.cList.get(y).datebegin;
	        	
	        	System.out.println("\n"+"================"+" V R E N T A L    I N V O I C E : "+" ================"+"\n"+"\n");
	        	vren.thedate.showD(RentDate, curDate);
	        	vren.thedate.daydif();
	        	
	        	int days =vren.thedate.daydif();
	        	double rpd = vren.cList.get(y).assignedVehicle.rateperday;
	        	vren.vret.Amount(days, rpd);
	        	
	        	System.out.print("---------------------------------------------------"
		        		+"\n"+	"Customer Name :-------------------------------------- "+vren.cList.get(y).cname +"\n"
		        		+"\n"+	"Customer Address :----------------------------------- "+vren.cList.get(y).address +"\n"
		        		+"\n"+	"Customer CNIC# :------------------------------------- "+vren.cList.get(y).cnic +"\n"
		        		+"\n"+	"Date Rented :---------------------------------------- "+RentDate +"\n"
			        	+"\n"+	"Date of Return :------------------------------------- "+curDate +"\n"
				        +"\n"+	"Number of days :------------------------------------- "+days +"\n"
				        +"\n"+	"Registered Vehicle :--------------------------------- "+vren.cList.get(y).assignedVehicle.name +"\n"
						+"\n"+	"                    --------------------------------- "+vren.cList.get(y).assignedVehicle.make +"\n"
						+"\n"+	"                    --------------------------------- "+vren.cList.get(y).assignedVehicle.model +"\n"
				        +"\n"+	"Rate per day :--------------------------------------- "+ rpd +"\n"
		        		+"\n"+	"TOTAL RENTAL AMOUNT :-------------------------------- "+vren.vret.Amount(days, rpd) +"\n"+"\n");
	        	break;
	        	
	        	//vren.vadd.vList.add(e)
	        	
	        case 5: 
	        	for(int i = 0; i<vren.cList.size(); i++)
	        	{
	        		System.out.println(vren.cList.get(i).toString());
	        	}
	        	
	        	break;
	        }
		 }while(swval != 6);
	        File a =new File("C:\\Users\\sharjeel sultan\\Documents\\NetBeansProjects\\VehicleRentalSystem\\src\\vehiclerentalsystem\\test.txt");
	        if(a.exists()) {System.out.println("file exists");}
	        else 
	        	{
	        	System.out.println("file does not exists");
	        	}
	        PrintWriter output= new PrintWriter(a);
	        
	        for(int i = 0; i<vren.cList.size();i++)
	        {
	        	output.write("hello");
	        	output.write(vren.cList.get(i).toString());
	        	output.write("\n");
	        }
	       for (int j=0; j<vren.vadd.vList.size();j++)
	       {
	    	   output.write(vren.vadd.vList.get(j).toString());
	    	   output.write("\n");
	       }
	       output.close();
                
               
		 
	         
	}

        // TODO code application logic here
    }

    //
//
//
///////////////////// V E H I C L E   C L A S S //////////
//
//
//
 class Vehicle
 {                            
    String name;
    String type;
    String make;
    String model;
    double rateperday;
    boolean available;
   public Vehicle (){
	   		//parameterless constructor
   }
   public Vehicle (String name, String type, String make, String model, double rateperday, boolean available){
   this.name= name;
   this.type= type;
   this.make= make;
   this.model= model;
   this.rateperday = rateperday;
   this.available = available;
   }
   public void setname (String name){
   this.name= name;
           }
   public void settype (String type){
   this.type=type;
   }
   public void setmake (String make){
   this.make=make;
   }
   public void setmodel (String model){
   this.model=model;
   }
   public void setrate (double rateperday) {
	   this.rateperday = rateperday;
   }
   public void setavail (boolean available) {
	   this.available=available;
   }
   public String getname(){
   return this.name;
   }
   public String gettype(){
   return this.type;
   }
   public String getmake(){
   return this.make;
   }
   public String getmodel(){
   return this.model;
   }
   public double getrate() {
	   return this.rateperday;
   }
   public boolean getavail() {
	   return this.available;
   }
   @Override
   public String toString (){
       return "name:          "+ name + "\n" + "type:          "+ type + "\n" + "make:          "+ make + "\n" + "model:         " + model + "\n"+ "rate per day:  "+ rateperday + "\n";
               }
 }
//
 //
 //
 // //////////////  V E H I C L E   A D D I T I O N /////////
 //
//
 //
 class vehicleAddition {
	 
	 String name = "Subaru";
	 String type = "casual";
	 String make = "Nisan";
	 String model= "2020";
	 double rateperday = 5000;
	 boolean available = false;
	 
	 Vehicle v1 = new Vehicle( name, type, make, model, rateperday, available);
	 
	 String nam = "Hiace";
	 String typ = "van";
	 String mak = "Toyota";
	 String modl= "2015";
	 double rateperda = 15000;
	 boolean availab = true;
	 
	 Vehicle v2 = new Vehicle( nam, typ, mak, modl, rateperda, availab);
	 
	 String nm = "Audi A8";
	 String tp = "Luxury";
	 String mk = "Audi";
	 String mdl= "2021";
	 double rateprda = 50000;
	 boolean avilab = true;
	 
	 Vehicle v3 = new Vehicle( nm, tp, mk, mdl, rateprda, avilab);
	 
	 ArrayList<Vehicle> vList = new ArrayList<Vehicle>();
	 
	 void defaultVehicle() {
	 vList.add(v1);
	 vList.add(v3);
	 vList.add(v2);
	 
	 }

	 public void addVehicle(Vehicle newVehicle) {
		// boolean alreadyingarage = false;
	/*	 
		 for (Vehicle vehicle : vList) {
			 if (vehicle.name.equals(newVehicle.name)) {
				 alreadyingarage = true;
				 System.out.println("Vehicle is aleady in garage .. add another one");
				 break;
			 }
		 }
		 if(!alreadyingarage) {
			 vList.add(newVehicle);
		 }
	 }
	 
	 */
		 vList.add(newVehicle);
		 }

	 public String showGarage() { 
		 return vList.toString();
	 }
 }
 //
 //
 //
 ////////////// C U S T O M E R  R E G I S T R A T I O N ////
 //
 //
 //
 class customerRegistration {
	 
	 String cname; //customername
	 String address;
	 String cnic;
	 Vehicle assignedVehicle;  //VEHICLE type data field which tell which vehicle is assigned to customer
	 Date datebegin;
	 
	 public customerRegistration() {
		 
	 }
	 
	 public customerRegistration(String cname, String address, String cnic,Vehicle assignedVehicle, Date datebegin) {
		 this.cname=cname;
		 this.address=address;
		 this.cnic=cnic;
		 this.assignedVehicle=assignedVehicle;
		 this.datebegin = datebegin;
	 }
	 
	 public void setcname(String cname) {
		 this.cname=cname;
	 }
	 public void setaddress(String address) {
		 this.address=address;
	 }
	 public void setcnic(String cnic) {
		 this.cnic=cnic;
	 }
	 public String getcname() {
		 return this.cname;
	 }
	 public String getaddress() {
		 return this.address;
	 }
	 public String getcnic() {
		 return this.cnic;
	 }
	 public String showDB() {
		 datebegin = new Date();
		 String txtDate = new SimpleDateFormat("dd/MM/yyyy").format(datebegin);
		return txtDate;
	 }
	 public String toString() {
		 return("\n"+"================"+" CUSTOMER: "+cname.toUpperCase()+" ================"+"\n"+"==========="+" YOUR VEHICLE ON RENT : "+"============"+"\n"+assignedVehicle);
	 }
 }
//
 //
 //
 // //////////////  V E H I C L E   R E G I S T R A T I O N /////////
 //  // //////////////  new RETURN VEHICLE   ////////
//
 //
 class ReturnVehicle  extends customerRegistration{
	 
	 String cname = super.cname;
	 String address = super.address;
	 String cnic = super.cnic;
	 Vehicle asgVec = super.assignedVehicle;
	 Date dtb = super.datebegin;
	 Date dateofReturn;
	 double rpd;
	 int days;
	 double total;
	 int invoiceNo = 2020000;	        
	        //ArrayList<Vehicle> vList2 = new ArrayList<Vehicle>();
	        vehicleAddition vadd = new vehicleAddition();
	        int x= vadd.vList.size(); // will access vList through object vadd of class vehicleAddition.
	        
	     
	        public double Amount(int days, double rpd)
	        {
	        	this.rpd=rpd;
	        	this.days=days;
	        	
	        	if(days==0) {
	        		total =  rpd;
	        	}
	        	else if(days>0) {
	        		total = (rpd*days);
	        	}
	        	else {
	        		total = Math.abs((rpd*days));
	        	}
	        	

	        	return total;
	        }
	        
	        
	        public String toString() {
	        	return("---------------------------------------------------"
	        		+"\n"+	"Customer Name :-------------------------------------- "+cname +"\n"
	        		+"\n"+	"Customer Address :----------------------------------- "+address +"\n"
	        		+"\n"+	"Customer CNIC# :------------------------------------- "+cnic +"\n"
	        		+"\n"+	"Date Rented :---------------------------------------- "+dtb +"\n"
		        	+"\n"+	"Date of Return :------------------------------------- "+dateofReturn +"\n"
			        +"\n"+	"Number of days :------------------------------------- "+cname +"\n"
			        +"\n"+	"Registered Vehicle :--------------------------------- "+asgVec +"\n"
			        +"\n"+	"Rate per day :--------------------------------------- "+ rpd +"\n"
	        		+"\n"+	"TOTAL RENTAL AMOUNT :-------------------------------- "+total +"\n");
	        }        
}     

class Dated{
		
		int difference;
		    void showD( Date datbgn, Date curDate){
		       
		    //	System.out.println("Date of rent :-------------------| "+datbgn);
				Date d1= datbgn;
				
			  
			//System.out.println("Date of return :-----------------| "+curDate);
			Date d2= curDate;
			
			Calendar cal1 = new GregorianCalendar();
		     Calendar cal2 = new GregorianCalendar();
		     cal1.setTime(d1);
		     cal2.setTime(d2);
		     
		     difference = cal2.DATE-cal1.DATE;
		    // System.out.println("Total Days :--------------------| "+difference);
		   }
		    public int daydif() {
		    	return difference;
		    }
		}