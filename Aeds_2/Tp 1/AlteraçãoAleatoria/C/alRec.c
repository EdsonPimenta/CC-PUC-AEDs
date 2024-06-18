#include <stdlib.h>
#include <string.h>
#include <stdio.h>

void alteraString(int count,int tam,char word[],char primeiraLetra,char segundaLetra){
    if(count>tam){
        return;
    }
    else if(word[count] ==  primeiraLetra){
        word[count] = segundaLetra;
    }
    alteraString(count+1,tam,word,primeiraLetra,segundaLetra);

}


int main(){
    srand(4);   
    
    char primeiraLetra;
    char segundaLetra;
    char word[500];
    
    primeiraLetra = (char)('a'+(rand() % 26));
    segundaLetra = (char)('a'+(rand() % 26));
    
    scanf(" %[^\n]", word);

    while(strcmp(word,"FIM")){
    
    int tam = strlen(word);


    alteraString(0,tam-1,word,primeiraLetra,segundaLetra);
    printf("%s\n",word);
    scanf(" %[^\n]", word);
    primeiraLetra = (char)('a'+(rand() % 26));
    segundaLetra = (char)('a'+(rand() % 26));

    }
}