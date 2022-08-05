import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class CalculadoraApplication {

    public static void main(String[] args) {
        String operacao;
        int num1;
        int num2;
        boolean continuaOuNao;

        Scanner scanner = new Scanner(in);

        try {
            do {
                out.println("Digite a operação desejada (+, -, *, /): ");
                operacao = scanner.next();

                out.println("Digite o valor um para o calculo: ");
                num1 = scanner.nextInt();

                out.println("Digite o valor dois para o calculo: ");
                num2 = scanner.nextInt();

                out.println("Resultado: " + realizarCalculo(operacao, num1, num2));

                continuaOuNao = verificarNovaOperacao();

            } while (continuaOuNao);

        } catch (InputMismatchException ex) {
            out.println("Os valores para calculo devem ser inteiros =(");
        }
    }

    public static boolean verificarNovaOperacao() {
        Scanner sc = new Scanner(in);

        out.println("\nDeseja realizar uma nova operação ? (S / N): ");
        return !sc.nextLine().toUpperCase(Locale.ROOT).equals("N");
    }

    public static Integer realizarCalculo(String operacao, Integer numeroUm, Integer numeroDois) {
        Integer resultado = null;

        switch (operacao) {
            case "+":
                resultado = numeroUm + numeroDois;
                break;
            case "-":
                resultado = numeroUm - numeroDois;
                break;
            case "*":
                resultado = numeroUm * numeroDois;
                break;
            case "/":
                resultado = numeroUm / numeroDois;
                break;

            default:
                out.println("Operador inválido =(");
        }
        return resultado;
    }
}
