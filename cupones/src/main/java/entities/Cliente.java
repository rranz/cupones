package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.xml.bind.annotation.XmlRootElement;

import com.javalego.entity.impl.IdNumberEntityImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class Cliente.
 */
@XmlRootElement
@Entity
public class Cliente extends IdNumberEntityImpl {

	/**
	 * The apellidos.
	 */
	private String apellidos;
	
	/**
	 * The nombre.
	 */
	private String nombre;
	
	/**
	 * The email.
	 */
	private String email;
	
	/**
	 * The password.
	 */
	private String password;
	
	/**
	 * The domicilio.
	 */
	private String domicilio;
	
	/**
	 * The telefono.
	 */
	private String telefono;
	
	/**
	 * The imagen.
	 */
	@Lob 
	private String imagen;
	
	/**
	 * The alta.
	 */
	private Date alta = new Date();
	
	/**
	 * Instantiates a new cliente.
	 */
	public Cliente() {
	}

	/**
	 * Instantiates a new cliente.
	 *
	 * @param email the email
	 * @param password the password
	 */
	public Cliente(String email, String password) {
		this.password = password;
		this.email = email;
	}
	
	/**
	 * Gets the apellidos.
	 *
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Sets the apellidos.
	 *
	 * @param apellidos the new apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the domicilio.
	 *
	 * @return the domicilio
	 */
	public String getDomicilio() {
		return domicilio;
	}

	/**
	 * Sets the domicilio.
	 *
	 * @param domicilio the new domicilio
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	/**
	 * Gets the telefono.
	 *
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Sets the telefono.
	 *
	 * @param telefono the new telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Gets the alta.
	 *
	 * @return the alta
	 */
	public Date getAlta() {
		return alta;
	}

	/**
	 * Sets the alta.
	 *
	 * @param alta the new alta
	 */
	public void setAlta(Date alta) {
		this.alta = alta;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the imagen.
	 *
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Sets the imagen.
	 *
	 * @param imagen the new imagen
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
