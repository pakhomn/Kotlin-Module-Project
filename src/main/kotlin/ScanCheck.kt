class ScanCheck {

    fun checkInt (input: String): Int {
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            -1
        }
    }

}