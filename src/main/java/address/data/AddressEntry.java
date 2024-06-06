package address.data;

/**
 * Clase que representa una entrada de dirección en la libreta de direcciones.
 * Contiene información de contacto como nombre, apellido, dirección, etc.
 *
 * @author JosephAvendaño
 */
public class AddressEntry {
    private String nombre;
    private String apellido;
    private String calle;
    private String ciudad;
    private String estado;
    private String codigoPostal;
    private String correoElectronico;
    private String telefono;

    /**
     * Constructor para inicializar una entrada de dirección con la información proporcionada.
     *
     * @param nombre el nombre de la persona
     * @param apellido el apellido de la persona
     * @param calle la calle de la dirección
     * @param ciudad la ciudad de la dirección
     * @param estado el estado de la dirección
     * @param codigoPostal el código postal de la dirección
     * @param correoElectronico el correo electrónico de la persona
     * @param telefono el teléfono de la persona
     */
    public AddressEntry(String nombre, String apellido, String calle, String ciudad, String estado, String codigoPostal, String correoElectronico, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.calle = calle;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve una representación en cadena de la entrada de dirección.
     *
     * @return una cadena con la información de contacto
     */
    @Override
    public String toString() {
        return nombre + " " + apellido + "\n" +
                calle + "\n" +
                ciudad + ", " + estado + " " + codigoPostal + "\n" +
                correoElectronico + "\n" + telefono;
    }
}
