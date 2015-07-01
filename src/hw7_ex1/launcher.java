package hw7_ex1;

/**
 * Created by rabota on 29.06.15.
 */
public class launcher {

    public static void main(String[] args) {
        ClassRoom classRoom = new ClassRoom();
        Student ivanov = new Student("Ivan", "Ivanov");
        Student petrov = new Student("Petr", "Petrov");
        Student borisov = new Student("Boris", "Borisov");
        Student sidorov = new Student("Adolf", "Sidorov");

        classRoom.enter(ivanov);
        classRoom.enter(petrov);
        classRoom.enter(borisov);
        classRoom.enter(sidorov);

//        classRoom.leave(ivanov);
//        classRoom.leave(petrov);
//        classRoom.leave(sidorov);
//        classRoom.leave(borisov);
//        classRoom.leave(borisov);


        System.out.println(classRoom.isPresent("Ivan", "Ivanov"));

        classRoom.getStudentCount();
        classRoom.printStudentInfo();
    }
}
