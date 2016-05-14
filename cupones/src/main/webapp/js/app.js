'use strict';

/**
 * Ruta de acceso al servidor de servicios rest de la aplicación.
 */
var host = "http://localhost:8080/cupones/";

/**
 * Edición offline para pruebas sin datos reales
 */
var offline = false;

/**
 * Comprueba si la aplicación se está ejecutando en un dispositivo móvil
 */
var isMobile = navigator.userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|Opera Mini|IEMobile/i) ? true : false;

/**
 * Rutas de acceso a las páginas de la aplicación.
 * Nota: se injecta el módulo ngCookies y se define cookiesProvider en la función de configuración para que se active correctamente el módulos de coockies de angularjs. 
 */
angular.module('cuponesApp', ['ngRoute', 'ngResource', 'ngMessages', 'ngCordovaOauth', 'ngCookies']).
config(function($routeProvider, $cookiesProvider) {
  $routeProvider.when('/cupones', {
    templateUrl: 'templates/pages/cupones/index.html'
  }).
  when('/clientes', {
	  templateUrl: 'templates/pages/clientes/index.html'
  }).
  when('/proveedores', {
	  templateUrl: 'templates/pages/proveedores/index.html'
  }).
  when('/login', {
	  templateUrl: 'templates/pages/login/index.html'
  }).
  when('/', {
	  templateUrl: 'templates/pages/cupones/index.html'
  }).
  otherwise({redirectTo: '/'})
  
//  $httpProvider.interceptors.push(function() {
//      return {
//          request: function(config) {
//              if (~['POST', 'PUT', 'DELETE'].indexOf(config.method)) {
//                  config.headers['X-CSRFToken'] = getCookie("csrftoken");
//              }
//          }
//      };
//  });  
});

/**
 * Colapsar panel boostrap de menú cuando se selecciona una item.
 */
$(function() {

    /* Hide mobile menu after clicking on a link
    -----------------------------------------------*/
    $('.navbar-collapse a').click(function(){
       $(".navbar-collapse").collapse('hide');
    });
})

/**
 * Cambiar el color de navbar-transparent cuando pasamos por la mitad de la imagen 
 */
/*
  $(document).on('scroll', function (e) {

     var alpha = $(document).scrollTop() / 550;

     if ($(document).scrollTop() > 200) {
         $('.navbar-transparent').css('background-color', 'black');
     }
     else {
            $('.navbar-transparent').css('background-color', 'rgba(70,103,26,0)');
     }
  });
  */
