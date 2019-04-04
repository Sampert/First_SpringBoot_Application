
function salvarNome(){
    var nome = document.getElementById("input_name").value;
    window.location = "/funcionario/" + nome;
}