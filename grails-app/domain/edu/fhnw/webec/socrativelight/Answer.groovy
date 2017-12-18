package edu.fhnw.webec.socrativelight

class Answer {
    Question question
    String text
    Boolean isCorrect = false;

    static belongsTo = [question: Question]

    static constraints = {
        question blank:false
        text blank: false
    }

    @Override
    String toString() {
        return "Question: ${question.id} the text is '${text}' and: ${isCorrect}"
    }
}
