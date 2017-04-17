app.controller("compTSalvaController", function ($scope,$window,$http){

    $scope.id = null;
    $scope.descricao = null;
    $scope.produto = null;
    $scope.datas;

    $scope.salvarDados = function () {

        var savingModel = new Object();

        savingModel.id = $scope.id;
        savingModel.descricao= $scope.descricao;
        savingModel.produto= $scope.produto;
        savingModel.datas= $scope.datas;


        var resultModel = $http.post("/saving/salvarDados", savingModel);

            resultModel.success(function(data,status,headers,config,location){

                if(data.codigo == 1){

                    $window.alert(data.mensagem);
                    $window.location.href="/compT.html";
                    $scope.id=null;
                    $scope.descricao = null;
                    $scope.produto = null;
                    $scope.datas;

                }
                else{
                    $window.alert(data.mensagem);
                }
            });
            resultModel.error(function (data,status,headers,config) {
                $window.alert(data.mensagem);

            });
    };

});
