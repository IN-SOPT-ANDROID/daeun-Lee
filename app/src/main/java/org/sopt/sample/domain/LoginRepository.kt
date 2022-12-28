package org.sopt.sample.domain

interface LoginRepository {
    suspend fun login(email: String, password: String) : Boolean
}