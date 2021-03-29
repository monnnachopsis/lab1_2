package recordTheatreMeth;
import java.util.Scanner;

class Theatre{
    String name, ceo, address;
    double rating;
}

public class recordTheatreMeth {
    public static Theatre[] setTheatreArr(int count) {
        Scanner sc=new Scanner(System.in);
        Theatre[] theatres = new Theatre[count];
        for (int i = 0; i < theatres.length; i++) {
            theatres[i] = new Theatre();
            System.out.println("Введите название: ");
            theatres[i].name = sc.nextLine();
            System.out.println("Введите худ. руководителя: ");
            theatres[i].ceo = sc.nextLine();
            System.out.println("Введите адрес: ");
            theatres[i].address = sc.nextLine();
            System.out.println("Введите рейтинг: ");
            theatres[i].rating = sc.nextDouble();
            sc.nextLine();
        }
        return theatres;
    }

    public static void showArray(Theatre[] ttr){
        for (int i = 0; i < ttr.length; i++) {
            System.out.println("" + ttr[i].name + " \t" + ttr[i].ceo + " \t" + ttr[i].address +" \t" + ttr[i].rating);
        } }
    public static void showTheatre(Theatre ttr){
        System.out.println(""+ttr.name+"\t"+ttr.ceo + "\t"+ttr.address+"\t"+ttr.rating); }

    public static int NomMax(Theatre[] ttr){
        int nommax=0;
        double max=ttr[nommax].rating;
        for (int i = 0; i < ttr.length; i++)
            if (ttr[i].rating>max) {
                max= ttr[i].rating;
                nommax=i;
            }
        return nommax;
    }

    public static void sortName(Theatre[] ttr){
        for (int i = 0; i < ttr.length-1; i++)
            for (int j = 0; j < ttr.length-i-1; j++)
                if(ttr[j].name.compareTo(ttr[i+1].name)<0){
                    Theatre rab=ttr[j];
                    ttr[j]=ttr[j+1];
                    ttr[j+1]=rab;
                }
    }

    public static int findCeo (Theatre[] ttr, String ceo){
        int index= -1;
        for (int i=0; i <ttr.length; i++){
            if(ceo.equals(ttr[i].ceo)){
                index = i;
            }
        }
        return index;
    }

    public static int findName (Theatre[] ttr, String name){
        int indexR= -1;
        for (int i=0; i <ttr.length; i++){
            if(name.equals(ttr[i].name)){
                indexR = i;
            }
        }
        return indexR;
    }

    public static void editTheatre(Theatre ttr) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Изменение поля:");
        System.out.println("name, ceo, address, rating");
        String editQuery = sc.nextLine();
        switch (editQuery) {
            case "name": {
                System.out.println("Новое название театра:");
                String newName = sc.nextLine();
                ttr.name = newName;
                break;
            }
            case "ceo": {
                System.out.println("Новый художественный руководитель:");
                String newCeo = sc.nextLine();
                ttr.ceo = newCeo;
                break;
            }
            case "address": {
                System.out.println("Новый адрес:");
                String newAddress = sc.nextLine();
                ttr.address = newAddress;
                break;
            }
            case "rating": {
                System.out.println("Новый рейтинг:");
                Double newRating = sc.nextDouble();
                ttr.rating = newRating;
                break;
            }
            default: {
                System.out.println("Поле ввода не существует");
            }
        }
    }

    public static Theatre[] Bigger(Theatre ttr[], Double rate){
        int kol=0;
        for (int i = 0; i < ttr.length; i++) {
            if (ttr[i].rating>rate)
                ++kol;
        }
        if (kol != 0){
            Theatre[] bigTheatre=new Theatre[kol];
            int n=-1;
            for (int i = 0; i < ttr.length; i++)
                if (ttr[i].rating>rate) {
                    bigTheatre[++n]=ttr[i];
                }
            return bigTheatre;
        } else return null;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Введите количество театров=> ");
        int n=sc.nextInt();
        Theatre theatres[]= setTheatreArr(n);

        System.out.println("\nХарактеристики театров:");
        showArray(theatres);

        int nommax=NomMax(theatres);
        System.out.println("\nТеатр с максимальным рейтингом:");
        showTheatre(theatres[nommax]);

        sortName(theatres);
        System.out.println("\nОтсортированный список по названиям наоборот:");
        showArray(theatres);

        System.out.println("Введите худ.руководителя:");
        sc.nextLine();
        String ceoF = sc.nextLine();
        int indexT = findCeo(theatres, ceoF);
        if (indexT != -1){
            System.out.println("Найдено");
            editTheatre(theatres[indexT]);
            showTheatre(theatres[indexT]);
        } else{
            System.out.println("Ничего не найдено");
        }

        System.out.println("Введите название:");
        sc.nextLine();
        String nameF = sc.nextLine();
        int indexF = findName(theatres, nameF);
        if (indexF != -1){
            System.out.println("Найдено, театры с рейтингом выше искомой:");
            Theatre [] larger=Bigger(theatres, theatres[indexF].rating);
            showArray(larger);
        } else{
            System.out.println("Ничего не найдено");
        }
    }
}
