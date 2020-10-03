package associate

import kotlin.reflect.KClass
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

val requestClass: KClass<ProfileRegistrationRequest> = ProfileRegistrationRequest::class

val request = ProfileRegistrationRequest(
    name = "田中太郎",
    age = 18
)

// propertyCollectionには次の配列が入っている -> [val associate.ProfileRegistrationRequest.age: kotlin.Int, val associate.ProfileRegistrationRequest.name: kotlin.String]
val propertyCollection: Collection<KProperty1<ProfileRegistrationRequest, *>> = requestClass.memberProperties

val properties: Map<String, Any> = propertyCollection.associate {
    val key: String = it.name
    val value = it.get(request) ?: throw IllegalStateException("properties does not has key. [key: $key]")
    it.name to value
}

fun main() {
    println(propertyCollection)
    println(properties)
}
