// use to encrypt password
import bcrypt from 'bcryptjs'

export namespace valueObjectExample {
  interface ValueObject {
    toString(): string
  }

  // value objects
  class Email implements ValueObject {
    private _value: string
    readonly mask: RegExp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/

    constructor(value: string) {
      if (!this.mask.test(String(value).toLowerCase())) {
        throw new Error(`The e-mail "${value}" format is invalid.`)
      }
      this._value = value.toLowerCase()
    }

    public toString(): string {
      return this._value
    }
  }

  class Password implements ValueObject {
    private _value: string

    // rules to value in domain
    constructor(value: string) {
      if (value.length < 5 || value.length > 12) {
        throw new Error(`The password "${value}" is invalid.`)
      }
      this._value = bcrypt.hashSync(value, 10)
    }

    public toString = () : string => {
      return this._value
    }
  }

  // entity
  class UserEntity {
    constructor(private _email: Email, private _password: Password) {}
    
    public get email(): string {
      return this._email.toString()
    }

    public get password(): string {
      return this._password.toString()
    }
  }

  // const email: Email = new Email('tha.motoggmail.com') // error
  // const passw: Password = new Password('Hell') // error
  const email: Email = new Email('THA.motog@gmail.com') // ok
  const passw: Password = new Password('HelloWorld!') // ok
  
  const user: UserEntity = new UserEntity(email, passw)

  console.log(user.email)
  console.log(user.password)

  // The 'value objects' equality are not based on their identity... Two value objects are equals if they have the same value(s) and not if they are the same object.
  const nativeEmail = { toString: (): string => 'tha.motog@gmail.com' }
  console.log(`${email}` === `${nativeEmail}`) // true, is equals
}
