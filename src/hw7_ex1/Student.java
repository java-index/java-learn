package hw7_ex1;

public class Student {
    private String firstName;
    private String secondName;

    public Student(String firstName, String secondName){
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return firstName + " " + secondName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Student && ((Student) obj).secondName == this.secondName && ((Student) obj).firstName == this.firstName){
           return true;
        } else {
           return false;
        }
    }
}
