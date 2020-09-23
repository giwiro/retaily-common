package com.retaily.common.web

import com.retaily.common.mock.MockHttpSession
import com.retaily.common.models.User
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SessionServiceTest() {
    private var httpSession = MockHttpSession()
    private var sessionService = SessionService(httpSession)

    @BeforeEach
    fun init() {
        httpSession = MockHttpSession()
        sessionService = SessionService(httpSession)
    }

    @Test
    fun startSessionTest() {
        val userId = 123123123L
        val user = User(userId, "Sample", "User", "sample@user.com")
        sessionService.startSession(user, userId)
        assertEquals(httpSession.getMap()["userId"], userId)
        assertEquals(httpSession.getMap()["user"], user)
    }

    @Test
    fun getUserIdSuccessTest() {
        val userId = 456456456L
        httpSession.setMap(hashMapOf("userId" to userId))
        assertEquals(sessionService.getUserId(), userId)
    }

    @Test
    fun getUserIdFailTest() {
        assertEquals(sessionService.getUserId(), null)
    }
}
