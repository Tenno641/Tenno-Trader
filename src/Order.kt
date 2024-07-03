data class Order (
    val creation_date: String,
    val id: String,
    val last_update: String,
    val mod_rank: Int,
    val order_type: String,
    val platform: String,
    val platinum: Int,
    val quantity: Int,
    val region: String,
    val user: User,
    val visible: Boolean
) : Comparable<Order> {
    override fun compareTo(other: Order): Int {
        return other.platinum - this.platinum
    }

}