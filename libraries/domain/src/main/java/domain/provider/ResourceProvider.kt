package domain.provider

interface ResourceProvider {

    fun readAssetIntoString(assetName: String): String
    fun getString(resInt: Int): String
}
