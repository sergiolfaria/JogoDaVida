import java.util.*;


class JogoDaVida {
   int tamanhoDigitado;
   int[][] matriz;
   
   
//tamanho = lerTamanho();
   public void receberMatriz(){
      Scanner teclado = new Scanner(System.in);
      boolean validInput = false;
        // verifica se a resposta do usuário é um número, caso não seja o while repete,
        // até ser.
      while (!validInput) {
            System.out.println("Digite o tamanho desejado de matriz: ");
            String input = teclado.nextLine();
            try {
                tamanhoDigitado = Integer.parseInt(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("A entrada não é um número inteiro válido. Tente novamente.");
            }
        }
     }

//inicializarMatriz(tamanho);
   public void criarMatriz(int tamanhoDigitado) {
        matriz = new int[tamanhoDigitado][tamanhoDigitado];
   }
    
    
   public void popularMatriz() {
      for (int i = 0; i < tamanhoDigitado; i++) {
         for (int j = 0; j < tamanhoDigitado; j++) {
            GerarAleatorio valor = new GerarAleatorio();
            int numeroAleatorio = valor.aleatorio();
            matriz[i][j] = numeroAleatorio;
         }
      }
   }
 //imprimirMatriz() 
   public void imprimirMatriz(){
      for (int[] linha : matriz) {
         for (int coluna : linha) {
            System.out.print(coluna + " ");
         }
         System.out.println();
      }
   }

   public void iniciarJogo() {
      receberMatriz();
      criarMatriz(tamanhoDigitado);
      popularMatriz();
      imprimirMatriz();
         }
}

   public void exibirMenu(){
      System.out.println("Deseja iniciar uma nova geração?");
      System.out.println("digite 1 para gerar a nova matriz, logo se desejar sair digite 2.");
      Scanner teclado = new Scanner(System.in);
      teclado = opcao;
      boolean validInput = false;
       while (!validInput) {
       if(opcao == 1){
          //calcularProximaGeracao();
         //imprimirMatriz();

         validInput = true;
       }
       else if(opcao == 2){
        

         validInput = true;
       }
       else{
         validInput = false;
       }
      }
   }
   
   
   
   
   
   

  
   
   //For
   //exibirMenu();
   //calcularProximaGeracao();
   //imprimirMatriz();























/*  private Matriz matriz;
  private int tamanhoMatriz;

  public void iniciarJogo() {
        this.matriz = new Matriz();
        matriz.instanciarMatriz();
        
    }

    public int contarVizinhosVivos(int linha, int coluna) {
        int numVizinhosVivos = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                // Ignora a célula atual
                if (i == 0 && j == 0) {
                    continue;
                }

                // Obtém as coordenadas do vizinho
                int vizinhoLinha = (linha + i + receberMatriz) % tamanhoMatriz;
                int vizinhoColuna = (coluna + j + receberMatriz) % tamanhoMatriz;

                // Incrementa o número de vizinhos vivos, se o vizinho estiver vivo
                if (matriz[vizinhoLinha][vizinhoColuna] == 1) {
                    numVizinhosVivos++;
                }
            }
        }
        return numVizinhosVivos;
    }*/