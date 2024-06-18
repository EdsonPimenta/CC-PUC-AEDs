#include <iostream>
#include <string>
#include <string.h>

using  namespace std;

class Forma{

public:
double perimetro;
double area;
string nome;


void setArea(double area)
{
    this->area = area;
}
void setPerimetro(double permetro)
{
    this->perimetro = perimetro;
}
void setNome(string nome)
{
    this->nome = nome;
}
double getArea()
{
    return area;
}
double getPerimetro(){
    return perimetro;
}
string getNome()
{
    return nome;
}



void imprimir(string nome,double altura,double base,double raio){
    if(nome=="Circulo"||nome == "circulo")
        cout<<"Nome: "<<nome <<", "<<"Raio: " << raio << endl;
    else
        cout<<"Nome: "<< nome<<", "<<"Base: " <<base<<", "<< "altura: "<<altura<<endl;
}
void mostraForma(double area,double perimetro){
    cout<<"A area eh: "<< area << endl<<"O perimetro eh: "<< perimetro << endl<<endl;
      
}




};


class Retangulo: public Forma{

protected:
double base;
double altura;
public:
void setBase(double base)
{
    this->base = base;
}
void setAltura(double altura)
{
    this->altura = altura;
}
double getBase()
{
    return base;
}
double getAltura()
{
    return altura;
}



};


class Circulo: public Forma{

private:
double raio;
public:
void setRaio(double raio)
{
    this->raio = raio;
}
double getRaio()
{
    return  raio;;
}
};

class Quadrado: public Retangulo{


};

int main()
{

Retangulo retangulo;
Quadrado quadrado;
Circulo circulo;

double area;
double perimetro;
double lado;
double altura;
double raio;

retangulo.setNome("Retangulo");
retangulo.setAltura(5);
retangulo.setBase(2);

perimetro = (retangulo.getAltura()*2)+(retangulo.getBase()*2);
area = retangulo.getAltura()*retangulo.getBase();

retangulo.setArea(area);
retangulo.setPerimetro(perimetro);
retangulo.imprimir(retangulo.getNome(),retangulo.getAltura(),retangulo.getBase(),0);
retangulo.mostraForma(area,perimetro);




quadrado.setNome("quadrado");
quadrado.setAltura(10);
quadrado.setBase(3);

perimetro = (quadrado.getAltura()*2)+(quadrado.getBase()*2);
area = quadrado.getAltura()*quadrado.getBase();

quadrado.setArea(area);
quadrado.setPerimetro(perimetro);
quadrado.imprimir(quadrado.getNome(),quadrado.getAltura(),quadrado.getBase(),0);
quadrado.mostraForma(area,perimetro);




circulo.setNome("circulo");
circulo.setRaio(4);

perimetro = 2*3.14*circulo.getRaio();
area = (circulo.getRaio()*circulo.getRaio())*3.14;

circulo.setArea(area);
circulo.setPerimetro(perimetro);
circulo.imprimir(circulo.getNome(),0,0,circulo.getRaio());
circulo.mostraForma(area,perimetro);
    
    return 0;
}