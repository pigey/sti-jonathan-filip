public class Course {
    private int yhPoints;
    private Teacher teacher;
    private int courseId;
    private double courseHours;

    public Course(int yhPoints, Teacher teacher, int courseId, double courseHours){
        this.yhPoints = yhPoints;
        this.teacher = teacher;
        this.courseId = courseId;
        this.courseHours = courseHours;
    }
}
