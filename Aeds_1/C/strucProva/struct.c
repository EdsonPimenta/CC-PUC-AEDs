#include <stdio.h>
#include <stdlib.h>
#include <string.h>


typedef struct Paciente{

char nome[30];
int codigo;
int vetDoenca[100];
char genero;
}Paciente;



Paciente cadastraPac(char nome[],int codigo,char genero) {
Paciente paciente;
paciente.nome;
paciente.codigo;
paciente.genero;



return paciente;

}
void registraDoenca(Paciente* paciente,int vetDoenca[],int qtdDoenca)
{
    for(int i = 0;i<qtdDoenca;i++)
    {
        scanf("%d",&paciente->vetDoenca[i]);
    }
}


int qtdDoenca(Paciente paciente[],int codigoDoenca,int tam1,int tam2) 
{
    int c = 0;

    for(int i = 0;i<1;i++)
        for(int j = 0;j<tam1;j++)
    {
        if(paciente[i].vetDoenca[j] == codigoDoenca)
        c++; 
    }
    for(int i = 1;i<=1;i++)
    {
        for(int j = 0;j<tam2;j++)
        {
            if(paciente[i].vetDoenca[j]==codigoDoenca)
                c++;
        }
    }

    return c;
}


int main() {

    Paciente paciente[100];
     paciente[0] = cadastraPac("nome",18,'M');
     paciente[1] = cadastraPac("nome2",19,'F');
    registraDoenca(&paciente[0],paciente->vetDoenca,2);
    registraDoenca(&paciente[1],paciente->vetDoenca,5);
    int resultado = qtdDoenca(paciente,99,2,5);
    printf("%d",resultado);




    return 0;
}

