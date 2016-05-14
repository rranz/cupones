'use strict';

/* Services */
angular.module('cuponesApp').service('CuponesServices', function ($resource, $http) {
    
	var basedir = host + 'rest/cupones/';

    this.save = function (cupon) {
    	return $http.post(basedir + 'save', cupon); 
    }

    this.get = function (id) {
    	return $http.get(basedir + id); 
    }
    
    this.delete = function (cupon) {
    	return $http.get(basedir + 'delete/' + cupon.id); 
    }

    this.list = function () {
    	return $http.get(basedir); 
    }

    this.proveedor = function (id) {
    	return $http.get(basedir + 'proveedor/' + id); 
    }

});
