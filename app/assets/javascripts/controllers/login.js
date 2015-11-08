define(["angular"], function(angular) {
    "use strict";

    return {
        LoginCtrl: function($scope, playRoutes) {
            /*PlayRoutes' usage example
            $scope.login = function(credentials) {
                console.log("about to post Credentials: " + credentials);
                playRoutes.controllers.Application.login().post(credentials).then(function(response) {
                    console.log("Received Token: " + response.data.token);
                    return response.data; // return promise so we can chain easily
                }).then(function(response) {
                    // Promise of Users.user(3).get() is resolved here
                    $scope.loggedIn = true;
                    $scope.user = response.data;
                });
            };*/
        }
    };

});