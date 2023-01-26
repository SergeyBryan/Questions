package ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

//Напишите пример перехвата и обработки исключения с использованием собственных исключений.
public class Ticket {
    public static ArrayList<ArrayList<String>> masterShelf = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<String> shelf1 = new ArrayList<>();
        ArrayList<String> shelf2 = new ArrayList<>();
        ArrayList<String> shelf3 = new ArrayList<>();
        ArrayList<String> shelf4 = new ArrayList<>();
        ArrayList<String> shelf5 = new ArrayList<>();
        masterShelf.add(shelf1);
        masterShelf.add(shelf2);
        masterShelf.add(shelf3);
        masterShelf.add(shelf4);
        masterShelf.add(shelf5);
        ArrayList<String> books = new ArrayList<>();
        books.add("War and Peace");
        books.add("Harry Potter");
        books.add("Star Wars");
        books.add("Anna Karenina");
        books.add("The Walking Dead");
        books.add("The Old Man and the Sea");
        books.add("Lord of the Rings");
        books.add("Crime and Punishment");
        books.add("Batman");
        books.add("Spider-man");
        books.add("Iron man");
        books.add("The Count of Monte Cristo");
        books.add("Hero");
        try {
            transformer(books);
        } catch (MyExceptional e) {
            System.out.println(e.getMessage());
        }
    }

    public static void transformer(ArrayList<String> book)throws MyExceptional {
        int counter = book.size() / masterShelf.size();
        validate(counter);
        Collections.sort(book);
        for (int i = 0; i < book.size(); i++) {
            if (masterShelf.get(0).size() < counter + 1) {
                masterShelf.get(0).add(book.get(i));
            } else if (masterShelf.get(1).size() < counter) {
                masterShelf.get(1).add(book.get(i));
            } else if (masterShelf.get(2).size() < counter + 1) {
                masterShelf.get(2).add(book.get(i));
            } else if (masterShelf.get(3).size() < counter) {
                masterShelf.get(3).add(book.get(i));
            } else if (masterShelf.get(4).size() < counter + 1) {
                masterShelf.get(4).add(book.get(i));
            } else {
                masterShelf.get(1).add(book.get(i));
            }
        }
        printInfo(book);
    }
    public static int validate(int counter)throws MyExceptional{
        if (counter == 0) {
            throw new MyExceptional("Книг нет, передайте актуальный список книг, который нужно раскидать по полкам");
        } return counter;
    }

    public static void printInfo(ArrayList<String> book) {
        int counter = masterShelf.get(0).size() + masterShelf.get(1).size() + masterShelf.get(2).size() + masterShelf.get(3).size() + masterShelf.get(4).size();
        System.out.println("Количество книг " + book.size() + '\n' +
                "На 1 полке лежит " + masterShelf.get(0).size() + " и включает в себя: " + masterShelf.get(0) + '\n'
                + "На 2 полке лежит " + masterShelf.get(1).size() + " и включает в себя: " + masterShelf.get(1) + '\n'
                + "На 3 полке лежит " + masterShelf.get(2).size() + " и включает в себя: " + masterShelf.get(2) + '\n'
                + "На 4 полке лежит " + masterShelf.get(3).size() + " и включает в себя: " + masterShelf.get(3) + '\n'
                + "На 5 полке лежит " + masterShelf.get(4).size() + " и включает в себя: " + masterShelf.get(4) + '\n'
                + "Книг распределено: " + counter);
    }
}
