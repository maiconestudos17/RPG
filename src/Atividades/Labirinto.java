package Atividades;

import java.util.Random;
import java.util.Scanner;

public class LabirintoTwo {
    public static int gerarPosicaoAleatoria(int limite) {
        Random random = new Random();
        return random.nextInt(limite);
    }

    public static boolean dentroDosLimites(int linha, int coluna, int linhasMax, int colunasMax) {
        return linha >= 0 && linha < linhasMax && coluna >= 0 && coluna < colunasMax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] labirinto = {
                {'1', '0', '0', '0', '0'},
                {'0', '1', '0', '1', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '1', '0', '1', '0'},
                {'0', '0', '0', '1', '0'}
        };

        int linhaHeroi;
        int colunaHeroi;

        do{
            linhaHeroi = gerarPosicaoAleatoria(5);
            colunaHeroi = gerarPosicaoAleatoria(5);
        }while (labirinto[linhaHeroi][colunaHeroi] != '0');

        labirinto[linhaHeroi][colunaHeroi] = 'H';

        int linhaTesouro;
        int colunaTesouro;

        do{
            linhaTesouro = gerarPosicaoAleatoria(5);
            colunaTesouro = gerarPosicaoAleatoria(5);
        }while (labirinto[linhaTesouro][colunaTesouro] != '0');

        labirinto[linhaTesouro][colunaTesouro] = 'T';

        boolean venceu = false;

        while (!venceu){


            System.out.println("\nLABIRINTO:");

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(labirinto[i][j] + " ");
                }
                System.out.println();
            }

            System.out.print("\nMovimento " +
                    "(W = Cima / S = Baixo / A = Esquerda / D = Direita): ");
            String comando = sc.nextLine().toUpperCase();

            int novaLinha = linhaHeroi;
            int novaColuna = colunaHeroi;

            switch (comando){
                case "W":
                    novaLinha--;
                    break;
                case "A":
                    novaColuna--;
                    break;
                case "S":
                    novaLinha++;
                    break;
                case "D":
                    novaColuna++;
                    break;
                default:
                    System.out.println("\nMOVIMENTO INVÁLIDO!");
                    continue;

            }

            if(!dentroDosLimites(novaLinha, novaColuna, 5, 5)){
                System.out.println("\nVOCÊ SAIU DOS LIMITES!");
                continue;
            }

            if (labirinto[novaLinha][novaColuna] == '1'){
                System.out.println("\nHÁ UMA PAREDE AQUI!");
                continue;
            }

            if (labirinto[novaLinha][novaColuna] == 'T'){
                venceu = true;
            }

            labirinto[linhaHeroi][colunaHeroi] = '0';

            linhaHeroi = novaLinha;
            colunaHeroi = novaColuna;

            labirinto[linhaHeroi][colunaHeroi] = 'H';
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(labirinto[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(
                "Parabéns! Você encontrou o tesouro do Reino de Salesiania!"
        );

        sc.close();

    }
}
