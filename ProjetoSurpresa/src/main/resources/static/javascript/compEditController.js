app.controller("compEditController",function ($scope,$window,$http){



    $scope.init = function(){

        var result = $http.get("/consultarPorId/{id}");

        result.success(function(data, status, headers, config){

            $scope.savings = data;

        });
        result.error(function(data, status, headers, config){

            $window.alert(data);

        });

    }

    $scope.removerDados = function(id){

        if($window.confirm("Deseja realmente excluir essa pessoa?")){

            var result = $http.delete("removerDados/" + id);

            result.success(function(data, status, headers, config){

                $scope.init();


            });

            result.error(function(data, status, headers, config){

                $window.alert(data);
            });


        }

    }

        $scope.editarDados = function(index) {

            var savingModel = new Object();

            savingModel.id = $scope.savings[index].id;
            savingModel.descricao = $scope.descricao;
            savingModel.produto = $scope.produto;
            savingModel.datas = $scope.datas;


            var resultdoModel = $http.post("/saving/editarDados", savingModel);

            resultdoModel.success(function (data, status, headers, config,location) {

                if (data.codigo == 1) {

                    $window.alert(data.mensagem);
                    $window.location.href="/compT.html";


                }
                else {

                    $window.alert(data.mensagem);
                }
            });
            resultdoModel.error(function (data, status, headers, config) {

                $window.alert(data);
            });
        }
});