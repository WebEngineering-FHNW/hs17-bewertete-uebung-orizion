package edu.fhnw.webec.socrativelight

import grails.transaction.Transactional

class StudentController {
    def questionsService

    def index() {
        render view:"index", model: [questions: questionsService.listQuestions()]
    }

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
            List<String> answer_ids = params.list("answer_ids")
            questionsService.submit_answers(params.question_id,answer_ids)
        }
        redirect (controller: "teacher", action: "show_report")
    }
}
