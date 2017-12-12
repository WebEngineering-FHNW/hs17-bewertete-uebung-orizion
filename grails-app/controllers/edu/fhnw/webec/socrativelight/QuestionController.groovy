package edu.fhnw.webec.socrativelight

import grails.transaction.Transactional


class QuestionController {

    //static scaffold = Question

    def index() {
        render view: "index", model: [questions: Question.findAll()]
    }

    def show(Question question) {
        def answers = Answer.findAllByQuestion(question)
        render view: "show", model: [question: question,answers:answers]
    }

    def create() {
        render view: "create"
    }

    @Transactional
    def save(Question question) {
        if(question.hasErrors()) {
            respond question.errors, view:'create'
        }
        else {
            question.save flush:true
            withFormat {
                html {
                    flash.message = message(code: 'default.created.message', args: [message(code: 'book.label', default: 'Book'), book.id])
                    redirect(action: "show", id: question.id)
                }
                '*' {  redirect(action: "show", id: question.id)}
            }
        }
    }

    @Transactional
    def addanswer() {
            def answer = new Answer(question: Question.get(params.question_id),isCorrect: params.isCorrect, text: params.text)

            answer.save(flush: true)
            println answer
            redirect(action: "show", id: params.question_id)
    }
}
