public class jogoVida{
   public int Tabuleiro(){
    for (int[] linha : matriz) {
            for (int coluna : linha) {
                System.out.print(coluna + " ");
            }
            System.out.println();
        }
   
}