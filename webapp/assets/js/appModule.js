var app = angular.module('hrmsApp', ['ngRoute']);

app.config(function($routeProvider){
    $routeProvider
    
  /*  .when('/', {
          templateUrl: 'assets/pages/dashboard.html',
        controller: 'dashboardController'
          })
          */
    .when('/', {
        templateUrl: 'assets/pages/employee.html',
        controller: 'employeeController'
    })
    .when('/documents', {
          templateUrl: 'assets/pages/documents.html',
        controller: 'documentsController'
          })
    
    .when('/leave', {
          templateUrl: 'assets/pages/leave.html',
        controller: 'leaveController'
          })
    
    .when('/contact', {
          templateUrl: 'assets/pages/contact.html',
        controller: 'contactController'
          })
    .when('/pending', {
          templateUrl: 'assets/pages/pendingLeaves.html',
        controller: 'pendingController'
          })
    .when('/esop', {
          templateUrl: 'assets/pages/addEsop.html',
        controller: 'esopController'
          })
    .when('/breakage', {
          templateUrl: 'assets/pages/viewEsops.html',
        controller: 'breakageController'
          })
    
});