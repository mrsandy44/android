package com.x8bit.bitwarden.data.platform.provider

import com.bitwarden.data.repository.util.baseApiUrl
import com.bitwarden.data.repository.util.baseEventsUrl
import com.bitwarden.data.repository.util.baseIdentityUrl
import com.x8bit.bitwarden.data.platform.util.toEnvironmentOrDefault
import com.bitwarden.network.interceptor.BaseUrlsProvider
import com.x8bit.bitwarden.data.platform.datasource.disk.EnvironmentDiskSource

/**
 * The default implementation of [BaseUrlsProvider].
 */
class BaseUrlsProviderImpl(
    private val environmentDiskSource: EnvironmentDiskSource,
) : BaseUrlsProvider {

    override fun getBaseApiUrl(): String = environmentDiskSource
        .preAuthEnvironmentUrlData
        .toEnvironmentOrDefault()
        .baseApiUrl

    override fun getBaseIdentityUrl(): String = environmentDiskSource
        .preAuthEnvironmentUrlData
        .toEnvironmentOrDefault()
        .baseIdentityUrl

    override fun getBaseEventsUrl(): String = environmentDiskSource
        .preAuthEnvironmentUrlData
        .toEnvironmentOrDefault()
        .baseEventsUrl

    override fun getBaseFillAssistUrl(): String? = environmentDiskSource.fillAssistRulesUrl
}
