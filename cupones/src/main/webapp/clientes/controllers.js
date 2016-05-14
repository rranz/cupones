'use strict';

/* Controllers */
angular.module('cuponesApp').controller('ClientesController', function($scope, $http, ClientesServices) {

    $scope.showform = false;
    $scope.showerrors = false;

    var index = 0;
    
	$scope.list = function() {
		
		if (offline) {
			$scope.clientes = [];
			return;
		}
		
		// Lista de objetos
		var res = ClientesServices.list();
		
		res.success(function(data, status, headers, config) {
			if (data == null) {
				$scope.clientes = [];
			}
			if (data.cliente instanceof Array) {
				$scope.clientes = data.cliente;
			}
			else if (data.cliente != null) {
				$scope.clientes = [data.cliente];
			}
			else {
				$scope.clientes = [];
			}
		});
		
		res.error(function(data, status, headers, config) {
    		showError(false);
		});
	}

    $scope.edit = function (cliente) {
        $scope.newcliente = angular.copy(cliente);
        $scope.showform = true;
    }

    $scope.cancel = function() {
        $scope.newcliente = {};
        $scope.showform = false;
    }

    $scope.new = function () {
        $scope.newcliente = {};
        $scope.showform = true;
    }

    $scope.delete = function (cliente) {

    	for (var i in $scope.clientes) {

    		if ($scope.clientes[i].id == cliente.id) {

    			if (!offline) {
	            	var res = ClientesServices.delete(cliente);
	            	res.success(function(data, status, headers, config) {
	                	$scope.clientes.splice(i, 1);
	                   	$scope.cancel();
	                });
	            	res.error(function(data, status, headers, config) {
	            		showError(true);
	            	});
    			}
    			else {
                	$scope.clientes.splice(i, 1);
                   	$scope.cancel();
    			}
            	break;
            }
        }
    }

    function showError(save) {
    	if (!$scope.showerrors) {
			$scope.error = save ? "Error al grabar datos" : "Error al cargar datos";
			$scope.showerrors = true;
    	}
    }

    // save method create a new cliente if not already exists
    // else update the existing object
    $scope.save = function (cliente) {

    	if (offline) {
    		$scope.update(cliente, cliente.id == null);
    	}
    	else {
	    	var res = ClientesServices.save(cliente);
	    	res.success(function(data, status, headers, config) {
	    		$scope.update(data, cliente.id == null);
	    	});
	    	res.error(function(data, status, headers, config) {
	    		showError(true);
	    	});
    	}
    }
    
    // actualización del registro en la lista y 
    $scope.update = function(cliente, insert) {
    	if (insert) {
            // if this is new cliente, add it in clientes array
    		if (offline) {
    			cliente.id = ++index;
    		}
            $scope.clientes.push(cliente);
        } else {
            // for existing cliente, find this cliente using id
            // and update it.
            for (var i in $scope.clientes) {
                if ($scope.clientes[i].id == cliente.id) {
                	$scope.clientes[i] = cliente;
                	break;
                }
            }
        }
        $scope.showform = false;
    }

    $scope.list();

});
