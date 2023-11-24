/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pc2extra;

/**
 *
 * @author Joaquin
 */
import pc2extra.Book;
import pc2extra.Author;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    private ArrayList<Book> books;

    public Main() {
        this.books = new ArrayList<>();
        initializeBookList();
    }

    private void initializeBookList() {
        Author author1 = new Author("Gabriel García Márquez", "gabo@email.com", 'M');
        Author author2 = new Author("J. R. R. Tolkien", "tolkien@email.com", 'M');
        Author author3 = new Author("George Orwell", "orwell@email.com", 'M');
        Author author4 = new Author("Aldous Huxley", "huxley@email.com", 'M');
        Author author5 = new Author("Jane Austen", "austen@email.com", 'F');
        Author author6 = new Author("Fiódor Dostoyevski", "dostoyevski@email.com", 'M');
        Author author7 = new Author("Vladimir Nabokov", "nabokov@email.com", 'M');
        Author author8 = new Author("James Joyce", "joyce@email.com", 'M');
        Author author9 = new Author("Gustave Flaubert", "flaubert@email.com", 'M');
        Author author10 = new Author("Marcel Proust", "proust@email.com", 'M');
        Author author11 = new Author("Miguel de Cervantes", "cervantes@email.com", 'M');
        Author author12 = new Author("Oscar Wilde", "wilde@email.com", 'M');
        Author author13 = new Author("Antoine de Saint-Exupéry", "saint-exupery@email.com", 'M');
        Author author14 = new Author("William Faulkner", "faulkner@email.com", 'M');
        Author author15 = new Author("Jonathan Swif", "swif@email.com", 'M');
        Author author16 = new Author("Arthur Golden", "golden@email.com", 'M');
        Author author17 = new Author("Suzanne Collins", "collins@email.com", 'F');
        Author author18 = new Author("J. K. Rowling", "rowling@email.com", 'F');
        Author author19 = new Author("Victor Hugo", "hugo@email.com", 'M');
        Author author20 = new Author("C. S. Lewis", "lewis@email.com", 'M');

        books.add(new Book("Cien años de soledad", author1, 200, 400));
        books.add(new Book("El señor de los anillos (Trilogía)", author2, 1500, 1200));
        books.add(new Book("1984", author3, 500, 300));
        books.add(new Book("Un mundo feliz", author4, 320, 500));
        books.add(new Book("Orgullo y prejuicio", author5, 130, 700));
        books.add(new Book("Crimen y castigo", author6, 230, 540));
        books.add(new Book("Lolita", author7, 140, 456));
        books.add(new Book("Ulises", author8, 158, 400));
        books.add(new Book("Madame Bovary", author9, 120, 430));
        books.add(new Book("En busca del tiempo perdido", author10, 345, 450));
        books.add(new Book("Don Quijote de la Mancha", author11, 340, 123));
        books.add(new Book("El retrato de Dorian Gray", author12, 125, 67));
        books.add(new Book("El Principito", author13, 259, 345));
        books.add(new Book("El ruido y la furia", author14, 134, 246));
        books.add(new Book("Los viajes de Gulliver", author15, 186, 234));
        books.add(new Book("Memorias de una geisha", author16, 195, 234));
        books.add(new Book("Los juegos del hambre", author17, 181, 234));
        books.add(new Book("Harry Potter y la piedra filosofal", author18, 650, 4000));
        books.add(new Book("Los miserables", author19, 23, 245));
        books.add(new Book("Las crónicas de Narnia", author20, 456, 444));
    }

    public void displayMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Mostrar la lista de libros.");
        System.out.println("2. Agregar un libro y asignar el autor del libro.");
        System.out.println("3. Eliminar un libro.");
        System.out.println("4. Editar un libro.");
        System.out.println("5. Buscar un libro por título.");
        System.out.println("6. Buscar el autor dado un libro.");
        System.out.println("7. Ordenar los libros por autor.");
        System.out.println("8. Salir.");
    }

    public void showBookList() {
    System.out.println("Lista de libros:");
    for (int i = 0; i < books.size(); i++) {
        System.out.println((i + 1) + ". " + books.get(i).toString());
    }
}

   public void addBook() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Ingrese el nombre del libro:");
    String bookName = scanner.nextLine();

    System.out.println("Ingrese el nombre del autor:");
    String authorName = scanner.nextLine();

    System.out.println("Ingrese el email del autor:");
    String authorEmail = scanner.nextLine();

    System.out.println("Ingrese el género del autor (M/F):");
    char authorGender = scanner.nextLine().charAt(0);

    double bookPrice = 0.0;
    boolean validPrice = false;
    while (!validPrice) {
        try {
            System.out.println("Ingrese el precio del libro:");
            String priceInput = scanner.nextLine();
            if (!priceInput.isEmpty()) {
                bookPrice = Double.parseDouble(priceInput);
                validPrice = true;
            } else {
                System.out.println("Por favor, ingrese un valor válido para el precio.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un valor numérico válido para el precio.");
        }
    }

    int bookQty = 0;
    boolean validQty = false;
    while (!validQty) {
        try {
            System.out.println("Ingrese la cantidad de copias disponibles:");
            String qtyInput = scanner.nextLine();
            if (!qtyInput.isEmpty()) {
                bookQty = Integer.parseInt(qtyInput);
                validQty = true;
            } else {
                System.out.println("Por favor, ingrese un valor válido para la cantidad.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un valor numérico válido para la cantidad.");
        }
    }

    Author newAuthor = new Author(authorName, authorEmail, authorGender);
    Book newBook = new Book(bookName, newAuthor, bookPrice, bookQty);

    books.add(newBook);

    System.out.println("Libro agregado correctamente.");

    
    showBookList();
}

   public void removeBook() {
    Scanner scanner = new Scanner(System.in);

    showBookList();

    int bookNumber = 0;
    boolean validInput = false;

    while (!validInput) {
        try {
            System.out.println("Ingrese el número del libro que desea eliminar:");
            String userInput = scanner.nextLine();

            if (!userInput.isEmpty()) {
                bookNumber = Integer.parseInt(userInput);
                validInput = true;
            } else {
                System.out.println("Por favor, ingrese un número válido.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un número válido.");
        }
    }

    if (bookNumber >= 1 && bookNumber <= books.size()) {
        Book removedBook = books.remove(bookNumber - 1);
        System.out.println("Libro eliminado correctamente: " + removedBook);
    } else {
        System.out.println("Número de libro no válido. No se eliminó ningún libro.");
    }

    showBookList(); 
}


    public void editBook() {
    Scanner scanner = new Scanner(System.in);

    showBookList(); 

    System.out.println("Ingrese el número del libro que desea editar:");
    int bookNumber = Integer.parseInt(scanner.nextLine());

    if (bookNumber >= 1 && bookNumber <= books.size()) {
        Book bookToEdit = books.get(bookNumber - 1);

        System.out.println("Ingrese el nuevo precio del libro (actual: " + bookToEdit.getPrice() + "):");
        double newPrice = Double.parseDouble(scanner.nextLine());
        bookToEdit.setPrice(newPrice);

        System.out.println("Ingrese la nueva cantidad de copias disponibles (actual: " + bookToEdit.getQty() + "):");
        int newQty = Integer.parseInt(scanner.nextLine());
        bookToEdit.setQty(newQty);

        System.out.println("Libro editado correctamente: " + bookToEdit);
    } else {
        System.out.println("Número de libro no válido. No se editó ningún libro.");
    }

    showBookList(); 
}
public void searchBookByTitle() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Ingrese el título del libro que desea buscar:");
    String titleToSearch = scanner.nextLine().trim();

    boolean found = false;

    for (Book book : books) {
        if (book.getName().equalsIgnoreCase(titleToSearch)) {
            System.out.println("Libro encontrado:\n" + book);
            found = true;
            break; 
        }
    }
}
public void searchAuthorByBook() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Ingrese el título del libro para buscar al autor:");
    String titleToSearch = scanner.nextLine().trim();

    boolean found = false;

    for (Book book : books) {
        if (book.getName().equalsIgnoreCase(titleToSearch)) {
            Author author = book.getAuthor();
            System.out.println("Autor encontrado para '" + titleToSearch + "':\n" + author);
            found = true;
            break; 
        }
    }

    if (!found) {
        System.out.println("Libro no encontrado con el título: " + titleToSearch);
    }
}
public void sortBooksByAuthor() {
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                String author1 = book1.getAuthor().getName();
                String author2 = book2.getAuthor().getName();
                return author1.compareToIgnoreCase(author2);
            }
        });

        System.out.println("Libros ordenados por autor:");
        showBookList();
    }

    public static void main(String[] args) {
        Main manager = new Main();
        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            manager.displayMenu();
            choice = scanner.nextLine().charAt(0);

            switch (choice) {
                case '1':
                    manager.showBookList();
                    break;
                case '2':
                    manager.addBook();
                    break;
                case '3':
                    manager.removeBook();
                    break;
                case '4':
                    manager.editBook();
                    break;
                case '5':
                    manager.searchBookByTitle();
                    break;
                case '6':
                    manager.searchAuthorByBook();
                    break;
                case '7':
                    manager.sortBooksByAuthor();
                    break;
                case '8':
                    System.out.println("¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (choice != '8');
    }
}

