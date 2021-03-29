package recordTheatre;
import java.util.Scanner;

class Theatre{
    String name, ceo, address;
    double rating;
}

public class RecordTheatre {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Введите количество театров=> ");
        int n=sc.nextInt();
        Theatre theatres[]=new Theatre[n];
        System.out.println("Введите информацию о театрах: ");
        for (int i = 0; i < theatres.length; i++) {
            sc.nextLine();
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
        System.out.println("\nХарактеристики стран:");
        for (Theatre str : theatres)
            System.out.println(" "+str.name+ "\t" +str.ceo +"\t"+ str.address+"\t"+str.rating);

        int nommax=0;
        double max=theatres[nommax].rating;

        for (int i = 0; i < theatres.length; i++)
            if (theatres[i].rating>max) {
                max= theatres[i].rating;
                nommax=i;
            }
        System.out.println("\nТеатр с наибольшим рейтингом:");
        System.out.println(""+theatres[nommax].name+"\t"+theatres[nommax].ceo+"\t"+theatres[nommax].address+"\t"+theatres[nommax].rating);

        for (int i = 0; i < theatres.length-1; i++)
            for (int j = 0; j < theatres.length-i-1; j++)
                if(theatres [j].name.compareTo(theatres[i+1].name)<0){
                    Theatre rab=theatres[j];
                    theatres[j]=theatres[j+1];
                    theatres[j+1]=rab;
                }
        System.out.println("\nОтсортированный список по названиям наоборот:");
        for (Theatre str : theatres)
            System.out.println(" "+str.name+ "\t" +str.ceo +"\t"+ str.address+"\t"+str.rating);

        sc.nextLine();
        System.out.println("Поиск театра по имени худ. руководителя:");
        String ceo = sc.nextLine();
        int index = -1;
        for (int i = 0; i < theatres.length; i++) {
            if (ceo.equals(theatres[i].ceo)) {
                index = i;
            }
        }
        if (index != -1) {
            System.out.println("Найден театр:");
            System.out.println(theatres[index]);
            System.out.println("Отредактировать поле:");
            System.out.println("name, ceo, address, rating");
            String editQuery = sc.nextLine();
            switch (editQuery) {
                case "name": {
                    System.out.println("Новое название театра:");
                    String newName = sc.nextLine();
                    theatres[index].name = newName;
                    break;
                }
                case "ceo": {
                    System.out.println("Новый художественный руководитель:");
                    String newCeo = sc.nextLine();
                    theatres[index].ceo = newCeo;
                    break;
                }
                case "address":{
                    System.out.println("Новый адрес:");
                    String newAddress = sc.nextLine();
                    theatres[index].address=newAddress;
                    break;
                }
                case "rating": {
                    System.out.println("Новый рейтинг:");
                    Double newRating = sc.nextDouble();
                    theatres[index].rating = newRating;
                    break;
                }
                default: {
                    System.out.println("Поле ввода не существует");
                }
            }
        } else {
            System.out.println("Ничего не найдено!");
        }
        System.out.println(theatres[index].name + "\t" + theatres[index].ceo + "\t" + theatres[index].address + "\t" + theatres[index].rating);

        sc.nextLine();
        System.out.println("Введите название искомого театра=> ");
        String name=sc.nextLine();
        int nom=-1;
        for (int i = 0; i < theatres.length; i++)
            if (name.equalsIgnoreCase(theatres[i].name))
                nom=i;
        if (nom!=-1) {
            System.out.println("Такой театр есть в списке. Это "
                    +theatres[nom].name+". Его рейтинг составляет: "+theatres[nom].rating);
            System.out.println("\nТеатры с рейтингом выше искомого:");
            for (Theatre str : theatres)
                if(str.rating>theatres[nom].rating)
                    System.out.println(" "+str.name+ "\t" +str.ceo +"\t"+ str.address+"\t"+str.rating);

        }else System.out.println("Такого театра нет в списке");

    }
}
