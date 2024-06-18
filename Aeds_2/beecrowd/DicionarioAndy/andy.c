#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

// -------- inicio struct -----
typedef struct Strings{
    char palavra[200];
}Strings;

typedef struct SizeArr{
    int size;
}SizeArr;

// transforma a string para minusculo
void toLower(char string[]){
    for(int i = 0; i < strlen(string);i++){
            string[i] = tolower(string[i]);
    }
}

// separa a string por espaços adicionando-as ao array
void separaPorEspaco(char string[],Strings* arr,SizeArr* object){
    char* token;
    char newChar[1000];
    char delimitador[] = ",";

    // retira os caracteres especiais
    for(int i = 0;i<strlen(string);i++){
        if(string[i]>0){
            newChar[i] = string[i];
        }
    }
    token = strtok(newChar,delimitador);
    while(token != NULL){
        strcpy(arr[object->size].palavra,token);
        token = strtok(NULL,delimitador);
        object->size++;
    }
    
}
// ordena array de strings (selection sort)
void ordenaArray(Strings* arr,SizeArr* object){
    for(int i = 0; i < object->size - 1;i++){
        int menorIndice = 0;
        for(int j = i + 1; j < object->size;j++){
            if(strcmp(arr[i].palavra,arr[j].palavra) > 0){
                menorIndice = j;
            }
        }
    char tmp[200];
    strcpy(tmp, arr[i].palavra);
    strcpy(arr[i].palavra , arr[menorIndice].palavra);
    strcpy(arr[menorIndice].palavra, tmp);
    
}
    }

// ler strings 
void lerString(Strings* arr,SizeArr* object){
    char string[200];
    int i = 0;
    while(scanf(" %[^\n]",string)!= EOF){
        toLower(string);
    }
    separaPorEspaco(string,arr,object);
    ordenaArray(arr,object);

}

//  printa array de strings
void printaArray(Strings* arr,SizeArr* object){
    for(int i = 0;i < object-> size;i++){
        printf("%s\n",arr[i].palavra);
    }
}

// ------ Main --------------------------------------------------------------------
int main(){
   Strings* arr = (Strings*) malloc(500*sizeof(Strings));
   SizeArr* object;
   object->size = 0;
   lerString(arr,object);
   free(arr);



    return 0;
}