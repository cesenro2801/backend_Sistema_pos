function loadData() {
    let request = sendRequest('/productos/list', 'GET', '');
    let table = document.getElementById('producto-table');
    table.innerHTML = "";
    
    request.onload = function() {
        let data = request.response;
        console.log(data);
        
        data.forEach((element, indice) => {
            table.innerHTML += `
            <tr>
                <td>${element.identificacion}</td>
                <td>${element.descripcion}</td>
                <td>${element.existencias}</td>
                <td>${element.stock_minimo}</td>
                <td>${element.codigobarras}</td>
                <td>${element.codigo_interno}</td>
                <td>${element.precioventa}</td>
                <td>${element.preciocompra}</td>
                <td>${element.id_categoria}</td>
                <td>
                    <button type="button" class="btn btn-primary" 
                    onclick='window.location = "form_productos.html?idproducto=${element.identificacion}"'>
                        Ver
                    </button>
                </td>
            </tr>
            `;
        });
    }
    
    request.onerror = function() {
        table.innerHTML = `
        <tr>
            <td colspan="5">Error al recuperar los datos.</td>
        </tr>
        `;
    }
}

function loadProductos(idproducto){
    let request = sendRequest('/productos/list/'+idproducto, 'GET', '');
    let id = document.getElementById('producto-id').value;
    let descripcion = document.getElementById('producto-descripcion').value;
    let existencias = document.getElementById('producto-existencias').value;
    let stockMinimo = document.getElementById('producto-stock-minimo').value;
    let codigoBarras = document.getElementById('producto-codigo-de-barras').value;
    let codigoInterno = document.getElementById('producto-codigo-interno').value;
    let precioVenta = document.getElementById('producto-precio-venta').value;
    let precioCompra = document.getElementById('producto-precio-compra').value;
    let idCategoria = document.getElementById('producto-id-categoria').value;

    request.onload = function(){
        let data = request.response;
        console.log(data);
        id.value=data.identificacion;
        descripcion.value=data.descripcion;
        existencias.value=data.existencias;
        stockMinimo.value=data.stock_minimo;
        codigoBarras.value=data.codigo_barras;
        codigoInterno.value=data.codigo_interno;
        precioVenta.value=data.precioventa;
        precioCompra.value=data.preciocompra;
        idCategoria.value=data.id_categoria;

    }

    request.onerror = function(){
        alert("Error al recuperar datos");
    }
}

function saveProducto(){
    let id = document.getElementById('producto-id').value;
    let descripcion = document.getElementById('producto-descripcion').value;
    let existencias = document.getElementById('producto-existencias').value;
    let stockMinimo = document.getElementById('producto-stock-minimo').value;
    let codigoBarras = document.getElementById('producto-codigo-de-barras').value;
    let codigoInterno = document.getElementById('producto-codigo-interno').value;
    let precioVenta = document.getElementById('producto-precio-venta').value;
    let precioCompra = document.getElementById('producto-precio-compra').value;
    let idCategoria = document.getElementById('producto-id-categoria').value;
    
    let data = {
        'id': id,
        'descripcion': descripcion,
        'existencias': existencias,
        'stock_minimo': stockMinimo,
        'codigobarras': codigoBarras,
        'codigo_interno': codigoInterno,
        'precioventa': precioVenta,
        'preciocompra': precioCompra,
        'id_categoria': idCategoria
    };
    
    console.log(data);
    let request = sendRequest('/productos/', id ? 'PUT' : 'POST', data)
    request.onload = function(){
        alert('Producto Creado o actualizado Exitosamente.')
        window.location = 'productos.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios.')
    }
}

function deleteProducto(){
    let id = document.getElementById('producto-id').value
    let request = sendRequest('/productos/'+ id , 'DELETE', '')
    request.onload = function(){
        alert('Registro Eliminado Exitosamente.')
        window.location = 'productos.html';
    }
    request.onerror = function(){
        alert('Error al guardar los cambios.')
    }
}