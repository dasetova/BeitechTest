'use strict';
 
angular.module('beitechApp').factory('CustomerService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {
 
            var factory = {
            	loadAllCustomers, loadAllCustomers,
                getAllCustomers: getAllCustomers
            };
 
            return factory;
 
            function loadAllCustomers() {
                console.log('Fetching customers');
                console.log(urls.CUSTOMER_SERVICE_API + 'list');
                
                var deferred = $q.defer();
                $http.get(urls.CUSTOMER_SERVICE_API + 'list')
                    .then(
                        function (response) {
                            console.log('Fetched successfully customers');
                            $localStorage.customers = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading customers');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
            
            function getAllCustomers(){
                return $localStorage.customers;
            }
        }
    ]);