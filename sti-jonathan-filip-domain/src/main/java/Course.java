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

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getYhPoints() {
        return yhPoints;
    }

    public void setYhPoints(int yhPoints) {
        this.yhPoints = yhPoints;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public double getCourseHours() {
        return courseHours;
    }

    public void setCourseHours(double courseHours) {
        this.courseHours = courseHours;
    }
}
