package domain.mapper

/**
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer data source layers
 *
 * @param <DOMAIN> the cached model input type
 * @param <DOMAIN> the remote model input type
 * @param <ENTITY> the model return type
 */
interface EntityMapper<DOMAIN, ENTITY> {

    fun mapToEntity(type: DOMAIN): ENTITY

    fun mapFromEntity(type: ENTITY): DOMAIN
}
