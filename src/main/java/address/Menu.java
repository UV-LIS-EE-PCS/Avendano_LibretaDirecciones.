package address;

import address.data.AddressBook;
import address.data.AddressEntry;

import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * La clase Menu se utiliza para mostrar las opciones de menú al usuario
 * y manejar la entrada del usuario.
 *
 * @author JosephAvendaño
 */
public class Menu {
    private final AddressBook addressBook;
    private final Scanner scanner;

    /**
     * Constructor de la clase Menu.
     *
     * @param addressBook La libreta de direcciones que se va a manejar.
     */
    public Menu(AddressBook addressBook) {
        this.addressBook = addressBook;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú y maneja la entrada del usuario.
     */
    public void displayMenu() {
        String option;
        do {
            System.out.println("Menu:");
            System.out.println("a) Carga de entradas desde un archivo.");
            System.out.println("b) Agregar una nueva entrada.");
            System.out.println("c) Eliminar una entrada.");
            System.out.println("d) Buscar entradas.");
            System.out.println("e) Mostrar todas las entradas.");
            System.out.println("f) Salir.");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextLine().toLowerCase();

            switch (option) {
                case "a":
                    loadEntriesFromFile();
                    break;
                case "b":
                    addEntry();
                    break;
                case "c":
                    removeEntry();
                    break;
                case "d":
                    findEntries();
                    break;
                case "e":
                    showAllEntries();
                    break;
                case "f":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (!option.equals("f"));
    }

    /**
     * Solicita al usuario el nombre de un archivo y carga las entradas desde el archivo en la libreta de direcciones.
     */
    void loadEntriesFromFile() {
        System.out.print("Ingresa la ruta completa del archivo: ");
        String filename = scanner.nextLine();
        // Usa una ruta absoluta para asegurarte de que el archivo se pueda leer correctamente
        String absolutePath = new File(filename).getAbsolutePath();
        addressBook.loadFromFile(absolutePath);
    }

    /**
     * Solicita al usuario los detalles de una nueva entrada y la agrega a la libreta de direcciones.
     */
    void addEntry() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Calle: ");
        String calle = scanner.nextLine();
        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        System.out.print("Código Postal: ");
        String codigoPostal = scanner.nextLine();
        System.out.print("Correo Electrónico: ");
        String correoElectronico = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        AddressEntry entry = new AddressEntry(nombre, apellido, calle, ciudad, estado, codigoPostal, correoElectronico, telefono);
        addressBook.addAddressEntry(entry);
        System.out.println("Entrada añadida correctamente.");
    }

    /**
     * Solicita al usuario el apellido de una entrada a eliminar, busca la entrada y la elimina de la libreta de direcciones.
     */
    void removeEntry() {
        System.out.print("Ingrese el apellido para buscar la entrada a eliminar: ");
        String apellido = scanner.nextLine();
        List<AddressEntry> results = addressBook.findEntry(apellido);
        if (results.isEmpty()) {
            System.out.println("No se encontraron entradas con ese apellido.");
            return;
        }

        for (int i = 0; i < results.size(); i++) {
            System.out.println((i + 1) + ": " + results.get(i));
        }

        System.out.print("Seleccione el número de la entrada que desea eliminar: ");
        int entryNumber;
        try {
            entryNumber = Integer.parseInt(scanner.nextLine());
            if (entryNumber < 1 || entryNumber > results.size()) {
                System.out.println("Número de entrada no válido.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Debe ser un número.");
            return;
        }

        AddressEntry entryToRemove = results.get(entryNumber - 1);
        addressBook.removeAddressEntry(entryToRemove);
        System.out.println("Entrada eliminada correctamente.");
    }

    /**
     * Solicita al usuario el apellido o el inicio del apellido para buscar entradas, y muestra las entradas encontradas.
     */
    void findEntries() {
        System.out.print("Ingrese el apellido o el inicio del apellido a buscar: ");
        String apellido = scanner.nextLine();
        List<AddressEntry> results = addressBook.findEntry(apellido);
        if (results.isEmpty()) {
            System.out.println("No se encontraron entradas con ese apellido.");
        } else {
            for (AddressEntry entry : results) {
                System.out.println(entry);
            }
        }
    }

    /**
     * Muestra todas las entradas en la libreta de direcciones.
     */
    void showAllEntries() {
        List<AddressEntry> allEntries = addressBook.listEntries();
        if (allEntries.isEmpty()) {
            System.out.println("No hay entradas en la libreta de direcciones.");
        } else {
            for (AddressEntry entry : allEntries) {
                System.out.println(entry);
            }
        }
    }
}

