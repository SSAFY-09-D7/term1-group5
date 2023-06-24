import java.math.BigInteger;
import java.util.Scanner;

public class fri_baek_1560 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        BigInteger nn = new BigInteger(n);
        if (nn.compareTo(BigInteger.TWO) <= 0) {
            System.out.println(n);
            return;
        }
        nn = nn.add(nn);
        System.out.println(nn.subtract(BigInteger.TWO));
    }

}
