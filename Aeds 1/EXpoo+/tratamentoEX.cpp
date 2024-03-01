#include <iostream>
#include <string>
#include <string.h>
#include <exception>
using namespace std;


class TrataEx:public exception {

private: 
string erro;

public:
TrataEx(string erro)
{
    this->erro = erro;
}
void setErro(string erro)
{
    this->erro =  erro;

}
string getErro(){
    return erro;
}
};



int main()
{
    TrataEx ex = TrataEx("Valor invalido");
    int n;

    try{
    printf("Digite o numero de um dado: ");
    cin>>n;
     if(n<1||n>6)
        throw ex;
    }catch(TrataEx& ex)
    {
        cerr<<"Erro: "<<ex.what()<<endl<<ex.getErro()<<endl;

    }


return 0;
}