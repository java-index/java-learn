package hw7_ex1;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
    List<Student> students;

    public ClassRoom(){
        students = new ArrayList<Student>();
    }

    public void enter(Student student){
        students.add(student);
    }

    public void leave(Student student){
        students.remove(student);
    }

    public int getStudentCount(){
        System.out.println(students.size());
        return 0;
    }

    public boolean isPresent(String firstName, String secondName){

        if (students.contains(new Student(firstName, secondName))){
            return true;
        }

//        for(int i = 0; i < students.size(); i++){
//            if (students.get(i).getFirstName() == firstName && students.get(i).getSecondName() == secondName){
//                return true;
//            }
//        }
        return false;
    }

    public void printStudentInfo(){
        for (Student s : students){
            System.out.printf("%s\n", s.toString());
        }
    }

//    public Student getStudent(){
//
//    }
}
