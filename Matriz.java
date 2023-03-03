import java.util.*;
import java.util.Random;

public class Matriz {
    private int[][] matriz;

    public void criarMatriz(int tamanhoDigitado) {
        matriz = new int[tamanhoDigitado][tamanhoDigitado];
    }

    public void tamanhoMatriz() {
        Scanner teclado = new Scanner(System.in);
        boolean validInput = false;
        // verifica se a resposta do usuário é um número, caso não seja o while repete,
        // até ser.
        while (!validInput) {
            System.out.println("Digite o tamanho desejado de matriz: ");
            String input = teclado.nextLine();
            try {
                int tamanhoDigitado = Integer.parseInt(input);
                validInput = true;
                criarMatriz(tamanhoDigitado);
            } catch (NumberFormatException e) {
                System.out.println("A entrada não é um número inteiro válido. Tente novamente.");
            }
        }
    }

    public void imprimirMatriz() {
        tamanhoMatriz();
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("Digite o valor para a posição (" + i + ", " + j + "): ");
                int valor = teclado.nextInt();
                matriz[i][j] = valor;
            }
        }
        for (int[] linha : matriz) {
            for (int coluna : linha) {
                System.out.print(coluna + " ");
            }
            System.out.println();
        }
    }
}
