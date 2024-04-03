import java.util.*;

public class JogoDaVelha {
    // Representação do tabuleiro do jogo da velha
    private char[][] tabuleiro;

    // Construtor para inicializar o tabuleiro
    public JogoDaVelha() {
        tabuleiro = new char[3][3];
        iniciarTabuleiro();
    }

    // Inicializa o tabuleiro com espaços em branco
    private void iniciarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    // Exibe o tabuleiro atual
    public void exibirTabuleiro() {
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " | ");
            }
            System.out.println();
        }
    }

    // Verifica se o tabuleiro está cheio (empate)
    public boolean tabuleiroCheio() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false; // Ainda há espaços vazios
                }
            }
        }
        return true; // Tabuleiro está cheio
    }

    // Verifica se alguém ganhou o jogo
    public boolean verificarVitoria(char jogador) {
        // Verifica linhas e colunas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                return true; // Vitória na linha i
            }
            if (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador) {
                return true; // Vitória na coluna i
            }
        }
        // Verifica diagonais
        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
            return true; // Vitória na diagonal principal
        }
        if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
            return true; // Vitória na diagonal secundária
        }
        return false; // Ninguém ganhou ainda
    }

    // Marca uma jogada no tabuleiro
    public boolean fazerJogada(int coluna, int linha, char jogador) {
        if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[coluna][linha] == ' ') {
            tabuleiro[coluna][linha] = jogador;
            return true; // Jogada válida
        }
        return false; // Jogada inválida
    }

    // Algoritmo de busca em largura (BFS)
    public void BFS() {
    }

    // Algoritmo de busca em profundidade (DFS)
    public void DFS() {
    }

    public static void main(String[] args) {
        JogoDaVelha jogo = new JogoDaVelha();
        Scanner scanner = new Scanner(System.in);
        char jogadorAtual = 'X';

        System.out.println("Jogo da Velha\n");
        jogo.exibirTabuleiro();

        while (true) {
            System.out.println("\nJogador " + jogadorAtual + ", faça sua jogada (linha, coluna):");
            int coluna = scanner.nextInt();
            int linha = scanner.nextInt();

            if (jogo.fazerJogada(coluna, linha, jogadorAtual)) {
                jogo.exibirTabuleiro();
                if (jogo.verificarVitoria(jogadorAtual)) {
                    System.out.println("\nJogador " + jogadorAtual + " venceu!");
                    break;
                } else if (jogo.tabuleiroCheio()) {
                    System.out.println("\nEmpate!");
                    break;
                }
                jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X'; // Troca de jogador
            } else {
                System.out.println("\nJogada inválida, tente novamente.");
            }
        }

        scanner.close();
    }
}
