import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Staff> staff;

    public School() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        staff = new ArrayList<>();
    }

    // Methods to add, remove, or search for students, teachers, and staff

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    public void addStaff(Staff staffMember) {
        staff.add(staffMember);
    }

    public void removeStaff(Staff staffMember) {
        staff.remove(staffMember);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public List<Teacher> getAllTeachers() {
        return teachers;
    }

    public List<Staff> getAllStaff() {
        return staff;
    }

    // Other methods for managing the school

    public static void main(String[] args) {
        // Initialize and use the School class here
    }
}
