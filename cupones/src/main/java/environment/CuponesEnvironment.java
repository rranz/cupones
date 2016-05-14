package environment;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.cupones.services.cupon.CuponesDataServicesImpl;
import com.javalego.application.Environment;
import com.javalego.data.DataProvider;
import com.javalego.data.BusinessService;
import com.javalego.data.jpa.SpringDataProvider;
import com.javalego.entity.Entity;
import com.javalego.exception.LocalizedException;
import com.javalego.icons.RepositoryIcons;
import com.javalego.locale.translator.Translator;
import com.javalego.model.keys.Icon;
import com.javalego.model.keys.Key;
import com.javalego.security.SecurityServices;
import com.javalego.security.services.UserServices;
import com.javalego.security.session.UserSession;

/**
 * Entorno de pruebas.
 * 
 * @author ROBERTO RANZ
 *
 */
@Component
public class CuponesEnvironment implements Environment {

	public CuponesEnvironment() {
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public Key getTitle() {
		return null;
	}

	@Override
	public Key getDescription() {
		return null;
	}

	@Override
	public synchronized Collection<RepositoryIcons<Icon>> getRepositoriesIcons() throws LocalizedException {
		return null;
	}

	@Override
	public synchronized SecurityServices getSecurity() {
		return null;
	}

	@Override
	public synchronized DataProvider<Entity> getDataProvider() {
		// Configuración de proveedor de Datos Spring JPA
		return new SpringDataProvider(CuponesApplicationContext.class);
	}

	@Override
	public synchronized UserSession getUserSession() {
		return null;
	}

	@Override
	public Translator getTranslator() {
		return null;
	}

	@Override
	public BusinessService getBusinessService() {
		//return new MockCuponesDataServices();
		return new CuponesDataServicesImpl();
	}

	@Override
	public UserServices getUserServices() {
		return null;
	}
}
