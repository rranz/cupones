'use strict';

/* Services */
angular.module('cuponesApp').
service('ClientesServices', function ($resource, $http) {

  var basedir = host + 'rest/clientes/';

  this.save = function (proveedor) {
    return $http.post(basedir + 'save', proveedor);
  }

  this.get = function (id) {
    return $http.get(basedir + id);
  }

  this.delete = function (proveedor) {
    return $http.get(basedir + 'delete/' + proveedor.id);
  }

  this.list = function () {
    return $http.get(basedir);
  }
});
