let paint = (name: string, lastname: string) => {
    return `{name: '${name}', lastname: '${lastname}'}`
}

let decorativeFunction = (f: Function, name: string, lastname: string) => {
    let alreadyDecorated = () => {
        let ans = f(name, lastname)
        return ans.toUpperCase()
    }
    return alreadyDecorated
}
let decoratedFunction = decorativeFunction(paint, "Bruno", "Cardenas")
console.log(decoratedFunction())