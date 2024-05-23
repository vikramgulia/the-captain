(function (angular) {
    'use strict';

    var CaptainControllers = angular.module('CaptainControllers', []);

    CaptainControllers.controller('FlightController', ['$scope', 'Trips',
        function ($scope, Trips) {
            console.log("Inside the flight controller!!");
            $scope.projectName = "My Project";
            $scope.heading = "The Captain";

            $scope.isStillOnForm = true;
            $scope.isFlightLoading = false;
            $scope.isFlightSuccess = false;

            $scope.departFrom = "";
            $scope.arriveAt = "";
            $scope.departOn = new Date();
            $scope.arriveOn = new Date();
            $scope.passengers = 2;

            $scope.airports = [];
            Trips.getAirports({action: 'airports'}, {country: 'US'},
                function (data) {
                    $scope.airports = data;
                }, function (response) {
                    console.log(response);
                });

            $('#departFrom').on('input', function () {
                var val = this.value;
                $scope.setAirportIata('depart', val);
            });

            $('#arriveAt').on('input', function () {
                var val = this.value
                $scope.setAirportIata('arrive', val);
            });

            $scope.setAirportIata = function (field, val) {
                if ($('#airports option').filter(function () {
                        return this.value === val;
                    }).length) {
                    //send ajax request
                    Trips.getAirports({action: 'airports'}, {country: 'US', search: val},
                        function (data) {
                            if (field === 'depart')
                                $scope.departFrom = data[0].iataCode;
                            else
                                $scope.arriveAt = data[0].iataCode;
                        }, function (response) {
                            console.log(response);
                        });
                }
            };

            $scope.refreshFlights = function () {
                $scope.findFlights();
            };


            /*
             find the flights
             */
            $scope.findFlights = function () {
                $scope.isStillOnForm = false;
                $scope.isFlightLoading = true;
                console.log($scope.isFlightLoading);

                var request = {
                    "from": $scope.departFrom,
                    "to": $scope.arriveAt,
                    "fromDate": $scope.printDate($scope.departOn, 1),
                    "toDate": $scope.printDate($scope.arriveOn, 1),
                    "adults": $scope.passengers,
                    "child": "0",
                    "tripType": "ONE_WAY",
                    "ticketClass": "ECONOMY"
                };

                Trips.showMyOptions({action: 'trip'}, request, function (data) {
                    $scope.isFlightSuccess = true;
                    $scope.isFlightLoading = false;
                    console.log($scope.isFlightLoading);
                    console.log(data);
                    $scope.trips = data;
                }, function (response) {
                    $scope.isFlightSuccess = true;
                    $scope.isFlightLoading = false;
                    console.log($scope.isFlightLoading);
                    console.log(response);
                });

            };

            $scope.printDate = function (temp, numOfDaystoAdd) {
                var dateStr = padStr(temp.getFullYear()) + "-" +
                    padStr(1 + temp.getMonth()) + "-" +
                    padStr(temp.getDate() + numOfDaystoAdd);
                return dateStr;
            };

            function padStr(i) {
                return (i < 10) ? "0" + i : "" + i;
            };
        }
    ]);
})(window.angular);