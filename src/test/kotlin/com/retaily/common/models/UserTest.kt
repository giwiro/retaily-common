package com.retaily.common.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UserTest {
    @Test
    fun createUser() {
        val id = 123L
        val firstName = "TestFirstName"
        val lastName = "TestLastName"
        val email = "test@test.com"
        val user = User(id, firstName, lastName, email)
        assertEquals(user.id, id)
        assertEquals(user.firstName, firstName)
        assertEquals(user.lastName, lastName)
        assertEquals(user.email, email)
    }
}