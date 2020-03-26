export namespace simpleFactoryExample {
  
  export class User {
    constructor(private _username: string, private _age: number) {}
    public get username(): string { return this._username }
    public get age(): number { return this._age }
  }

  abstract class UserFactory {
    public static create(username: string, age: number): User {
      return new User(username, age)
    }
  }

  const user: User = UserFactory.create('thalysonalexr', 23)
  console.log(user)
}