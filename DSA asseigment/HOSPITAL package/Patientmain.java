package Hospital;

public class Patientmain {


    public static void main(String[] args) {

        Outpatient out = new Outpatient("Ahmed", 20, 30);

        System.out.println("Outpatient Name: " + out.Name);
        System.out.println("Consult Fee: " + out.ConsultFee);
        System.out.println("Lab Charge: " + out.LabCharge);
        System.out.println("Total Bill: " + out.CalculateBill());

        System.out.println();

        Inpatient in = new Inpatient("Ali", 20, 50, 3);

        System.out.println("Inpatient Name: " + in.Name);
        System.out.println("Consult Fee: " + in.ConsultFee);
        System.out.println("Room Charge: " + in.RoomCharge);
        System.out.println("Number of Days: " + in.NumberOfDays);
        System.out.println("Total Bill: " + in.CalculateBill());
    }
}

