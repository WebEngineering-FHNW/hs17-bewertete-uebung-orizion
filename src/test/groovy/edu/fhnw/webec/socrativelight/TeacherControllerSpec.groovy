package edu.fhnw.webec.socrativelight

import grails.test.mixin.TestFor
import grails.test.mixin.integration.Integration
import org.springframework.test.annotation.Rollback
import spock.lang.Specification
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

    void "test controller adds questions correctly"() {
        given:
            String text = "Text string gontaining sp€¢ïàlchärs"
        when:
            controller.save(new Question(text:text))
        expect:
            Question.get(1).text == text
    }
}
