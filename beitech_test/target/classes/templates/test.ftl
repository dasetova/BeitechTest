<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List Customers Orders </span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="selectedCustomer">Customer: </label>
                            <div class="col-md-7">
	                            <select id="selectedCustomer" ng-model="ctrl.selectedCustomer" ng-options="c.name for c in ctrl.getAllCustomers()">
								</select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="lowerDate">Lower Date: </label>
                            <div class="col-md-7">
	                            <input type="date" ng-model="ctrl.lowerDate" id="lowerDate" class="form-control input-sm" placeholder="Select lower Date" required/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="upperDate">Upper Date: </label>
                            <div class="col-md-7">
	                            <input type="date" ng-model="ctrl.upperDate" id="lowerDate" class="form-control input-sm" required/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="Send" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>    
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Orders </span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
	                    <tr>
	                        <th>Creation Date</th>
	                        <th>Order ID</th>
	                        <th>Total</th>
	                        <th>Delivery Address</th>
	                        <th>Products</th>
	                    </tr>
                    </thead>
                    <tbody>
	                    <tr ng-repeat="o in ctrl.orders">
	                        <td>{{o.creationDate[2]+'-'+o.creationDate[1]+'-'+o.creationDate[0]}}</td>
	                        <td>{{o.id}}</td>
	                        <td>{{o.totalPrice}}</td>
	                        <td>{{o.deliveryAddress}}</td>
	                        <td><label ng-repeat="od in o.orderDetails">{{od.quantity}} x {{od.product.name+';'}}</label></td>
	                    </tr>
                    </tbody>
                </table>      
            </div>
        </div>
    </div>
</div>