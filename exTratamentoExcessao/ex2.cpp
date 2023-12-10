#include <iostream>
#include <exception>
using namespace std;

class ExcecaoValorInvalido:public exception{
string msg;
public:
ExcecaoValorInvalido(string msg)
{
    this->msg = msg;
}
string getErro()
{
    return msg;
}



};



int main()
{
ExcecaoValorInvalido erro = ExcecaoValorInvalido("Valor invalido");
int numero;
int dado[] = {1,2,3,4,5,6};
try{

cout<<"Digite um numero para o dado:"<<endl;
cin>>numero;

if(numero<1||numero>6){
    throw  erro;
}

}catch(ExcecaoValorInvalido& ex){
    cerr<<"Erro: "<<ex.what()<<endl<<ex.getErro()<<":"<<numero;

}


}