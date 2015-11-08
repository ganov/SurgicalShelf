(function() {
    "use strict";

    requirejs.config({
        shim: {
            'jsRoutes': {
                deps: [],
                // it's not a RequireJS module, so we have to tell it what var is returned
                exports: 'jsRoutes'
            },
            'angular': {
                deps: ['jquery'],
                exports: 'angular'
            }
        },
        paths: {
            'angular': ['../lib/angularjs/angular.min'],
            'jquery': ['../lib/jquery/jquery.min'],
            'jsRoutes': ['/jsroutes']
        }
    });

    require(["angular", "./services/playRoutes", "./controllers/login"], function(a, b, login) {
        var app = angular.module("MyApp", ["play.routing"]);
        app.controller("LoginCtrl", login.LoginCtrl);

        angular.bootstrap(document, ["MyApp"]);
    });

})();

