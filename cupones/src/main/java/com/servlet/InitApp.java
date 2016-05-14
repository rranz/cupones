package com.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.javalego.application.AppContext;
import com.javalego.application.EnviromentFactory;
import com.javalego.application.Environment;
import com.javalego.exception.LocalizedException;

/**
 * Inicializar los servicios de la aplicación usando un contexto de aplicación
 * de la arquitectura.
 * 
 * Servlet implementation class InitApp
 */
@WebServlet(urlPatterns = { "/initapp" }, loadOnStartup = 1)
public class InitApp extends HttpServlet {

	private static final long serialVersionUID = -4061955194585389894L;

	private static final String APPLICATION_PROPERTIES = "application.properties";

	private static final Logger logger = Logger.getLogger(InitApp.class);
	
	private boolean test = false;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InitApp() {
		super();

	}

	/**
	 * Instanciamos el entorno en base a la configuración definida en el archivo
	 * de application.properties que incluye además la configuración de Spring
	 * Data.
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {

		if (test) {
			return;
		}
		
		try {
			Environment environment = EnviromentFactory.getEnvironment(APPLICATION_PROPERTIES);

			if (environment != null) {
				AppContext.getCurrent().load(environment);
			}
			else {
				logger.error("Environment not located in " + APPLICATION_PROPERTIES);
			}
		}
		catch (LocalizedException e) {
			logger.error(e.getLocalizedMessage());
		}
		super.init(config);
	}
}
