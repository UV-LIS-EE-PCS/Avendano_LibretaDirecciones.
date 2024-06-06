package address;

import address.data.AddressBook;

/**
 * Clase principal de la aplicación de libreta de direcciones.
 * Contiene el método main para iniciar la aplicación.
 *
 * @author JosephAvendaño
 */
public class AddressBookApplication {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Menu menu = new Menu(addressBook);
        menu.displayMenu();
    }
}
