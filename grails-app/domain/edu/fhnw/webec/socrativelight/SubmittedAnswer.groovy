package edu.fhnw.webec.socrativelight

/**
 * For every answer selected as a possible answer,
 * a SubmittedAnswer is created
 */
class SubmittedAnswer {
    Question question
    Answer answer

    //Associates teacher answer pairs to an id which tells the system
    //that they were submitted together with other teacher answer pairs.
    //Needed to group questions with multiple correct answers
    Integer submissionId


    static constraints = {
        submissionId min: 1,blank: false
        question blank: false
        answer blank: false
    }

    @Override
    String toString() {
        return "Q: " + question.id + " A: " + answer.id +" Sub: " + submissionId
    }
}
