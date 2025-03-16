package university;
public class University {

    private final String name;
    private String FirstName;
    private String LastName;

    private int student_count = 10000;
    private int course_count = 10;

    private final Student[] students = new Student[1000];
    private final Course[] courses = new Course[50];

    private int studentCount = 0;
    private int courseCount = 0;


    public University(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void setRector(String FirstName, String LastName) {
        this.FirstName = FirstName;
        this.LastName = LastName;
    }


    public String getRector() {
        return FirstName + " " + LastName;
    }

    public int enroll(String firstName, String lastName) {
        Student s = new Student(student_count, firstName, lastName);
        students[studentCount++] = s;
        return student_count++;
    }


    public String student(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                return students[i].toString();
            }
        }
        return null;
    }

    public int activate(String title, String name) {
        Course c = new Course(course_count, title, name);
        courses[courseCount++] = c;
        return course_count++;
    }


    public void register(int studentID, int courseCode) {
        Student s = null;
        Course c = null;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == studentID) {
                s = students[i];
                break;
            }
        }
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCode() == courseCode) {
                c = courses[i];
                break;
            }
        }

        if (s != null && c != null) {
            s.addCourse(c);
            c.addStudent(s);
        }
    }








    public String listAttendees(int courseCode) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCode() == courseCode) {
                return courses[i].listAttendees();
            }
        }
        return null;
    }

    public String studyPlan(int studentID) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == studentID) {
                return students[i].listCourses();
            }
        }
        return null;
    }
}
