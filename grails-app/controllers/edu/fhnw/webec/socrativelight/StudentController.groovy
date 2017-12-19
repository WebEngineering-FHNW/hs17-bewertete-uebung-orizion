package edu.fhnw.webec.socrativelight

import grails.transaction.Transactional

class StudentController {

    def index() { }

    /**
     * Show a single question to the user
     * @param question
     * @return
     */
    def show(Question question) {
        render view: "show", model: [question: question]
    }

    /**
     * Saves a students selected answers
     */
    @Transactional
    def submit_answers() {
        if(Question.exists(params.question_id)){
            def question = Question.get(params.question_id)
            List<String> answer_ids = params.list("answer_ids")
            def newId = 1;
            if(SubmittedAnswer.count() > 0) {
                newId = SubmittedAnswer.last().submissionId + 1;
            }
            for(answerId in answer_ids) {
                def answer = Answer.get(answerId)
                println(question)
                def a = new SubmittedAnswer(question: question, answer: answer,submissionId: newId)
                a.save(flush:true, failOnError: true)
                println(a)
            }
        }
        redirect (controller: "teacher", action: "showresults")
    }
}
