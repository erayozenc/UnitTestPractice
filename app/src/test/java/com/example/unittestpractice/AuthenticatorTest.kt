package com.example.unittestpractice

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class AuthenticatorTest {

    /*
    Global değişken tanımlayıp da test yapabilirsin
     */

    //fonk isimleri CamelCase Uygun olması daha iyi, bu otomatik create yaptığından sanırım
    // ifAnyInput... yada if_any_input tarzız
    @Test
    fun `if any input is empty when register, returns false`() {
        val result1 = Authenticator.register("","Pitt","bradpitt@gmail.com","asd123","asd123")
        val result2 = Authenticator.register("Brad","","bradpitt@gmail.com","asd123","asd123")
        val result3 = Authenticator.register("Brad","Pitt","","asd123","asd123")
        val result4 = Authenticator.register("Brad","Pitt","bradpitt@gmail.com","","asd123")
        val result5 = Authenticator.register("Brad","Pitt","bradpitt@gmail.com","asd123","")
        val totalResult = result1 || result2 || result3 || result4 || result5
        assertThat(totalResult).isFalse()
    }

    @Test
    fun `if password doesn't contain at least 6 characters and both number and letter, returns false`() {
        val result = Authenticator.register("Brad","Pitt","bradpitt@gmail.com","123456","123456")
        val result2 = Authenticator.register("Brad","Pitt","bradpitt@gmail.com","asdasd","asdasd")
        val result3 = Authenticator.register("Brad","Pitt","bradpitt@gmail.com","asd12","asd12")
        val totalResult = result || result2 || result3
        assertThat(totalResult).isFalse()
    }

    @Test
    fun `if password and confirm password is not same, returns false`() {
        val result = Authenticator.register("Brad","Pitt","bradpitt@gmail.com","asd123","asd1234")
        assertThat(result).isFalse()
    }

    @Test
    fun `if e-mail is not proper when register, returns false`() {
        val result = Authenticator.register("Brad","Pitt","bradpitt","asd123","asd123")
        assertThat(result).isFalse()
    }

    @Test
    fun `if e-mail is already taken, returns false`() {
        // bradpitt@hotmail.com is already taken
        val result = Authenticator.register("Brad","Pitt","bradpitt@hotmail.com","asd123","asd123")
        assertThat(result).isFalse()
    }

    @Test
    fun `if all parameters is proper when register, returns true`() {
        val result = Authenticator.register("Brad","Pitt","bradpitt@gmail.com","asd123","asd123")
        assertThat(result).isTrue()
    }

    @Test
    fun `if any input is empty when login, returns false`() {
        val result1 = Authenticator.loginWithEmailAndPassword("","asd123")
        val result2 = Authenticator.loginWithEmailAndPassword("bradpitt@hotmail.com","")
        val totalResult = result1 || result2
        assertThat(totalResult).isFalse()
    }

    @Test
    fun `if e-mail is not proper when login, returns false`() {
        val result = Authenticator.loginWithEmailAndPassword("bradpitt","asd123")
        assertThat(result).isFalse()
    }

    @Test
    fun `if e-mail and password is not true, returns false`() {
        //proper account -> e-mail = bradpitt@hotmail.com password = asd123
        val result = Authenticator.loginWithEmailAndPassword("bradpitt@hotmail.com","asd1234")
        assertThat(result).isFalse()
    }

    @Test
    fun `if e-mail and password is true, returns true`() {
        //proper account -> e-mail = bradpitt@hotmail.com password = asd123
        val result = Authenticator.loginWithEmailAndPassword("bradpitt@hotmail.com","asd123")
        assertThat(result).isTrue()
    }

    @Test
    fun `if email is not proper or there is no account with this email when forget password, returns false`() {
        val result = Authenticator.forgetPassword("bradpitt")
        val result2 = Authenticator.forgetPassword("bradpitt@yahoo.com")
        assertThat(result).isEqualTo("ERROR")
        assertThat(result2).isEqualTo("ERROR")
    }

    @Test
    fun `if email is proper when forget password, returns false`() {
        val result = Authenticator.forgetPassword("bradpitt@hotmail.com")
        assertThat(result).isEqualTo("TOKEN")
    }

    @Test
    fun `if token is not proper when changing password, returns false`() {
        //proper token is "TOKEN"
        val result = Authenticator.changePassword("TOOOKEEEN")
        assertThat(result).isFalse()
    }

    @Test
    fun `if token is proper when changing password, returns false`() {
        //proper token is "TOKEN"
        val result = Authenticator.changePassword("TOKEN")
        assertThat(result).isTrue()
    }
}