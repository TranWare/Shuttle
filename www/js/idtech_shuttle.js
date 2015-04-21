 'use strict';
 
    var Shuttle = ( typeof Shuttle === 'undefined' ? {} : Shuttle );
    var cordova = window.cordova || window.Cordova;
    
    Shuttle.detectReader = function(callback, error) {
        var success = function(data) {
        	console.log(data)
        	callback(data);
        };
        var fail_handler =  error;
        cordova.exec(success, fail_handler, 'com.tranware.Shuttle', 'ACTION_DETECT_READER', []);
    };
    
    Shuttle.getSwipe = function(callback, error) {
        var success = function(data) {
        	console.log(data)
        	callback(data);
        };
        var fail_handler =  error;
        cordova.exec(success, fail_handler, 'com.tranware.Shuttle', 'ACTION_GET_SWIPE', []);
    };
    
    Shuttle.cancelSwipe = function(callback, error) {
        var success = function(data) {
        	console.log(data)
        	callback(data);
        };
        var fail_handler =  error;
        cordova.exec(success, fail_handler, 'com.tranware.Shuttle', 'ACTION_CANCEL_SWIPE', []);
    };

    module.exports = Shuttle;
