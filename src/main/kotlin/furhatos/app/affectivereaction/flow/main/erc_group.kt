package furhatos.app.affectivereaction.flow.main

import furhatos.app.affectivereaction.flow.ResetHead
import furhatos.app.affectivereaction.flow.navigationButton
import furhatos.app.affectivereaction.setting.location_FRONT
import furhatos.app.affectivereaction.setting.location_LEFT
import furhatos.app.affectivereaction.setting.location_RIGHT
import furhatos.app.affectivereaction.setting.mapParticipants
import furhatos.app.affectivereaction.util.groupSummary
import furhatos.flow.kotlin.*

val transitionStatement = listOf<String>("Et", "Quant à", "Ensuite")

val Summary : State = state(ResetHead) {
    onButton(navigationButton.copy(label = "REACTIONS")){
        goto(Discussion)
    }

    onButton(turnButton.copy(label = "LEFT-RIGHT")) {
        with(furhat) {
            glance(location_LEFT, 1000)
            say("${mapParticipants[location_LEFT]}")
            glance(location_RIGHT, 1000)
            say("${mapParticipants[location_RIGHT]}")
        }
        goto(StatementMajority)
    }

    onButton(turnButton.copy(label = "LEFT-FRONT")) {
        with(furhat) {
            glance(location_LEFT, 1000)
            say("${mapParticipants[location_LEFT]}")
            glance(location_FRONT, 1000)
            say("${mapParticipants[location_FRONT]}")
        }
        goto(StatementMajority)
    }

    onButton(turnButton.copy(label = "RIGHT-FRONT")) {
        with(furhat) {
            glance(location_RIGHT, 1000)
            say("${mapParticipants[location_RIGHT]}")
            glance(location_RIGHT, 1000)
            say("${mapParticipants[location_FRONT]}")
        }
        goto(StatementMajority)
    }

    onButton(turnButton.copy(label = "LEFT")){
        with(furhat) {
            glance(location_LEFT, duration = 1000)
            say(transitionStatement.random().toString()+" ${mapParticipants[location_LEFT]}")
        }
        goto(StatementMinority)
    }

    onButton(turnButton.copy(label = "RIGHT")){
        with(furhat) {
            glance(location_RIGHT, duration = 1000)
            say(transitionStatement.random().toString()+" ${mapParticipants[location_RIGHT]}")
        }
        goto(StatementMinority)
    }

    onButton(turnButton.copy(label = "FRONT")){
        with(furhat) {
            glance(location_FRONT, duration = 1000)
            say(transitionStatement.random().toString()+" ${mapParticipants[location_FRONT]}")
        }
        goto(StatementMinority)
    }

}

val StatementMajority : State = state(ResetHead) {
    onButton(speakButton.copy(label = "PP")){
        with(furhat){
            glanceAll(furhat)
            if (groupSummary != null) {
                say(
                    Question(groupSummary.PP).nextQuestion()
                )
            }
        }
        goto(Summary)
    }

    onButton(speakButton.copy(label = "OO")){
        with(furhat){
            glanceAll(furhat)
            if (groupSummary != null) {
                say(
                    Question(groupSummary.OO).nextQuestion()
                )
            }
        }
        goto(Summary)
    }

    onButton(speakButton.copy(label = "NN")){
        with(furhat){
            glanceAll(furhat)
            if (groupSummary != null) {
                say(
                    Question(groupSummary.NN).nextQuestion()
                )
            }
        }
        goto(Summary)
    }
}

val StatementMinority: State = state {

    onButton(speakButton.copy(label = "P")) {
        with(furhat){
            if (groupSummary != null) {
                say(
                    Question(groupSummary.P).nextQuestion()
                )
            }
        }
        goto(Summary)
    }

    onButton(speakButton.copy(label = "O")) {
        with(furhat){
            if (groupSummary != null) {
                say(
                    Question(groupSummary.O).nextQuestion()
                )
            }
        }
        goto(Summary)
    }

    onButton(speakButton.copy(label = "N")) {
        with(furhat){
            if (groupSummary != null) {
                say(
                    Question(groupSummary.N).nextQuestion()
                )
            }
        }
        goto(Summary)
    }
}