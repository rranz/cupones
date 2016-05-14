'use strict';

/* Controllers */
angular.module('cuponesApp').controller('HomeController', function($scope, $http, $rootScope, $cookies) {

	// Usamos $rootScope que es compartido por todos los controladores y así podemos acceder al estado de login del usuario.
	var key = "authenticated";
	var profile = "dataprofile";
	
	var value = $cookies.getObject(key);
	$rootScope.authenticated = value == true ? true : false;
	
	var data = $cookies.getObject(profile);
	$rootScope.profile = data != null && data != "" ? angular.fromJson(data) : {};
	
//	var shaObj = new jsSHA(hashType, "TEXT");
//	shaObj.setHMACKey("abc", "TEXT");
//	shaObj.update("This is a test");
//	var hmac = shaObj.getHMAC("HEX");	
	
});
