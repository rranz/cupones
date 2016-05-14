'use strict';

// Declare app level module which depends on filters, and services
angular.module('proveedores', ['proveedores.services', 'proveedores.controllers']);


//window.onload = function() {
//
//	var fileInput = document.getElementById('fileInput');
//	var fileDisplayArea = document.getElementById('fileDisplayArea');
//
//
//	fileInput.addEventListener('change', function(e) {
//		var file = fileInput.files[0];
//		var imageType = /image.*/;
//
//		if (file.type.match(imageType)) {
//			var reader = new FileReader();
//
//			reader.onload = function(e) {
//				fileDisplayArea.innerHTML = "";
//
//				var img = new Image();
//				img.src = reader.result;
//
//				fileDisplayArea.appendChild(img);
//			}
//
//			reader.readAsDataURL(file);	
//		} else {
//			fileDisplayArea.innerHTML = "File not supported!"
//		}
//	});
//
//}



//function MyCtrl($scope) {
//    $scope.stepsModel = [];
//
//    $scope.imageUpload = function(event){
//         var files = event.target.files; //FileList object
//         for (var i = 0; i < files.length; i++) {
//             var file = files[i];
//                 var reader = new FileReader();
//                 reader.onload = function () {
//                     var imageData = reader.result;
//                  };                 
//                  reader.readAsDataURL(file);
//         }
//    }
//
//    $scope.imageIsLoaded = function(e){
//        $scope.$apply(function() {
//            $scope.stepsModel.push(e.target.result);
//        });
//    }
//}