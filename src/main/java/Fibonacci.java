import java.util.Scanner;

public class Fibonacci {


    static boolean quadradoPerfeito(int x) {
        //Conferindo se é um quadrado perfeito, ou seja, se a multiplicação do número por ele mesmo é igual à raiz Math.sqrt.
        int s = (int) Math.sqrt(x);
        return (s * s == x);
    }

    // Retorna se o número é Fibonacci ou não
    static boolean checandoFibonacci(int n) {
        // o parametro n recebe o input e confere se o numero é Fibonacci 5*n*n + 4 or 5*n*n - 4 or both
        // é um quadrado perfeito se uma ou as duas forem verdadeiras
        return quadradoPerfeito(5 * n * n + 4) ||
                quadradoPerfeito(5 * n * n - 4);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        {

            while (scan.hasNext()) {
                Integer input = scan.nextInt();
                System.out.println(checandoFibonacci(input) ? input + " e um numero da sequencia Fibonacci" :
                        input + " nao e um numero Fibonacci");
            }
        }
    }
}
