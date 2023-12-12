package org.example

import org.example.Models.Student

fun main() {
    val students = mutableListOf<Student>()

    while (true) {
        println("----- MENU -----")
        println("1. Add Student")
        println("2. Sort by TYT Score")
        println("3. Sort by AYT Score")
        println("4. Delete Student")
        println("0. Exit")

        print("Option: ")
        when (readLine()?.toIntOrNull()) {
            1 -> addStudent(students)
            2 -> sortByTytGrade(students)
            3 -> sortByAytGrade(students)
            4 -> removeStudent(students)
            0 -> return
            else -> println("Invalid option. Please try again.")
        }

        println()
    }
}


fun addStudent(students: MutableList<Student>) {

    print("Student Name: ")
    val name = readLine() ?: ""
    print("Student Surname: ")
    val surname = readLine() ?: ""
    print("School Number: ")
    val schoolNumber = readLine() ?: ""
    print("TYT Grade: ")
    val tytGrade = readLine()?.toDoubleOrNull() ?: 0.0
    print("AYT Grade: ")
    val aytGrade = readLine()?.toDoubleOrNull() ?: 0.0
    print("Target Job: ")
    val targetJob = readLine() ?: "undefined"


    val newStudent = Student(
        id = students.size + 1,
        name = name,
        surname = surname,
        schoolNumber = schoolNumber,
        tytGrade = tytGrade.toString().toDouble(),
        aytGrade = aytGrade.toString().toDouble(),
        targetJob = targetJob
    )

    students.add(newStudent)
    println("The student added successfully.")


}

fun sortByTytGrade(students: List<Student>) {
    val sortedStudents = students.sortedByDescending { it.tytGrade }
    printStudents("Ranking for TYT Grades", sortedStudents)
}

fun sortByAytGrade(students: List<Student>) {
    val sortedStudents = students.sortedByDescending { it.aytGrade }
    printStudents("Ranking for AYT Grades", sortedStudents)
}

fun printStudents(title: String, students: List<Student>) {
    println("----- $title -----")
    students.forEachIndexed { index, student ->
        println(
            "${index + 1}. ${student.name} ${student.surname} - School Number: ${student.schoolNumber},  TYT Grade: ${student.tytGrade}, AYT Grade: ${student.aytGrade}, Target Job: ${student.targetJob}"
        )
    }

}

fun removeStudent(students: MutableList<Student>) {
    print("Enter the school number of the student you want to remove: ")
    val schoolNumber = readLine()?.toIntOrNull()

    if (schoolNumber != null) {
        val removedStudent = students.find { it.schoolNumber == schoolNumber.toString() }
        if (removedStudent != null) {
            students.remove(removedStudent)
            println("Student successfully removed.")
        } else {
            println("No student found with the specified school number.")
        }
    } else {
        println("Invalid school number input.")
    }
}