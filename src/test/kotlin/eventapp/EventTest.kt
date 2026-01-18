package eventapp

import org.junit.jupiter.api.Test
import kotlin.test.*

class EventTest {

    @Test
    fun testSellOneTicketSuccess() {
        val e = Event("Postmodern Doom", 100)
        assertTrue(e.book(1))
    }

    @Test
    fun testSellOneTicketReducesStock() {
        val e = Event("Postmodern Doom", 100)
        e.book(1)
        assertEquals(99, e.getTickets())
    }

    @Test
    fun testSellOneTicketNoAvailability() {
        val e = Event("Postmodern Doom", 0)
        assertFalse(e.book(1))
    }

    @Test
    fun testSellOneTicketInvalidQuantity() {
        val e = Event("Postmodern Doom", 100)
        assertFalse(e.book(-1))
    }

    @Test
    fun testSellOneTicketNoAvailabilityDoesNotChangeStock() {
        val e = Event("Postmodern Doom", 0)
        e.book(1)
        assertEquals(0, e.getTickets())
    }

    @Test
    fun testSellOneTicketInvalidQuantityDoesNotChangeStock() {
        val e = Event("Postmodern Doom", 100)
        e.book(-1)
        assertEquals(100, e.getTickets())
    }

    @Test
    fun testSellTwoTicketsReducesStock() {
        val e = Event("Postmodern Doom", 100)
        e.book(2)
        assertEquals(98, e.getTickets())
    }
}
