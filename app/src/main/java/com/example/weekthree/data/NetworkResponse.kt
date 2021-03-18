package com.example.weekthree.data

sealed class NetworkResponse<T> {

    data class Success<T>(val data: T): NetworkResponse<T>()
    data class Error<T>(val error: Throwable): NetworkResponse<T>()
    class Loading<T>: NetworkResponse<T>()
}