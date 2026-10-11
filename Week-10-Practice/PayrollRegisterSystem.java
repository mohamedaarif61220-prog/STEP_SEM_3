abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();
    abstract String getType();

    public String toString() {
        return "Payslip[name=" + name
            + ", type=" + getType()
            + ", pay=" + formatPay(calculatePay()) + "]";
    }

    static String formatPay(double pay) {
        if (pay == (long) pay) {
            return String.valueOf((long) pay);
        }
        return String.valueOf(pay);
    }
}

class FullTime extends Staff {
    double salary;

    FullTime(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    double calculatePay() {
        return salary;
    }

    String getType() {
        return "FullTime";
    }
}

class PartTime extends Staff {
    double hours;
    double rate;

    PartTime(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {
        return hours * rate;
    }

    String getType() {
        return "PartTime";
    }
}

class Intern extends Staff {
    double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double calculatePay() {
        return stipend;
    }

    String getType() {
        return "Intern";
    }
}

public class PayrollRegisterSystem {
    public static void main(String[] args) {
        Staff[] staff = {
            new FullTime("Asha", 50000),
            new PartTime("Ravi", 80, 300),
            new Intern("Neha", 15000)
        };

        double total = 0;
        Staff topEarner = staff[0];

        for (Staff s : staff) {
            System.out.println(s);
            total += s.calculatePay();

            if (s.calculatePay() > topEarner.calculatePay()) {
                topEarner = s;
            }
        }

        System.out.println("Total " + Staff.formatPay(total));
        System.out.println("top earner " + topEarner.name);
    }
}