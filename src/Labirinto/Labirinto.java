package Labirinto;

import java.util.ArrayList;
import java.util.List;

/*
 Guarda a matriz do labirinto
 S = início, T = tesouro, # = parede, . = caminho livre, E = saída
 */
public class Labirinto {
    private char[][] matriz;

    // Monta a matriz a partir das linhas, tirando os espaços
    public Labirinto(String... linhas) {
        matriz = new char[linhas.length][];
        for (int i = 0; i < linhas.length; i++) {
            matriz[i] = linhas[i].replace(" ", "").toCharArray();
        }
    }

    public char simbolo(Posicao p) {
        return matriz[p.linha][p.coluna];
    }

    // Verifica se está dentro da matriz e não é parede
    public boolean podeAndar(int linha, int coluna) {
        return linha >= 0 && linha < matriz.length
            && coluna >= 0 && coluna < matriz[0].length
            && matriz[linha][coluna] != '#';
    }

    // Procura a primeira posição com o símbolo
    public Posicao encontrar(char simbolo) {
        List<Posicao> lista = encontrarTodos(simbolo);
        return lista.isEmpty() ? null : lista.get(0);
    }

    // Procura todas as posições com o símbolo
    public List<Posicao> encontrarTodos(char simbolo) {
        List<Posicao> lista = new ArrayList<>();
        for (int l = 0; l < matriz.length; l++) {
            for (int c = 0; c < matriz[l].length; c++) {
                if (matriz[l][c] == simbolo) lista.add(new Posicao(l, c));
            }
        }
        return lista;
    }

    public int linhas()  { return matriz.length; }
    public int colunas() { return matriz[0].length; }

    public void imprimir() {
        for (char[] linha : matriz) {
            System.out.println(new String(linha).replace("", " ").trim());
        }
        System.out.println();
    }
}
