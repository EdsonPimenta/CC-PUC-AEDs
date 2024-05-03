#include <sdio.h>

void ordenaArray(int array[],int tam){

    for(int i = 1 ;i < tam;i++){
        
        int aux = array[i];
        int j = i - 1;
        
        while(j>=0 && array[j]>aux){
            array[j+1] = array[j];
            j--;
        }
        array[j+1] = aux;
    }


}
void printaArray(int array[],int tam){
    for(int i = 0;i<tam;i++){
        printf("%d,",array[i]);
    }

}

int main(){

    int array[]={5,9,1,3,11};
    ordenaArray(array,5);
    printaArray(array,5);



    return 0;
}