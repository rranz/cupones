package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.xml.bind.annotation.XmlRootElement;

import com.javalego.entity.impl.IdNumberEntityImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class Proveedor.
 */
@XmlRootElement
@Entity
public class Proveedor extends IdNumberEntityImpl {

	/**
	 * The apellidos.
	 */
	private String apellidos;
	
	/**
	 * The nombre.
	 */
	private String nombre;
	
	/**
	 * The password.
	 */
	private String password;
	
	/**
	 * The email.
	 */
	private String email;
	
	/**
	 * The actividad.
	 */
	private String actividad;
	
	/**
	 * The domicilio.
	 */
	private String domicilio;
	
	/**
	 * The telefono.
	 */
	private String telefono;
	
	/**
	 * The empresa.
	 */
	private String empresa;
	
	/**
	 * The logo.
	 */
	@Lob 
	private String logo;
	
	/**
	 * The alta.
	 */
	private Date alta = new Date();
	
	/**
	 * Instantiates a new proveedor.
	 *
	 * @param empresa the empresa
	 * @param email the email
	 */
	public Proveedor(String empresa, String email) {
		this.empresa = empresa;
		this.email = email;
	}
	
	/**
	 * Instantiates a new proveedor.
	 */
	public Proveedor() {
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
	 * Gets the actividad.
	 *
	 * @return the actividad
	 */
	public String getActividad() {
		return actividad;
	}

	/**
	 * Sets the actividad.
	 *
	 * @param actividad the new actividad
	 */
	public void setActividad(String actividad) {
		this.actividad = actividad;
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
	 * Gets the empresa.
	 *
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * Sets the empresa.
	 *
	 * @param empresa the new empresa
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
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
	 * Gets the logo.
	 *
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * Sets the logo.
	 *
	 * @param logo the new logo
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

}
