package eventapp

// Minimal multi-event console app (Facade-style in main).
fun main() {
    val events = mutableListOf(
        Event("Postmodern Doom", 100),
        Event("Indie Night", 50),
        Event("Jazz Evening", 0)
    )

    var running = true
    while (running) {
        println()
        println("=== Event Management ===")
        println("1) List events")
        println("2) Book tickets for an event")
        println("3) Add a new event")
        println("4) Quit")
        print("Select option: ")

        when (readln().trim()) {
            "1" -> {
                if (events.isEmpty()) {
                    println("No events available.")
                } else {
                    println("Index\tName\tTickets")
                    events.forEachIndexed { index, event ->
                        // Use toString() for name, but keep output simple and stable
                        // (Event.toString() is optional; tickets are always available via getTickets()).
                        println("$index\t$event\t${event.getTickets()}")
                    }
                }
            }

            "2" -> {
                if (events.isEmpty()) {
                    println("No events available to book.")
                    continue
                }

                print("Enter event index: ")
                val index = readln().trim().toIntOrNull()
                if (index == null || index !in events.indices) {
                    println("Invalid index.")
                    continue
                }

                print("Enter number of tickets to book: ")
                val amount = readln().trim().toIntOrNull()
                if (amount == null) {
                    println("Invalid amount. Please enter a whole number.")
                    continue
                }

                val success = events[index].book(amount)
                if (success) {
                    println("Booking successful.")
                } else {
                    println("Booking failed (invalid amount or insufficient tickets).")
                }
            }

            "3" -> {
                print("Enter event name: ")
                val name = readln()
                if (name.isBlank()) {
                    println("Event name cannot be blank.")
                    continue
                }

                print("Enter number of tickets: ")
                val tickets = readln().trim().toIntOrNull()
                if (tickets == null || tickets < 0) {
                    println("Tickets must be a whole number and >= 0.")
                    continue
                }

                events.add(Event(name.trim(), tickets))
                println("Event added successfully.")
            }

            "4" -> {
                running = false
                println("Goodbye.")
            }

            else -> println("Invalid choice.")
        }
    }
}
