interface Repository<T, IDTYPE> {
    fun add(entity: T)
    fun remove(id: IDTYPE)
    fun getAll(): List<T>
    fun getById(id: IDTYPE): T?
}

data class User(val username: String, val password: String)

class UserRepository : Repository<User, String> {
    val users = mutableMapOf<String, User>()

    override fun add(entity: User) { users[entity.username] = entity }
    override fun remove(id: String) { users.remove(id) }
    override fun getAll(): List<User> = users.values.toList()
    override fun getById(id: String): User? = users[id]
}

val repository = UserRepository()

repository.add(User("user1", "pass"))
repository.add(User("user2", "pass"))
repository.add(User("user3", "pass"))
repository.add(User("user4", "pass"))

println("get by id user2: ${repository.getById("user2")}")

println("All users before remove: ${repository.getAll()}")
repository.remove("user3")
println("All users after remove user 3: ${repository.getAll()}")