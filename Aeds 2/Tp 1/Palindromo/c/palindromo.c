#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

// clear && gcc palindromo.c && ./a.out < pub.in > result.txt

bool isPalindromo(char string[])
{
    
    bool resultado = true;
    int tam = strlen(string);
    int j = tam - 1;
    for (int i = 0; i < tam / 2; i++) {
        
        if(string[i]>0||string[j]>0){
            if(string[i]!=string[j])
                resultado = false;
                break;
        }
        else if(string[i]<0||string[j]<0)
        {
                if(string[i]==-17){
                    i+=2;
                    if(string[i]!=string[j]){
                        resultado = false;
                        break;
                    }
                    i--;
                    j--;
                }
                else if(string[i+1]!=string[j]){
                    resultado = false;
                    break;
                    
                }
                j--;
                i++;

        }
        j--;
    }

    return resultado;
}

 
int main()
{
    char palavra[500];

    scanf(" %[^\r\n]", palavra);

    while (strcmp(palavra, "FIM"))
    {
        // printf("entrei no whhile");
        if (isPalindromo(palavra) == true)

            printf("SIM\n");
        else
            printf("NAO\n");

        scanf(" %[^\r\n]", palavra);
    }
}