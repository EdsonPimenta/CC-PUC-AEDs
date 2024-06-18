package sorts;
/**
 * Algoritmo de ordenacao por insercao
 * @author Max do Val Machado
 * @version 3 01/2020
 */

class Insercao extends Geracao {

	/**
	 * Construtor.
	 */
   public Insercao(){
      super();
   }


	/**
	 * Construtor.
	 * @param int tamanho do array de numeros inteiros.
	 */
   public Insercao(int tamanho){
      super(tamanho);
   }
   

	/**
	 * Algoritmo de ordenacao por insercao.
	 */
   @Override
   public void sort() {
		for (int i = 1; i < n; i++) {
			int tmp = array[i];
         int j = i - 1;
         count+=2;
         while ((j >= 0) && (array[j] > tmp)) {
            array[j + 1] = array[j];
            j--;
         }
         array[j + 1] = tmp;
         moviment += 3;
      }
	   
      System.out.println("Comparacoes: " + count + "  " + "Movimentacoes: " + moviment);
   }
   
}

