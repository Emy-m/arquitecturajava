function validacion() {
    const form = document.getElementById("form");
    if (form && form.isbn.value == "") alert("datos no validos");
    else form.submit();
}