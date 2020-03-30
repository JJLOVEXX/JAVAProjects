public class Teacher extends Person {
    private double wage;

    Teacher() {
        super();
    }

    Teacher(String name, String age, double wage) {
        super(name, age);
        this.wage=wage;
    }


    public Teach getTeachingMessage=new Teach() {
        @Override
        public String teach() {
            return "You are teaching.";
        }
        public String relax(){
            return "You are not relaxing.";
        }
    };

    public double getWage(){
        return wage;
    }

    @Override
    public String toString() {
        return super.toString()+"your wage is: "+getWage()+" "+getTeachingMessage.teach()+getTeachingMessage.relax();
    }
}
