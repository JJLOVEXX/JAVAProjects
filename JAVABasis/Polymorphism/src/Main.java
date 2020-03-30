public class Main {

    public static void main(String[] args) {
        Teacher teacher=new Teacher("Jack","28",100);
        System.out.println(teacher.toString());
        Student student=new Student("Macy","18",88);
        System.out.println(student.toString());
        Person person=new Teacher("Jennie","55",200);
        System.out.println(person.toString());
        show(person);
        Student student1=new Student("Macy","18",90);
        System.out.println(student.equals(student1));
        System.out.println(student.hashCode());
        System.out.println(student1.hashCode());
        System.out.println("Hello World!");
    }

    public static void show(Person person){
        if (person instanceof Teacher){
            Teacher teacher=(Teacher)person;
            System.out.println(teacher.toString());
        }
        else if (person instanceof Student){
           Student student=(Student)person;
            System.out.println(student.toString());
        }
    }
}
