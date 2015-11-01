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
            'angular': ['../lib/angularjs/angular'],
            'jquery': ['../lib/jquery/jquery'],
            'jsRoutes': ['/jsroutes']
        }
    });

    require(["angular", "./services/playRoutes"], function() {
        var app = angular.module("app", ["play.routing"]);

        angular.bootstrap(document, ["app"]);
    });

})();

