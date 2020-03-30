public class Student extends Person {
    private double grade;

    Student(){
        super();
    }
    Student(String name,String age, double grade){
        super(name,age);
        this.grade=grade;
    }

    public double getGrade(){
        return grade;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getAge() {
        return super.getAge();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)){
            return false;
        }
        else if (obj instanceof Student){
            return ((Student) obj).getName().equals(this.getName()) && (((Student) obj).getAge() == (this.getAge()));
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result=17;
        result=31*result+(super.getName()==null?0:super.getName().hashCode());
        result=331*result+(super.getAge()==null?0:super.getAge().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return super.toString()+"your grade is: "+getGrade();
    }
}
