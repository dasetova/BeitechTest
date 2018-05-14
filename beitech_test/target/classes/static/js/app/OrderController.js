'use strict';
 
angular.module('beitechApp').controller('OrderController',
    ['OrderService', 'CustomerService','$scope',  function( OrderService, CustomerService, $scope) {
 
        var self = this;
        self.selectedCustomer = {};
        self.lowerDate = '';
        self.upperDate = '';
        self.orders=[];
 
        self.getAllCustomers = getAllCustomers;
        self.getCustomerOrderByDates = getCustomerOrderByDates;
        self.submit = submit;
        self.reset = reset;
 
        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;
 
        function getAllCustomers(){
            return CustomerService.getAllCustomers();
        }
 
        function getCustomerOrderByDates(customer_id, lowerDate, upperDate) {
            self.successMessage='';
            self.errorMessage='';
            OrderService.getCustomerOrderByDates(customer_id, lowerDate, upperDate).then(
                function (orders) {
                    self.orders = orders.data;
                    console.log(self.orders);
                },
                function (errResponse) {
                    console.error('Error while getting orders for customer' + customer_id + ', Error :' + errResponse.data);
                }
            );
        }
        
        function submit() {
            console.log('Submitting');
            var lw = self.lowerDate.toISOString().substring(0,10);
            var uw = self.upperDate.toISOString().substring(0,10);
            getCustomerOrderByDates(self.selectedCustomer.id, lw, uw);
            
        }
        
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.user={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }
    ]);