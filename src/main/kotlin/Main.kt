import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var isMenuList: Boolean = true
    var counterOfArchives: Int = 0
    var exitProgram = false
    var level: Int = 0
    val menu = Menu()
    var points: Int = 2
    val archiveList: MutableList<Archive> =mutableListOf()
    var archiveNumber: Int

    fun getWrongSymbol(): String {
        return "Укажите цифру от 1 до $points, пожалуйста"
    }

    while (!exitProgram && isMenuList) {
        menu.print(level, counterOfArchives)
        points = menu.getSize()

        while (true) {
            val input = scanner.nextLine()
            val choice = ScanCheck()
            val number = choice.checkInt(input)

            if ((number <= 0) || number > menu.getSize()) {
                println(getWrongSymbol())
            } else {
                println("Выбрано [${menu.printPoint(number)}]")

                if (number == menu.getSize() && level == 0) {
                    println("Выходим из программы, до скорых встреч!")
                    exitProgram = true
                    break
                } else if (counterOfArchives == 0) {
                    val newArchive = Archive()
                    archiveList.add(newArchive)
                    counterOfArchives++
                    isMenuList = false
                    break
                } else {
                    isMenuList = false
                    break
                }
            }
        }

        while (!exitProgram && !isMenuList) {
            level = 1
            menu.print(level, counterOfArchives)
            points = menu.getSize()

            while (true) {
                val input = scanner.nextLine()
                val choice = ScanCheck()
                val number = choice.checkInt(input)

                if ((number <= 0) || number > menu.getSize()) {
                    println(getWrongSymbol())
                } else {
                    println("Выбрано [${menu.printPoint(number)}]")
                    if (number == menu.getSize() && level == 1) {
                        isMenuList = true
                        level = 0
                        break
                    } else if (number == 1 && level == 1) {
                        val newArchive = Archive()
                        archiveList.add(newArchive)
                        counterOfArchives++
                        menu.print(level, counterOfArchives)
                        points = menu.getSize()
                    } else if (number == 2 && level == 1) {
                        println("Cписок архивов и заметок.\nВыберите архив:")
                        for ((index, archive) in archiveList.withIndex()) {
                            println("${index + 1}. ${archive.getArchiveName()} [${archive.getSize() - 1}]")
                        }

                        while(true) {
                            val input = scanner.nextLine()
                            val choice = ScanCheck()
                            val number = choice.checkInt(input)

                            if ((number <= 0) || number > archiveList.size) {
                                points = archiveList.size
                                println(getWrongSymbol())
                                continue
                            }
                            else {
                                println("Выбрано [${archiveList[number-1].getArchiveName()} [${archiveList[number-1].getSize() - 1}]]")
                                counterOfArchives = archiveList[number-1].getSize() - 1
                                archiveNumber = number-1
                                level = 2
                                menu.print(level, counterOfArchives)
                                points = menu.getSize()

                                while (true) {
                                    val input = scanner.nextLine()
                                    val choice = ScanCheck()
                                    val number = choice.checkInt(input)

                                    if ((number <= 0) || number > menu.getSize()) {
                                        println(getWrongSymbol())
                                    } else {
                                        println("Выбрано [${menu.printPoint(number)}]")
                                        if (number == menu.getSize()) {
                                            isMenuList = true
                                            level = 1
                                            counterOfArchives = archiveList.size
                                            menu.print(level, counterOfArchives)
                                            points = menu.getSize()
                                            break
                                        } else if (number == 1 && level == 2) {
                                            archiveList[archiveNumber].addNote()
                                            isMenuList = true
                                            level = 2
                                            counterOfArchives = archiveList[number-1].getSize()
                                            menu.print(level, counterOfArchives)
                                            points = menu.getSize()
                                            continue
                                        }
                                        else if (number == 2 && level == 2) {
                                            archiveList[archiveNumber].printNotes()
                                            println("${archiveList[archiveNumber].getSize()}. Выход")

                                            while(true) {
                                                val input = scanner.nextLine()
                                                val choice = ScanCheck()
                                                val number = choice.checkInt(input)

                                                if ((number <= 0) || number > archiveList[archiveNumber].getSize()) {
                                                    points = archiveList[archiveNumber].getSize() - 1
                                                    println(getWrongSymbol())
                                                } else if (number == archiveList[archiveNumber].getSize()) {
                                                    isMenuList = true
                                                    level = 2
                                                    menu.print(level, counterOfArchives)
                                                    points = menu.getSize()
                                                    break
                                                } else {
                                                    println("Вот полный текст выбранной заметки:")
                                                    archiveList[archiveNumber].printOneNote(number)

                                                    println("Чтобы выйти напечатайте любой символ ИЛИ Enter")
                                                    readLine()

                                                    isMenuList = true
                                                    level = 2
                                                    menu.print(level, counterOfArchives)
                                                    points = menu.getSize()
                                                    break
                                                }
                                            }
                                            continue
                                        }
                                        break
                                    }
                                }
                            }
                            break
                        }
                    }
                }
            }
            continue
        }
    }
}