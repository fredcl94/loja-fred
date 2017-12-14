

$(document).ready(function () {
    $('#tab-produto').Tabledit({
        url: './produtodevenda',
        columns: {
            identifier: [0, 'id'],
            editable: [[1, 'nome'], [2, 'descricao'], [3, 'valor'], [4, 'quantidade'], [5, 'marca'], [6, 'categoria']]
        },
        onDraw: function () {
            console.log('onDraw()');
        },
        onSuccess: function (data, textStatus, jqXHR) {
            console.log('onSuccess(data, textStatus, jqXHR)');
            console.log(data);
            console.log(textStatus);
            console.log(jqXHR);
        },
        onFail: function (jqXHR, textStatus, errorThrown) {
            console.log('onFail(jqXHR, textStatus, errorThrown)');
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        },
        onAlways: function () {
            console.log('onAlways()');
        }
    });
     $("#file").val('');
});


function abreGerenciadorFotos(id) {
    $("#file").val('');
    $("#idProduto-modal").val(id);
    $("#janelaFotos").modal();

}