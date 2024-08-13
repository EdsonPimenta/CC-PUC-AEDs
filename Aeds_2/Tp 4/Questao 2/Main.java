import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DateFormat;

class Personagem {
    private String id;
    private String name;
    private List<String> alternate_names;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private Boolean hogwartsStaff;
    private Boolean hogwartsStudent;
    private String actorName;
    private Boolean alive;
    private Date dateOfBirth;
    private int yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private Boolean wizard;
    Personagem prox;
    Personagem ant;
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    // Construtor default
    Personagem() {
        this.prox = null;
        this.id = null;
        this.name = null;
        this.alternate_names = null;
        this.house = null;
        this.ancestry = null;
        this.species = null;
        this.patronus = null;
        this.hogwartsStaff = null;
        this.hogwartsStudent = null;
        this.actorName = null;
        this.alive = null;
        this.dateOfBirth = null;
        this.yearOfBirth = 0;
        this.eyeColour = null;
        this.gender = null;
        this.hairColour = null;
        this.wizard = null;
        this.dateFormat = null;

    }

    // Construtor da classe
    public Personagem(String id, String name, List<String> alternate_names, String house, String ancestry,
            String species, String patronus, Boolean hogwartsStaff, Boolean hogwartsStudent,
            String actorName, boolean alive, Date dateOfBirth, int yearOfBirth, String eyeColour,
            String gender, String hairColour, Boolean wizard, DateFormat dateFormat) {
        this.id = id;
        this.name = name;
        this.alternate_names = alternate_names;
        this.house = house;
        this.ancestry = ancestry;
        this.species = species;
        this.patronus = patronus;
        this.hogwartsStaff = hogwartsStaff;
        this.hogwartsStudent = hogwartsStudent;
        this.actorName = actorName;
        this.alive = alive;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.eyeColour = eyeColour;
        this.gender = gender;
        this.hairColour = hairColour;
        this.wizard = wizard;
        this.dateFormat = dateFormat;
        this.prox = null;
        this.ant = null;
    }

    public Personagem(String[] aux) throws ParseException {
        int j = 0;
        this.id = aux[j++];
        this.name = aux[j++];
        String[] aux2 = aux[j++].split(",");
        this.alternate_names = new ArrayList<>();
        for (String s : aux2) {
            alternate_names.add(s);
        }
        this.house = aux[j++];
        this.ancestry = aux[j++];
        this.species = aux[j++];
        this.patronus = aux[j++];

        // hogwarts staff
        if (aux[j++].charAt(0) == 'V')
            this.hogwartsStaff = true;
        else
            this.hogwartsStaff = false;

        // hogwarts student
        if (aux[j++].charAt(0) == 'V')
            this.hogwartsStudent = true;
        else
            this.hogwartsStudent = false;

        this.actorName = aux[j++];

        // alive
        if (aux[j++].charAt(0) == 'V')
            this.alive = true;
        else
            this.alive = false;

        // pulando actor name
        j++;
        this.dateOfBirth = dateFormat.parse(aux[j++]);
        this.yearOfBirth = Integer.parseInt(aux[j++]);
        this.eyeColour = aux[j++];
        this.gender = aux[j++];
        this.hairColour = aux[j++];

        // wizard
        if (aux[j++].charAt(0) == 'V')
        this.wizard = true;
        else
        this.wizard = false;
        this.prox = null;
        this.ant = null;
        
    }
    // clone do personagem
    public Personagem getClone(Personagem personagems) {
        return new Personagem(personagems.id,
                personagems.name,
                personagems.alternate_names,
                personagems.house,
                personagems.ancestry,
                personagems.species,
                personagems.patronus,
                personagems.hogwartsStaff,
                personagems.hogwartsStudent,
                personagems.actorName,
                personagems.alive,
                personagems.dateOfBirth,
                personagems.yearOfBirth,
                personagems.eyeColour,
                personagems.gender,
                personagems.hairColour,
                personagems.wizard,
                personagems.dateFormat);
    }
    
    // printa array de personagem
    public void printPersonagem(int i) {
        int j = 0;
        System.out.print("["+ id + " ## " +
                name + " ## " +
                "{");
        for (String s : alternate_names) {
            j++;
            System.out.print(s);
            if (j < alternate_names.size()) {
                System.out.print(",");
            }
        }
        System.out.println("}" + " ## " +
                house + " ## " +
                ancestry + " ## " +
                species + " ## " +
                patronus + " ## " +
                hogwartsStaff + " ## " +
                hogwartsStudent + " ## " +
                actorName + " ## " +
                alive + " ## " +
                dateFormat.format(dateOfBirth) + " ## " +
                yearOfBirth + " ## " +
                eyeColour + " ## " +
                gender + " ## " +
                hairColour + " ## " +
                wizard +
                "]");

    }

    // ------------------ Setters --------------------------------------------------
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlternateNames(List<String> alternate_names) {
        this.alternate_names = alternate_names;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

    public void setHogwartsStaff(Boolean hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }

    public void setHogwartsStudent(Boolean hogwartsStudent) {
        this.hogwartsStudent = hogwartsStudent;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setWizard(Boolean wizard) {
        this.wizard = wizard;
    }
    public void setProx(Personagem prox){
        this.prox = prox;
    }
    public void setAnt(Personagem ant){
        this.ant = ant;
    }

    // ---------------------------- Getters
    // ----------------------------------------------
    public Boolean getWizard() {
        return wizard;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean getIsAlive() {
        return alive;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getAlternateNames() {
        return alternate_names;
    }

    public String getHouse() {
        return house;
    }

    public String getAncestry() {
        return ancestry;
    }

    public String getSpecies() {
        return species;
    }

    public String getPatronus() {
        return patronus;
    }

    public Boolean isHogwartsStaff() {
        return hogwartsStaff;
    }

    public Boolean getHogwartsStudent() {
        return hogwartsStudent;
    }

    public String getActorName() {
        return actorName;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public String getGender() {
        return gender;
    }

    public String getHairColour() {
        return hairColour;
    }
    public Personagem getProx(){
        return prox;
    }
    public Personagem getAnt(){
        return ant;
    }


    // printa array list de personagem
    public static void printaArray(Personagem primeiro) {
        int pos = 0;
        Personagem i = primeiro.prox;
        while (i != null) {
            i.printPersonagem(pos);;
            i = i.prox;
            pos++;
        }
    }


}


// -------------------Ler arquivo---------------------------------------------------
class LerArquivo {


    public static ArrayList<Personagem> lerArquivo() throws ParseException {
        ArrayList<Personagem> array = new ArrayList<Personagem>();
        // tratamento de excessao
        try {
            RandomAccessFile arq = new RandomAccessFile("characters.csv", "r");
            arq.seek(0);
            arq.readLine();
            for (long i = 0; i < arq.length(); i = arq.getFilePointer()) {
                String WordPersonagem = "";
                String aux2 = "";
                String aux[];
                WordPersonagem += arq.readLine();
                for (int j = 0; j < WordPersonagem.length(); j++) {
                    if (WordPersonagem.charAt(j) != '[' && WordPersonagem.charAt(j) != ']'
                            && WordPersonagem.charAt(j) != '\'') {
                        aux2 += WordPersonagem.charAt(j);
                    }
                }
                aux = aux2.split(";", 18);// split
                Personagem personagem = new Personagem(aux);
                array.add(personagem);

            }
            arq.close();// fechando arquivo

        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

}


// ---------------------- Compara SubLists ------------------------------

class SubLists {

        // retorna personagem buscando por id
        public static Personagem buscaPorId(String myId, ArrayList<Personagem> personagem) {
            Personagem personagem1 = null;
            for (Personagem p : personagem) {
                if (p.getId().equals(myId)) {
                    personagem1 = p.getClone(p);
                    continue;
                }
            }
            return personagem1;
        }
    
    //add sublist por id
    public static ArrayList<Personagem> addSubList1(ArrayList<Personagem> personagem,Scanner scanner){
        String myId;
        ArrayList<Personagem> subList1 = new ArrayList<Personagem>();
        while (!(myId = scanner.nextLine()).equals("FIM")) {
            if (SubLists.buscaPorId(myId, personagem) == null)
                continue;
            subList1.add(SubLists.buscaPorId(myId, personagem));
        }
        return subList1;

    }

}   
//  --------------------------------------------Ordenacao ---------------------------------------------
    class Ordenacao{

        //  Swap
        public static void swap(ArrayList<Personagem> subList1,int i,int menorIndice){
            Personagem aux = subList1.get(i);
            subList1.set(i,subList1.get(menorIndice));
            subList1.set(menorIndice,aux);

        }
        //  Selection Sort por nome
        public static void selectionSort(ArrayList<Personagem> subList1){  
            for(int i = 0;i < subList1.size()-1;i++){
                String stringI = null;
                String stringJ = null;

                int menorIndice = i;
                stringI = subList1.get(menorIndice).getName();
                for(int j = i + 1; j < subList1.size();j++){
                    stringJ = subList1.get(j).getName();
                    int resultado = stringI.compareTo(stringJ);
                    if(resultado>0){
                        menorIndice = j;
                        stringI = subList1.get(menorIndice).getName();
                    }
                }
                swap(subList1,i,menorIndice);
            }
        
        }
            // Insertion Sort por data de nascimento
            public static void insertionSort(ArrayList<Personagem> subList1){
                for (int i = 1; i < subList1.size(); i++) {
                  Personagem aux = subList1.get(i);
                  int j = i - 1;
                  while ((j >= 0) && (desempateNome(subList1.get(j),aux) > 0)) {
                    subList1.set(j+1,subList1.get(j));
                    j--;

                    }
                subList1.set(j+1,aux);
                }
            }
        //  Ordenar por nome em caso de empate
            public static int desempateNome(Personagem personagem,Personagem personagem2){
                int result = personagem.getDateOfBirth().compareTo(personagem2.getDateOfBirth());
                if(result==0){
                    result = personagem.getName().compareTo(personagem2.getName());
                }
            return result;
            }


  
      /**
       * Retorna o maior elemento do array.
      * @return maior elemento
       */
      public static int getMaior(List<Personagem> arr) {
         int maior = arr.get(0).getYearOfBirth();
  
          for (int i = 0; i < arr.size(); i++) {
           if(maior < arr.get(i).getYearOfBirth()){
              maior = arr.get(i).getYearOfBirth();
           }
          }
         return maior;	
      }
      
      //-------------- Fim CountingSort ----------------
        
    }

    
    class Lista {
        private int tamanho;
        Personagem primeiro,ultimo,primeiroRemovidos,ultimoRemovidos;
    
        Lista() {
             primeiro = ultimo = new Personagem();
             primeiroRemovidos = ultimoRemovidos = new Personagem();
        }
        
         // ----- inserção -----
         public void inserirInicio(Personagem personagem){
            Personagem tmp = personagem.getClone(personagem);
            tmp.prox = primeiro.prox;
            tmp.ant = primeiro;
            primeiro.prox = tmp;
            if(primeiro == ultimo){
                ultimo = tmp;
            }
            else{
                tmp.prox.ant = tmp;
            }
            tmp = null; // organização
            tamanho++;
         }
         public void inserirFim(Personagem personagem){
            ultimo.prox = personagem;
            ultimo.prox.ant = ultimo;
            ultimo = ultimo.prox;
            tamanho++;
         }
         public void inserir(int pos,Personagem personagem){
            if(pos < 0 || pos > tamanho){
                System.exit(0);
            }else if(pos == 0){
                inserirInicio(personagem);
            }else if(pos == tamanho){
                inserirFim(personagem);
            }else{
                Personagem tmp = personagem.getClone(personagem);
                Personagem j = primeiro;
                for(int i = 0;i<pos;i++,j = j.prox);
                tmp.prox = j.prox;
                j.prox = tmp;
                tmp = j = null;
                tamanho++;
            }
         
         }
         //------ remoção -------
         public Personagem removerInicio(){
            if(primeiro == ultimo){
                System.exit(0);
            }
            Personagem tmp = primeiro.prox;
            Personagem resp = tmp;
            tmp.prox.ant = primeiro;
            primeiro.prox = primeiro.prox.prox;
            // remove fisicamente a Personagem
            tmp.prox = tmp.ant =  null;
            tmp = null;
            tamanho--;
    
             return resp;
         } 
         public Personagem removerFim (){
            if(primeiro == ultimo){
                System.exit(0);      
            }
             Personagem i;
             for(i = primeiro;i.prox!=ultimo;i = i.prox);
             Personagem resp = ultimo;
             ultimo = i;
             i.prox.ant = null;
             i = ultimo.prox = null;
             tamanho--;
             return resp;
         }
         public Personagem remover(int pos){
            Personagem resp = null;
            if(primeiro == ultimo || pos < 0 || pos >= tamanho){
                System.exit(0);
            }
            else if(pos == 0){
                removerInicio();
            }
            else if(pos == tamanho - 1){
                removerFim();
            }
            else{
                Personagem j = primeiro;
                for(int i = 0; i < pos;i++,j = j.prox);
                resp = j;
                j.prox.ant = j.ant;
                j.ant.prox = j.prox;
                j.prox = j.ant = null;
                j = null;
            }
             tamanho--;
             return resp;
         }
             // ------ QuickSort por house -------
    public static void quickSort(Lista lista) {
        quickSortCall(lista.primeiro.prox, lista.ultimo);
    }

    private static void quickSortCall(Personagem low, Personagem high) {
        if (high != null && low != high && low != high.prox) {
            Personagem pi = partition(low, high);
            quickSortCall(low, pi.ant);
            quickSortCall(pi.prox, high);
        }
    }

    private static Personagem partition(Personagem low, Personagem high) {
        Personagem pivot = high;
        Personagem i = low.ant;

        for (Personagem j = low; j != high; j = j.prox) {
            if (compareHouse(j, pivot) < 0) {
                i = (i == null) ? low : i.prox;
                swap(i, j);
            }
        }
        i = (i == null) ? low : i.prox;
        swap(i, high);
        return i;
    }

    private static int compareHouse(Personagem p1, Personagem p2) {
        int result = p1.getHouse().compareTo(p2.getHouse());
        if (result == 0) {
            result = p1.getName().compareTo(p2.getName());
        }
        return result;
    }

    private static void swap(Personagem a, Personagem b) {
        // Clonamos os atributos do objeto 'a'
        Personagem temp = new Personagem(
            a.getId(), a.getName(), a.getAlternateNames(), a.getHouse(), a.getAncestry(), a.getSpecies(),
            a.getPatronus(), a.isHogwartsStaff(), a.getHogwartsStudent(), a.getActorName(), a.getIsAlive(),
            a.getDateOfBirth(), a.getYearOfBirth(), a.getEyeColour(), a.getGender(), a.getHairColour(),
            a.getWizard(), a.dateFormat
        );
    
        // Transferimos os atributos de 'b' para 'a'
        a.setId(b.getId());
        a.setName(b.getName());
        a.setAlternateNames(b.getAlternateNames());
        a.setHouse(b.getHouse());
        a.setAncestry(b.getAncestry());
        a.setSpecies(b.getSpecies());
        a.setPatronus(b.getPatronus());
        a.setHogwartsStaff(b.isHogwartsStaff());
        a.setHogwartsStudent(b.getHogwartsStudent());
        a.setActorName(b.getActorName());
        a.setAlive(b.getIsAlive());
        a.setDateOfBirth(b.getDateOfBirth());
        a.setYearOfBirth(b.getYearOfBirth());
        a.setEyeColour(b.getEyeColour());
        a.setGender(b.getGender());
        a.setHairColour(b.getHairColour());
        a.setWizard(b.getWizard());
        
        // Transferimos os atributos de 'temp' para 'b'
        b.setId(temp.getId());
        b.setName(temp.getName());
        b.setAlternateNames(temp.getAlternateNames());
        b.setHouse(temp.getHouse());
        b.setAncestry(temp.getAncestry());
        b.setSpecies(temp.getSpecies());
        b.setPatronus(temp.getPatronus());
        b.setHogwartsStaff(temp.isHogwartsStaff());
        b.setHogwartsStudent(temp.getHogwartsStudent());
        b.setActorName(temp.getActorName());
        b.setAlive(temp.getIsAlive());
        b.setDateOfBirth(temp.getDateOfBirth());
        b.setYearOfBirth(temp.getYearOfBirth());
        b.setEyeColour(temp.getEyeColour());
        b.setGender(temp.getGender());
        b.setHairColour(temp.getHairColour());
        b.setWizard(temp.getWizard());
    }
    

         // ---- mostrar ------
         public void mostrar(){
            Personagem.printaArray(primeiro);
         
         } 
    
        public int getTamanho() {
            return tamanho;
        }
    }
    class No {
        public Personagem personagem;
        public No esq, dir;
    
        public No(Personagem personagem) {
            this.personagem = personagem;
            this.esq = this.dir = null;
        }
    }
    
    class ArvoreBinaria {
        private No raiz;
    
        public ArvoreBinaria() {
            raiz = null;
        }
    
        public void inserir(Personagem personagem, boolean isSecondaryTree) {
            if (!isSecondaryTree) {
                raiz = inserir(raiz, personagem, false);
            } else {
                raiz = inserir(raiz, personagem, true);
            }
        }
    
        private No inserir(No no, Personagem personagem, boolean isSecondaryTree) {
            if (no == null) {
                return new No(personagem);
            } else {
                if (!isSecondaryTree) {
                    int modulo = personagem.getYearOfBirth() % 15;
                    if (modulo < no.personagem.getYearOfBirth() % 15) {
                        no.esq = inserir(no.esq, personagem, false);
                    } else {
                        no.dir = inserir(no.dir, personagem, false);
                    }
                } else {
                    if (personagem.getName().compareTo(no.personagem.getName()) < 0) {
                        no.esq = inserir(no.esq, personagem, true);
                    } else {
                        no.dir = inserir(no.dir, personagem, true);
                    }
                }
                return no;
            }
        }
    
        public boolean pesquisar(int yearMod, String nome, StringBuilder caminho) {
            return pesquisar(raiz, yearMod, nome, caminho);
        }
    
        private boolean pesquisar(No no, int yearMod, String nome, StringBuilder caminho) {
            if (no == null) {
                return false;
            } else {
                if (yearMod < no.personagem.getYearOfBirth() % 15) {
                    caminho.append("ESQ ");
                    return pesquisar(no.esq, yearMod, nome, caminho);
                } else if (yearMod > no.personagem.getYearOfBirth() % 15) {
                    caminho.append("DIR ");
                    return pesquisar(no.dir, yearMod, nome, caminho);
                } else {
                    caminho.append("SIM ");
                    return pesquisarNome(no, nome, caminho);
                }
            }
        }
    
        private boolean pesquisarNome(No no, String nome, StringBuilder caminho) {
            if (no == null) {
                return false;
            } else {
                if (nome.equals(no.personagem.getName())) {
                    return true;
                } else if (nome.compareTo(no.personagem.getName()) < 0) {
                    caminho.append("esq->");
                    return pesquisarNome(no.esq, nome, caminho);
                } else {
                    caminho.append("dir->");
                    return pesquisarNome(no.dir, nome, caminho);
                }
            }
        }
    }
    
        
    public class Main {
        public static void main(String[] args) throws ParseException {
            ArrayList<Personagem> personagens = LerArquivo.lerArquivo();
            ArvoreBinaria arvorePrincipal = new ArvoreBinaria();
            ArvoreBinaria arvoreSecundaria = new ArvoreBinaria();
    
            // Inserir na árvore principal e secundária
            for (Personagem p : personagens) {
                arvorePrincipal.inserir(p, false);
                arvoreSecundaria.inserir(p, true);
            }
    
            // Leitura e processamento das consultas
            Scanner scanner = new Scanner(System.in);
            StringBuilder caminho = new StringBuilder();
            String inputLine;
            while (!(inputLine = scanner.nextLine()).equals("FIM")) {
                int yearMod = Integer.parseInt(inputLine);
                String nome = scanner.nextLine();
    
                caminho.setLength(0); // Limpa o StringBuilder antes de cada consulta
                boolean encontrado = arvorePrincipal.pesquisar(yearMod, nome, caminho);
    
                if (encontrado) {
                    System.out.printf("%s%s%n", caminho.toString(), "SIM");
                } else {
                    System.out.printf("%s%n", caminho.toString());
                }
            }
            scanner.close();
        }
    }
                