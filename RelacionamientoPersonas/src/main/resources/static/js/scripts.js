const ID_SESION = "idSesion"

const obtenerSesion = () => localStorage.getItem(ID_SESION)

const cambiarUrl = (url = "/") => {
    const idSesion = obtenerSesion()

    if (!idSesion) {
        window.location = "/login"
    } else {
        window.location = `/${url}?sesion=${idSesion}`
    }
}

document.getElementById("navActualizarDatos").addEventListener("click", (e) => {
    e.preventDefault() // Evitamos que el <form> cambie la URL
    cambiarUrl("misDatos/personas")
})

document.getElementById("navNuevaDelegacion").addEventListener("click", (e) => {
    e.preventDefault() // Evitamos que el <form> cambie la URL
    cambiarUrl("delegaciones/nueva")
})

document.getElementById("navMisDelegacionesAceptadas").addEventListener("click", (e) => {
    e.preventDefault() // Evitamos que el <form> cambie la URL
    cambiarUrl("delegacionesAceptadas")
    //delegacion -> mis delegaciones aceptadas
})

document.getElementById("navMisDelegacionesParaMi").addEventListener("click", (e) => {
    e.preventDefault() // Evitamos que el <form> cambie la URL
    cambiarUrl("delegacionesMias")
    //delegacion -> mis delegaciones para mi aceptadas
})

document.getElementById("navMisDelegacionesPendientes").addEventListener("click", (e) => {
    e.preventDefault() // Evitamos que el <form> cambie la URL
    cambiarUrl("delegacionesPendientes")
})

document.getElementById("navMisDelegacionesParaMiPendientes").addEventListener("click", (e) => {
    e.preventDefault() // Evitamos que el <form> cambie la URL
    cambiarUrl("delegacionesMiasPendientes")
})
