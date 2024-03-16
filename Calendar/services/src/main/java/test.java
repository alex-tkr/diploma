

public class test {
    public static void main(String[] args) {
        var sc = new ServicesConfiguration();
        sc.eventDao().findByName("lesson");
    }
}
