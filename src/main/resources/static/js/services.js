(function (angular) {
    'use strict';

    var CaptainServices = angular.module('CaptainServices', ['ngResource']);

    CaptainServices.factory('Trips', ['$resource',
        function ($resource) {
            return $resource('/captain/:action', {action: '@action'}, {
                /**
                 *  showMyOptions
                 */
                showMyOptions: {
                    method: "POST"
                },
                /**
                 * Get airports
                 */
                getAirports: {
                    method: "GET",
                    params: {country: '@country', search: '@search'},
                    isArray: true
                }
            });
        }]);

    CaptainServices.factory('Topics', ['$resource',
        function ($resource) {
            return $resource('/Events/v1/util/topics/:group_id', {group_id: '@group_id'}, {
                /**
                 * add topic resource - see com.dish.des.proxy.controllers.UtilController#addTopic
                 */
                addTopic: {
                    method: 'PUT',
                    params: {topic: '@topic', partition: '@partition', replication: '@replication'}
                },
                /**
                 * delete topic resource - see com.dish.des.proxy.controllers.UtilController#deleteTopic
                 */
                deleteTopic: {
                    method: 'DELETE',
                    params: {topic: '@topic'}
                },
                /**
                 * alter topic resource - see com.dish.des.proxy.controllers.UtilController#alterTopic
                 */
                alterTopic: {
                    method: 'POST',
                    params: {topic: '@topic', partition: '@partition'}
                }
            });
        }]);

    CaptainServices.factory('Lags', ['$resource',
        function ($resource) {
            return $resource('/Events/v1/util/lags/:topic/:group_id', {
                topic: '@topic',
                group_id: '@group_id'
            });
        }]);

    CaptainServices.factory('TopicDetails', ['$resource',
        function ($resource) {
            return $resource('/Events/v1/util//topicDetails/:topic', {
                topic: '@topic'
            });
        }]);

    CaptainServices.factory('Schema', ['$resource',
        function ($resource) {
            return $resource('/Events/v1/util//schema/:call/:name', {
                call: '@call',
                name: "@name"
            }, {
                schema: {
                    method: 'POST'
                }
            });
        }]);

})(window.angular);