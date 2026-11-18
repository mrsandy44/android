package com.x8bit.bitwarden.data.platform.util

import com.bitwarden.data.datasource.disk.model.EnvironmentUrlDataJson
import com.bitwarden.data.repository.model.Environment
import com.bitwarden.data.repository.util.toEnvironmentUrls

/**
 * Сервер, к которому привязана эта сборка.
 */
const val LOCKED_BASE_URL: String = "https://mrsandy.duckdns.org:8443"

/**
 * Окружение по умолчанию: self-hosted, без облачных вариантов.
 */
val LOCKED_ENVIRONMENT: Environment =
    Environment.SelfHosted(EnvironmentUrlDataJson(base = LOCKED_BASE_URL))

/**
 * Возвращает сохранённое окружение либо наш сервер, никогда — облако Bitwarden.
 */
fun EnvironmentUrlDataJson?.toEnvironmentOrDefault(): Environment =
    this?.toEnvironmentUrls() ?: LOCKED_ENVIRONMENT
