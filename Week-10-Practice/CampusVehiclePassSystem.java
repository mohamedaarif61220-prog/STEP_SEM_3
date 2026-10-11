import java.util.HashMap;
import java.util.Map;

interface Chargeable {
    void bookChargingBay();
}

abstract class Vehicle {
    String passNumber;
    String owner;

    Vehicle(String passNumber, String owner) {
        this.passNumber = passNumber;
        this.owner = owner;
    }

    abstract int getPassFee();
    abstract String getType();
}

class Bike extends Vehicle {
    Bike(String pass, String owner) {
        super(pass, owner);
    }

    int getPassFee() {
        return 300;
    }

    String getType() {
        return "Bike";
    }
}

class Car extends Vehicle {
    Car(String pass, String owner) {
        super(pass, owner);
    }

    int getPassFee() {
        return 1000;
    }

    String getType() {
        return "Car";
    }
}

class EBike extends Vehicle implements Chargeable {
    EBike(String pass, String owner) {
        super(pass, owner);
    }

    int getPassFee() {
        return 300;
    }

    String getType() {
        return "E-Bike";
    }

    public void bookChargingBay() {
        System.out.println(passNumber + " charging bay allotted");
    }
}

class ECar extends Vehicle implements Chargeable {
    ECar(String pass, String owner) {
        super(pass, owner);
    }

    int getPassFee() {
        return 1000;
    }

    String getType() {
        return "ECar";
    }

    public void bookChargingBay() {
        System.out.println(passNumber + " charging bay allotted");
    }
}

public class CampusVehiclePassSystem {
    public static void main(String[] args) {
        Map<String, Vehicle> vehicles = new HashMap<>();

        register(vehicles, new Bike("KA01", "Asha"));
        register(vehicles, new ECar("KA02", "Ravi"));

        charge(vehicles, "KA02");
        charge(vehicles, "KA01");
    }

    static void register(Map<String, Vehicle> vehicles, Vehicle v) {
        vehicles.put(v.passNumber, v);

        System.out.println(v.passNumber + " (" + v.getType()
            + ") pass fee " + v.getPassFee());
    }

    static void charge(Map<String, Vehicle> vehicles, String pass) {
        Vehicle v = vehicles.get(pass);

        if (v == null) {
            System.out.println("Vehicle not found");
        } else if (v instanceof Chargeable) {
            ((Chargeable) v).bookChargingBay();
        } else {
            System.out.println(pass + " rejected: charging unsupported");
        }
    }
}