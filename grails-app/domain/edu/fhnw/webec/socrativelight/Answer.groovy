package edu.fhnw.webec.socrativelight

class Answer {
    Question question
    String text
    Boolean isCorrect = false;

    static belongsTo = [question: Question]

    static constraints = {
        question
        text blank: false, minSize: 10
    }

    @Override
    String toString() {
        return "Question: ${question.id} the text is '${text}' and: ${isCorrect}"
    }
}
