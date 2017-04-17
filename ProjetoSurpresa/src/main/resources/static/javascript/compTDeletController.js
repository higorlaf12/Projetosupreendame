app.controller("compTDeletController", function( $scope, $window, $http){

    $scope.savings = new Array();

    $scope.init = function(){

        var resultado = $http.get("/saving/consultarTodos");

        resultado.success(function(data, status, headers, config){

            $scope.savings = data;
            console.log(data);

        });
        resultado.error(function(data, status, headers, config){

            $window.alert(data);

        });

    }

    $scope.removerDados = function(id){

            var resultado = $http.delete("/saving/removerDados/" + id);

            resultado.success(function(data, status, headers, config,location){

                $scope.init();
                $window.alert("removido com suceso");
                $window.location.href="/compT.html";

            });

            resultado.error(function(data, status, headers, config){

                $window.alert(data);
            });


        }



    $scope.editarDados = function(id){

        $window.location.href = "/saving/editarDados.html/" + id;
    }
});