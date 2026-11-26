package Labirinto;

import java.util.ArrayList;
import java.util.List;

/*
 Encontra o menor caminho entre duas posições usando recursão
  Testa todos os caminhos possíveis e guarda o mais curto.
 */
public class BuscaRecursiva {
    private Labirinto labirinto;
    private boolean[][] visitado;
    private List<Posicao> caminhoAtual;
    private List<Posicao> melhorCaminho;

    public BuscaRecursiva(Labirinto labirinto) {
        this.labirinto = labirinto;
    }

    // Devolve o menor caminho de origem até destino, ou null se não existir.
    public List<Posicao> menorCaminho(Posicao origem, Posicao destino) {
        visitado = new boolean[labirinto.linhas()][labirinto.colunas()];
        caminhoAtual = new ArrayList<>();
        melhorCaminho = null;

        buscar(origem.linha, origem.coluna, destino);
        return melhorCaminho;
    }

    private void buscar(int linha, int coluna, Posicao destino) {
        // Parede, fora da matriz ou já passou por aqui
        if (!labirinto.podeAndar(linha, coluna) || visitado[linha][coluna]) return;

        // Se já ficou maior que o melhor caminho, para
        if (melhorCaminho != null && caminhoAtual.size() + 1 >= melhorCaminho.size()) return;

        // Entra na célula
        Posicao aqui = new Posicao(linha, coluna);
        caminhoAtual.add(aqui);
        visitado[linha][coluna] = true;

        if (aqui.igual(destino)) {
            // Guarda uma cópia do caminho
            melhorCaminho = new ArrayList<>(caminhoAtual);
        } else {
            // Tenta as 4 direções
            buscar(linha - 1, coluna, destino); // cima
            buscar(linha + 1, coluna, destino); // baixo
            buscar(linha, coluna - 1, destino); // esquerda
            buscar(linha, coluna + 1, destino); // direita
        }

        // Volta para testar outros caminhos
        visitado[linha][coluna] = false;
        caminhoAtual.remove(caminhoAtual.size() - 1);
    }
}
