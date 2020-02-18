public class Main {

    public static String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1) return originStr;
        //System.out.println(originStr.charAt(0));
        //System.out.println(originStr.substring(1));
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    public static void main(String[] args) {
        String s1 = "ILOVEYOU";
        System.out.println(reverse(s1));
    }

}
