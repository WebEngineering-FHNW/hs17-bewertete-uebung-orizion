package edu.fhnw.webec.socrativelight

import grails.transaction.Transactional

class TeacherController {

    def questionsService

    //static scaffold = Question

    def index() {
        render view: "index", model: [questions: questionsService.listQuestions()]
    }

    def show(Question question) {
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
            questionsService.save(question)
            redirect(action: "show", id: question.id)
        }
    }

    @Transactional
    def addanswer() {
        def isCorrect = false
        if(params.isCorrect != null) {
            isCorrect = true
        }
        if(Question.exists(question_id)) {
            def answer = new Answer(question_id: params.question_id,isCorrect: isCorrect, text: params.text)
            if(answer.hasErrors()) {
                respond answer.errors, view:'show', id: params.question_id
            }else {
                questionsService.add_answer(answer)
                redirect(action: "show", id: params.question_id)
            }
        }else {

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


            //check result sets
            SUBMISSION:
            for(submission in groupedSubmissions) {
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

    def show_report() {
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

        render view: "show_report", model: [questions: questions, answerCount: answerCount]
    }
}
