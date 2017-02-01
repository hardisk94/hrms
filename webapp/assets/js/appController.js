app.controller('indexController', function ($scope, $rootScope) {
        $rootScope.empID = "1";
        $rootScope.customerID = "1";
        $rootScope.employeeDetails = {};
        $rootScope.baseUrl = "http://localhost:8080";
        if ($scope.empID === "emp1") {
                $('.navigation-main').append('<li id="pending-link"><a href="#/pending"><i class="icon-newspaper"></i> <span>Pending Leaves</span></a></li>');
        }

});

app.controller('contactController', ['$scope', '$rootScope', '$http', function ($scope, $rootScope, $http) {
        $scope.tab = "basic";



        //   $("#contact-link").on('click',function(e){  

        // $http.get('assets/js/json/MOCK_D.json')
        $http.get($rootScope.baseUrl + "/employee/contactDetails/getById/" + $rootScope.customerID + "/" + $rootScope.empID)
                .then(function (response) {
                        $scope.contactDetails = response.data.result;
                        console.log($scope.contactDetails);

                        $scope.frontDeskNumber = $scope.contactDetails.employeeId;
                        $scope.block = $scope.contactDetails.locationShortName;
                        $scope.address = $scope.contactDetails.locationAddress;
                        $scope.off = $scope.contactDetails.locationPhone;
                        $scope.add = $scope.contactDetails.permanentAddress;
                        $scope.ename = $scope.contactDetails.emergencyName;
                        $scope.relation = $scope.contactDetails.emergencyRelation;
                        $scope.eadd = $scope.contactDetails.emergencyAddress;
                        $scope.no = $scope.contactDetails.phoneNumber;
                        $scope.email_id = $scope.contactDetails.emailId;
                        $scope.facebook_id = $scope.contactDetails.facebookId;
                        $scope.skype_id = $scope.contactDetails.twitterId;
                        $scope.twitter_id = $scope.contactDetails.skypeId;

                }, function (response) {
                        //Second function handles error
                        $scope.content = "Something went wrong";

                });
        //  });

}]);
app.controller('dashboardController', function ($scope, $rootScope) {
        $scope.message = "This is dashboard controller."
});
app.controller('documentsController', function ($scope, $rootScope) {
        $("#documents-link").on('click', function (e) {

                $.ajax({
                        url: "assets/js/json/MOCK_D.json",
                        success: function (json) {

                                $scope.data = json.records;

                        }
                });
        });
});

 
app.controller('employeeController', ['$scope','$rootScope','$http', function($scope, $rootScope,$http){
      $scope.tab="basic";
  
    
    /*Employee image here
    
     $http.get('assets/js/json/MOCK_D.json')
    //    $http.get($rootScope.baseUrl+"/employee/dependentDetails/getById/"+$rootScope.customerID+"/"+$rootScope.empID)
   .then(function(response) {
        
                    document.getElementById("emp-pic").src = "data:image/png;base64," + response.data.image;
                },
          function(response) {
        //Second function handles error
        $scope.content = "Something went wrong";
          
    });
    */
    
   // $("#employee-link").on('click',function(e){

        $scope.sub = function(){
            $('#emp_edit_form').submit(function(){

                                     console.log("It works")

                                                                           // SET VALUE OF HIDDEN FIELDS IN FORM(EMPLOYEE & CUSTOMER ID)
                                     $('#empId').val($rootScope.empID);

                                     $('#custId').val($rootScope.customerID);

                                             $.ajax({
                                               url: 'http://localhost:8080/employee/updateEmployee',
                                               type: $('#emp_edit_form').attr('method'),
                                               data : $('#edit_emp_form').serialize(),
                                                 dataType: 'html',
                                               success: function(resp){
                                                        console.log("Updated")
                                                 },
                                                 error: function(resp){
                                                     alert("Can not update.");
                                               }
                                             });
                                             return false;
                                         });
                                         };


        
        //$http.get($rootScope.baseUrl+"/employee/basicDetails/getById/"+$rootScope.customerID+"/"+$rootScope.empID)
       $http.get("http://10.177.68.228:8080/employee/basicDetails/getById/"+$rootScope.customerID+"/"+$rootScope.empID)
   .then(function(response) {
        
        $scope.employeeDetails = response.data.result;
            //----------------ADD EMPLOYEE DETAILS HERE --------------------------//
           $scope.Name = $scope.employeeDetails.employeeName;
           $scope.employeeId = $scope.employeeDetails.employeeId;
           $scope.Designation = $scope.employeeDetails.designationName;
           $scope.Department = $scope.employeeDetails.departmentName;
           $scope.Phoneno = $scope.employeeDetails.phoneNumber;
           $scope.Emailid = $scope.employeeDetails.emailId;
    //     $scope.EmploymentType = $scope.employeeDetails.employeeId;
           $scope.DOJ = $scope.employeeDetails.dateOfJoining;
    //       $scope.HighestDegree = $scope.employeeDetails.employeeId;
           $scope.BloodGroup = $scope.employeeDetails.bloodGroup;
           $scope.DesignationName = $scope.employeeDetails.designationName;
           $scope.Description = $scope.employeeDetails.designationDesc;
            $scope.Roles = $scope.employeeDetails.roleResponsibilities;
            $scope.Criteria = $scope.employeeDetails.criteriaForNextPromotion;
            
           document.getElementById("emp-pic").src = "data:image/png;base64," + $scope.employeeDetails.image;
    }, function(response) {
        //Second function handles error
        $scope.content = "Something went wrong";
          
    });
    //  $scope.$apply('reset',function($scope, $rootScope){
    $rootScope.reset = function(){
           $http.get("http://10.177.68.228:8080/employee/basicDetails/getById/"+$rootScope.customerID+"/"+$rootScope.empID)
   .then(function(response) {
        $scope.employeeDetails = {};
               $scope.employeeId="";
        $scope.employeeDetails = response.data.result;
         console.log($scope.employeeDetails);
            //----------------ADD EMPLOYEE DETAILS HERE --------------------------//
           $scope.Name = $scope.employeeDetails.employeeName;
           $scope.employeeId = $scope.employeeDetails.employeeId;
           $scope.Designation = $scope.employeeDetails.designationName;
           $scope.Department = $scope.employeeDetails.departmentName;
           $scope.Phoneno = $scope.employeeDetails.phoneNumber;
           $scope.Emailid = $scope.employeeDetails.emailId;
    //     $scope.EmploymentType = $scope.employeeDetails.employeeId;
           $scope.DOJ = $scope.employeeDetails.dateOfJoining;
    //       $scope.HighestDegree = $scope.employeeDetails.employeeId;
           $scope.BloodGroup = $scope.employeeDetails.bloodGroup;
           $scope.DesignationName = $scope.employeeDetails.designationName;
           $scope.Description = $scope.employeeDetails.designationDesc;
            $scope.Roles = $scope.employeeDetails.roleResponsibilities;
            $scope.Criteria = $scope.employeeDetails.criteriaForNextPromotion;
            
            $('#emp-pic').attr('src',$scope.employeeDetails.image);
             
    }, function(response) {
        //Second function handles error
        $scope.content = "Something went wrong";
          
    }
         );
   
     };   
     
 //   });
    
    
    $("#employee-qualification").on('click',function(e){
   
         $http.get($rootScope.baseUrl+"/skills/listSkillsTechnical/"+$rootScope.customerID+"/"+$rootScope.empID)
   .then(function(response) {
        console.log(response.data);
        $scope.TskillDetails = response.data;
             
            $scope.Technicalx = $scope.TskillDetails;
            
            
            
    }, function(response) {
        //Second function handles error
        $scope.content = "Something went wrong";
          
    });
         $http.get($rootScope.baseUrl+"/skills/listSkillsNonTechnical/"+$rootScope.customerID+"/"+$rootScope.empID)
   .then(function(response) {
        
             $scope.SskillDetails = response.data;
            $scope.Softx = $scope.SskillDetails;
            
            
    }, function(response) {
        //Second function handles error
        $scope.content = "Something went wrong";
          
    });
        
         //$http.get($rootScope.baseUrl+"/getEduDetails/"+$rootScope.empID)
         $http.get("http://10.177.68.228:8080/getEduDetails/"+$rootScope.empID)
   .then(function(response) {
        
        $scope.qualificationDetails = response.data;
            $scope.qualificationx = $scope.qualificationDetails;
            
            
    }, function(response) {
        //Second function handles error
        $scope.content = "Something went wrong";
          
    });
    });
    
    
    $("#employee-dependent").on('click',function(e){
   
        $http.get($rootScope.baseUrl+"/employee/dependentDetails/getById/"+$rootScope.customerID+"/"+$rootScope.empID)
   .then(function(response) {
        
        $scope.dependentDetails = response.data.result;
       
         $scope.family = $scope.dependentDetails.noOfMember;
            $scope.dependentx = $scope.dependentDetails.dependentsList;
            
            
    }, function(response) {
        //Second function handles error
        $scope.content = "Something went wrong";
          
    });
    });
    
    $("#employee-salary").on('click',function(e){
   
        $http.get( $rootScope.baseUrl + '/salary/getcurrent/'+ $rootScope.customerID+"/"+$rootScope.empID)
   .then(function(response) {
        
        $scope.currentsalaryDetails = response.data;
        
         $scope.c_fixed = $scope.currentsalaryDetails.fixedSalary;
            $scope.c_variable = $scope.currentsalaryDetails.variableSalary;
     }, function(response) {
        //Second function handles error
        $scope.content = "Something went wrong";
          
    });
        
        
        $http.get($rootScope.baseUrl+ '/salary/getprevious/'+ $rootScope.customerID+"/"+$rootScope.empID)
   .then(function(response) {
        
        $scope.previoussalaryDetails = response.data;
         console.log($scope.previoussalaryDetails);
         $scope.p_fixed = $scope.previoussalaryDetails.fixedSalary;
            $scope.p_variable = $scope.previoussalaryDetails.variableSalary;
     }, function(response) {
        //Second function handles error
        $scope.content = "Something went wrong";
          
    });
        
         $http.get($rootScope.baseUrl+'/variablepay/get/'+ $rootScope.customerID+"/"+$rootScope.empID)
   .then(function(response) {
        
        $scope.salaryx = response.data;
         
       
     }, function(response) {
        //Second function handles error
        $scope.content = "Something went wrong";
          
    });
        
    });
    
    $("#employee-project").on('click',function(e){
   
        
        //for table body1
        
       $.ajax({
               url: "http://10.177.68.169:8080/project/getEmployeeProject/emp3",
            success:
           function(json){
              console.log(json);
               
               var projects = json.projects;
               
               for(var i in projects){
                    
                    $("#Project_table1").append("<tr data-toggle='collapse' data-target='#Project1'"+ "class='clickable'>" +
                    "<td>"+projects[i].name+"</td>" +
                    "<td>"+projects[i].projectTypeObj.name+"</td>" +
				    "<td>"+projects[i].startDate+"</td>" +
                    "<td>"+projects[i].endDate+"</td> "+
                    "<td><button style='margin-right:10%' type='button' class='btn btn-coviam btn-sm'"+
                                        "data-toggle='modal' data-target='#projectmodal'"+
                                        "id='edit_project' style='float:right;'>"+
                                   "<span class='glyphicon glyphicon-pencil'><b>Edit</b></span>"+
                                   "</button></td>"+
                                                
                     "<tr>"+
                        "<td colspan='8' class='zeroPadding'>"+
                        "<div id='Project1' class='collapse out'>"+
                        "<br>"+
                          projects[i].projectDesc+                      
                        "</div>"+
                        "</td>"+
                        "</tr>"
                                                                            
                
                );   
               }
               
               
           }
        });
        
        
        
        //for table body2
        
        $.ajax({
               url: "http://10.177.68.169:8080/work/emp3",
            success:
           function(json){
             // console.log(json);
               
               var workExperiences = json;
               
               for(var i in workExperiences){
                    
                    $("#Project_table2").append("<tr>"+
									"<td>"+workExperiences[i].organizationName+"</td>"+
                                    "<td>"+workExperiences[i].designation+"</td>"+
				                    "<td>"+workExperiences[i].startDate+"</td>"+
                                    "<td>"+workExperiences[i].endDate+"</td>"+
                "<td><button style='margin-right:10%' type='button' class='btn btn-coviam btn-sm'"+ "data-toggle='modal' data-target='#prevExp' id='edit_prevExp' style='float:right;'>"+   "<span class='icon-pencil'><b>Edit</b></span>"+
                                   "</button></td>"+
									"</tr>"
                                                                            
                
                );   
               }
               
               
           }
        });
        
        var project = {
                
                name : "Project 2", 
                projectTypeName : "Product", 
                projectDesc: "asdasd",
                startDate: "2016-02-07",
                endDate: "2016-02-07",
                customerId: "1" ,
                employeeId: "1"
            };
            
   //     console.log(JSON.stringify(project));
        
        $.ajax({
            type : 'POST',
            url : 'http://10.177.68.169:8080/project/add',
            data : JSON.stringify(project),
            contentType : "application/json",
            dataType : 'json'
        });
        
        
        $scope.AddProject= function(){
            
            var project = {
                
                name : $("#ec_name1").val(), 
                projectTypeName : $("#ec_type1").val(), 
                projectDesc: $("#ec_description1").val(),
                startDate: $("#ec_startDate1").val(),
                endDate: $("#ec_endDate1").val(),
                customerId: $rootScope.empID ,
                employeeId: $rootScope.customerID
            }
            
//            console.log(JSON.stringify(project));
            
            $.ajax({
                url: 'http://10.177.68.169:8080/project/add', 
                method: 'post',
                data: JSON.stringify(project)
            });
            
        }
        
        
        
        
    });
    
    $("#employee-details").on('click',function(e){
   
        $http.get($rootScope.baseUrl+'/bankDetails/show/'+ $rootScope.customerID+"/"+$rootScope.empID)
   .then(function(response) {
        
        $scope.bankDetails = response.data;
     //    console.log($scope.bankDetails);
       
      $scope.BankName=$scope.bankDetails.bankName;
    $scope.BranchName=$scope.bankDetails.branchName;
    $scope.IFSCCode=$scope.bankDetails.ifscCode;
    $scope.AccountNo=$scope.bankDetails.accountNumber;
    
    $scope.AccountType=$scope.bankDetails.accountType;
    $scope.BankDetailsId=$scope.bankDetails.bankDetailId;
     }, function(response) {
        //Second function handles error
        $scope.content = "Something went wrong";
          
    });
    });
    
     
    
    $scope.VisaDetails="23333";
    
   
    $scope.ProjectName="Employee Management System";
}]);
app.controller('leaveController', function($scope,$rootScope, $http){
 $scope.tab = "tab-1";
     $("#leave-link").on('click',function(e){
     
         
          $http.get($rootScope.baseUrl+"/getAllLeaveHistory/"+$rootScope.empID+"/"+$rootScope.customerID)
   .then(function(response) {
            $scope.data=response.data;
        //         console.log($scope.data); 
          });
     });
    
    //dynamic leave type in dropdown
   
   $("#apply-leave").on('click',function(e){
   });
   
  //      console.log("here in leave type");
});

app.controller('modalController', function ($scope, $rootScope, $http) {
        //  $('#EditInfoModal #submit-btn').on('click', function(){ console.log("fsefz");});
        $('#emp_edit_form').submit(function (event) {

                $('#empId').val($rootScope.empID);

                $('#custId').val($rootScope.customerID);

                $.ajax({
                        url: $rootScope.baseUrl+ '/employee/updateEmployee',
                        type: $('#emp_edit_form').attr('method'),
                        data: $('#edit_emp_form').serialize(),
                        dataType: 'html',
                        success: function (resp) {
                                console.log("Updated");
                        },
                        error: function (resp) {
                                alert("Can not update.");
                        }
                });
                event.preventDefault();
                return false;
        });
    });

    
    app.controller('employeeCodeController', function($scope,$rootScope,$http,$compile, $window){
    
    // $("#codes").on('click',function(e){
     
         $.ajax({
             
                url: "http://10.177.68.228:8080/getAllEmplyeeId/2",
             success:
            function(json){
                var employeeCode = json;
                $scope.data=json;
                 
                var i =0;
             for(i=0;i<employeeCode.length;i++){ 
                console.log(employeeCode.length);
                 var comp = "<li id='"+ employeeCode[i].employeeId +"' ng-click=\"setEmployee("+employeeCode[i].employeeId+")\" >"+employeeCode[i].employeeId+" </li>";
             
                 
                 var temp = $compile(comp)($scope);
                $("#employee_code").html("");
                 $("#employee_code").append(temp);
             }
                 
            }
         });
    
   
        $scope.setEmployee = function(ID){
      console.log("here");
      $rootScope.empID=ID;
   console.log("NEW" + $rootScope.empID);
    $window.location.reload();  
    
    };



});
app.controller('employeeController', ['$scope', '$rootScope', '$http', function ($scope, $rootScope, $http) {
        $scope.tab = "basic";

        $http.get($rootScope.baseUrl + "/employee/basicDetails/getById/" + $rootScope.customerID + "/" + $rootScope.empID)
                // $http.get('http://10.177.68.76:8080/employee/basicDetails/getById/1/1')
                .then(function (response) {

                        $scope.employeeDetails = response.data.result;
                        console.log($scope.employeeDetails);
                        //----------------ADD EMPLOYEE DETAILS HERE --------------------------//
                        $scope.Name = $scope.employeeDetails.employeeName;
                        $scope.employeeId = $scope.employeeDetails.employeeId;
                        $scope.Designation = $scope.employeeDetails.designationName;
                        $scope.Department = $scope.employeeDetails.departmentName;
                        $scope.Phoneno = $scope.employeeDetails.phoneNumber;
                        $scope.Emailid = $scope.employeeDetails.emailId;
                        //     $scope.EmploymentType = $scope.employeeDetails.employeeId;
                        $scope.DOJ = $scope.employeeDetails.dateOfJoining;
                        //       $scope.HighestDegree = $scope.employeeDetails.employeeId;
                        $scope.BloodGroup = $scope.employeeDetails.bloodGroup;
                        $scope.DesignationName = $scope.employeeDetails.designationName;
                        $scope.Description = $scope.employeeDetails.designationDesc;
                        $scope.Roles = $scope.employeeDetails.roleResponsibilities;
                        $scope.Criteria = $scope.employeeDetails.criteriaForNextPromotion;
                        $scope.emppic = "data:image/png;base64," + $scope.employeeDetails.image;
            console.log($scope.employeeDetails);
                        //document.getElementById("emp-pic").src = "data:image/png;base64," + $scope.employeeDetails.image;
                }, function (response) {
                        //Second function handles error
                        $scope.content = "Something went wrong";

                });

        //   });


        $("#employee-qualification").on('click', function (e) {

                $http.get($rootScope.baseUrl + "/skills/listSkillsTechnical/" + $rootScope.customerID + "/" + $rootScope.empID)
                        .then(function (response) {
                                console.log(response.data);
                                $scope.TskillDetails = response.data;

                                $scope.Technicalx = $scope.TskillDetails;



                        }, function (response) {
                                //Second function handles error
                                $scope.content = "Something went wrong";

                        });
                $http.get($rootScope.baseUrl + "/skills/listSkillsNonTechnical/" + $rootScope.customerID + "/" + $rootScope.empID)
                        .then(function (response) {

                                $scope.SskillDetails = response.data;
                                $scope.Softx = $scope.SskillDetails;


                        }, function (response) {
                                //Second function handles error
                                $scope.content = "Something went wrong";

                        });

                $http.get($rootScope.baseUrl + "/getEduDetails/" + '/' + $rootScope.customerID + '/' + $rootScope.empID)
                        .then(function (response) {

                                $scope.qualificationDetails = response.data;
                                $scope.qualificationx = $scope.qualificationDetails;
                        console.log($scope.qualificationx);

                        }, function (response) {
                                //Second function handles error
                                $scope.content = "Something went wrong";

                        });
        });


        $("#employee-dependent").on('click', function (e) {

                //  $http.get('assets/js/json/MOCK_D.json')
                $http.get($rootScope.baseUrl + "/employee/dependentDetails/getById/" + $rootScope.customerID + "/" + $rootScope.empID)
                        .then(function (response) {
                                console.log(response.data.result)
                                $scope.dependentDetails = response.data.result;

                                $scope.family = $scope.dependentDetails.noOfMember;
                                $scope.dependentx = $scope.dependentDetails.dependentsList;
                        }, function (response) {
                                //Second function handles error
                                $scope.content = "Something went wrong";

                        });
        });

        $("#employee-salary").on('click', function (e) {

                $http.get($rootScope.baseUrl + '/salary/getcurrent/' + $rootScope.customerID + "/" + $rootScope.empID)
                        .then(function (response) {

                                $scope.currentsalaryDetails = response.data;

                                $scope.c_fixed = $scope.currentsalaryDetails.fixedSalary;
                                $scope.c_variable = $scope.currentsalaryDetails.variableSalary;
                        }, function (response) {
                                //Second function handles error
                                $scope.content = "Something went wrong";

                        });


                $http.get($rootScope.baseUrl + '/salary/getprevious/' + $rootScope.customerID + "/" + $rootScope.empID)
                        .then(function (response) {

                                $scope.previoussalaryDetails = response.data;
                                console.log($scope.previoussalaryDetails);
                                $scope.p_fixed = $scope.previoussalaryDetails.fixedSalary;
                                $scope.p_variable = $scope.previoussalaryDetails.variableSalary;
                        }, function (response) {
                                //Second function handles error
                                $scope.content = "Something went wrong";

                        });

                $http.get($rootScope.baseUrl + '/variablepay/get/' + $rootScope.customerID + "/" + $rootScope.empID)
                        .then(function (response) {

                                $scope.salaryx = response.data;


                        }, function (response) {
                                //Second function handles error
                                $scope.content = "Something went wrong";

                        });

        });

        $("#employee-project").on('click', function (e) {


                // Data -- for table body1 Add Current project

                $.ajax({
                        url: $rootScope.baseUrl + '/project/getEmployeeProject/' + $rootScope.customerID + '/' + $rootScope.empID,
                        //url:"http://10.177.68.169:8080/project/getEmployeeProject/1/1",
                        success: function (json) {
                                console.log(json);

                                var projects = json.projects;

                                for (var i in projects) {

                                        $("#Project_table1").append("<tr data-toggle='collapse' data-target='#Project1'" + "class='clickable'>" +
                                                "<td>" + projects[i].name + "</td>" +
                                                "<td>" + projects[i].projectTypeObj.name + "</td>" +
                                                "<td>" + projects[i].startDate + "</td>" +
                                                "<td>" + projects[i].endDate + "</td> " +
                                                "<td><button style='margin-right:10%' type='button' class='btn btn-coviam btn-sm'" +
                                                "data-toggle='modal' data-target='#projectmodal'" +
                                                "id='edit_project' style='float:right;'>" +
                                                "<span class='glyphicon glyphicon-pencil'><b>Edit</b></span>" +
                                                "</button></td>" +

                                                "<tr>" +
                                                "<td colspan='8' class='zeroPadding'>" +
                                                "<div id='Project1' class='collapse out'>" +
                                                "<br>" +
                                                projects[i].projectDesc +
                                                "</div>" +
                                                "</td>" +
                                                "</tr>"


                                        );
                                }


                        }
                });



                //Data - for table body2 Add Previous Experience 

                $.ajax({
                        url: $rootScope.baseUrl + '/work/getPastWorkExperience/' + $rootScope.empID,

                        success: function (json) {
                                console.log(json);

                                var workExperiences = json;

                                for (var i in workExperiences) {

                                        $("#Project_table2").append("<tr>" +
                                                "<td>" + workExperiences[i].organizationName + "</td>" +
                                                "<td>" + workExperiences[i].designation + "</td>" +
                                                "<td>" + workExperiences[i].startDate + "</td>" +
                                                "<td>" + workExperiences[i].endDate + "</td>" +
                                                "<td><button style='margin-right:10%' type='button' class='btn btn-coviam btn-sm'" + "data-toggle='modal' data-target='#prevExp' id='edit_prevExp' style='float:right;'>" + "<span class='icon-pencil'><b>Edit</b></span>" +
                                                "</button></td>" +
                                                "</tr>"


                                        );
                                }


                        }
                });



                //----------- Add Current Project ------------------  

                $scope.AddProject = function () {

                        var project = {

                                name: $("#ec_name1").val(),
                                projectTypeName: $("#ec_type1").val(),
                                projectDesc: $("#ec_description1").val(),
                                startDate: $("#ec_startDate1").val(),
                                endDate: $("#ec_endDate1").val(),
                                customerId: $rootScope.empID,
                                employeeId: $rootScope.customerID
                        }

                        console.log(JSON.stringify(project));


                        //$.post("http://10.177.68.169:8080/project/add", JSON.stringify(project), "jsonp" )

                        console.log(JSON.stringify(project));

                        $.ajax({
                                type: 'POST',
                                url: $rootScope.baseUrl + '/project/add/' + $rootScope.empID,
                                data: project,
                                //header: { 'Access-Control-Allow-Origin' : '*'},
                                crossDomain: true,


                                success: function (data, textStatus, jQXhr) {
                                        $("#responseDiv").html(data);
                                }



                        });

                } 
       
            
            
            
            
    // ----------------  DropDown integration Add Current Project --------------------        
         $.ajax({
    url:$rootScope.baseUrl+'/project/getAllProjectType/'+$rootScope.customerID,
            // url:"http://10.177.68.169:8080/project/getAllProjectType/1",
            success:
           function(json){
              console.log(json);
               
               var projectsType = json;
               
             $("#ec_type1").html( "" );  
               
               for(var i in projectsType){
               
    $("#ec_type1").append("<option value='"+projectsType[i].name+"'>"+projectsType[i].name+"</option>")
               
               }
            
           }
            
        
        
    });

     // ---------------- / DropDown integration Add Current Project --------------------  
        
 
        
 // NOT REQUIRED----------------  DropDown integration Add PREVIOUS Experience --------------------          
        
 /* $.ajax({
    //url:$rootScope.baseUrl+'/project/getAllProjectType/'+$rootScope.customerID,
             url:"http://10.177.68.169:8080/project/getAllProjectType/1",
            success:
           function(json){
              console.log(json);
               
               var projectsTypePreviousExp = json;
               
             $("#ec_type2").html( "" );  
               
               for(var i in projectsTypePreviousExp){
               
    $("#ec_type1").append("<option value='"+projectsTypePreviousExp[i].name+"'>"+projectsTypePreviousExp[i].name+"</option>")
               
               }
            
           }
            
        
        
    }); */
        
        
 // ----------------  / DropDown integration Add PREVIOUS Experience  -------------------- 
        
        
    // ----------------  DropDown integration EDIT --------------------          
        
  $.ajax({
    url:$rootScope.baseUrl+'/project/getAllProjectType/'+$rootScope.customerID,
            // url:"http://10.177.68.169:8080/project/getAllProjectType/1",
            success:
           function(json){
              console.log(json);
               
               var EditCurrentProject = json;
               
             $("#ec_editType1").html( "" );  
               
               for(var i in EditCurrentProject){
               
    $("#ec_editType1").append("<option value='"+EditCurrentProject[i].name+"'>"+EditCurrentProject[i].name+"</option>")
               
               }
            
           }
            
        
        
    }); 
        
        
 // ----------------  DropDown integration Add PREVIOUS Experience  --------------------     
        
        
        
        
        
        
        
        
        
        
    });
    
    $("#employee-details").on('click',function(e){
   
        $http.get($rootScope.baseUrl+'/bankDetails/show/'+ $rootScope.customerID+"/"+$rootScope.empID)
   .then(function(response) {
        if(response!=null){
            $scope.bankDetails = response.data[0];
         console.log($scope.bankDetails);
       
      $scope.BankName=$scope.bankDetails.bankName;
    $scope.BranchName=$scope.bankDetails.branchName;
    $scope.IFSCCode=$scope.bankDetails.ifscCode;
    $scope.AccountNo=$scope.bankDetails.accountNumber;
    
    $scope.AccountType=$scope.bankDetails.accountType;
    $rootScope.BankDetailsId=$scope.bankDetails.bankDetailId;
            console.log($scope.BankDetailsId);
        }
        
        }, function(response) {
        //Second function handles error
        $scope.content = "Something went wrong";
          
    });
        

        $scope.addBankDetails=function(){
            console.log("string");
            
            var bankDetails={
                bankName : document.getElementById('ec_bankname').value,
                branchName : document.getElementById('ec_branchName').value,
                ifscCode : document.getElementById('ec_ifscCode').value,
                accountType :document.getElementById('ec_accountType').value,
                accountNumber : document.getElementById('ec_accountNumber').value,
                employeeId : $rootScope.empID,
                customerId : $rootScope.customerID  ,
                bankDetailsId:  $rootScope.BankDetailsId
            }
            console.log(bankDetails);
            

            
             $.ajax({
            type : 'PUT',
            url :$rootScope.baseUrl+'/bankDetails/update',
            data : bankDetails,
            crossDomain: true,  
            success: function(data, textStatus, jQXhr){
            
             console.log($().html(data));
            }
             });

                //-------------- AddProjectPreviousExp ---------------------------


                $scope.AddProjectPreviousExp = function () {

                        var projectPreExp = {

                                name: $("#ec_name2").val(),
                                projectTypeName: $("#ec_type2").val(),
                                //projectDesc: $("#ec_description1").val(),
                                startDate: $("#ec_startDate2").val(),
                                endDate: $("#ec_endDate2").val(),
                                customerId: $rootScope.empID,
                                employeeId: $rootScope.customerID
                        }

                        console.log(JSON.stringify(projectPreExp));


                        //$.post("http://10.177.68.169:8080/project/add", JSON.stringify(project), "jsonp" )

                        console.log(JSON.stringify(projectPreExp));

                        $.ajax({
                                type: 'POST',
                                url: $rootScope.baseUrl + '/work/addWork/',

                                data: projectPreExp,
                                //header: { 'Access-Control-Allow-Origin' : '*'},
                                crossDomain: true,


                                success: function (data, textStatus, jQXhr) {
                                        $("#responseDiv").html(data);
                                }



                        });


                }

                // -----------------  / AddProjectPreviousExp -----------------------
        }
    });
                        





                // ----------------  DropDown integration Add Current Project --------------------        
                $.ajax({
                        url: $rootScope.baseUrl + '/project/getAllProjectType/' + $rootScope.customerID,
                        // url:"http://10.177.68.169:8080/project/getAllProjectType/1",
                        success: function (json) {
                                console.log(json);

                                var projectsType = json;

                                $("#ec_type1").html("");

                                for (var i in projectsType) {

                                        $("#ec_type1").append("<option value='" + projectsType[i].name + "'>" + projectsType[i].name + "</option>")

                                }

                        }



                });

                // ---------------- / DropDown integration Add Current Project --------------------  



                // NOT REQUIRED----------------  DropDown integration Add PREVIOUS Experience --------------------          

                /* $.ajax({
                   //url:$rootScope.baseUrl+'/project/getAllProjectType/'+$rootScope.customerID,
                            url:"http://10.177.68.169:8080/project/getAllProjectType/1",
                           success:
                          function(json){
                             console.log(json);
                              
                              var projectsTypePreviousExp = json;
                              
                            $("#ec_type2").html( "" );  
                              
                              for(var i in projectsTypePreviousExp){
                              
                   $("#ec_type1").append("<option value='"+projectsTypePreviousExp[i].name+"'>"+projectsTypePreviousExp[i].name+"</option>")
                              
                              }
                           
                          }
                           
                       
                       
                   }); */


                // ----------------  / DropDown integration Add PREVIOUS Experience  -------------------- 


                // ----------------  DropDown integration EDIT --------------------          

                $.ajax({
                        url: $rootScope.baseUrl + '/project/getAllProjectType/' + $rootScope.customerID,
                        // url:"http://10.177.68.169:8080/project/getAllProjectType/1",
                        success: function (json) {
                                console.log(json);

                                var EditCurrentProject = json;

                                $("#ec_editType1").html("");

                                for (var i in EditCurrentProject) {

                                        $("#ec_editType1").append("<option value='" + EditCurrentProject[i].name + "'>" + EditCurrentProject[i].name + "</option>")

                                }

                        }



                });


                // ----------------  DropDown integration Add PREVIOUS Experience  --------------------     
     

        $("#employee-details").on('click', function (e) {

                $http.get($rootScope.baseUrl + '/bankDetails/show/' + $rootScope.customerID + "/" + $rootScope.empID)
                        .then(function (response) {

                                $scope.bankDetails = response.data[0];
                                console.log($scope.bankDetails);

                                 $scope.BankName=$scope.bankDetails.bankName;
                                $scope.BranchName=$scope.bankDetails.branchName;
                                $scope.IFSCCode=$scope.bankDetails.ifscCode;
                                $scope.AccountNo=$scope.bankDetails.accountNumber;

                                $scope.AccountType=$scope.bankDetails.accountType;
                                $scope.BankDetailsId=$scope.bankDetails.bankDetailId;
                }, function(response) {
                               // Second function handles error
                                $scope.content = "Something went wrong";

                        });


                $http.get($rootScope.baseUrl + '/work/viewVisa/' + $rootScope.customerID + "/" + $rootScope.empID)
                        .then(function (response) {
                                 console.log(response.data);
                                 $scope.visax = response.data;
                                }, function(response) {
                                               // Second function handles error
                                                $scope.content = "Something went wrong";

                                        });


                $scope.addBankDetails = function () {
                        console.log("string");

                        var bankDetails = {
                                bankName: document.getElementById('ec_bankname').value,
                                branchName: document.getElementById('ec_branchName').value,
                                ifscCode: document.getElementById('ec_ifscCode').value,
                                accountType: document.getElementById('ec_accountType').value,
                                accountNumber: document.getElementById('ec_accountNumber').value,
                                bankDetailId: document.getElementById('ec_bankDeatilId').value,
                                employeeId: $rootScope.empID,
                                customerId: $rootScope.customerID
                        }
                        console.log(bankDetails);


                        $.ajax({
                                type: 'POST',
                                url: $rootScope.baseUrl + '/bankDetails/create',
                                data: bankDetails,
                                crossDomain: true,
                                success: function (data, textStatus, jQXhr) {
                                        console.log($().html(data));
                                }
                        });
                };

                // $http.get("js/qualification.json")
                //    .then(function (response) {
                //        console.log(response.data);
                //    $scope.qualificationx = response.data.records;
                //});

                // $scope.VisaDetails="23333";
                // $scope.ProjectName="Employee Management System";
        });


    



}]);






app.controller('leaveController', function ($scope, $rootScope, $http) {
        $scope.tab = "tab-1";
        //    $("#leave-link").on('click',function(e){

        /*  $.ajax({
              
                 url: $rootScope.baseUrl+"/getAllLeaveHistory/"+$rootScope.empID+"/"+$rootScope.customerID,
              success:
             function(json){
                 
                 $scope.data=json[0];
                  console.log($scope.data);
             }
          });
          */

        $http.get($rootScope.baseUrl + "/getAllLeaveHistory/" + $rootScope.empID + "/" + $rootScope.customerID)
                .then(function (response) {
                        $scope.data = response.data;
                        console.log($scope.data);
                });
        //   });

        //dynamic leave type in dropdown

        $("#apply-leave").on('click', function (e) {

                console.log("here in leave type");

                $.ajax({

                        url: $rootScope.baseUrl + "/getAllLeaveTypeName/" + $rootScope.customerID,
                        success: function (json) {

                                $scope.leaveType = json;
                                console.log($scope.leaveType);
                                for (var i in $scope.leaveType) {
                                        $("#leave_type").append("<option>" + $scope.leaveType[i] + "</option>");
                                }
                        }
                });
        });

        $scope.tab = "tab-1";
        $scope.leave_type = "sick leave";
        $scope.start_date = "2/01/2017";
        $scope.end_date = "12/01/2017";
        $scope.reason = "Fever";
        $scope.waiting = "";
        $scope.approval = "approved";
        $scope.deny = "";
        $scope.approved_date = "1/01/2017";
        $scope.approved_by = "Phani Kumar";
        $scope.comment = "ok";

});

app.controller('employeeCodeController', function ($scope, $rootScope, $http, $compile, $window) {

        // $("#codes").on('click',function(e){

        $.ajax({

                //url: "http://10.177.68.228:8080/getAllEmplyeeId/2",
                url: 'http://localhost:8080/getAllEmplyeeId/' + $rootScope.customerID,
                success: function (json) {
                        //  

                        var employeeCode = json;
                        $scope.data = json;

                        //       $($scope.data).each(function(){

                        //     var option = $('<option />');
                        //    option.attr('value', this.value).text(this.employeeId);

                        //  $('#employee_code').append(option);
                        var i = 0;
                        for (i = 0; i < employeeCode.length; i++) {
                                console.log(employeeCode.length);
                                var comp = "<li id='" + employeeCode[i].employeeId + "' ng-click=\"setEmployee(" + employeeCode[i].employeeId + ")\" >" + employeeCode[i].employeeId + " </li>";


                                var temp = $compile(comp)($scope);
                                $("#employee_code").html("");
                                $("#employee_code").append(temp);
                        }

                }
        });

        // });
        $scope.setEmployee = function (ID) {
                console.log("here");
                $rootScope.empID = ID;
                console.log("NEW" + $rootScope.empID);
                $window.location.reload();

        };

});

    
    app.controller('employeeCodeController', function($scope,$rootScope,$http,$compile, $window){
    
        //Set employee image./////
        $.ajax({
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        timeout: 10000,
        url: 'Common.asmx/GetItemPreview',
     //   data: '{"id":"' + document.getElementById("AwardDropDown").value + '"}',
        success: function (response) {
          //  if (data.d != null) {
            //    var results = jQuery.parseJSON(data.d);
              //  for (var key in results) {
                    //the results is a base64 string.  convert it to an image and assign as 'src'
                    document.getElementById("emp-pic").src = "data:image/png;base64," + response.data;
        //        }
            }
        });
    
        
        
        //End employee image////
        
        
        
    // $("#codes").on('click',function(e){
     
         $.ajax({
             
                url: $rootScope.baseUrl+"/getAllEmplyeeId/1",
             success:
            function(json){
       //      console.log(json);
                
                var employeeCode = json;
                $scope.data=json;
                 
         //       $($scope.data).each(function(){
   
           //     var option = $('<option />');
            //    option.attr('value', this.value).text(this.employeeId);

              //  $('#employee_code').append(option);
                var i =0;
             for(i=0;i<employeeCode.length;i++){ 
           //     console.log(employeeCode.length);
                 var comp = "<a href='#/'><li id='"+ employeeCode[i].employeeId +"' ng-click=\"setEmployee("+employeeCode[i].employeeId+")\" >"+employeeCode[i].employeeId+" </li></a>";
             
                 
                 var temp = $compile(comp)($scope);
                //$("#employee_code").html("");
                 $("#employee_code").append(temp);
             }
                 
            }
         });
    
    // });
  $scope.setEmployee = function(ID){
//     $window.location.reload();  

      console.log("here");
      $rootScope.empID=ID;
  // console.log("NEW" + $rootScope.empID);
      console.log($rootScope.empID);
    $rootScope.reset();
    };
        
        
        $scope.AddEduDetail = function(){
            
            var project = {
                degree : $("#ec_degree1").val(),
                university : $("#ec_university1").val(),
                duration : $("#ec_duration1").val(),
                score : $("#ec_score1").val(),
                type : $("#ec_type1").val(),
                customerId: $rootScope.empID ,
                employeeId: $rootScope.customerID
            }
            
            console.log(JSON.stringify(project));
            
            
            $.ajax({
                type : 'POST',
                url : 'http://10.177.68.228/addEduDetails/'+$rootScope.empID,
                data : project,
                crossDomain: true,
                
                success: function(data, textStatus, jQXhr){
                    $("#responseDiv").html(data);
                }
            });
        }
        

    });
    //for cancellation
   $("#table_edit").on('click',function(e){
   
   
        
    });


//for cancellation
$("#table_edit").on('click', function (e) {


});


function applyLeave() {
        var jsonStr = $('#leaveApply_form').serialize()
        console.log("***** in aplly leave *****");

        //$('#empId').val($rootScope.empID);

        //$('#custId').val($rootScope.customerID);
        console.log("inside aplly leave");
        $.ajax({
                url: 'http://localhost:8080/applyLeave',
                type: "POST",
                //type: $('#leaveApply_form').attr('method'),

                data: jsonStr,
                dataType: 'html',
                success: function (resp) {
                        console.log("Success block");
                        alert(resp);
                        console.log('form resp: ');
                        window.location = "#/";
                },
                error: function (resp) {
                        console.log('form resp: ');
                        alert("Can not add LEAVE.");
                }
        });
        return false;
        /* var leaveApplication={
     "leaveType" :document.getElementById("leave_type").value,
     "fromDate" :document.getElementById("sdate").value,
     "toDate": document.getElementById("edate").value,
     "no_of_days" : document.getElementById("day").value,
     "leaveReason" : document.getElementById("reason").value,
    }
   
    console.log(leaveApplication);
     $.ajax({
          type: "POST",
     contentType : 'application/json; charset=utf-8',
     dataType : 'json',
     url: "http://localhost:8080/applyLeave",
     data: JSON.stringify(leaveApplication), // Note it is important
     success :function(result) {
       alert("leave applied");
     }
 });
  */
}
app.controller('pendingController', function ($scope, $rootScope) {

});
//----------------------------------POST REQUESTS-------------


app.controller('esopController', function ($scope, $rootScope, $routeParams) {
        $scope.operation = $routeParams.operation;

        today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; //January is 0!

        var yyyy = today.getFullYear();
        if (dd < 10) {
                dd = '0' + dd;
        }
        if (mm < 10) {
                mm = '0' + mm;
        }
        var today = yyyy + "-" + mm + "-" + dd;
        $('#myDate').val(today);


        if ($scope.operation == "update") {

                var url = $rootScope.baseUrl+ "/eSOPs/getByEsopId/" + $routeParams.esopId; //url for Spring API using global employee ID variale

                $.getJSON(url, function (json) {
                        $scope.json = json;



                        console.log(json);
                        $('#myDate').val(json.dateOffered);
                        $('#stckname').val(json.offeredStocks);
                        $('#pricename').val(json.priceOfStock);
                        $('#rows').val(json.breakages);
                        $('#decideBreakages').val("Show Breakages");


                        document.getElementById("rows").readOnly = true;


                        breakages = json.esopBreakageList;
                        $('#decideBreakages').on('click', function (e) {
                                console.log(breakages);
                                var num_rows = json.breakages;
                                var num_cols = 2;
                                var theader = '<table border="1" >\n';
                                var tbody = '';
                                tbody += '<tr>';

                                tbody += "<td style='padding:10px;'>";

                                tbody += 'Date';

                                tbody += '</td>'
                                tbody += '<td>';

                                tbody += 'Breakage amount';

                                tbody += '</td>'

                                for (var i = 0; i < num_rows; i++) {

                                        console.log(breakages[i].vestingDate);
                                        tbody += '<tr>';
                                        for (var j = 0; j < num_cols; j++) {

                                                tbody += '<td>';
                                                if (j / 2 == 0) {
                                                        tbody += '<input name="dates[' + i + ']" value="' + breakages[i].vestingDate + '" type="date" size="20"/>';
                                                } else {
                                                        tbody += '<input name="stocks[' + i + ']" value="' + breakages[i].stocksToBeVested + '" type="text" size="20"/>';
                                                }
                                                tbody += '</td>'
                                        }

                                        tbody += '</tr>\n';
                                }
                                var tfooter = '</table>';
                                document.getElementById('wrapper').innerHTML = theader + tbody + tfooter;


                        });







                });

        }

        $('#stock_form').submit(function () {
                // SET VALUE OF HIDDEN FIELDS IN FORM(EMPLOYEE & CUSTOMER ID)
                if ($scope.operation == "add") {
                        console.log("adding");
                        $('#empId').val($rootScope.empID);

                        $('#custId').val($rootScope.customerID);

                        $.ajax({
                                url: $rootScope.baseUrl+'/eSOPs/addEsop/',
                                type: $('#stock_form').attr('method'),
                                data: $('#stock_form').serialize(),
                                dataType: 'html',
                                success: function (resp) {

                                        console.log('form resp: ');
                                        location.href = "#/breakage";
                                },
                                error: function (resp) {
                                        console.log('form resp: ');
                                        alert("Can not add ESOP.");
                                }
                        });
                        return false;
                } else if ($scope.operation == "update") {
                        console.log("updating");
                        $('#esopId').val($routeParams.esopId);
                        $('#empId').val($rootScope.empID);

                        $('#custId').val($rootScope.customerID);

                        $.ajax({
                                url: $rootScope.baseUrl +'/eSOPs/updateEsop/',
                                type: 'PUT',
                                data: $('#stock_form').serialize(),
                                dataType: 'html',
                                success: function (resp) {

                                        console.log('form resp: ');
                                        location.href = "#/breakage";
                                },
                                error: function (resp) {
                                        console.log('form resp: ');
                                        alert("Can not update ESOP.");
                                }
                        });
                        return false;

                }

        });



        $('#decideBreakages').on('click', function () {



                var num_rows = document.getElementById('rows').value;
                var num_cols = 2;
                var theader = '<table  class ="table">\n';
                var tbody = '';
                tbody += '<tr>';

                tbody += '<td>';

                tbody += 'Vesting Date';

                tbody += '</td>'
                tbody += '<td>';

                tbody += 'Stocks to be Vested';

                tbody += '</td></tr><tr>'

                for (var i = 0; i < num_rows; i++) {


                        today = new Date();
                        var dd = today.getDate();
                        var mm = today.getMonth() + 1; //January is 0!

                        var yyyy = today.getFullYear();
                        if (dd < 10) {
                                dd = '0' + dd;
                        }
                        if (mm < 10) {
                                mm = '0' + mm;
                        }
                        var today = yyyy + "-" + mm + "-" + dd;
                        yyyy = yyyy + i + 1;
                        date = (yyyy) + "-" + mm + "-" + dd;
                        stocks = document.getElementById('stckname').value;
                        if (stocks == "") stocks = 0;
                        stocks = Math.floor(stocks / num_rows);

                        //console.log(date+" "+stocks);

                        for (var j = 0; j < num_cols; j++) {

                                tbody += '<td>';
                                if (j / 2 == 0) {
                                        tbody += '<input name="dates[' + i + ']" value="' + date + '" type="date" size="20"/>';
                                } else {
                                        tbody += '<input name="stocks[' + i + ']" value="' + stocks + '"type="text" size="20"/>';
                                }
                                tbody += '</td>'
                        }

                        tbody += '</tr>\n';
                }

                var tfooter = '</table>';
                document.getElementById('wrapper').innerHTML = theader + tbody + tfooter;

        });

});









app.controller('breakageController', function ($scope, $rootScope, $compile) { //Controller for viewEsops.html




        $scope.showBreakages = function (i) {
                obj = $scope.json[i];

                arr = obj.esopBreakageList;
                //console.log(arr); 
                count = 0;
                $("#breakagetbody").html("");
                if (arr != null && arr.length > 0) {
                        for (var j in arr) {
                                console.log(arr[j]);
                                if (arr[j].active == 1) {
                                        count++;
                                        $("#breakagetbody").append("<tr ><td >" + arr[j].vestingDate + "</td> //<td>" + arr[j].stocksToBeVested + "</td> </tr>");
                                }

                        }
                }

                if (count == 0) $("#breakagetbody").append("<tr ><td >No active breakages for this ESOP.</td> </tr>");


        };

        $scope.deleteEsop = function (i) {
                obj = $scope.json[i];
                esopId = obj.esopId;
                $.ajax({
                        type: 'DELETE',
                        url: $rootScope.baseUrl + "/eSOPs/deleteEsopById/" + esopId,
                        success: function (msg) {
                                alert("ESOP Deleted: ");
                                location.reload();
                        },
                        error: function (msg) {
                                alert("ESOP Not Deleted: ");
                        }
                });

        };

        $scope.updateEsop = function (i) {
                obj = $scope.json[i];
                esopId = obj.esopId;
                location.href = "#/esop?operation=update&esopId=" + esopId;
        };


        $('#addButton').on('click', function (e) {


                //console.log("shalini ruined this");
                location.href = "#/esop?operation=add";
        });




        var url = $rootScope.baseUrl + "/eSOPs/getEsopsByEmployee/" + $rootScope.customerID + "/" + $rootScope.empID; //url for Spring API using global employee ID variale

        $.getJSON(url, function (json) {
                $scope.json = json;
                $("#esoptbody").html("");
                if (json != null && json.length > 0) {
                        for (var i in json) {
                                console.log(json[i]);

                                $scope.breakages = json[i].esopBreakageList;
                                //console.log($scope.breakages);
                                esop = json[i];
                                if (json[i].active == 1) {
                                        var comp = ("<tr >" +
                                                "<td >" + json[i].dateOffered + "</td>" +
                                                "<td >" + json[i].offeredStocks + "</td>" +
                                                "<td >" + json[i].priceOfStock + "</td>" +
                                                "<td >" + json[i].breakages + "</td>" +
                                                "<td >Yes</td>" +
                                                "<td>  <button  ng-click=\"showBreakages(" + i + ")\" class='btn btn-coviam' data-toggle='modal' data-target='#myModal'>View Breakages</button> </td>" +
                                                "<td> <div><button class='btn btn-coviam' ng-click=\"updateEsop(" + i + ")\" id='editButton'>Edit ESOP</button></div></td>" +
                                                "<td> <div><button class='btn btn-coviam' ng-click=\"deleteEsop(" + i + ")\"id='deleteButton'>Delete ESOP</button></div></td>       " +
                                                "</tr>");
                                        var temp = $compile(comp)($scope); //for assigning dynamic ng-click function
                                        $("#esoptbody").append(temp);
                                } else {
                                        var comp = ("<tr >" +
                                                "<td >" + json[i].dateOffered + "</td>" +
                                                "<td >" + json[i].offeredStocks + "</td>" +
                                                "<td >" + json[i].priceOfStock + "</td>" +
                                                "<td >" + json[i].breakages + " </td>" +
                                                "<td >No</td>" +
                                                "<td> <button  ng-click=\"showBreakages(" + i + ")\" class='btn btn-coviam' data-toggle='modal' data-target='#myModal'>View" + "Breakages</button> </td>" +
                                                "<td></td><td></td></tr>");
                                        var temp = $compile(comp)($scope); //for assigning dynamic ng-click function
                                        $("#esoptbody").append(temp);
                                }


                        }
                } else {
                        $("#esoptbody").append("<tr ><td></td><td></td>" +
                                "<td>No ESOPs for this employee.</td><td></td>" +
                                "</tr>");
                }

        });







});
   
