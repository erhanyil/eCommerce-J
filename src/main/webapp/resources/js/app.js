'use strict';

var eCommerce = {};

var eCommerceModule = angular.module('eCommerce', [
    'eCommerce.filters',
    'eCommerce.services',
    'eCommerce.directives']);

// Declare app level module which depends on filters, and services
eCommerceModule.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/cars', {
        templateUrl: 'cars/layout',
        controller: CarController
    });

    $routeProvider.when('/shops', {
        templateUrl: 'shops/layout',
        controller: ShopsController
    });

    $routeProvider.when('/login', {
        templateUrl: 'login/layout',
        controller: LoginController
    });
    
    $routeProvider.when('/railwaystations', {
        templateUrl: 'railwaystations/layout',
        controller: RailwayStationController
    });

    $routeProvider.otherwise({redirectTo: '/login'});
}]);

