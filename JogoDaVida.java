import java.util.*;


class JogoDaVida {
   int tamanhoDigitado;
   int[][] matriz;
   int opcao;
   
   
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
      while(opcao != 2){
          exibirMenu();
          imprimirMatriz();
      }
     
         
    }

   public void exibirMenu(){
      System.out.println("Deseja iniciar uma nova geracao?");
      System.out.println("digite 1 para gerar a nova matriz, logo se desejar sair digite 2.");
      Scanner teclado = new Scanner(System.in);
      opcao = teclado.nextInt();
      boolean validInput = false;
      while (!validInput) {
         if(opcao == 1){
            calcularProximaGeracao();
            
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
   public void calcularProximaGeracao() {
       int[][] proximaGeracao = new int[tamanhoDigitado][tamanhoDigitado];
   
       // percorre a matriz atual
       for (int i = 0; i < tamanhoDigitado; i++) {
           for (int j = 0; j < tamanhoDigitado; j++) {
               // conta o número de vizinhos vivos
               int vizinhosVivos = 0;
               for (int k = i - 1; k <= i + 1; k++) {
                   for (int l = j - 1; l <= j + 1; l++) {
                       if (k >= 0 && k < tamanhoDigitado && l >= 0 && l < tamanhoDigitado) {
                           if (k != i || l != j) { // não contar a célula atual
                               vizinhosVivos += matriz[k][l];
                           }
                       }
                   }
               }
   
               // aplica as regras do jogo
               if (matriz[i][j] == 1) { // célula viva
                   if (vizinhosVivos < 2 || vizinhosVivos > 3) {
                       proximaGeracao[i][j] = 0; // morre
                   } else {
                       proximaGeracao[i][j] = 1; // continua viva
                   }
               } else { // célula morta
                   if (vizinhosVivos == 3) {
                       proximaGeracao[i][j] = 1; // nasce
                   } else {
                       proximaGeracao[i][j] = 0; // continua morta
                   }
               }
           }
       }
   
       // atualiza a matriz para a próxima geração
       matriz = proximaGeracao;
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