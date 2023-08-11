var btnLimapar = document.getElementById("btn-limpar");
var formLivro = document.getElementById("formlivro").elements

btnLimapar.addEventListener("click", function() {
	for(var index = 0 ; index < formLivro.length ; index++){
		formLivro[index].value = null;
	}
	
	
})
