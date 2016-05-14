'use strict';

/* Controllers */
angular.module('cuponesApp').controller('LoginController', function($scope, $http, $cordovaOauth, $rootScope, $cookies, LoginServices) {

	$scope.showprofile = $rootScope.authenticated;
	$scope.showregister = false;
	$scope.offline = offline;
	$scope.profile = $rootScope.profile != null ? $rootScope.profile : {};
	$scope.loginError = false;
	$scope.login = {};
	
	// Login de usuario (cordova mobile o hello.js web)
	$scope.loginOAuth = function(social) {

		if (isMobile) {

	      $cordovaOauth.facebook("601650163316034", ["email"], {"auth_type": "rerequest"}).then(function(result) {
	        //alert(JSON.stringify(result));
	        $http.get("https://graph.facebook.com/v2.2/me", { params: { access_token: result.access_token, fields: "email,id,name,gender,location,website,picture,relationship_status", format: "json" }}).then(function(result) {
			  // La evaluación de sincronización es requerida para establecer el método de visualización. en caso contrario, no se aplicaría en primera instancia y sólo se visualizaría el profile al realizar el login una segunda vez.
			  $scope.$evalAsync(function() {
				  authenticated(result.data.id, result.data.name, result.data.email, result.data.picture.data.url, null);
				  $scope.profile.oauth = true;
			  });	
	        }, function(error) {
	          alert("There was a problem getting your profile.  Check the logs for details.");
	          console.log(error);
	         });
	      }, function(error) {
	        console.log(JSON.stringify(error));
	        alert("Error: " + JSON.stringify(error));
	      });
		}
		else {
			// Inicialización de la biblioteca hello.js
			hello.init({
				facebook: '601650163316034',
				twitter: 'AdP3nCuoSB85iDl6XSiJWBKJS'
			}, {redirect_uri: 'http://localhost:8080/cupones'});

			// hello('facebook').logout( function() {
			//	$rootScope.authenticated = false;
			// });          
		      
			hello(social).login(function(e){
				// Se incluye este método de inicialización para evitar que se ejecute el login sin pasar por la ventana de login de facebook (TODO: seguramente sean cookies de la librería).
				hello.on('auth.login', function(auth) {
					// Call user information, for the given network
					hello(auth.network).api('/me').then(function(r) {
						// La evaluación de sincronización es requerida para establecer el método de visualización. en caso contrario, no se aplicaría en primera instancia y sólo se visualizaría el profile al realizar el login una segunda vez.
						$scope.$evalAsync(function() {
							authenticated(r.id, r.name, r.email, r.thumbnail, null);
							$scope.profile.oauth = true;
				        });					
					});
				});				
			});		    
		}
	}

	/**
	 * Registrar usuario
	 */
	$scope.register = function($event) {
		authenticated(null, $scope.profile.name, $scope.profile.email, null, $scope.profile.password);
	}
	
    $scope.login = function($event) {
    	// Realiza el submit de la página
    	//$event.target.submit();
    	login($scope.login.name, $scope.login.email, $scope.login.password);
    	// Cancela el submit del form. Es útil para editores que deseamos controlar los errores de edición html5 sin angularjs y que
    	// queremos customizar en el propio controlador el evento del submit sin recargar la página (single one page). ver editores de clientes, cupones,...
    	//$event.preventDefault();
    };	
	
    $scope.saveProfile = function($event) {
    	saveProfile($scope.profile.id, $scope.profile.name, $scope.profile.email, $scope.profile.password, $scope.profile.picture);
    };	

	/**
	 * Autenticar usuario estableciendo la visibilidad de los datos de su perfil de usuario
	 */
	function saveProfile(id, name, email, password, picture) {
		
		if (!offline) {
			var res = LoginServices.save({id: id, nombre: name, email: email, password: password, imagen: picture});
	    	res.success(function(data, status, headers, config) {
	    		alert("Datos modificados");
	    	});
	    	res.error(function(data, status, headers, config) {
	    		alert("Error en la grabación de datos");  		
	    	});	    	
		}
		else {
			setData(id, name, email, picture, password);
		}
	}    
    
	/**
	 * Cambiar los datos del perfil de usuario
	 */
	function login(name, email, password) {
		
		if (!offline) {
			var res = LoginServices.login({nombre: name, email: email, password: password});
	    	res.success(function(data, status, headers, config) {
	    		setData(data.id, data.nombre, data.email, data.imagen, password);
	    	});
	    	res.error(function(data, status, headers, config) {
	    		$scope.loginError = true;	    		
	    	});	    	
		}
		else {
			setData(null, name, email, null, password);
		}
	}    
    
	/**
	 * Autenticar usuario estableciendo la visibilidad de los datos de su perfil de usuario
	 */
	function authenticated(id, name, email, picture, password) {
		
		if (!offline) {
			var res = LoginServices.register({id: id, nombre: name, email: email, password: password, imagen: picture});
	    	res.success(function(data, status, headers, config) {
	    		setData(id, name, email, picture, password);
	    	});
	    	res.error(function(data, status, headers, config) {
	    		alert("Error al registrar su cuenta de usuario.");
	    	});	    	
		}
		else {
			setData(id, name, email, picture, password);
		}
	}
	
	/**
	 * Establecer los datos del perfil de usuario
	 */
	function setData(id, name, email, picture, password) {

		$scope.showprofile = true;
		$scope.showregister = false;
		$scope.loginError = false;
		
		//$rootScope.reload();
		$scope.profile.name = name;
		$scope.profile.id = id;
		$scope.profile.email = email;
		$scope.profile.picture = picture;
		$scope.profile.password = password;

		// Datos rootScope para recuperarlos al cargar de nuevo la página del login
		$rootScope.authenticated = true;
		$rootScope.profile = {};
		$rootScope.profile.name = name;
		$rootScope.profile.id = id;
		$rootScope.profile.email = email;
		$rootScope.profile.picture = picture;
		$rootScope.profile.password = password;
		$rootScope.profile.oauth = $scope.profile.oauth;
		
		$cookies.put("authenticated", true);
		$cookies.put("dataprofile", angular.toJson($rootScope.profile));
	}

	// Datos de configuración de facebook en opción settings:
	// Basic:
	// Web site. Site url=    http://localhost:8080/cupones
	//
	// Advanced. Valid OAuth redirect URIs
	// http://localhost/callback (para cordova)
	// https://www.facebook.com/connect/login_success.html (para cordova facebook) 
	// http://localhost:8080/cupones (para hello.js)
	// http://localhost:8080/fb/oauthcallback.html (no usada)
	// http://luminous-heat-9870.firebaseapp.com (para firebire angularjs) no usada actualmente

    // Evento de cambio de imagen
    $scope.imageUpload = function(element){
    	var imageType = /image.*/;
    	var file = element.files[0];
    	if (file != null && file.type.match(imageType)) {
	        var reader = new FileReader();
	        reader.onload = $scope.imageIsLoaded;
	        reader.readAsDataURL(file);
    	}
    	else {
    		alert('El archivo seleccionado no es una imagen válida.')
    	}
      }
    
    // Establecer la imagen del control input type file
    $scope.imageIsLoaded = function(e){
        $scope.$apply(function() {
          $scope.profile.picture = e.target.result;
        });
      }  	
});
