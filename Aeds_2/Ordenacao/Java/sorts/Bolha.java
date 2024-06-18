package sorts;

/**
 * Metodo de ordenacao da bolha
 * @author Max do Val Machado
 * @version 3 08/2020
 */
class Bolha extends Geracao {

	/**
	 * Construtor.
	 */
   public Bolha(){
      super();
   }


	/**
	 * Construtor.
	 * @param int tamanho do array de numeros inteiros.
	 */
   public Bolha(int tamanho){
      super(tamanho);
   }


	/**
	 * Algoritmo de ordenacao Bolha.
	 */
   @Override
   public void sort() {
		for (int i = (n - 1); i > 0; i--) {
			for (int j = 0; j < i; j++) {
				++count;
				if (array[j] > array[j + 1]) {
               swap(j, j+1);
			   	moviment+=3;
				}
			}
		}
		System.out.println("Comparacoes: " + count + "  " + "Movimentacoes: " + moviment);
   }
}
