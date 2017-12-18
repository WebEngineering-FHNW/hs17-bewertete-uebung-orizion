package edu.fhnw.webec.socrativelight

class SubmittedAnswer {
    Question question
    Answer answer

    //Associates teacher answer pairs to an id which tells the system
    //that they were submitted together with other teacher answer pairs.
    //Needed to group questions with multiple correct answers
    Integer submissionId


    static constraints = {

    }

    @Override
    String toString() {
        return "Q: " + question.id + " A: " + answer.id +" Sub: " + submissionId
    }
}
