package Labirinto;

// Guarda uma posição (linha, coluna) do labirinto
public class Posicao {
    int linha;
    int coluna;

    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    // Verifica se é a mesma posição
    public boolean igual(Posicao outra) {
        return linha == outra.linha && coluna == outra.coluna;
    }

    @Override
    public String toString() {
        return "(" + linha + "," + coluna + ")";
    }
}
