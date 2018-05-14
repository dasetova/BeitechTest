'use strict';
 
angular.module('beitechApp').factory('OrderService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {
 
            var factory = {
                getCustomerOrderByDates: getCustomerOrderByDates
            };
 
            return factory;
 
            function getCustomerOrderByDates(customer_id, lowerDate, upperDate) {
                console.log('Fetching orders');
                
                var deferred = $q.defer();
                $http.get(urls.ORDER_SERVICE_API + 'list' , {
                    params: {
                        customer_id: customer_id,
                        lowerDate: lowerDate,
                        upperDate: upperDate
                      }
                	})
                    .then(
                        function (response) {
                            console.log('Fetched successfully orders');
                            $localStorage.orders = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while getting orders');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
        }
    ]);