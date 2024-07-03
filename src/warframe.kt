import com.google.gson.Gson
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URI
import java.net.URL
import java.util.TreeSet

const val API = "https://api.warframe.market/v1/items/arcane_energize/orders"

fun main() {

    try {

        val set = TreeSet<Order>()

        val gson = Gson()
        val file = File("orders").apply { createNewFile() }

        val url: URL = URI.create(API).toURL()
        val connection: HttpURLConnection = url.openConnection() as HttpURLConnection

        connection.requestMethod = "GET"

        val responseCode = connection.responseCode

        if (responseCode == HttpURLConnection.HTTP_OK) {
            val reader = BufferedReader(InputStreamReader(connection.inputStream))
            var line: String?
            val response = StringBuilder()

            while (reader.readLine().also { line = it } != null) {
                response.append(line)
            }

            reader.close()

            val data = gson.fromJson(response.toString(), WarframeOrders::class.java)

            for (item in data.payload.orders) {
                if (item.order_type == "buy" && item.mod_rank == 5 && item.platinum >= 800) {
                    set.add(item)
                }
            }

            file.writeText("")

            for (item in set) {
                println(item.user.ingame_name)
                file.appendText("${item.user.ingame_name}\n")
            }

        } else {
            println("Sorry, can't fetch data.")
        }

    } catch (e: Exception) {
        e.printStackTrace()
        println("Something went wrong!")
    }

}