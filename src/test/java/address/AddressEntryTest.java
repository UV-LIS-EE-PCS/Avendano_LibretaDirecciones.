package address;


import address.data.AddressEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase AddressEntry.
 *
 * @author JosephAvendaño
 */
public class AddressEntryTest {
    private AddressEntry addressEntry;

    /**
     * Configuración inicial para cada prueba.
     * Crea una nueva entrada de dirección con información de ejemplo.
     */
    @BeforeEach
    public void setUp() {
        addressEntry = new AddressEntry("Joseph", "Landa", "Independencia 13", "Minatitlan", "Veracruz", "96719", "joseph@gmail.com", "9222831631");
    }

    /**
     * Prueba para el método getNombre de la clase AddressEntry.
     * Verifica que el nombre sea el esperado.
     */
    @Test
    public void testGetNombre() {
        assertEquals("Joseph", addressEntry.getNombre());
    }

    /**
     * Prueba para el método setNombre de la clase AddressEntry.
     * Verifica que el nombre se pueda cambiar y obtener correctamente.
     */
    @Test
    public void testSetNombre() {
        addressEntry.setNombre("Ricardo");
        assertEquals("Ricardo", addressEntry.getNombre());
    }

    /**
     * Prueba para el método getApellido de la clase AddressEntry.
     * Verifica que el apellido sea el esperado.
     */
    @Test
    public void testGetApellido() {
        assertEquals("Landa", addressEntry.getApellido());
    }

    /**
     * Prueba para el método setApellido de la clase AddressEntry.
     * Verifica que el apellido se pueda cambiar y obtener correctamente.
     */
    @Test
    public void testSetApellido() {
        addressEntry.setApellido("Avendaño");
        assertEquals("Avendaño", addressEntry.getApellido());
    }

    /**
     * Prueba para el método getCalle de la clase AddressEntry.
     * Verifica que la calle sea la esperada.
     */
    @Test
    public void testGetCalle() {
        assertEquals("Independencia 13", addressEntry.getCalle());
    }

    /**
     * Prueba para el método setCalle de la clase AddressEntry.
     * Verifica que la calle se pueda cambiar y obtener correctamente.
     */
    @Test
    public void testSetCalle() {
        addressEntry.setCalle("Independencia 13");
        assertEquals("Independencia 13", addressEntry.getCalle());
    }

    /**
     * Prueba para el método getCiudad de la clase AddressEntry.
     * Verifica que la ciudad sea la esperada.
     */
    @Test
    public void testGetCiudad() {
        assertEquals("Minatitlan", addressEntry.getCiudad());
    }

    /**
     * Prueba para el método setCiudad de la clase AddressEntry.
     * Verifica que la ciudad se pueda cambiar y obtener correctamente.
     */
    @Test
    public void testSetCiudad() {
        addressEntry.setCiudad("Minatitlan");
        assertEquals("Minatitlan", addressEntry.getCiudad());
    }

    /**
     * Prueba para el método getEstado de la clase AddressEntry.
     * Verifica que el estado sea el esperado.
     */
    @Test
    public void testGetEstado() {
        assertEquals("Veracruz", addressEntry.getEstado());
    }

    /**
     * Prueba para el método setEstado de la clase AddressEntry.
     * Verifica que el estado se pueda cambiar y obtener correctamente.
     */
    @Test
    public void testSetEstado() {
        addressEntry.setEstado("Tabasco");
        assertEquals("Tabasco", addressEntry.getEstado());
    }

    /**
     * Prueba para el método getCodigoPostal de la clase AddressEntry.
     * Verifica que el código postal sea el esperado.
     */
    @Test
    public void testGetCodigoPostal() {
        assertEquals("96719", addressEntry.getCodigoPostal());
    }

    /**
     * Prueba para el método setCodigoPostal de la clase AddressEntry.
     * Verifica que el código postal se pueda cambiar y obtener correctamente.
     */
    @Test
    public void testSetCodigoPostal() {
        addressEntry.setCodigoPostal("90210");
        assertEquals("90210", addressEntry.getCodigoPostal());
    }

    /**
     * Prueba para el método getCorreoElectronico de la clase AddressEntry.
     * Verifica que el correo electrónico sea el esperado.
     */
    @Test
    public void testGetCorreoElectronico() {
        assertEquals("joseph@gmail.com", addressEntry.getCorreoElectronico());
    }

    /**
     * Prueba para el método setCorreoElectronico de la clase AddressEntry.
     * Verifica que el correo electrónico se pueda cambiar y obtener correctamente.
     */
    @Test
    public void testSetCorreoElectronico() {
        addressEntry.setCorreoElectronico("joseph@example.com");
        assertEquals("joseph@example.com", addressEntry.getCorreoElectronico());
    }

    /**
     * Prueba para el método getTelefono de la clase AddressEntry.
     * Verifica que el teléfono sea el esperado.
     */
    @Test
    public void testGetTelefono() {
        assertEquals("9222831631", addressEntry.getTelefono());
    }

    /**
     * Prueba para el método setTelefono de la clase AddressEntry.
     * Verifica que el teléfono se pueda cambiar y obtener correctamente.
     */
    @Test
    public void testSetTelefono() {
        addressEntry.setTelefono("9222831631");
        assertEquals("9222831631", addressEntry.getTelefono());
    }

    /**
     * Prueba para el método toString de la clase AddressEntry.
     * Verifica que la representación en cadena de la entrada de dirección sea la esperada.
     */
    @Test
    public void testToString() {
        String expected = "Joseph Landa\nIndependencia 13\nMinatitlan, Veracruz 96719\njoseph@gmail.com\n9222831631";
        assertEquals(expected, addressEntry.toString());
    }
}
