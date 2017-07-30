'use strict';

var ShopsController = function($scope, $http, Shops, principal) {

    $scope.newShop = {};
    $scope.editable = false;

    function fail(errObj) {
        alert(errObj);
    }

    $scope.getAllShops = function(editable) {
        Shops.getAllShops({}, function(data){
            if(null == data){
                $scope.errorMsg = "There are no Market AP POS";
            }
            else{
                $scope.items = data;
                $scope.newShop = {};
                $scope.editable = false;
                alert(principal);
            }
        }, fail);
    };

    $scope.addNewShop = function(newShop) {
        if ($scope.editable){
            $http.post('shops/editShop',newShop).success(function(){
                $scope.getAllShops();
                $scope.newShop = {};
            },fail);
        } else {
            $http.post('shops/newShop',newShop).success(function(){
                $scope.getAllShops();
                $scope.newShop = {};
            },fail);
        }
    };

    $scope.deleteShop = function(id) {
        $http.post('shops/deleteShop',id).success(function(){
            $scope.getAllShops();
        },fail);
    };

    $scope.editShop = function (shop) {
        $scope.editable = true;
        $scope.newShop.id = shop.id;
        $scope.newShop.shopName  = shop.shopName;
        $scope.newShop.shopAdress  = shop.shopAdress;
        $scope.newShop.shopPhone  = shop.shopPhone;
    };

    $scope.getAllShops();

};