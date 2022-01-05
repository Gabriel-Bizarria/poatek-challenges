data class Student(val name: String, val height: Int, val age: Int)

fun main(args: Array<String>) {

    //Creation of the student list
    val studentList = listOf(
        Student("Bruno", 170, 14),
        Student("Leonardo", 174, 21),
        Student("Juan", 156, 12),
        Student("Juliana", 166, 13),
        Student("Wagner", 184, 17),
        Student("Micaela", 172, 18),
        Student("Bento", 150, 14),
        Student("Lucia", 162, 13),
        Student("Pedro", 169, 14),
        Student("Carla", 158, 16)
    )
    //A filter that check if the student in the list is 13 years old or over it.
    val olderThirteen = studentList.filter { it.age >= 13 }

    //Determines the average height of these students
    val averageHeight = olderThirteen.sumOf{ it.height } / olderThirteen.size

    println("A média de altura entre os alunos com 13 anos ou mais é $averageHeight.")
    println("E essa é a lista de estudantes abaixo dessa média:")

    olderThirteen.filter { it.height < averageHeight }.forEach { println(it.name) }

}

/*[[“Bruno”, 170, 14], [“Leonardo”, 174, 21], [“Juan”, 156, 12], [“Juliana”, 166, 13],
[“Wagner”, 184, 17], [“Micaela”, 172, 18], [“Bento”, 150, 14], [“Lucia”, 162, 13], [“Pedro”,
169, 14], [“Carla”, 158, 16]]*/

