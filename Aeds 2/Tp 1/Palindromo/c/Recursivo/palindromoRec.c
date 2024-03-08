#include <stdio.h>
#include <stdbool.h>
#include <string.h> 
// clear && gcc palindromoRec.c && ./a.out < pub.in > result.txt
bool isPalindromo(int left,int right,char word[]){

    if (left>=right){
        return true;
    }
    
    if (word[left] < 128 || word[right] < 128) {
        if (word[left] != word[right]){
            return false;
        }
    }

    return isPalindromo(left + 1, right - 1, word);
}


int main(){
    char word[500];
    
    scanf(" %[^\r\n]",word);
    
    int tam =  strlen(word);
    int i  = 0;
    int j = tam/2;
    
    while(strcmp(word,"FIM")){
        
        tam = strlen(word);
        if(isPalindromo(0, tam - 1, word)==true){
            printf("SIM\n");
        }
        else
            printf("NAO\n");

        scanf(" %[^\r\n]",word);
    }


    return 0;
}