package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.xml.bind.annotation.XmlRootElement;

import com.javalego.entity.impl.IdNumberEntityImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class Usuario.
 */
@XmlRootElement
@Entity
public class Usuario extends IdNumberEntityImpl {

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
	 * The imagen.
	 */
	@Lob 
	private String imagen;
	
	/**
	 * The alta.
	 */
	private Date alta = new Date();
	
	/**
	 * Instantiates a new usuario.
	 */
	public Usuario() {
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
