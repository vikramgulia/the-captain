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
                    "request": {
                        "passengers": {
                            "adultCount": $scope.passengers,
                            "childCount": 0,
                            "infantInLapCount": 0,
                            "infantInSeatCount": 0,
                            "seniorCount": 0
                        },
                        "slice": [
                            {
                                "duration": 0,
                                "origin": $scope.departFrom,
                                "destination": $scope.arriveAt,
                                "date": $scope.printDate($scope.departOn),
                                "maxStops": 2,
                                "maxConnectionDuration": 0,
                                "permittedDepartureTime": {
                                    "earliestTime": "06:00",
                                    "latestTime": "08:00"
                                }
                            }
                        ],
                        "refundable": false,
                        "solutions": 50
                    }
                };


                Trips.showMyOptions({action: 'trip'}, request, function (data) {
                    $scope.isFlightSuccess = true;
                    $scope.isFlightLoading = false;
                    console.log($scope.isFlightLoading);
                    console.log(data);
                    $scope.trips = data.trips;
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