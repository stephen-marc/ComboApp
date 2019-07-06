package de.combo.app.thread.provider

import android.content.Context
import androidx.annotation.StringRes
import domain.provider.ResourceProvider

class AndroidResourceProvider(private val context: Context) :
    ResourceProvider {
    override fun readAssetIntoString(assetName: String): String {
        context.resources.assets.open(assetName).bufferedReader().use {
            return it.readText()
        }
    }

    override fun getString(@StringRes resInt: Int): String {
        return context.getString(resInt)
    }
}
