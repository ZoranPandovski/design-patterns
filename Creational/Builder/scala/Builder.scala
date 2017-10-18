// case class are Immutable
// all parameters need to be specified at instantiation
case class TokenResponse(access_token: String,
                         token_type: String,
                         refresh_token: String,
                         expires_in: Long,
                         id_token: String) {
}


// define the builder
// val in params of constructor are mandatory fields
class TokenResponseBuilder(val access_token: String, val token_type: String) {
  var refresh_token: String = _
  var expires_in: Long = _
  var id_token: String = _

  def refresh_token(refresh_token: String): TokenResponseBuilder = {
    this.refresh_token = refresh_token
    this
  }

  def expires_in(expires_in: Long): TokenResponseBuilder = {
    this.expires_in = expires_in
    this
  }

  def id_token(id_token: String): TokenResponseBuilder = {
    this.id_token = id_token
    this
  }

  def build: TokenResponse = new TokenResponse(access_token, token_type, refresh_token, expires_in, id_token)
}


// use this builder
object Main extends App {
  Console.println(
    new TokenResponseBuilder("ACCESS_TOKEN", "TOKEN_TYPE")
      .refresh_token("REFRESH_TOKEN")
      .expires_in(3600)
      .id_token("ID_TOKEN")
      .build
  )
}
