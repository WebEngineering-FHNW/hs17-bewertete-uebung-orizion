package edu.fhnw.webec.socrativelight

class Question {

    String text;

    static hasMany = [answers:Answer]

    static mapping = {
        answers cascade: 'all-delete-orphan'
    }

    static constraints = {
        text blank:false
    }
}
