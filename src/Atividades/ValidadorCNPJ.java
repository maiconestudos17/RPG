package Atividades;
import java.util.Scanner;
public class ValidadorCNPJ {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            System.out.print("Digite o CNPJ: ");
            String cnpj = sc.nextLine();

            cnpj = limparCNPJ(cnpj);

            if (validarCNPJ(cnpj)) {
                System.out.println("CNPJ válido!");
            } else {
                System.out.println("CNPJ inválido!");
            }

            sc.close();
        }


        // Remove pontos, barras, traços
        public static String limparCNPJ(String cnpj) {

            return cnpj.replace(".", "")
                    .replace("/", "")
                    .replace("-", "");
        }


        // Verifica se o CNPJ possui 14 dígitos
        public static boolean verificarTamanho(String cnpj) {

            return cnpj.length() == 14;
        }


        // Verifica se todos os números são iguais
        public static boolean todosDigitosIguais(String cnpj) {

            char primeiroNumero = cnpj.charAt(0);

            for (int i = 1; i < cnpj.length(); i++) {

                if (cnpj.charAt(i) != primeiroNumero) {
                    return false;
                }
            }

            return true;
        }


        public static int calcularPrimeiroDigito(String cnpj) {

            int[] pesos = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

            int soma = 0;

            for (int i = 0; i < 12; i++) {

                int numero = Character.getNumericValue(cnpj.charAt(i));

                soma = soma + (numero * pesos[i]);
            }

            int resto = soma % 11;

            if (resto < 2) {
                return 0;
            } else {
                return 11 - resto;
            }
        }


        public static int calcularSegundoDigito(String cnpj, int primeiroDigito) {

            int[] pesos = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

            int soma = 0;

            for (int i = 0; i < 12; i++) {

                int numero = Character.getNumericValue(cnpj.charAt(i));

                soma = soma + (numero * pesos[i]);
            }

            soma = soma + (primeiroDigito * pesos[12]);

            int resto = soma % 11;

            if (resto < 2) {
                return 0;
            } else {
                return 11 - resto;
            }
        }


        // valida o final do CNPJ
        public static boolean validarCNPJ(String cnpj) {

            if (!verificarTamanho(cnpj)) {
                return false;
            }

            if (todosDigitosIguais(cnpj)) {
                return false;
            }

            int primeiroDigitoCalculado = calcularPrimeiroDigito(cnpj);

            int segundoDigitoCalculado = calcularSegundoDigito(cnpj, primeiroDigitoCalculado);


            int primeiroDigitoInformado = Character.getNumericValue(cnpj.charAt(12));

            int segundoDigitoInformado = Character.getNumericValue(cnpj.charAt(13));


            if (primeiroDigitoCalculado == primeiroDigitoInformado && segundoDigitoCalculado == segundoDigitoInformado) {

                return true;

            } else {

                return false;
            }
        }

}
