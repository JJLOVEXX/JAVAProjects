import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyTest2 {
    @SuppressWarnings("unchecked")

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Class<?> clazz = list.getClass();
        ListProxy<String> myProxy = new ListProxy<String>(list);
        List<String> newList = (List<String>) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), myProxy);
        newList.add("apple");
        newList.add("banana");
        newList.add("orange");
        newList.remove("banana");
    }
}
