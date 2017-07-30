'use strict';

/* Filters */

var eCommerceFilters = angular.module('eCommerce.filters', []);

eCommerceFilters.filter('interpolate', ['version', function (version) {
    return function (text) {
        return String(text).replace(/\%VERSION\%/mg, version);
    }
}]);
