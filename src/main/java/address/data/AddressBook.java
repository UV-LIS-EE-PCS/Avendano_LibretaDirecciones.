package address.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * La clase AddressBook representa una lista de entradas de direcciones (AddressEntry).
 * Permite agregar, eliminar, buscar y listar entradas de direcciones.
 * También puede cargar entradas de un archivo de texto.
 *
 * @author JosephAvendaño
 */
public class AddressBook {
    private final TreeMap<String, List<AddressEntry>> addressEntries;

    public AddressBook() {
        this.addressEntries = new TreeMap<>();
    }

    /**
     * Agrega una entrada de dirección a la libreta de direcciones.
     *
     * @param entry la entrada de dirección a agregar
     */
    public void addAddressEntry(AddressEntry entry) {
        addressEntries
                .computeIfAbsent(entry.getApellido(), k -> new ArrayList<>())
                .add(entry);
    }

    /**
     * Elimina una entrada de dirección de la libreta de direcciones.
     *
     * @param entry la entrada de dirección a eliminar
     */
    public void removeAddressEntry(AddressEntry entry) {
        List<AddressEntry> entries = addressEntries.get(entry.getApellido());
        if (entries != null) {
            entries.remove(entry);
            if (entries.isEmpty()) {
                addressEntries.remove(entry.getApellido());
            }
        }
    }

    /**
     * Busca entradas de dirección por apellido.
     *
     * @param apellido el apellido a buscar
     * @return una lista de entradas de dirección que coinciden con el apellido dado
     */
    public List<AddressEntry> findEntry(String apellido) {
        List<AddressEntry> results = new ArrayList<>();
        for (String key : addressEntries.tailMap(apellido).keySet()) {
            if (!key.startsWith(apellido)) {
                break;
            }
            results.addAll(addressEntries.get(key));
        }
        return results;
    }

    /**
     * Lista todas las entradas de dirección en la libreta de direcciones.
     *
     * @return una lista de todas las entradas de dirección
     */
    public List<AddressEntry> listEntries() {
        List<AddressEntry> sortedEntries = new ArrayList<>();
        for (List<AddressEntry> entryList : addressEntries.values()) {
            sortedEntries.addAll(entryList);
        }
        return sortedEntries;
    }

    /**
     * Carga entradas de dirección desde un archivo de texto.
     *
     * @param filename el nombre del archivo desde el cual cargar las entradas
     */
    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 8) {
                    AddressEntry entry = new AddressEntry(
                            data[0], // Nombre
                            data[1], // Apellido
                            data[2], // Calle
                            data[3], // Ciudad
                            data[4], // Estado
                            data[5], // Código postal
                            data[6], // Correo electrónico
                            data[7]  // Teléfono
                    );
                    addAddressEntry(entry);
                    System.out.println("Entrada cargada: " + entry);
                }
            }
            System.out.println("Carga del archivo completada.");
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + filename);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + filename);
        }
    }
}
