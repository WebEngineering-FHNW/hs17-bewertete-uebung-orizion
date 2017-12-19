package edu.fhnw.webec.socrativelight

import grails.transaction.Transactional

class QuestionsService {

    @Transactional(readOnly = true)
    def listQuestions() {
        return Question.findAll().sort()
    }

    @Transactional
    def save(Question question) {
        question.save flush:true
    }

    @Transactional
    def add_answer(Answer answer) {
        answer.save(flush: true)
    }
}
