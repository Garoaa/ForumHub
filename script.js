const textArea = document.querySelector('.conteiner__secaoPrincipal__text-area');
const resposta = document.querySelector('.conteiner__secaoSecundaria__resposta');

function botaoCriptografar() {
    const stringCriptografada = criptografar(textArea.value);
    resposta.value = stringCriptografada;
    textArea.value = ''
    document.getElementById('resposta').removeAttribute('disabled');
}

function criptografar(stringCriptografada) {

    let matrizCodigo = [['e' , 'enter'] , ['i' , 'imes'] , ['a' , 'ai'] , ['o' , 'ober'] , ['u' , 'ufat']];
    stringCriptografada = stringCriptografada.toLowerCase();

    for(let i = 0; i < matrizCodigo.length; i++) {
        if(stringCriptografada.includes(matrizCodigo[i][0])){
            stringCriptografada = stringCriptografada.replaceAll(matrizCodigo[i][0], matrizCodigo[i][1]);
        }
    }
    return stringCriptografada
}

function botaoDescriptografar() {
    const stringDescriptada = descriptografar(textArea.value);
    resposta.value = stringDescriptada;
    textArea.value = '';
    document.getElementById('resposta').removeAttribute('disabled');
}

function descriptografar(stringDescriptada) {

    let matrizCodigoDes = [['enter' , 'e'] , ['imes' , 'i'] , ['ai' , 'a'] , ['ober' , 'o'] , ['ufat' , 'u']];
    stringDescriptada = stringDescriptada.toLowerCase();

    for(let j = 0; j < matrizCodigoDes.length; j++) {
        if(stringDescriptada.includes(matrizCodigoDes[j][0])){
            stringDescriptada = stringDescriptada.replaceAll(matrizCodigoDes[j][0], matrizCodigoDes[j][1]);
        }
    }
    return stringDescriptada
}