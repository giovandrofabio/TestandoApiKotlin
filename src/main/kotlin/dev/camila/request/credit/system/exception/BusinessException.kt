package dev.camila.request.credit.system.exception

data class BusinessException(override val message: String?) : RuntimeException(message)