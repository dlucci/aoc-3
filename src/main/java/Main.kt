import java.io.File

fun main(args: Array<String>) {

    var list = File("~/IdeaProjects/aoc-3/src/main/resources/data.txt").readLines()
    var countList: Array<NumCount> = Array(list[0].length) { NumCount() }

    list
        .forEach { outer ->
            outer.forEachIndexed { index, item ->
                when (item) {
                    '0' -> countList[index].numZeros++
                    '1' -> countList[index].numOnes++
                }
            }
        }
    var maxString = String()
    var minString = String()
    countList.forEach {
        if(it.numOnes > it.numZeros) {
            maxString += "1"
            minString += "0"
        } else {
            maxString += "0"
            minString += "1"
        }

    }
    val maxInt = Integer.parseInt(maxString, 2)

    val minInt = Integer.parseInt(minString, 2)
    println(maxInt * minInt)
    //10110
}

data class NumCount(
    var numZeros: Int = 0,
    var numOnes: Int = 0
)