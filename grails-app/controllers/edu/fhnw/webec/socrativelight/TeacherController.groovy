package edu.fhnw.webec.socrativelight

import grails.transaction.Transactional

class TeacherController {

    def questionsService

    //static scaffold = Question

    /**
     * Displays all questions with their answers
     * @return
     */
    def index() {
        render view: "index", model: [questions: questionsService.listQuestions()]
    }

    /**
     * Question show view
     * @param question
     * @return
     */
    def show(Question question) {
        render view: "show", model: [question: question]
    }

    /**
     * Question create view
     * @return
     */
    def create() {
        render view: "create"
    }

    /**
     * saves a question
     * @param question
     * @return
     */
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

    /**
     * Adds an answer to a question
     * @return
     */
    @Transactional
    def addanswer() {
        def isCorrect = false
        if(params.isCorrect != null) {
            isCorrect = true
        }
        println("we add answers")
        if(Question.exists(params.question_id)) {
            def q = questionsService.find(params.question_id)
            def answer = new Answer(question: q,isCorrect: isCorrect, text: params.text)
                println(answer)
            if(answer.hasErrors()) {
                respond answer.errors, view:'show', id: params.question_id
            }else {
                questionsService.add_answer(answer)
                redirect(action: "show", id: params.question_id)
            }
        }
    }

    /**
     * Removes an answer from a question
     * @param answer
     * @return
     */
    @Transactional
    def removeanswer(Answer answer) {
        if(Answer.exists(answer.id)){
            def a = Answer.get(answer.id)
            a.delete()
        }
        redirect action:"show", id: answer.question.id
    }

    /**
     * Calculate how often the correct answer for each question was given
     * @return the report view showing the report result
     */
    def show_report_correct_answers() {
        def questions = Question.getAll()
        def correctCount = [:]
        def answerCount = [:]
        //evaluate results for every teacher
        for(question in questions) {
            def results = SubmittedAnswer.findAllByQuestion(question)
            def groupedSubmissions = results.groupBy {sa -> sa.submissionId}
            def correctAnswers = question.answers.findAll {a-> a.isCorrect}
            def correctAnswersCount = 0

            answerCount[question.id] = groupedSubmissions.size()

            //check result sets
            SUBMISSION:
            for(submission in groupedSubmissions) {
                //if not the same number of answers was given as are declared correct, we can
                //declare it to be wrong
                if(correctAnswers.size()
                        != submission.value.size()) {
                    continue SUBMISSION
                }
                //search if all correct answers are present
                //we dont need to check if more than the correct ones are present, as we already ensured
                //equality in number of answers
                for(answer in correctAnswers) {
                    if(null == submission.value.find {a -> a.answerId == answer.id}) {
                        continue SUBMISSION
                    }
                }
                correctAnswersCount++
            }
            correctCount[question.id] = correctAnswersCount
        }

        render view: "show_report_correct_answers", model: [questions: questions, correctCount: correctCount, answerCount: answerCount]
    }

    /**
     * Generates the report showing the number of times each question was chosen
     * @return the report view
     */
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
