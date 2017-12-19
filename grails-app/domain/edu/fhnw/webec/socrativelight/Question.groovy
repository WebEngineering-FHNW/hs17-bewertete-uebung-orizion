package edu.fhnw.webec.socrativelight

class Question {

    String text;

    static hasMany = [answers:Answer]

    static mapping = {
        answers cascade: 'all-delete-orphan', sort:'id', order:'desc'
    }

    static constraints = {
        text blank:false, minSize: 10
    }
}
