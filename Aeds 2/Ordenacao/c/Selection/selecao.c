#include <stdio.h>
#include <stdlib.h>

void ordenaArray(int array[],int tam){
    //int menor;
    int indiceMenor;
    int aux;
    for(int i = 0;i<tam-1;i++){
        // menor = array[i];
        indiceMenor = i;
        for(int j = (i+1);j<tam;j++){
            if(array[j]<array[indiceMenor]){
                //menor = array[j];
                indiceMenor = j;
            }
        }
        int aux = array[i];
        array[i] = array[indiceMenor];
        array[indiceMenor] = aux;
    }

}

void printaVetor(int array[],int tam){
    for(int i = 0;i<tam;i++){
        printf("%d,",array[i]);
    }

}

int main(){
    int array[] = {6,20,10,5};
    ordenaArray(array,4);
    printaVetor(array,4);



return 0;
}