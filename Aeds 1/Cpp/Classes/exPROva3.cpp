#include <iostream>
#include <string>
#include <string.h>
using namespace std;

class Elevador{
private:
int andarAtual;
int quantidadePessoas;

public:
Elevador(){}

void setAndarAtual(int andarAtual)
{
    this->andarAtual = andarAtual;
}

void setQuantidadePessoas(int quantidadePessoas)
{
    this->quantidadePessoas=quantidadePessoas;
}

void SubirAndar()
{
    andarAtual++;
}

void descerAndar()
{
    andarAtual--;
}

void adicionarPessoas(int adicionarPessoas)
{
    quantidadePessoas+=adicionarPessoas;
}

void retirarPessoas(int quantidade)
{
    quantidadePessoas-=quantidade;
}

int getAndar(){
    return andarAtual;
}
int getQtdPessoas()
{
    return quantidadePessoas;
}


};



int main(){

Elevador elevador1;
elevador1.setAndarAtual(5);
elevador1.setQuantidadePessoas(10);
elevador1.adicionarPessoas(2);
elevador1.SubirAndar();

cout<<"O elevador esta no andar: "<<elevador1.getAndar()<<endl;
cout<<"Tem: "<<elevador1.getQtdPessoas()<<" pessoas"<<endl;




    return 0;
}