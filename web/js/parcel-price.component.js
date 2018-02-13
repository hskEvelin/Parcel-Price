// Register `phoneList` component, along with its associated controller and template
angular.
  module('parcelConfig').
  component('parcelPrice', {
	  transclude: true,
	  template:
		 
		  '<form class="w3-container">'+
	
		  '<div class="w3-panel w3-teal">'+
		    '<h3 class="w3-opacity" ng-click="$ctrl.calcPrice($ctrl.parcelprice)">Gesamtpreis berechnen: {{$ctrl.parcelprice.price}} EUR</h3>'+
		  '</div>'+
		  '</form>'+
		  '<br />'+
		  '</div>' ,
    	
    	
    controller: function ParcelPriceController($rootScope, $http) {
    	
    	
    	this.parcelprice = {
    		parcelsize : $rootScope.parcelsize,
    		parceladdresses: $rootScope.parceladdresses,
    		parceloptions: $rootScope.parceloptions,
    		price: this.price
    	};
      
      
     
      
      this.calcPrice = function($parcel){
    	  this.parcelprice.parcelsize = $rootScope.parcelsize;
    	  this.parcelprice.parceloptions = $rootScope.parceloptions;
    	  console.log(JSON.stringify(this.parcelprice));
    	
    	 $http({
    		    url: "http://localhost:1300/parcel/sent/price",
    		    dataType: "json",
    		    method: "POST",
    		    data: JSON.stringify(this.parcelprice),
    		    headers: {
    		        "Content-Type": "text/plain"
    		    }
    		}).then(function(response){
    			console.log(response.data.price);
    			$parcel.price = response.data.price;
    		});
      }
    }
  });
  
 
  