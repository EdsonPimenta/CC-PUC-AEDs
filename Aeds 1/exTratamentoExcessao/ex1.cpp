#include <iostream>
#include <exception>
using namespace std;

class  ExcecaoValorInvalido:public exception{






};




int main()
{
int numero;
try{
    
int dado[] = {1,2,3,4,5,6};
cout<<"Digite um numero para o dado:"<<endl;
cin>>numero;

if(numero<1||numero>6){
    throw exception();
}

}
catch(exception& e){
    cout<<"Erro, valor invalido: "<<numero <<endl;

}

return 0;
}