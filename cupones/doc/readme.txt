APACHE CORDOVA

ANGULARJS http get error cors filter

Para solucionar el problema de cors domain cuando estamos desplegando la
aplicación en un dispositivo móvil y queremos comunicarnos con servicios rest
que están corriendo en un servidor Tomcat, debemos permitir las llamadas
cors domain incluyendo en el /conf/web.xml de Tomcat los siguientes filtros:

<filter>
  <filter-name>CorsFilter</filter-name>
  <filter-class>org.apache.catalina.filters.CorsFilter</filter-class>
</filter>
<filter-mapping>
  <filter-name>CorsFilter</filter-name>
  <url-pattern>/*</url-pattern>
</filter-mapping> 

NOTA: en Eclipse.Package Explorer.Servers.Tomcat 7.web.xml incluir este filtro.

Construir android-debug.apk para poder instalar en los dispositivos sin ejecutar cordova platform android que 
usará un emulador o genymotion.

1. Comando para generar apk instalable en android:
cordova build android 

2. Comando para ejecutar la aplicación en el emulador disponible
cordova run android


ANDROID DEPURAR APLICACIÓN EN DISPOSITIVO CONECTADO. (Allow USB Debugging)

Referencias: 
	https://msdn.microsoft.com/es-es/library/dn757059.aspx
	http://developer.android.com/tools/device.html

Activar depuración USB en opciones de desarrollador. Si no aparece esta opción en Ajustes.Opciones de desarrollador, ir
a "Acerca del dispositivo" y en número de compilación (build number) pulsar 7 veces esta opción hasta que se active.

Ir a mi proyecto Cordova y teclear: cordova run android para ejecutar la aplicación en el dispositivo conectado.


Ver dispositivos conectados en sdk android:

/sdk/platform-tools/adb devices


BLUESTACKS

Se puede usar este emulador como genymotion para arrancar nuestras aplicaciones android cordova de forma mucho más eficiente
Solo hay que ejecutar el comando:
sdk/platform-tools/adb connect localhost

y 

cordova run android
