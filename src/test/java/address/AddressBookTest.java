package address;

import address.data.AddressBook;
import address.data.AddressEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase AddressBook.
 *
 * @author JosephAvendaño
 */
public class AddressBookTest {
    private AddressBook addressBook;

    /**
     * Configuración inicial para cada prueba.
     * Crea una nueva libreta de direcciones vacía.
     */
    @BeforeEach
    public void setUp() {
        addressBook = new AddressBook();
    }

    /**
     * Prueba para el método addAddressEntry de la clase AddressBook.
     * Verifica que se pueda agregar una entrada de dirección correctamente.
     */
    @Test
    public void testAddAddressEntry() {
        AddressEntry entry = new AddressEntry("Ricardo", "Landa", "Independencia 12", "Coatzacoalcos", "Veracruz", "96718", "ricardo@gmail.com", "9211026534");
        addressBook.addAddressEntry(entry);
        List<AddressEntry> entries = addressBook.listEntries();
        assertEquals(1, entries.size());
        assertEquals(entry, entries.get(0));
    }

    /**
     * Prueba para el método removeAddressEntry de la clase AddressBook.
     * Verifica que se pueda eliminar una entrada de dirección correctamente.
     */
    @Test
    public void testRemoveAddressEntry() {
        AddressEntry entry = new AddressEntry("Ricardo", "Landa", "Independencia 12", "Coatzacoalcos", "Veracruz", "96718", "ricardo@gmail.com", "9211026534");
        addressBook.addAddressEntry(entry);
        addressBook.removeAddressEntry(entry);
        List<AddressEntry> entries = addressBook.listEntries();
        assertEquals(0, entries.size());
    }

    /**
     * Prueba para el método findEntry de la clase AddressBook.
     * Verifica que se pueda encontrar una entrada de dirección por el apellido correctamente.
     */
    @Test
    public void testFindEntry() {
        AddressEntry entry1 = new AddressEntry("Ricardo", "Landa", "Independencia 12", "Coatzacoalcos", "Veracruz", "96718", "ricardo@gmail.com", "9211026534");
        AddressEntry entry2 = new AddressEntry("Joseph", "Landa", "Independencia 13", "Minatitlan", "Veracruz", "96719", "joseph@gmail.com", "922291631");
        addressBook.addAddressEntry(entry1);
        addressBook.addAddressEntry(entry2);
        List<AddressEntry> results = addressBook.findEntry("Landa");
        assertEquals(2, results.size());
        assertTrue(results.contains(entry1));
        assertTrue(results.contains(entry2));
    }

    /**
     * Prueba para el método listEntries de la clase AddressBook.
     * Verifica que se puedan listar todas las entradas de dirección correctamente.
     */
    @Test
    public void testListEntries() {
        AddressEntry entry1 = new AddressEntry("Ricardo", "Landa", "Independencia 12", "Coatzacoalcos", "Veracruz", "96718", "ricardo@gmail.com", "9211026534");
        AddressEntry entry2 = new AddressEntry("Joseph", "Landa", "Independencia 13", "Minatitlan", "Veracruz", "96719", "joseph@gmail.com", "922291631");
        addressBook.addAddressEntry(entry1);
        addressBook.addAddressEntry(entry2);
        List<AddressEntry> entries = addressBook.listEntries();
        assertEquals(2, entries.size());
        assertTrue(entries.contains(entry1));
        assertTrue(entries.contains(entry2));
    }

    /**
     * Prueba para el método loadFromFile de la clase AddressBook.
     * Verifica que se puedan cargar entradas de dirección desde un archivo correctamente.
     */
    @Test
    public void testLoadFromFile() {
        String testFilename = "C:/Users/JOSEPH/IdeaProjects/address_book/src/Data.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFilename))) {
            writer.write("Joseph,Avendaño,Independencia 12,Minatitlan,Veracruz,96718,jr457944@gmail.com,9222831631\n");
            writer.write("Ricardo,Landa,Venustiano Carranza 13,Coatzacoalcos,Veracruz,96719,ricardo@gmail.com,9212831631\n");
        } catch (IOException e) {
            fail("Error al escribir el archivo de prueba.");
        }

        addressBook.loadFromFile(testFilename);
        List<AddressEntry> entries = addressBook.listEntries();
        assertEquals(2, entries.size());

        AddressEntry entry1 = entries.get(0);
        assertEquals("Joseph", entry1.getNombre());
        assertEquals("Avendaño", entry1.getApellido());
        assertEquals("Independencia 12", entry1.getCalle());
        assertEquals("Minatitlan", entry1.getCiudad());
        assertEquals("Veracruz", entry1.getEstado());
        assertEquals("96718", entry1.getCodigoPostal());
        assertEquals("jr457944@gmail.com", entry1.getCorreoElectronico());
        assertEquals("9222831631", entry1.getTelefono());

        AddressEntry entry2 = entries.get(1);
        assertEquals("Ricardo", entry2.getNombre());
        assertEquals("Landa", entry2.getApellido());
        assertEquals("Venustiano Carranza 13", entry2.getCalle());
        assertEquals("Coatzacoalcos", entry2.getCiudad());
        assertEquals("Veracruz", entry2.getEstado());
        assertEquals("96719", entry2.getCodigoPostal());
        assertEquals("ricardo@gmail.com", entry2.getCorreoElectronico());
        assertEquals("9212831631", entry2.getTelefono());

        // Limpieza del archivo de prueba
        File file = new File(testFilename);
        if (!file.delete()) {
            System.err.println("No se pudo eliminar el archivo de prueba: " + testFilename);
        }
    }
}
