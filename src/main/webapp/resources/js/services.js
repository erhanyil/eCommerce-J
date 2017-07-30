'use strict';

/* Services */

var eCommerceServices = angular.module('eCommerce.services', ['ngResource']);

eCommerceServices.value('version', '0.1');

eCommerceServices.factory('Shops', ['$resource',function($resource){
    return $resource('../shops/:dest/:name',
        {
            dest:"shops"
        },
        {
            getAllShops:{
                method: "GET",
                isArray: true,
                cache:false,
                params:{
                    dest:"getAllShops"
                }
            }
        }
    );
}]);

eCommerceServices.factory('principal', ['$q', '$http',function($q, $http) {
    var _identity = undefined,_authenticated = false;
    return {
        getIdentityData: function() {
            return _identity;
        },
        isIdentityResolved: function() {
            return angular.isDefined(_identity);
        },
        isAuthenticated: function() {
            return _authenticated;
        },
        isInRole: function(role) {
            if (!_authenticated || !_identity.roles) return false;

            return _identity.roles.indexOf(role) != -1;
        },
        isInAnyRole: function(roles) {
            if (!_authenticated || !_identity.roles) return false;
            for (var i = 0; i < roles.length; i++) {
                if (this.isInRole(roles[i])) return true;
            }
            return false;
        },
        authenticate: function(identity) {
            _identity = identity;
            _authenticated = identity != null;
        },
        identity: function(force) {
            //myConfig.currentConfig = {};
            var deferred = $q.defer();
            if (force === true) _identity = undefined;
            // check and see if we have retrieved the identity data from the server.
            // if we have, reuse it by immediately resolving
            if (angular.isDefined(_identity)) {
                deferred.resolve(_identity);
                return deferred.promise;
            }
            var self = this;
            $http({method: 'GET', url: '../rest/user/identity'}).
            success(function(data, status, headers, config) {
                _identity = data;
                _authenticated = true;
                deferred.resolve(_identity);
            }).
            error(function(data, status, headers, config) {
                _identity = null;
                _authenticated = false;
                deferred.resolve(_identity);
            });
            return deferred.promise;
        }
    };
}
]);