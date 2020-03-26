export namespace callbackExample {
  export const sum = (...numbers: number[]) => numbers.reduce((x, y) => x + y)
  export const sub = (...numbers: number[]) => numbers.reduce((x, y) => x - y)
  
  function calc12345(name: string, op: CallableFunction): void {
    console.log(`Hello ${name}!`)
    console.log(`Calc ${op.toString()} = ${op(1, 2, 3, 4, 5)}`)
  }

  calc12345('Mike', sum)
  calc12345('John', sub)
}
