package entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.javalego.entity.impl.IdNumberEntityImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class ClienteCupon.
 */
@XmlRootElement
@Entity
public class ClienteCupon extends IdNumberEntityImpl {

	/**
	 * The cliente.
	 */
	@ManyToOne 
	@JoinColumn(name="cliente_id") 
	@NotNull
	private Cliente cliente;
	
	/**
	 * The cupon.
	 */
	@ManyToOne 
	@JoinColumn(name="cupon_id") 
	@NotNull
	private Cupon cupon;
	
	/**
	 * Número de consumos realizados
	 */
	private int consumos;
	
	/**
	 * Instantiates a new cliente cupon.
	 */
	public ClienteCupon() {
	}

	/**
	 * Gets the cliente.
	 *
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Sets the cliente.
	 *
	 * @param cliente the new cliente
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Gets the cupon.
	 *
	 * @return the cupon
	 */
	public Cupon getCupon() {
		return cupon;
	}

	/**
	 * Sets the cupon.
	 *
	 * @param cupon the new cupon
	 */
	public void setCupon(Cupon cupon) {
		this.cupon = cupon;
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
	 * Gets the restan.
	 *
	 * @return the restan
	 */
	public int getRestan() {
		return cupon.getConsumos() - consumos;
	}

}
