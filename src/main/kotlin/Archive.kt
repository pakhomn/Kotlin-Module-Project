class Archive {
    private val archiveList: MutableList<String> = mutableListOf()


    constructor() {
        while (true) {
            println("Введите название архива:")
            val input = readLine()

            if (!input.isNullOrBlank()) {
                archiveList.add(input)
                println("Создан архив с названием [$input]")
                break
            } else {
                println("Название архива не может быть пустым. Пожалуйста, повторите ввод.")
            }
        }
    }


    fun setArchiveName(name: String) {
        archiveList.set(0, name)
    }

    fun getArchiveName(): String {
        return archiveList[0]
    }

    fun getSize(): Int {
        return archiveList.size
    }

    fun addNote() {
        while (true) {
            println("Введите текст заметки:")
            val input = readLine()

            if (!input.isNullOrBlank()) {
                archiveList.add(input)
                println("Добавили новую заметку!")
                break
            } else {
                println("Заметка не может быть пустой. Пожалуйста, повторите ввод.")
            }
        }

    }

    fun printArchives() {
        println("Список архивов:")
        for ((index, name) in archiveList.withIndex()) {
            println("${index + 1}. $name")
        }
    }

    fun printNotes() {
        println("Список заметок в [${getArchiveName()}].\nВыберите, какую заметку показать ИЛИ Выход")
        for ((index, name) in archiveList.withIndex()) {
            if (index > 0) {
                val miniName = if (name.length > 15) {"${name.substring(0, 15)}..."} else name
                println("${index}. $miniName")
            }
        }
    }


    fun printOneNote(index: Int) {
        if (index >= 0 && index < archiveList.size) {
            val element = archiveList[index]
            println("$element")
        } else {
            println("Такой заметки нет")
        }
    }

}