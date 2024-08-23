let textoEntrada = document.querySelector('.conteiner__secaoPrincipal__text-area');

function criptografar() {
    textoEntrada = ['a' , 'e' , 'i' , 'o' , 'u'] ? textoEntrada : [];
    console.log(textoEntrada);
}

function mensagemCriptografada(){
    let texto = document.querySelector('textarea').value


}



function myFunction() {
    var x = document.getElementById('saida');
    if (x.style.display === 'none') {
      x.style.display = 'block';
    } else {
      x.style.display = 'none';
    }
  }