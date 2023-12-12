package org.example.Models

class Student(var id: Int,var name: String,var surname: String, var schoolNumber: String,var tytGrade: Double,var aytGrade: Double,var targetJob: String) {
    override fun toString(): String {
        return "| ID: $id | Name: $name | Surname: $surname | School Number: $schoolNumber | TYT Grade: $tytGrade | AYT Grade: $aytGrade | Target Job: $targetJob |"
    }
}