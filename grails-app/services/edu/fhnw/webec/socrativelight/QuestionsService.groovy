package edu.fhnw.webec.socrativelight

import grails.transaction.Transactional

class QuestionsService {

    @Transactional(readOnly = true)
    def listQuestions() {
        return Question.getAll()
    }

    @Transactional
    def save(Question question) {
        question.save flush:true
    }

    @Transactional
    def add_answer(Answer answer) {
        answer.save(flush: true)
    }

    @Transactional
    def submit_answers(question_id,answer_ids) {
        def question = Question.get(question_id)
        def newId = 1;
        if(SubmittedAnswer.count() > 0) {
            newId = SubmittedAnswer.last().submissionId + 1;
        }
        for(answerId in answer_ids) {
            def answer = Answer.get(answerId)
            def a = new SubmittedAnswer(question: question, answer: answer,submissionId: newId)
            a.save(flush:true, failOnError: true)
        }
    }
}
