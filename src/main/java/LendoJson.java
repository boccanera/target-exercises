import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;


public class LendoJson {

    public static void main(String[] args) {


        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(".\\src\\main\\json\\dados.json")) {

            // "Parseando" pelo documento.
            Object obj = jsonParser.parse(reader);
            JSONArray diasValorLista = (JSONArray) obj;

            //Definindo total de dias para tirar a média.
            int totalDeDias = 0;
            double somaValores = 0.0;
            double menorValor = 0.0;
            double maiorValor = 0.0;
            double media = 0.0;
            int contador = 0;

            //Varrendo o Json para pegar os valores min, max e a media .
            for (Object o : diasValorLista) {
                totalDeDias++;
                JSONObject valores = (JSONObject) o;
                Double valoresEmDouble = (Double) valores.get("valor");
                somaValores += valoresEmDouble;

                // Pegando menor valor
                if (valoresEmDouble < menorValor) {
                    menorValor = valoresEmDouble;
                }
                // Pegando maior valor
                if (valoresEmDouble > maiorValor) {
                    maiorValor = valoresEmDouble;
                }
                //Definindo o valor da média e adicionando um contador no if para os valores maiores que a média.
                media = somaValores / totalDeDias;
                boolean maiorQueAMedia = media < valoresEmDouble;
                if (maiorQueAMedia) {
                    contador++;
                }
            }

            System.out.println("Total de dias = " + totalDeDias);
            System.out.println("Soma dos valores = " + String.format("%.2f", somaValores));
            //Acredito que numa situação real seja melhor deixar sem limitações decimais como o String.format "%2f"
            System.out.println("O menor valor e = R$" + String.format("%.2f", menorValor));
            System.out.println("O maior valor e = R$" + String.format("%.2f", maiorValor));
            System.out.println("A media do faturamento e = R$" + String.format("%.2f", media));
            System.out.println("Numero de dias no mes que o faturamento foi superior a media = " + contador);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
