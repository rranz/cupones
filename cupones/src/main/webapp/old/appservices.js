/**
 * NO USADO ACTUALMENTE. SOLO COMO CASO DE POSIBLE USO FUTURO.
 * 
 * Ejemplo de servicio para compartir datos entre controladores. También se puede usar $rootScope injectando este scope en cada controlador y definiendo sus variables. 
 */
angular.module('cuponesApp').factory("AppServices", function () {
  var authenticated = false;
    
  function getAuthenticated() {
    return authenticated;
  }
  function setAuthenticated(authenticated) {    
    this.authenticated = authenticated;
  }
  return {
    getAuthenticated: getAuthenticated,
    setAuthenticated: setAuthenticated,
  }
});

function ControllerOne($scope, Service) {
    
    $scope.setNumber = Service.setNumber;  
}

function ControllerTwo($scope, Service) {
        $scope.Service = Service;
}


<div ng-controller="ControllerOne">
<button ng-click="setNumber(1)">One</button>
<button ng-click="setNumber(2)">Two</button>
</div>
<div ng-controller="ControllerTwo">{{Service.getNumber()}} was chosen!</div>

Código de ejemplo:
	
http://jsfiddle.net/qcUm6/9/