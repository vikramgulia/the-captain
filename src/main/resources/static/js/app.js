(function (angular) {
    'use strict';

    var captainApp = angular.module('captainApp', ['angular-loading-bar', 'ngAnimate', 'ngRoute', 'CaptainControllers', 'CaptainServices'
    ]);

    captainApp.config(['$routeProvider',
            function ($routeProvider) {
                $routeProvider.when('/trip-details', {
                    templateUrl: 'partials/flight-list.html',
                    controller: 'FlightController'
                }).when('/trip', {
                    templateUrl: 'partials/flight.html',
                    controller: 'FlightController'
                }).otherwise({
                    redirectTo: '/trip'
                });
            }
        ]
    );

})(window.angular);