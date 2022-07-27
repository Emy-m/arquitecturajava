const params = new URLSearchParams(window.location.search)
const category = params.get("categoria")
const selected = document.getElementById("categoria")

function filtrar() {
    if (!params.has("categoria") && selected.value != 'seleccionar') {
        window.location.href = "MostrarLibros?categoria=" + selected.value
    } else if (params.has("categoria") && selected.value != category && selected.value != "seleccionar") {
        window.location.href = "MostrarLibros?categoria=" + selected.value
    } else if (params.has("categoria") && selected.value == "seleccionar") {
        window.location.href = "MostrarLibros"
    }
}

