package org.example

import org.example.Models.Student

fun main() {
    var idCounter = 0
    val studentList = mutableListOf<Student>()
    while (true) {
        println("Name: ")
        val nameInput = readLine() ?: ""

        println("Surname: ")
        val surnameInput = readLine() ?: ""

        println("School Number: ")
        val schoolNumberInput = readLine() ?: ""

        println("TYT Grade: ")
        val tytGradeInput = readLine() ?: ""

        println("AYT Grade: ")
        val aytGradeInput = readLine() ?: ""

        println("Target Job: ")
        val targetJobInput = readLine() ?: ""

        val newStudent = Student(
            idCounter,
            nameInput,
            surnameInput,
            schoolNumberInput,
            tytGradeInput.toDouble(),
            aytGradeInput.toDouble(),
            targetJobInput
        )
        studentList.addFirst(newStudent)
        //veri tabanına ekle
        idCounter++
        studentList.forEach {
            println(it.toString())
        }
    }


}