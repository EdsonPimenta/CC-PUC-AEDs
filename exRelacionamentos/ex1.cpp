#include <iostream>
#include <string>
#include <string.h>
using namespace std;

class itemComanda{
    private:
    string descricao;
    double valor;

    public:
    itemComanda()
    {
    }

    void setDescricao(string descricao)
    {
        this->descricao = descricao;
    }
    void setValor(double valor)
    {
        this-> valor = valor;
    }
    string getDescricao()
    {
        return descricao;
    }
    double getValor()
    {
        return valor;
    }

};


class Cliente{

private:
string nome;
string cpf;

public:
void setNome(string nome){
    this->nome = nome;
}
void setCpf(string cpf)
{
    this->cpf = cpf;
}
string getNome(){
    return nome;
}
string getCpf(){
    return cpf;
}




};


class Comanda{

private:
Cliente cliente;
string data;
string garcon;
int contador = 0;
float valorTotal = 0;

public:
itemComanda item[10];                
Comanda(){}
void setCliente(Cliente cliente)
{
    this->cliente = cliente;
}
Cliente getCliente()
{
    return cliente;
}

void adicionarItemComanda(itemComanda item)
{
    
    item.getDescricao();
    item.getValor();
    contador++;
    valorTotal+= item.getValor();
    
}
int getNumerosItensComanda()
{
    return contador;
}
float getValorTotal()
{
    return valorTotal;
}

void setData(string data)
{
    this->data = data;
}
void setGarcon(string garcon)
{
    this->garcon = garcon;
}

string getData()
{
    return data;
}
string getGarcon()
{
    return garcon;
}

};


int main(){
    Comanda* comanda = new Comanda[10];   
    Cliente cliente[10];
    int QTDcliente = 0;
    string descricao;
    double valor;
    int i = comanda->getNumerosItensComanda();
   
    string data;
    string garcon;
   
    string cpf;
    string nome;
    
    cliente[QTDcliente].setNome("Edson");
    cliente[QTDcliente].setCpf("140.375.676.79");

    comanda->setCliente(cliente[QTDcliente]);
    
    int itens;
    
       

    comanda->item[i].setDescricao("Queijo");
    comanda->item[i].setValor(30);
    comanda->adicionarItemComanda(comanda->item[i]);
    cout<<"O valor total da comanda eh: "<<comanda->getValorTotal()<<endl;



    




    return 0;
}