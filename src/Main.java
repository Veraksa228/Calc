import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(Calc.Calc(sc.nextLine()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
