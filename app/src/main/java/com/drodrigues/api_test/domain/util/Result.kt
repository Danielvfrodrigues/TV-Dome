package com.drodrigues.tvdome.domain.util

internal sealed class Result<out A> {

    // TODO Implement Exception Handle

    internal data class Success<A>(
        val value: A
    ) : Result<A>()

    internal data class Failure(
        val throwable: Throwable? = null
    ) : Result<Nothing>()

}
