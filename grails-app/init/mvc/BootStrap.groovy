package mvc

import edu.fhnw.webec.socrativelight.Answer
import edu.fhnw.webec.socrativelight.Question
import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        if (Environment.current == Environment.PRODUCTION) {
            return
        }

        Room windowRoom = save(new Room(name: "1.333", max: 32))
        Room cornerRoom = save(new Room(name: "1.331", max: 42))

        Person dierk = save(new Person(firstName: "Dierk", lastName: "König", email:"dierk.koenig@fhnw.ch"))

        Date today = new Date().clearTime();
        save(new Booking(booker: dierk, room: windowRoom, date: today - 1, slot: Booking.AM))
        save(new Booking(booker: dierk, room: windowRoom, date: today,     slot: Booking.AM))
        save(new Booking(booker: dierk, room: windowRoom, date: today + 1, slot: Booking.AM))
        save(new Booking(booker: dierk, room: cornerRoom, date: today ,    slot: Booking.AM))

        Question q1 = new Question(text: "Is this the real life?")
        q1.save()

        save(new Answer(text: "this is just fantasy",question: q1, isCorrect: true))
        save(new Answer(text: "caught in a landslide",question: q1))
        save(new Answer(text: "escape from reality",question: q1))
    }

    static save(domainObject) {
        domainObject.save(failOnError: true)
    }

    def destroy = {
    }
}
