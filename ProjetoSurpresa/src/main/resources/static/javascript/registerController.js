var registerControllerApp = angular.module("registerControllerApp", []);

registerControllerApp.controller("registerController", function($scope, $window, $http){

    $scope.login = null;
    $scope.senha = null;


    $scope.savePerson = function(){

        var txtsenha = document.getElementById("txtsenha"),txtrepitirsenha = document.getElementById("txtrepitirsenha");

            if(txtsenha.value != txtrepitirsenha.value) {
                $window.alert("Senhas diferentes!");
            } else
                {
        var registerPersonModel = new Object();


        registerPersonModel.login = $scope.login;
        registerPersonModel.senha = $scope.senha;

        var resultModel = $http.post("savePerson", registerPersonModel);

        resultModel.success(function(data, status, headers, config){


                    if (data.codigo == 1) {

                        $window.alert(data.mensagem);

                        $scope.login = null;
                        $scope.senha = null;

                        $window.location.href="/person/register.html";

                    }
                    else {

                        $window.alert(data.mensagem);

                    }
                });

        resultModel.error(function(data, status, headers, config){

            $window.alert(data.mensagem);

        });
            }
    };

    $scope.logar = function () {

        var login = $scope.login;
        console.log(login);
        var senha = $scope.senha;

        var RegiterPersonModel = $http.get("person/validar/"+login );

        RegiterPersonModel.success(function (data) {
            if(data.senha == senha){
                $window.alert("Senha correta");
                $window.location.href="/compT.html";
            }else if(data.senha != null){

            }
            else{
                $window.alert("Senha errada");
                $window.location.href="#";
            }
        });
        RegiterPersonModel.error(function(data, status, headers, config) {

            $window.alert("Senha incorreta");
            $window.location.href="#";
        });

    }

});