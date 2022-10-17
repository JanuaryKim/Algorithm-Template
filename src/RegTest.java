public class RegTest {
    public static void main(String[] args) {
        String reg = "[a-zA-Z]";
        String str = "abc";

        boolean matches = str.matches(reg);

        System.out.println(matches);
    }
}


