import java.util.Scanner;

public class jogo {
	public static void main(String[] args) {

		int linha, coluna, rodada = 1, tamanho = 60;
		String player1, player2;
		String tabuleiro[][] = new String[3][3];
		boolean vitoria = false;

		Scanner leia = new Scanner(System.in);

		for (linha = 0; linha < 3; linha++) {
			for (coluna = 0; coluna < 3; coluna++) {
				tabuleiro[linha][coluna] = " ";
			}
		}
		linha(tamanho);
		System.out.println("\n\t\t     Jogo da velha");
		linha(tamanho);
		System.out.println("\nDigite o nome do(a) primeiro(a) jogador(a): ");
		player1 = leia.nextLine();
		System.out.println("Digite o nome do(a) segundo(a) jogador(a): ");
		player2 = leia.nextLine();

		do {
			linha(tamanho);
			System.out.printf("\n\t\t     Rodada %d\n", rodada);
			linha(tamanho);
			System.out.printf("\nÉ a vez do jogador: %s\n", player1);
			do {
				System.out.print("Digite a linha: ");
				linha = leia.nextInt();
				while (linha < 0 || linha > 2) {
					System.out.println("Valor incorreto. Digite um valor entre 0 e 2: ");
					linha = leia.nextInt();
				}
				System.out.print("Coluna: ");
				coluna = leia.nextInt();
				while (coluna < 0 || linha > 2) {
					System.out.println("Valor incorreto. Digite um valor entre 0 e 2: ");
					coluna = leia.nextInt();
				}
				if (verificaTabuleiro(tabuleiro, linha, coluna) == false) {
					System.out.println("Já jogaram nesta posição. Escolha outra possição no tabuleiro.");
				}
			} while (verificaTabuleiro(tabuleiro, linha, coluna) == false);
			tabuleiro[linha][coluna] = "O";

			for (linha = 0; linha < 3; linha++) {
				for (coluna = 0; coluna < 3; coluna++) {
					if (coluna == 2) {
						System.out.printf(" %s", tabuleiro[linha][coluna]);
					} else {
						System.out.printf(" %s |", tabuleiro[linha][coluna]);
					}
				}
				System.out.println("");
			}
			if (verificaVitoria(tabuleiro) == true) {
				System.out.printf("Parabéns %s, você ganhou a partida!!!", player1);
				break;
			}
			if(rodada == 9) {
				System.out.println("Parabéns aos dois, partida empatada =).");
				break;
			}
			rodada++;
			linha(tamanho);
			System.out.printf("\n\t\t     Rodada %d\n", rodada);
			linha(tamanho);
			System.out.printf("\nÉ a vez do jogador: %s\n", player2);
			do {
				System.out.print("Digite a linha: ");
				linha = leia.nextInt();
				while (linha < 0 || linha > 2) {
					System.out.println("Valor incorreto. Digite um valor entre 0 e 2: ");
					linha = leia.nextInt();
				}
				System.out.print("Coluna: ");
				coluna = leia.nextInt();
				while (coluna < 0 || linha > 2) {
					System.out.println("Valor incorreto. Digite um valor entre 0 e 2: ");
					coluna = leia.nextInt();
				}
				if (verificaTabuleiro(tabuleiro, linha, coluna) == false) {
					System.out.println("Já jogaram nesta posição. Escolha outra possição no tabuleiro.");
				}
			} while (verificaTabuleiro(tabuleiro, linha, coluna) == false);
			tabuleiro[linha][coluna] = "X";

			for (linha = 0; linha < 3; linha++) {
				for (coluna = 0; coluna < 3; coluna++) {
					if (coluna == 2) {
						System.out.printf(" %s", tabuleiro[linha][coluna]);
					} else {
						System.out.printf(" %s |", tabuleiro[linha][coluna]);
					}
				}
				System.out.println("");
			}
			if (verificaVitoria(tabuleiro) == true) {
				System.out.printf("Parabéns %s, você ganhou a partida!!!", player2);
				break;
			}
			rodada++;
		} while (vitoria == false);
	}

	static void linha(int tamanho) {
		for (int x = 0; x < tamanho; x++) {
			System.out.print("=");
		}
	}

	static boolean verificaVitoria(String tabuleiro[][]) {
		boolean vitoria = false;
		// colunas
		if (tabuleiro[0][0] == "X" && tabuleiro[1][0] == "X" && tabuleiro[2][0] == "X"
				|| tabuleiro[0][0] == "O" && tabuleiro[1][0] == "O" && tabuleiro[2][0] == "O") {
			vitoria = true;
		} else if (tabuleiro[0][1] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][1] == "X"
				|| tabuleiro[0][1] == "O" && tabuleiro[1][1] == "O" && tabuleiro[2][1] == "O") {
			vitoria = true;
		} else if (tabuleiro[0][2] == "X" && tabuleiro[1][2] == "X" && tabuleiro[2][2] == "X"
				|| tabuleiro[0][2] == "O" && tabuleiro[1][2] == "O" && tabuleiro[2][2] == "O") {
			vitoria = true;
		}
		// linhas
		else if (tabuleiro[0][0] == "X" && tabuleiro[0][1] == "X" && tabuleiro[0][2] == "X"
				|| tabuleiro[0][0] == "O" && tabuleiro[0][1] == "O" && tabuleiro[0][2] == "O") {
			vitoria = true;
		} else if (tabuleiro[1][0] == "X" && tabuleiro[1][1] == "X" && tabuleiro[1][2] == "X"
				|| tabuleiro[1][0] == "O" && tabuleiro[1][1] == "O" && tabuleiro[1][2] == "O") {
			vitoria = true;
		} else if (tabuleiro[2][0] == "X" && tabuleiro[2][1] == "X" && tabuleiro[2][2] == "X"
				|| tabuleiro[2][0] == "O" && tabuleiro[2][1] == "O" && tabuleiro[2][2] == "O") {
			vitoria = true;
		}
		// diagonais
		else if (tabuleiro[0][0] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][2] == "X"
				|| tabuleiro[0][0] == "O" && tabuleiro[1][1] == "O" && tabuleiro[2][2] == "O") {
			vitoria = true;
		} else if (tabuleiro[0][2] == "X" && tabuleiro[1][1] == "X" && tabuleiro[2][0] == "X"
				|| tabuleiro[0][2] == "O" && tabuleiro[1][1] == "O" && tabuleiro[2][0] == "O") {
			vitoria = true;
		}
		return vitoria;
	}
	static boolean verificaTabuleiro(String tabuleiro[][], int linha, int coluna) {
		if (tabuleiro[linha][coluna].equals("X") || tabuleiro[linha][coluna].equals("O")) {
			return false;
		}
		return true;
	}
}
