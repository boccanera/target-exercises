import java.util.Scanner;


//Como foi pedido para não utilizar reverse, utilizei charAt com um for básico.
public class ReverseString {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        StringBuilder inversao = new StringBuilder();
        int quantidadeDePalavras = input.length();

        for (int i = quantidadeDePalavras - 1; i >= 0; i--) {
            inversao.append(input.charAt(i)); //inversao = inversao + input.charAt(i);
        }
        System.out.println("A inversao de caracteres de " + input + " e " + inversao);
    }
}

