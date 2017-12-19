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
     * Saves a students selected answers to a question
     */
    @Transactional
    def submit_answer() {
        if(Question.exists(params.question_id)){
            List<String> answer_ids = params.list("answer_ids")
            questionsService.submit_answers(params.question_id,answer_ids)
        }
        redirect (controller: "teacher", action: "show_report")
    }

    /**
     * Saves a students selected answers to a question
     */
    @Transactional
    def submit_answers() {
        def question_ids = params.list("question_ids")
        for(question_id in question_ids) {
            if(Question.exists(question_id)){
                List<String> answer_ids = params.list("q_"+question_id+"_answer_ids")
                questionsService.submit_answers(question_id,answer_ids)
            }
        }
        redirect (controller: "teacher", action: "show_report")
    }
}
