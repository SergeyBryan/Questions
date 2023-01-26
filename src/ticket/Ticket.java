package ticket;

import java.util.ArrayList;
import java.util.Collections;

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
        books.add("Heroes");
        books.add("Mont Blanc");
        books.add("Domino");
        ArrayList<String> book2 = new ArrayList<>();
        try {
            transformer(books);
        } catch (MyExceptional e) {
            System.out.println(e.getMessage());
        }
    }

    public static int validate(int counter) throws MyExceptional {
        if (counter == 0) {
            throw new MyExceptional("Книг нет, передайте актуальный список книг, который нужно раскидать по полкам");
        }
        return counter;
    }

    public static void printInfo(ArrayList<String> book) {
        int counter = 0;
        for (int i = 0; i < masterShelf.size(); i++) {
            counter = counter + masterShelf.get(i).size();
        }
        System.out.println("Количество книг " + book.size() + '\n'
                + "Книг распределено: " + counter);
        int number = 1;
        for (int i = 0; i < masterShelf.size(); i++) {
            System.out.printf("На %d полке лежит %d книг и включает в себя %s \n", number, masterShelf.get(i).size(), masterShelf.get(i));
            number++;
        }
    }

    public static void transformer(ArrayList<String> book) throws MyExceptional {
        validate(book.size());
        int counter = book.size() / masterShelf.size();
        int extraBook = (book.size() % masterShelf.size());
        Collections.sort(book);
        for (int i = 0; i < book.size(); i++) {
            if (extraBook > 0) {
                for (int j = 0; j < masterShelf.size(); ) {
                    if (masterShelf.get(j).size() < counter + 1 && j < extraBook) {
                        masterShelf.get(j).add(book.get(i));
                        i++;
                    } else {
                        j++;
                    }
                }
            }
            for (int j = 0; j < masterShelf.size(); ) {
                if (masterShelf.get(j).size() < counter) {
                    masterShelf.get(j).add(book.get(i));
                    i++;
                } else {
                    j++;
                }
            }
        }
        printInfo(book);
    }
}