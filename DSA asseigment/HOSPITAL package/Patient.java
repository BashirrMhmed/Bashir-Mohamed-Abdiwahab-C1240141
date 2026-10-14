package Hospital;

class Patient {
    String Name;
    double ConsultFee;

    Patient(String Name, double ConsultFee) {
        this.Name = Name;
        this.ConsultFee = ConsultFee;
    }
}

class Outpatient extends Patient {
    double LabCharge;

    Outpatient(String Name, double ConsultFee, double LabCharge) {
        super(Name, ConsultFee);
        this.LabCharge = LabCharge;
    }

    double CalculateBill() {
        return LabCharge + ConsultFee;
    }
}

class Inpatient extends Patient {
    double RoomCharge;
    int NumberOfDays;

    Inpatient(String Name, double ConsultFee,
              double RoomCharge, int NumberOfDays) {
        super(Name, ConsultFee);
        this.RoomCharge = RoomCharge;
        this.NumberOfDays = NumberOfDays;
    }

    double CalculateBill() {
        return (NumberOfDays * RoomCharge) + ConsultFee;
    }
}


