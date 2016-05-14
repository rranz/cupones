'use strict';

/* Services */
angular.module('cuponesApp').service('LoginServices', function ($resource, $http) {
    
	var basedir = host + 'rest/security/';

    this.register = function (user) {
    	
//    	return $http({
//    		  method: 'POST',
//    		  url: basedir + 'register',
//    		  data: user
//    			  
//    		}).then(function successCallback(response) {
//    		    // this callback will be called asynchronously
//    		    // when the response is available
//    			alert(response);
//    		  }, function errorCallback(response) {
//    		    // called asynchronously if an error occurs
//    		    // or server returns response with an error status.
//    			  alert(response);
//    		});    	
    	
    	
    	return $http.post(basedir + 'register', user);
    }

    this.save = function (user) {
    	return $http.post(basedir + 'save', user);
    }
    
    this.get = function (id) {
    	return $http.get(basedir + id); 
    }

    this.login = function (user) {
    	return $http.post(basedir + 'login', user); 
    }
    
    this.delete = function (user) {
    	return $http.get(basedir + 'delete/' + user.id); 
    }

});
