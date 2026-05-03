import java.util.Random;

public class MyTestingClass {
    int a;
    int[] b = new int[10];
    private static Random r = new Random();

    public MyTestingClass() {
        this.a = r.nextInt();
        for (int i = 0; i < 10; i++) {
            b[i] = r.nextInt();
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += a;
        for (int i = 0; i < 10; i++) {
            hash = b[i] + hash * 31;
        }
        return hash;
    }
}
