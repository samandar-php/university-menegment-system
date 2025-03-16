package university;

public class Course {

    private final int code;
    private final String title;
    private final String name;
    private final Student[] attendees = new Student[100];
    private int attendeeCount = 0;

    public Course(int code, String title, String name) {
        this.code = code;
        this.title = title;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void addStudent(Student student) {
        if (attendeeCount < 100) {
            attendees[attendeeCount++] = student;
        }
    }
    public String listAttendees() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < attendeeCount; i++) {
            result.append(attendees[i].toString()).append("\n");
        }
        return result.toString();
    }

    public String toString() {
        return code + "," + title + "," + name;
    }
}
