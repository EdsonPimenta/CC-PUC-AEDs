#include <iostream>
#include <string.h>
#include<string>
using namespace std;

class AnimaldeEstimacao{

protected:
string nome;
string raca;
public:
AnimaldeEstimacao(){}
int anda;
void setNome(string nome)
{
    this->nome = nome;
}
void setRaca(string raca)
{
    this->raca = raca;
}
string getNome()
{
    return nome;
}
string getRaca()
{
    return raca;
}
void caminha()
{
    cout<<"Caminha"<<endl;
}

};


class Cachorro: public AnimaldeEstimacao{

public:
Cachorro(){}
void late()
{
    cout<<"Late"<<endl;
}

};

class Gato: public AnimaldeEstimacao{
public:
Gato(){}
void mia()
{
    cout<<"Mia"<<endl;
}




};



int main()
{
    Cachorro cachorro;
    Gato gato;


    cachorro.setNome("Teca");
    cachorro.setRaca("Fox Paulistinha");
   
    cout<<"Nome cachorro: "<<cachorro.getNome()<<endl<<"Raca: "<<cachorro.getRaca()<<endl;
    cachorro.caminha();
    cachorro.late();


    gato.setRaca("Vira - lata");
    gato.setNome("Montilho");

    cout<<"Nome gato: "<<gato.getNome()<<endl<<"Raca: "<<gato.getRaca()<<endl;
    gato.caminha();
    gato.mia();

 return 0;
}