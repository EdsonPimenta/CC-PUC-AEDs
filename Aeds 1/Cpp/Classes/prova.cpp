#include <iostream>
#include <string>
using namespace std;

class Veiculo{
protected:
    string marca;
    int qtdRodas;;
    int qtdCombustivel;

public:
    Veiculo(string marca,int qtdRodas):marca(marca),qtdRodas(qtdRodas),qtdCombustivel(0){}
    
    virtual int abastecer()
    {
        qtdCombustivel+=2;
        return 2;
    }
    virtual void imprimirDados()
    {
        cout<<"marca: "<<marca<<"Rodas: "<<qtdRodas<<"qtdRodas: "<<"Combustivel: "<<qtdCombustivel<<endl;
    }


};

class Moto: public Veiculo{
public:



};




int main()
{




    return 0;
}