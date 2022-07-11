package com.github.haseoo.bmms.util

import java.util.*

fun <T> Optional<T>.unwrap(): T? = orElse(null)