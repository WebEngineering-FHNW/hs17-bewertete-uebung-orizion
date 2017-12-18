package edu.fhnw.webec.socrativelight

import grails.transaction.Transactional


class TeacherController {

    //static scaffold = Question

    def index() {
        render view: "index", model: [questions: Question.findAll()]
    }

    def show(Question question) {
        //def answers = Answer.findAllByQuestion(teacher)
        render view: "show", model: [question: question]
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
        if(Question.exists(params.question_id)) {
            def isCorrect = params.isCorrect == null ? false : params.isCorrect
            def answer = new Answer(question: Question.get(params.question_id), isCorrect: isCorrect, text: params.text)
            answer.save(flush: true)
            redirect(action: "show", id: params.question_id)
        }
    }

    @Transactional
    def removeanswer() {
        if(Answer.exists(params.id)){
            def a = Answer.get(params.id)
            a.delete()
        }
    }

    def showresults() {
        def questions = Question.getAll()
        def sas = SubmittedAnswer.getAll()
        //evaluate results for every teacher
        def correctCount = [:]
        def answerCount = [:]
        for(question in questions) {
            def results = SubmittedAnswer.findAllByQuestion(question)
            def groupedSubmissions = results.groupBy {sa -> sa.submissionId}
            def correctAnswers = question.answers.findAll {a-> a.isCorrect}
            def correctAnswersCount = 0
            answerCount[question.id] = groupedSubmissions.size()
            println(groupedSubmissions)
            //check result sets
            SUBMISSION:
            for(submission in groupedSubmissions) {
                //println(submission)
                //if not the same number of answers was given, we can
                //declare it to be wrong from the start

                if(correctAnswers.size()
                        != submission.value.size()) {
                    //do smtn if wrongly answered
                    println("count isnt the same bro")
                }
                //search if all correct answers are present
                //we dont need to check if more than the correct ones are present, as we already ensured
                //equality in number of answers
                for(answer in correctAnswers) {
                    if(null == submission.value.find {a -> a.answerId == answer.id}) {
                        println("wrong answers")
                        continue SUBMISSION
                    }
                }
                correctAnswersCount++
            }
            correctCount[question.id] = correctAnswersCount
        }

        render view: "showresults", model: [questions: questions, correctCount: correctCount, answerCount: answerCount]
    }

    def showresultsaslist() {
        def questions = Question.getAll()
        def results = SubmittedAnswer.findAll()

        def answerCount = [:]

        for(result in results) {
            if(answerCount[result.answer.id] == null) {
                answerCount[result.answer.id] = 1
            }else {
                answerCount[result.answer.id]++
            }

        }

        render view: "showresultsaslist", model: [questions: questions, answerCount: answerCount]
    }
}
