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
    private boolean alive;
    private Date dateOfBirth;
    private int yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private Boolean wizard;
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    // Construtor default
    Personagem() {
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
    }

    public  Personagem(String[] aux) throws ParseException {
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
        this.hogwartsStaff = Boolean.parseBoolean(aux[j++]);
        this.hogwartsStudent = Boolean.parseBoolean(aux[j++]);
        this.actorName = aux[j++];
        this.alive = Boolean.parseBoolean(aux[j++]);
        j++;
        this.dateOfBirth = dateFormat.parse(aux[j++]);
        this.yearOfBirth = Integer.parseInt(aux[j++]);
        this.eyeColour = aux[j++];
        this.gender = aux[j++];
        this.hairColour = aux[j++];
        if(aux[j] == "VERDADEIRO")
        this.wizard = true;
        else
        this.wizard = false;
   
    }

    // printa array de personagem
    public void printPersonagem() {
        int i = 0;

        System.out.print("[" + id + " ## " +
                name + " ## " +
                "{");
        for (String s : alternate_names) {
            i++;
            System.out.print(s);
            if (i < alternate_names.size()) {
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

    // ---------------------------- Getters ----------------------------------------------
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

    //  printa array list de personagem
    public static void printaArray(ArrayList<Personagem> personagem) {

        for (int i = 0; i < personagem.size(); i++) {
            personagem.get(i).printPersonagem();
        }

    }

    // clone do personagem
    public  static Personagem clone(Personagem personagems) {
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

}


// -------------------Ler arquivo---------------------------------------------------
class LerArquivo {


    public static ArrayList<Personagem> lerArquivo() throws ParseException {
        ArrayList<Personagem> array = new ArrayList<Personagem>();
        // tratamento de excessao
        try {
            RandomAccessFile arq = new RandomAccessFile("/tmp/characters.csv", "r");
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
    public static Scanner scanner = new Scanner(System.in);

    // retorna personagem buscando por id
    public static Personagem buscaPorId(String myId, ArrayList<Personagem> personagem) {
        Personagem personagem1 = null;
        for (Personagem p : personagem) {
            if (p.getId().equals(myId)) {
                personagem1 = Personagem.clone(p);
                continue;
            }
        }
        return personagem1;
    }
    // retorna personagem bucando por nome
    public static Personagem buscaPorNome(String name, ArrayList<Personagem> personagem) {
        Personagem personagem2 = null;
        for (Personagem p : personagem) {
            if (p.getName().equals(name)) {
                personagem2 = Personagem.clone(p);
                continue;
            }
        }
        return personagem2;
    }

    //add sublist por id
    public static ArrayList<Personagem> addSubList1(ArrayList<Personagem> personagem ){
        String myId;
        ArrayList<Personagem> subList1 = new ArrayList<Personagem>();
        while (!(myId = scanner.nextLine()).equals("FIM")) {
            if (SubLists.buscaPorId(myId, personagem) == null)
                continue;
            subList1.add(SubLists.buscaPorId(myId, personagem));
        }
        return subList1;

    }
    //add sublist por nome
    public static ArrayList<Personagem> addSubList2(ArrayList<Personagem> personagem ){
        String name;
        ArrayList<Personagem> subList2 = new ArrayList<Personagem>();
        while (!(name = scanner.nextLine()).equals("FIM")) {
            if (SubLists.buscaPorNome(name, personagem) == null)
                continue;
            subList2.add(SubLists.buscaPorNome(name, personagem));
        }

        return subList2;
    }
    // comparo os novos sublists nome - > id
    public  static void comparaSubLists(ArrayList<Personagem> personagem, ArrayList<Personagem> personagem2) {
        boolean ehIgual = false;
        for (Personagem p : personagem) {
            ehIgual = false;
            for (Personagem p2 : personagem2) {
                if (p.getName().equals(p2.getName())) {
                    ehIgual = true;
                    break;
                }
            }
            if (ehIgual)
                System.out.println("SIM");
            else
                System.out.println("NAO");
        }
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

        //---------------------------------HeapSort por Hair Colour --------------------------------

    public  static void heapSort(List<Personagem> arr) {
        int n = arr.size();

        // Constrói o heap inicial (Max Heap)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extrai elementos do heap um por um
        for (int i = n - 1; i > 0; i--) {
            // Move o elemento raiz (maior elemento) para o final
            Collections.swap(arr, 0, i);

            // Recria o heap Max Heap para o array reduzido
            heapify(arr, i, 0);
        }
    }

    public static void heapify(List<Personagem> arr, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        // Verifica se o filho esquerdo é maior que o pai
        if (leftChild < n && compareHairColour(arr.get(leftChild), arr.get(largest)) > 0) {
            largest = leftChild;
        }

        // Verifica se o filho direito é maior que o maior até agora
        if (rightChild < n && compareHairColour(arr.get(rightChild), arr.get(largest)) > 0) {
            largest = rightChild;
        }

        // Se o maior não é o pai, troca os elementos e recria o heap
        if (largest != i) {
            Collections.swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    public static int compareHairColour(Personagem p1, Personagem p2) {
        int result = p1.getHairColour().compareTo(p2.getHairColour());
        if (result == 0) {
            return p1.getName().compareTo(p2.getName());
        }
        return result;
    }
     //------------ Fim HeapSort --------------------------------------------------------

    //------------- Inicio CoutingSort --------------------------------------------------
    private static void countingSort(List<Personagem> arr) {
        int n = arr.size();

        // Encontra o maior ano de nascimento
        int maxYear = Integer.MIN_VALUE;
        for (Personagem personagem : arr) {
            maxYear = Math.max(maxYear, personagem.getYearOfBirth());
        }

        // Cria um array de contagem e inicializa com zeros
        int[] count = new int[maxYear + 1];
        for (Personagem personagem : arr) {
            count[personagem.getYearOfBirth()]++;
        }

        // Atualiza o array de contagem para indicar as posições corretas dos elementos ordenados
        for (int i = 1; i <= maxYear; i++) {
            count[i] += count[i - 1];
        }

        // Cria um array temporário para armazenar os elementos ordenados
        Personagem[] sorted = new Personagem[n];
        for (int i = n - 1; i >= 0; i--) {
            sorted[count[arr.get(i).getYearOfBirth()] - 1] = arr.get(i);
            count[arr.get(i).getYearOfBirth()]--;
        }

        // Copia os elementos ordenados de volta para a lista original
        for (int i = 0; i < n; i++) {
            arr.set(i, sorted[i]);
        }

        // Ordena os elementos com o mesmo ano de nascimento pelo nome em ordem alfabética
        Map<Integer, List<Personagem>> mapByYear = new HashMap<>();
        for (Personagem personagem : arr) {
            mapByYear.computeIfAbsent(personagem.getYearOfBirth(), k -> new ArrayList<>()).add(personagem);
        }
        for (List<Personagem> group : mapByYear.values()) {
            group.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
        }

        // Recria a lista ordenada com o critério de desempate
        List<Personagem> sortedWithTies = new ArrayList<>();
        for (List<Personagem> group : mapByYear.values()) {
            sortedWithTies.addAll(group);
        }
        arr.clear();
        arr.addAll(sortedWithTies);
    }
    //-------------- Fim CountingSort -------------------------------------------------
    }

    

    //------------------- Classe  Principal -------------------------------------------------------
    public class Main{
        public static Scanner scanner = new Scanner(System.in);
        
        public static void main(String[] args) throws ParseException {
            
            ArrayList<Personagem> personagem = new ArrayList<Personagem>();
            ArrayList<Personagem> subList1 = new ArrayList<Personagem>();

            personagem = LerArquivo.lerArquivo();
            subList1 = SubLists.addSubList1(personagem);
            Ordenacao.heapSort(subList1);
            Personagem.printaArray(subList1);
            
        }

}
