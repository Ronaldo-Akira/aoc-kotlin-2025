fun main() {
    fun part1(input: List<String>): Long {

        fun isInvalidId(n: Long): Boolean{
            val s = n.toString()
            if (s.length %2 != 0) return false
            val mid = s.length / 2
            val first = s.take(mid)
            val last = s.substring(mid)
            return first == last
        }

        var sum: Long = 0
        input[0]
            .split(",")
            .map{ it.split("-")}
            .forEach { range ->
                val firstId = range[0]
                val lastId = range[1]
                for(id in firstId.toLong() .. lastId.toLong()){
                    if(isInvalidId(id)) sum += id
                }
            }

        return sum
    }

    fun part2(input: List<String>): Int {
        return input.size
    }


    // Or read a large test input from the `src/Day02_test.txt` file:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 1227775554.toLong())

    // Read the input from the `src/Day02.txt` file.
    val input = readInput("Day02")
    part1(input).println()
//    part2(input).println()
}
