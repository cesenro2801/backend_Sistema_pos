function validarLogin() {
    var username = document.getElementById('icon_user').value;
    var password = document.getElementById('icon_pass').value;
    //    let mensajeError = document.getElementById('mensajeError');
    //    mensajeError.innerHTML = "";
    
    console.log(username);
    console.log(password);
    //    prompt("Una pausa por favor")
    
    let data = {'username': username, 'password': password};
    console.log(data);
    //    prompt("Una pausa por favor")
    
    let request = sendRequest('/usuarios/loginclient', 'POST', data);
    request.onload = function() {
        let data1 = request.response;
        console.log(data1);
        
        if(data1 == 1) {
            alert("Login Correcto");
            window.location = 'menu.html';
        } else {
            alert('Alerta:Usuario o Password incorrectos.');
        }
    };
    
    request.onerror = function() {
        alert("Error al recuperar los datos.");
    };
}