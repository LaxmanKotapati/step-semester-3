abstract class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    abstract boolean canTakeLeave(int days);
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name) {
        super(name);
    }

    boolean canTakeLeave(int days) {
        return days <= 10;
    }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name) {
        super(name);
    }

    boolean canTakeLeave(int days) {
        return days <= 5;
    }
}

class LeaveRequest {
    Employee employee;
    String status = "Pending";

    LeaveRequest(Employee employee) {
        this.employee = employee;
    }

    void submit(int days) {
        if (employee.canTakeLeave(days))
            System.out.println("Leave request submitted for " + employee.name);
        else
            System.out.println("Leave not allowed.");
    }

    void approve() {
        if (status.equals("Pending")) {
            status = "Approved";
            System.out.println("Leave approved. Status: " + status);
        }
    }

    void reject() {
        if (status.equals("Pending")) {
            status = "Rejected";
            System.out.println("Leave rejected. Status: " + status);
        }
    }

    void changeToPending() {
        if (!status.equals("Pending"))
            System.out.println("Cannot change " + status + " to Pending.");
    }
}

class LeaveSystem {
    public static void main(String[] args) {

        FullTimeEmployee e = new FullTimeEmployee("John");

        LeaveRequest request = new LeaveRequest(e);

        request.submit(5);
        request.approve();
        request.changeToPending();
    }
}