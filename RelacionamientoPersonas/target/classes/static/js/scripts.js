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
    cambiarUrl("delegaciones")
})

document.getElementById("navActualizarDatos").addEventListener("click", (e) => {
    e.preventDefault() // Evitamos que el <form> cambie la URL
    cambiarUrl("delegaciones")
})

document.getElementById("navNuevaDelegacion").addEventListener("click", (e) => {
    e.preventDefault() // Evitamos que el <form> cambie la URL
    cambiarUrl("delegaciones")
})
document.getElementById("navMisDelegacionesAceptadas").addEventListener("click", (e) => {
    e.preventDefault() // Evitamos que el <form> cambie la URL
    cambiarUrl("delegaciones")
})

document.getElementById("navMisDelegacionesParaMi").addEventListener("click", (e) => {
    e.preventDefault() // Evitamos que el <form> cambie la URL
    cambiarUrl("delegaciones")
})
document.getElementById("navMisDelegacionesParaMiPendientes").addEventListener("click", (e) => {
    e.preventDefault() // Evitamos que el <form> cambie la URL
    cambiarUrl("delegaciones")
})
