/**
 * 懒学生
 */
public class LazyStudent implements Candidate {
    private String name; // 姓名

    public LazyStudent(String name) {
        this.name = name;
    }

    @Override
    public void answerTheQuestions() {
        // 懒学生只能写出自己的名字不会答题
        System.out.println("name: " + name);
    }
}
