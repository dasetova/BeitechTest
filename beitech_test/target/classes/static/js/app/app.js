var app = angular.module('beitechApp',['ui.router','ngStorage']);
 
app.constant('urls', {
    BASE: 'http://localhost:8080/BeitechTestApp',
    ORDER_SERVICE_API : 'http://localhost:8080/BeitechTestApp/api/order/',
    CUSTOMER_SERVICE_API : 'http://localhost:8080/BeitechTestApp/api/customer/'
});
 
app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
 
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/test',
                controller:'OrderController',
                controllerAs:'ctrl',
                resolve: {
                    customers: function ($q, CustomerService) {
                        console.log('Load all customers');
                        var deferred = $q.defer();
                        CustomerService.loadAllCustomers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);