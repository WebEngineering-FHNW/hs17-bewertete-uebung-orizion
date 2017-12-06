package edu.fhnw.webec.socrativelight

class Answer {
    Question question
    String text

    static belongsTo = [question: Question]

    static constraints = {
    }
}
