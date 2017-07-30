'use strict';

/* Directives */

var eCommerceDirectives = angular.module('eCommerce.directives', []);

eCommerceDirectives.directive('appVersion', ['version', function (version) {
    return function (scope, elm, attrs) {
        elm.text(version);
    };
}]);
