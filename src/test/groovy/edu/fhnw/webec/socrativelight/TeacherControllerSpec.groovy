package edu.fhnw.webec.socrativelight

import grails.test.mixin.TestFor
import grails.test.mixin.integration.Integration
import org.springframework.test.annotation.Rollback
import spock.lang.Specification
import spock.lang.Unroll
/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@Integration
@Rollback
@TestFor(TeacherController)
class TeacherControllerSpec extends Specification {

    TeacherController controller

    def setup() {
        controller = new TeacherController()
    }

    def setupData() {
        new Question(text: "A new Question").save(flush: true)
    }

    def cleanup() {
    }

    void "test something"() {
        given:
            setupData()
        expect:
            Question.count() == 1
    }




    @Unroll
    void "saving a question with text #text"(text) {
        given:
            def q = new Question(text: text)
        when: "Text"
            controller.save(q)
        then: "The question is saved with #text"
            q.text == text
        where:
            text << ["This is the first Question",
                     "SéNDèRZèïCH@n",
                     "Test test"]

    }
}
