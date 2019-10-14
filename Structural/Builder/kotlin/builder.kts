class User private constructor(
        val username: String?,
        val password: String?,
        val birthday: Date?) {

    data class Builder(
            var username: String? = null,
            var password: String? = null,
            var birthday: Date? = null) {

        fun username(username: String) = apply { this.username = username }
        fun password(password: String) = apply { this.password = password }
        fun birthday(birthday: Date) = apply { this.birthday = birthday }
        fun build() = User(username, password, birthday)
    }
}

val adminUser = User.Builder()
        .username("admin")
        .password("strictAdm!nP@ssword")
        .birthday(Date(1990, 1, 1))
        .build()