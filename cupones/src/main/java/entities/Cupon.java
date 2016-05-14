package entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.javalego.entity.impl.IdNumberEntityImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class Cupon.
 */
@XmlRootElement
@Entity
public class Cupon extends IdNumberEntityImpl {

	/**
	 * The nombre.
	 */
	private String nombre;

	/**
	 * The descripcion.
	 */
	private String descripcion;

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
	 * Número total de consumos a realizar para conseguir un consumo gratis.
	 * TODO Hay que buscar otro nombre más apropiado.
	 */
	private int consumos;
	
	/**
	 * The proveedor.
	 */
	@ManyToOne 
	@JoinColumn(name="proveedor_id") 
	@NotNull
	private Proveedor proveedor;
	
	/**
	 * Instantiates a new cupon.
	 */
	public Cupon() {
	}

	/**
	 * Instantiates a new cupon.
	 *
	 * @param nombre the nombre
	 * @param descripcion the descripcion
	 */
	public Cupon(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
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
	 * Gets the descripcion.
	 *
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Sets the descripcion.
	 *
	 * @param descripcion the new descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * Gets the consumos.
	 *
	 * @return the consumos
	 */
	public int getConsumos() {
		return consumos;
	}

	/**
	 * Sets the consumos.
	 *
	 * @param consumos the new consumos
	 */
	public void setConsumos(int consumos) {
		this.consumos = consumos;
	}

	/**
	 * Gets the proveedor.
	 *
	 * @return the proveedor
	 */
	public Proveedor getProveedor() {
		return proveedor;
	}

	/**
	 * Sets the proveedor.
	 *
	 * @param proveedor the new proveedor
	 */
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
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
