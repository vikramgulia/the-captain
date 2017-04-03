'use strict'

var AppControllers = angular.module('AppControllers', []);

AppControllers.controller('EventController', ['$scope',
    function ($scope) {
        console.log("Inside the event controller!!");
        $scope.projectName = "My Project";
        $scope.heading = "The Twig Parser";
    }
]);


