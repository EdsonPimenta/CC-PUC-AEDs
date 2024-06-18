#include <stddef.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Exercicio: Ordenação por Tamanho, Nível: 4, BeeCrowd


// ---------------- structs -------
typedef struct arrStrings{
    char palavra[200];
} arrStrings;

typedef struct sizeArr{
    int size;
} sizeArr;

// ordena array de strings por tamanho
void ordenaArr(arrStrings* arr,sizeArr* object){
    for(int i = 0; i < object->size - 1;i++){
        int menorIndice = i;
        for(int j = i+1;j < object->size;j++){
            if(strlen(arr[menorIndice].palavra)<strlen(arr[j].palavra)){
                menorIndice = j;
            }
        }
        char aux[100];
        strcpy(aux,arr[i].palavra);
        strcpy(arr[i].palavra, arr[menorIndice].palavra);
        strcpy(arr[menorIndice].palavra, aux);
    }

}

// separa string por espaço usando strtoken, e chama a função para ordenar o array de strings
void separaPorEspaco(char string[],arrStrings* arr,sizeArr* object){
    
    char* token;
    char delimitador[] = " ";
    token = strtok(string,delimitador);
    while (token!=NULL) {
        strcpy(arr[object->size].palavra, token);
        token = strtok(NULL,delimitador);
        object->size++;
    }
    ordenaArr(arr,object);
    
    
}
// ler string e chama a função para separa-la por espaço
void lerString(arrStrings* arr,sizeArr* object){
        char string[250];
        scanf(" %[^\n]",string);
        separaPorEspaco(string,arr,object);
    
}

// printa array de strings
void printaArr(arrStrings* arr,sizeArr* object){
    for(int i = 0; i < object->size;i++){
        printf("%s ",arr[i].palavra);
    }
    printf("\n");
}

// ------ Main -------------------------------------------------
int main(){
    int n;
    arrStrings* arr = (arrStrings*) malloc(200*sizeof(arrStrings));
    sizeArr* object;
    scanf("%d",&n);
    for(int i = 0; i < n; i++){
        object->size = 0;
        lerString(arr,object);
        printaArr(arr,object);
    }
    free(arr);



    return 0;
}