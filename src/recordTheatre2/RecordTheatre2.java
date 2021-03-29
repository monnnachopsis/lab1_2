package recordTheatre2;
import java.util.Scanner;

class Theatre{
    String name, ceo, address;
    double rating;
}

public class RecordTheatre2 {
    public static Theatre [] setCountryArr(int k){
        Scanner sc=new Scanner(System.in);
        Theatre theatres[]=new Theatre[k];

        System.out.println("Введите информацию о театрах: ");
        for (int i = 0; i < theatres.length; i++) {
            theatres[i]=new Theatre();
            System.out.print("Название "+(i+1)+"-го театра => ");
            theatres[i].name=sc.nextLine();
            System.out.print("Художественный руководитель "+(i+1)+"-го театра => ");
            theatres[i].ceo=sc.nextLine();
            System.out.print("Адрес "+(i+1)+"-го театра => ");
            theatres[i].address=sc.nextLine();
            System.out.print("Рейтинг "+(i+1)+"-го театра=>");
            theatres[i].rating=sc.nextDouble();
        }
        return theatres;
    }

    public static void showArray(Theatre [] ttr){
        for (int i = 0; i < ttr.length; i++) {
            System.out.println("" + ttr[i].name + " \t" + ttr[i].ceo + " \t" + ttr[i].address +" \t" + ttr[i].rating);
        } }
    public static void showTheatre(Theatre ttr){
        System.out.println(""+ttr.name+"\t"+ttr.ceo + "\t"+ttr.address+"\t"+ttr.rating); }

    public static int NomMax(Theatre []ttr){
        int nommax=0;
        double max=ttr[nommax].rating;
        for (int i = 0; i < ttr.length; i++)
            if (ttr[i].rating>max) {
                max= ttr[i].rating;
                nommax=i;
            }
        return nommax;
    }

}
