package br.com.library.data.vo
import jakarta.persistence.*
import java.util.ArrayList
import java.util.Date


class UserVO (
    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var email: String = ""
)