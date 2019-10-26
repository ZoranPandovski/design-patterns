interface Reclamo{
    producto: string
    monto: number
}

abstract class EmpleadoTienda{
    sucesor: EmpleadoTienda
    agregarSucesor(empleado: EmpleadoTienda){
        this.sucesor = empleado
    }
    abstract resolverReclamo(reclamo: Reclamo)
}
class Vendedor extends EmpleadoTienda{
    resolverReclamo(reclamo: Reclamo) {
        if(reclamo.monto < 300){
            console.log("El vendedor relolvio el reclamo")
        } else {
            this.sucesor.resolverReclamo(reclamo)
        }
    }
    
}
class Supervisor extends EmpleadoTienda{
    resolverReclamo(reclamo: Reclamo) {
        if(reclamo.monto < 500){
            console.log("El supervisor relolvio el reclamo")
        } else {
            this.sucesor.resolverReclamo(reclamo)
        }
    }

}
class Gerente extends EmpleadoTienda{
    resolverReclamo(reclamo: Reclamo) {
        console.log("El gerente relolvio el reclamo")
    }

}

let chain = () => {
    let vendedor: EmpleadoTienda = new Vendedor()
    let supervisor: EmpleadoTienda = new Supervisor()
    let gerente: EmpleadoTienda = new Gerente()

    vendedor.agregarSucesor(supervisor)
    supervisor.agregarSucesor(gerente)

    let reclamo: Reclamo = {
        producto: "Zapatilla",
        monto: 300
    }

    vendedor.resolverReclamo(reclamo)
}

chain()