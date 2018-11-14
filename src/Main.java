import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczby po przecinku: ");
        String numbers = null;
        try {
            numbers = scanner.nextLine();
            Calc calc = new Calc(numbers);
            System.out.println(calc.getMostRepeatedNumber(calc.getList()));
        } catch (NoSuchElementException e) {
            System.err.println(e);
        }

    }
}
