import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String s = new String("123");
        String q = new String("321");
        Set<String> st = new HashSet();
        st.add(s);
        st.add(q);
        System.out.println(s.equals(q));
        System.out.println(st);
        System.out.println(s.hashCode()==q.hashCode());
        System.out.println("Hello World!");
    }
/**
 public boolean equals(Object obj) {


 return false;
 }
 **/
}
