package eventapp

// Minimal Event class
class Event(private val name: String, private var tickets: Int = 100) {

    fun book(amount: Int): Boolean {
        if (tickets < amount || amount <= 0) {
            return false
        }
        tickets -= amount
        return true
    }

    fun getTickets(): Int {
        return tickets
    }

    override fun toString(): String {
        return "Event(name='$name', tickets=$tickets)"
    }
}
