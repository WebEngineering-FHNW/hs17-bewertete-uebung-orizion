package edu.fhnw.webec.socrativelight

import grails.transaction.Transactional

@Transactional
class QuestionsService {

    def save(Question question) {
        question.save flush:true
    }

    def add_answer(question_id, isCorrect, text) {
        if(Question.exists(question_id)) {
            def answer = new Answer(question: Question.get(question_id), isCorrect: isCorrect, text: text)
            answer.save(flush: true)
        }
    }
}
