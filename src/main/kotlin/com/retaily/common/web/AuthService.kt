package com.retaily.common.web

import com.retaily.common.models.User
import javax.servlet.http.HttpSession
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SessionService(@Autowired val session: HttpSession) {
    fun startSession(user: User, userId: Long) {
        session.setAttribute("userId", userId)
        session.setAttribute("user", user)
    }

    fun getUserId(): Long? {
        val userIdStr = session.getAttribute("userId")
        if (userIdStr != null) {
            return userIdStr.toString().toLong()
        }
        return null
    }

    fun finishSession() {
        session.invalidate()
    }
}
