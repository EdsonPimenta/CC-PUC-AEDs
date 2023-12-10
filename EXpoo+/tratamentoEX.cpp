#include <iostream>
#include <string>
#include <string.h>
#include <exception>
using namespace std;


class TrataEx{

private: 
string erro;

public:
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
    TrataEx ex;
    int n;

    try{
    printf("Digite o numero de um dado: ");
    cin>>n;
     if(n<1||n>6)
        throw ex;
    }


return 0;
}