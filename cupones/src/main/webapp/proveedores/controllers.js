'use strict';

/* Controllers */
angular.module('cuponesApp').controller('ProveedoresController', function($scope, $http, ProveedoresServices, CuponesServices) {

	/**
	 * Secciones
	 */
    $scope.showform = false;
    $scope.showcuponform = false;
    $scope.showcuponesform = false;
    $scope.showerrors = false;
    
    var index = 0;
    var indexCupon = 0;

    /**
	 * Listar
	 */
	$scope.list = function() {

		if (offline) {
			$scope.proveedores = [];
			return;
		}
		
		var res = ProveedoresServices.list();
		
		res.success(function(data, status, headers, config) {
			if (data == null) {
				$scope.proveedores = [];
			}
			else if (data.proveedor instanceof Array) {
				$scope.proveedores = data.proveedor;
			}
			else if (data.proveedor != null) {
				$scope.proveedores = [data.proveedor];
			}
			else {
				$scope.proveedores = [];
			}
		});
		
		res.error(function(data, status, headers, config) {
    		showError(false);
		});
	}

	/**
	 * Editar o insertar
	 */
    $scope.edit = function (proveedor) {
   
    	// $scope.newproveedor = angular.copy(proveedor);
        
		if (offline) {
			$scope.newproveedor = angular.copy(proveedor);
			$scope.showform = true;
			$scope.showcuponesform = true;
			$scope.cupones = [];
			return;
		}
		
    	var res = ProveedoresServices.get(proveedor.id);
    	
    	res.success(function(data, status, headers, config) {
				
    		$scope.newproveedor = data;
			$scope.showform = true;

			// Obtener la lista de sus cupones del proveedor
			if (proveedor.id != null) {
		        	
				var res = CuponesServices.proveedor(proveedor.id);
					
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
		        });
	        	res.error(function(data, status, headers, config) {
	        		showError(false);
	        	});        
			}
			$scope.showcuponesform = true;
			$scope.cupones = [];
		});
		
    	res.error(function(data, status, headers, config) {
    		showError(false);
		});      	
    	
    }	

    $scope.editCupon = function (cupon) {
    	$scope.newcupon = angular.copy(cupon);
    	$scope.showcuponform = true;
    }    
    
    $scope.cancel = function() {
        $scope.newproveedor = {};
        $scope.showform = false;
    }
    
    $scope.cancelCupon = function() {
        $scope.newcupon = {};
        $scope.showcuponform = false;
    }
    
    $scope.new = function () {
    	document.getElementById("imagen").value = "";
        $scope.newproveedor = {};
        $scope.showform = true;
        $scope.showcuponesform = false;
    }	

    $scope.newCupon = function () {
        $scope.newcupon = {};
        $scope.showcuponform = true;
    }	

    /**
	 * Eliminar
	 */
    $scope.delete = function (proveedor) {
    	
    	for (var i in $scope.proveedores) {
            
    		if ($scope.proveedores[i].id == proveedor.id) {

    			if (!offline) {
	            	var res = ProveedoresServices.delete(proveedor);
	            	
	            	res.success(function(data, status, headers, config) {
	                	$scope.proveedores.splice(i, 1);
	                   	$scope.cancel();
	                });
	            	
	            	res.error(function(data, status, headers, config) {
	            		showError(true);
	            	});                    		
    			}
    			else {
                	$scope.proveedores.splice(i, 1);
                   	$scope.cancel();
    			}
            	break;
            }
        }    	
    }	
    
    $scope.deleteCupon = function (cupon) {
    	
    	for (var i in $scope.cupones) {
            
    		if ($scope.cupones[i].id == cupon.id) {

    			if (offline) {
                	$scope.cupones.splice(i, 1);
                   	$scope.cancelCupon();
    			}
    			else {
	            	var res = CuponesServices.delete(cupon);
	            	
	            	res.success(function(data, status, headers, config) {
	                	$scope.cupones.splice(i, 1);
	                   	$scope.cancelCupon();
	                });
	            	
	            	res.error(function(data, status, headers, config) {
	            		showError(true);
	            	});                    		
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
    
    /**
	 * Grabar o insertar
	 */
    $scope.save = function (proveedor) {
    	
    	if (offline) {
    		$scope.update(proveedor, proveedor.id == null);
    	}
    	else {
	    	var res = ProveedoresServices.save(proveedor);
	    	res.success(function(data, status, headers, config) {
	    		$scope.update(data, proveedor.id == null);
	    	});
	    	res.error(function(data, status, headers, config) {
	    		showError(true);
	    	});
    	}
     }    
    
    // actualización del registro en la lista y 
    $scope.update = function(proveedor, insert) {
    	if (insert) {
            // if this is new cliente, add it in clientes array
    		if (offline) {
    			proveedor.id = ++index;
    		}
            $scope.proveedores.push(proveedor);
        } else {
            // for existing cliente, find this cliente using id
            // and update it.
            for (var i in $scope.proveedores) {
                if ($scope.proveedores[i].id == proveedor.id) {
                	$scope.proveedores[i] = proveedor;
                	break;
                }
            }
        }
        $scope.showform = false;
    }    
    
    $scope.saveCupon = function(cupon) {
		
    	cupon.proveedor = $scope.newproveedor;

    	if (offline) {
    		$scope.updateCupon(cupon, cupon.id == null);
    	}    	
    	else {
	    	var res = CuponesServices.save($scope.newcupon);
	    	res.success(function(data, status, headers, config) {
	    		$scope.updateCupon(data, cupon.id == null);
	    	});
	    	res.error(function(data, status, headers, config) {
	    		showError(true);
	    	});   
    	}
    }
    
    // actualización del registro en la lista y 
    $scope.updateCupon = function(cupon, insert) {
    	if (insert) {
            // if this is new cliente, add it in clientes array
    		if (offline) {
    			cupon.id = ++indexCupon;
    		}
            $scope.cupones.push(cupon);
        } else {
            // for existing cliente, find this cliente using id
            // and update it.
            for (var i in $scope.cupones) {
                if ($scope.cupones[i].id == cupon.id) {
                	$scope.cupones[i] = cupon;
                	break;
                }
            }
        }
        $scope.showcuponform = false;
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
          $scope.newproveedor.logo = e.target.result;
        });
      }    

    // Evento de cambio de imagen
    $scope.imageUploadCupon = function(element){
    	var imageType = /image.*/;
    	var file = element.files[0];
    	if (file != null && file.type.match(imageType)) {
	        var reader = new FileReader();
	        reader.onload = $scope.imageIsLoadedCupon;
	        reader.readAsDataURL(file);
    	}
    	else {
    		alert('El archivo seleccionado no es una imagen válida.')
    	}
      }
    
    // Establecer la imagen del control input type file
    $scope.imageIsLoadedCupon = function(e){
        $scope.$apply(function() {
          $scope.newcupon.imagen = e.target.result;
        });
      }    
    
});
