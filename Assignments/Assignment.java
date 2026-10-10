abstract class Assignment {
    String name;
    int maxMarks;

    Assignment(String name, int maxMarks) {
        this.name = name;
        this.maxMarks = maxMarks;
    }

    abstract double penalty(int lateDays);
}

class Coding extends Assignment {
    Coding(String name, int maxMarks) {
        super(name, maxMarks);
    }

    double penalty(int lateDays) {
        return lateDays * 0.10;
    }
}

class Written extends Assignment {
    Written(String name, int maxMarks) {
        super(name, maxMarks);
    }

    double penalty(int lateDays) {
        return lateDays * 0.20;
    }
}

class Submission {
    Assignment assignment;
    String student;
    boolean graded = false;

    Submission(String student, Assignment assignment) {
        this.student = student;
        this.assignment = assignment;
    }

    void submit() {
        if (graded)
            System.out.println("Cannot resubmit: already graded.");
        else
            System.out.println(student + "'s submission received.");
    }

    void grade(int marks, int lateDays) {
        if (graded) {
            System.out.println("Already graded.");
            return;
        }

        double penalty = assignment.penalty(lateDays);
        double finalMarks = marks - (marks * penalty);

        graded = true;

        System.out.println(student + " graded: "
                + finalMarks + "/" + assignment.maxMarks);
        System.out.println("Status: Graded");
    }
}

class AssignmentPortal {
    public static void main(String[] args) {

        Coding coding = new Coding("Linked List Lab", 50);
        Written written = new Written("Design Essay", 50);

        Submission s1 = new Submission("Asha", coding);
        Submission s2 = new Submission("Ravi", written);

        s1.submit();
        s2.submit();

        s1.grade(45, 0);
        s2.grade(40, 2);

        s1.submit();
    }
}