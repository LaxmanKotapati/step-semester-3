interface NotificationChannel {
    void send(String student, String message);
}

class Email implements NotificationChannel {
    public void send(String student, String message) {
        System.out.println("[Email → " + student + "] " + message);
    }
}

class SMS implements NotificationChannel {
    public void send(String student, String message) {
        System.out.println("[SMS → " + student + "] " + message);
    }
}

class App implements NotificationChannel {
    public void send(String student, String message) {
        System.out.println("[App → " + student + "] " + message);
    }
}

class Student {
    String name;
    String department;
    NotificationChannel[] channels;

    Student(String name, String department,
            NotificationChannel[] channels) {
        this.name = name;
        this.department = department;
        this.channels = channels;
    }
}

class NoticeBoard {

    void post(String title, String[] departments,
              Student[] students) {

        if (title.equals("") || departments.length == 0) {
            System.out.println(
                    "Cannot post notice: At least one target department is required."
            );
            return;
        }

        System.out.println("Notice '" + title + "' posted.");

        for (Student s : students) {

            for (String dept : departments) {

                if (s.department.equals(dept)) {

                    for (NotificationChannel c : s.channels) {
                        c.send(s.name, title);
                    }

                }
            }
        }
    }
}

class CampusNotice {
    public static void main(String[] args) {

        Student asha = new Student(
                "Asha",
                "CSE",
                new NotificationChannel[]{
                        new Email(),
                        new App()
                }
        );

        Student ravi = new Student(
                "Ravi",
                "ECE",
                new NotificationChannel[]{
                        new SMS()
                }
        );

        Student[] students = {asha, ravi};

        NoticeBoard board = new NoticeBoard();

        board.post(
                "Lab Closed Tomorrow",
                new String[]{"CSE"},
                students
        );

        board.post(
                "Fee Deadline Extended",
                new String[]{"CSE", "ECE"},
                students
        );

        board.post(
                "Sports Day",
                new String[]{},
                students
        );
    }
}