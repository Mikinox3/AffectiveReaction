package furhatos.app.affectivereaction.setting

import furhatos.records.Location

val maxNumberOfUsers = 3
val distanceToEngage = 2.0
val location_LEFT = Location(0.6, 0.0, 1.0)
val location_RIGHT = Location(-0.6, 0.0, 1.0)
val location_FRONT = Location(0.0, 0.0, 2.0)
val listPositions = listOf(location_LEFT, location_RIGHT, location_FRONT)
//LEFT
var p1 = "Achille"
//FRONT
var p2 = "Mélodie"
//RIGHT
var p3 = "Bénédicte"
var listParticipants = mutableListOf(p1, p2, p3)
var mapParticipants = mutableMapOf(
    location_LEFT to p1,
    location_FRONT to p2,
    location_RIGHT to p3)