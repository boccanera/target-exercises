import java.util.*;

public class PercentualDeRepresentacao {

    public static void main(String[] args) {

        Map<String, Double> faturamentoPorEstado = new HashMap<>() {{
            put("SP", 67836.43);
            put("RJ", 36678.66);
            put("MG", 29229.88);
            put("ES", 27165.48);
            put("Outros", 19849.53);
        }};

        double soma = faturamentoPorEstado.values().stream().mapToDouble(d -> d).sum();
        double porcentagem;

        // for para interagir entre os elementos e o respectivo valor de cada Estado e obter a porcentagem sobre o valor total.
        for (Map.Entry<String, Double> entry : faturamentoPorEstado.entrySet()) {
            String key = entry.getKey();
            Double valor = entry.getValue();
            System.out.println("Estado = " + key);
            System.out.println("Valor = R$" + valor);
            porcentagem = valor / soma * 100;
            System.out.println("Respectiva participacao = " + String.format("%.2f", porcentagem) + "% \n");
        }
        System.out.println("A soma dos valores e de = R$" + soma);
    }
}
