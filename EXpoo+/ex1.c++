#include <iostream>
#include <string.h>
#include <string>
using namespace std;


class Carro{
private:

string marca;
string modelo;
int quilometragem;
int anoDeFabricacao;


public:

Carro(){}

void setMarca(string marca){
this->marca = marca;
}

void setModelo(string modelo){
    this->modelo = modelo;
}

void setQuilometragem(int quilometragem)
{
    this->quilometragem = quilometragem;
}

void setAnoFabricacao(int anoDeFabricacao)
{
    this->anoDeFabricacao = anoDeFabricacao;
}


string getMarca()
{
    return marca;
}

string getModelo()
{
    return modelo;
}

int getQuilo()
{
    return quilometragem;
}

int getAno(){
    return anoDeFabricacao;
}

};

int main()
{   
    Carro carro1;
    carro1.setMarca("FIAT");
    carro1.setModelo("Ferrari");
    carro1.setQuilometragem(100);
    carro1.setAnoFabricacao(2023);

    cout<<"A marca do carro eh: "<<carro1.getMarca()<<endl;
    cout<<"O modelo do carro eh: "<<carro1.getModelo()<<endl;
    cout<<"O ano de fabricacao eh: "<<carro1.getAno()<<endl;
    cout<<"A  quilometragem eh: "<<carro1.getQuilo()<<endl;




    return 0;
}