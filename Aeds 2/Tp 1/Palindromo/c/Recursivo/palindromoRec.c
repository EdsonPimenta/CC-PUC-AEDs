#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool isPalindromo(char word[],int tam,int i){
    bool ehPalindromo = true;
    
    if(i>tam){
        return ehPalindromo;
    }
    else if(word[i]>0||word[tam-1]>0){
         if(word[i]!=word[tam-1])
         return ehPalindromo = false;
    }
    else 
        return isPalindromo(word,tam-1,i-1);
}


int main(){
    char word[50];
    scanf(" %[^\r\n]",word);
    
    int tam =  strlen(word);
    int i  = 0;
    
    while(strcmp(word,"FIM")){
        
        if(isPalindromo(word,tam,i)==true){
            printf("SIM\n");
        }
        else
            printf("NAO\n");

        scanf(" %[^\r\n]",word);
        i = 0;
        tam = strlen(word);
    }


    return 0;
}