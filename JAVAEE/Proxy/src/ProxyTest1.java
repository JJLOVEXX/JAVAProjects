public class ProxyTest1 {
    public static void main(String[] args) {
        Candidate c = new Gunman(new LazyStudent("Jack"));
        c.answerTheQuestions();
    }
}
