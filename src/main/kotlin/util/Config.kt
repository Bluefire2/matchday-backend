package util

import com.moandjiezana.toml.Toml
import java.io.InputStream

data class Config(val leagues: Map<String, League>) {
    companion object {
        @JvmStatic
        fun read(stream: InputStream): Config {
            return Toml().read(stream).to<Config>(Config::class.java)
        }
    }

    data class League(
        val spiId: Int,
        val espnStandings: String,
        val winPoints: Int,
        val drawPoints:Int,
        val losePoints: Int
    )
}