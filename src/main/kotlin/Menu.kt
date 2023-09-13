class Menu {

    var point: ArrayList<String> = ArrayList()

        fun print(level: Int, counterOfArchives: Int) {
            if (level == 0 && counterOfArchives == 0) {
                val pointFirst: ArrayList<String> = ArrayList()

                pointFirst.add("Меню:")
                pointFirst.add("1. Создать архив")
                pointFirst.add("2. Выйти")
                pointFirst.add("Выберете действие")

                pointFirst.forEach {
                        element -> println(element)
                }

                point.clear()
                point.addAll(pointFirst)
            }

            else if (counterOfArchives > 0 && level == 0) {
                val pointSecond: ArrayList<String> = ArrayList()

                pointSecond.add("Меню:")
                pointSecond.add("1. Архивы")
                pointSecond.add("2. Выйти")
                pointSecond.add("Выберете действие")

                pointSecond.forEach {
                            element -> println(element)
                }

                point.clear()
                point.addAll(pointSecond)
            }

            else if (counterOfArchives >= 1 && level == 1) {
                val pointThird: ArrayList<String> = ArrayList()

                pointThird.add("Меню:")
                pointThird.add("1. Cоздать новый архив")
                pointThird.add("2. Выбрать архив")
                pointThird.add("3. Назад")
                pointThird.add("Выберете действие")

                pointThird.forEach {
                        element -> println(element)
                }

                point.clear()
                point.addAll(pointThird)
            }

            else if (counterOfArchives == 0 && level == 2) {
                val pointThird: ArrayList<String> = ArrayList()

                pointThird.add("Меню:")
                pointThird.add("1. Cоздать заметку")
                pointThird.add("2. Назад")
                pointThird.add("Выберете действие")

                pointThird.forEach {
                        element -> println(element)
                }

                point.clear()
                point.addAll(pointThird)
            }

            else if (counterOfArchives >= 1 && level == 2) {
                val pointThird: ArrayList<String> = ArrayList()

                pointThird.add("Меню:")
                pointThird.add("1. Cоздать новую заметку")
                pointThird.add("2. Выбрать заметку")
                pointThird.add("3. Назад")
                pointThird.add("Выберете действие")

                pointThird.forEach {
                        element -> println(element)
                }

                point.clear()
                point.addAll(pointThird)
            }
        }

    fun getSize(): Int {
        return (point.size - 2)
    }

    fun printPoint(number: Int): String {
        return point[number]
    }


}