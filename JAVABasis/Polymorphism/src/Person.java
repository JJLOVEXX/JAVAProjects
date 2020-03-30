public class Person {
    private String name;
    private String age;

    Person(){

    }
    Person(String name,String age){
        this.name=name;
        this.age=age;
    }
    public String getName(){
        return name;
    }
    public String getAge(){
        return age;
    }

    @Override
    public String toString() {
        return "Hello,"+getName()+"("+getAge()+")"+",";
    }
}
