#include <stdio.h>
#include <stdlib.h>

typedef struct Ponto{
float x;
float y;
}Ponto;


 
float distancia(Ponto* ponto)
{
    return ponto->y - ponto->x;
}
void atribuir(float a,float b,Ponto* ponto)
{

    ponto->x = a;
    ponto->y = b;

}



int main(){

Ponto *ponto;
Ponto *ponto2;






}