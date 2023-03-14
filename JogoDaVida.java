import java.util.*;

class JogoDaVida {
   
   int tamanhoDigitado;
   int[][] matriz;
   int opcao;
   int[][] novaMatriz;
   int tamanhoMatriz;
    
   // recebe o valor digitado pelo usuário para o tamanho desejado da matriz
   private void receberMatriz() {
      Scanner teclado = new Scanner(System.in);
      boolean validInput = false;
       
      // verificar se a resposta do usuário é um número, caso contrário, o while repete até receber um número
      while (!validInput){
         System.out.println("Digite o tamanho desejado para a matriz: ");
         String input = teclado.nextLine();
         
         try {
            tamanhoDigitado = Integer.parseInt(input);
            validInput = true;
            tamanhoMatriz = tamanhoDigitado;
         } 
         catch (NumberFormatException e){
            System.out.println("A entrada não é um número inteiro válido. Tente novamente.");
         }
      }
   }

   // inicializa a matriz criando ela com a dimensão escolhida pelo usuário 
   private void criarMatriz(int tamanhoMatriz) {
      matriz = new int[tamanhoMatriz][tamanhoMatriz];
   }
     
   // popula a matriz com valores gerados aleatoriamente, sendo eles 0 ou 1
   private void popularMatriz() {
      for (int i = 0; i < tamanhoMatriz; i++) {
         for (int j = 0; j < tamanhoMatriz; j++) {
            GerarAleatorio valor = new GerarAleatorio();
            int numeroAleatorio = valor.aleatorio();
            matriz[i][j] = numeroAleatorio;
         }
      }
   }
   
   // imprime a matriz 
   private void imprimirMatriz(){
      System.out.println();
      for (int[] linha : matriz){
         for (int coluna : linha){
            System.out.print(coluna + " ");
         }
         System.out.println();
      }
   }
   
   // imprime a nova matriz 
   private void imprimirNovaMatriz(){
      System.out.println();
      for (int[] linhaNova : novaMatriz){
         for (int colunaNova : linhaNova){
            System.out.print(colunaNova + " ");
         }
         System.out.println();
         matriz = novaMatriz;
      }
   }

   // inicializa o jogo chamando todos os métodos necessários para o funcionamento
   public void iniciarJogo(){
      receberMatriz();
      criarMatriz(tamanhoMatriz);
      popularMatriz();
      imprimirMatriz();
      
      while (opcao != 2){
         exibirMenu();    
      }
      encerrarJogo();
      
   }
   
   // Avisa ao usuario que ele encerrou o jogo.
   public void encerrarJogo(){
      if (opcao == 2){
         System.out.println("\nVoce encerrou o jogo!");
      }
   }

   // exibe o menu do jogo 
   public void exibirMenu(){
      System.out.println("\nDeseja iniciar uma nova geracao?");
      System.out.println("[1] Iniciar nova geracao\n[2] Sair do jogo\n\n");
      Scanner teclado = new Scanner(System.in);
      opcao = teclado.nextInt();
      calcularNovaGeracao();  
   }  
   
   // realiza o cálculo para gerar uma nova geração da matriz 
  

// conta quantos vizinhos vivos a célula tem
   public void calcularNovaGeracao(){
      novaMatriz = new int[tamanhoMatriz][tamanhoMatriz];

      for (int i = 0; i < tamanhoMatriz; i++){
         for (int j = 0; j < tamanhoMatriz; j++){
            int vizinhosVivos = contarVizinhos(i, j);

            if (matriz[i][j] == 1 && vizinhosVivos < 2){
               novaMatriz[i][j] = 0; // morre por solidão
            } 
            else if (matriz[i][j] == 1 && (vizinhosVivos == 2 || vizinhosVivos == 3)){
               novaMatriz[i][j] = 1; // sobrevive
            } 
            else if (matriz[i][j] == 1 && vizinhosVivos > 3){
               novaMatriz[i][j] = 0; // morre por superpopulação
            } 
            else if (matriz[i][j] == 0 && vizinhosVivos == 3){
               novaMatriz[i][j] = 1; // nasce por reprodução
            } 
            System.out.printf("(%d,%d) vizinhos vivos: %d\n", i, j, vizinhosVivos);
         }
      }
      imprimirNovaMatriz();
   }

   // conta quantos vizinhos vivos a célula tem
   public int contarVizinhos(int linha, int coluna){
      int vivos = 0;
      // Verificar vizinhos acima e abaixo
      for (int i = linha - 1; i <= linha + 1; i += 2) {
         int verificarLinha = i;
         int verificarColuna = coluna;
         
         if (verificarLinha < 0){
            verificarLinha = tamanhoMatriz - 1;
         } 
         else if (verificarLinha >= tamanhoMatriz){
            verificarLinha = 0;
         }
         if (matriz[verificarLinha][verificarColuna] == 1){
            vivos++;
         }
      }
      
      // Verificar vizinhos à esquerda e à direita
      for (int j = coluna - 1; j <= coluna + 1; j += 2){
         int verificarLinha = linha;
         int verificarColuna = j;
         if (verificarColuna < 0){
            verificarColuna = tamanhoMatriz - 1;
         }
         else if (verificarColuna >= tamanhoMatriz){
            verificarColuna = 0;
         }
         if (matriz[verificarLinha][verificarColuna] == 1){
            vivos++;
         }
      }
      return vivos;
   }
// classe auxiliar para gerar valores aleatórios para a matriz
}


      
      
