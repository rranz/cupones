'use strict';

/* Controllers */
angular.module('cuponesApp').controller('CuponesController', function($scope, $http, CuponesServices/*, Restangular*/) {

    $scope.showform = false;
    $scope.showerrors = false;
	$scope.offline = offline;
	
    var index = 0;
    
    //var User = Restangular.all('ngdemo/rest/cupones/');
    //var allUsers = User.getList();
    
	$scope.list = function() {
		
		if (offline) {
			$scope.cupones = [];
			return;
		}
		
		// Lista de objetos
		var res = CuponesServices.list();
		res.success(function(data, status, headers, config) {
			if (data == null) {
				$scope.cupones = [];
			}
			else if (data.cupon instanceof Array) {
				$scope.cupones = data.cupon;
			}
			else if (data.cupon != null) {
				$scope.cupones = [data.cupon];
			}
			else {
				$scope.cupones = [];
			}
		});
		res.error(function(data, status, headers, config) {
    		showError(false);
		});
	}
	
    $scope.edit = function (cupon) {
        $scope.newcupon = angular.copy(cupon);
        $scope.showform = true;
        $scope.showerrors = false;
        document.getElementById("name").focus();
    }
    

    $scope.cancel = function() {
        $scope.newcupon = {};
        $scope.showform = false;
        $scope.showerrors = false;
    }
    
    $scope.new = function () {
    	document.getElementById("imagen").value = "";
        $scope.newcupon = {};
        $scope.showform = true;
        $scope.showerrors = false;
        document.getElementById("name").focus();
    }	

    $scope.delete = function (cupon) {
    	
    	for (var i in $scope.cupones) {
            
    		if ($scope.cupones[i].id == cupon.id) {

            	if (!offline) {
	    			var res = CuponesServices.delete(cupon);
	            	res.success(function(data, status, headers, config) {
	                	$scope.cupones.splice(i, 1);
	                   	$scope.cancel();
	                });
	            	res.error(function(data, status, headers, config) {
	            		showError(true);
	            	});            
            	}
            	else {
                	$scope.cupones.splice(i, 1);
                   	$scope.cancel();
            	}
            	break;
            }
        }    	
    }	

    /**
     * Mostrar mensaje de error al obtener o persistir datos.
     */
    function showError(save) {
    	if (!$scope.showerrors) {
			$scope.error = save ? "Error al grabar datos" : "Error al cargar datos";
			$scope.showerrors = true;
    	}
    	else {
    	}
    }
    
    // save method create a new cupon if not already exists
    // else update the existing object
    $scope.save = function (cupon) {
    	
    	if (offline) {
    		$scope.update(cupon, cupon.id == null);
    	}
    	else {
	    	var res = CuponesServices.save(cupon);
	    	res.success(function(data, status, headers, config) {
	    		$scope.update(data, cupon.id == null);
	    	});
	    	res.error(function(data, status, headers, config) {
	    		showError(true);
	    	});        
    	}
    }    
    
    // actualización del registro en la lista y 
    $scope.update = function(cupon, insert) {
    	if (insert) {
    		if (offline) {
    			cupon.id = ++index;
    		}
            $scope.cupones.push(cupon);
        } else {
            for (var i in $scope.cupones) {
                if ($scope.cupones[i].id == cupon.id) {
                	$scope.cupones[i] = cupon;
                	break;
                }
            }
        }
        $scope.showform = false;
    }    
    
    $scope.list();

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
          $scope.newcupon.imagen = e.target.result;
        });
      }     
});
