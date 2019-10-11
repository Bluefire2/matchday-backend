package matchday

import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.ListenableFuture
import com.google.common.util.concurrent.MoreExecutors
import util.Config
import util.Request
import util.Response
import java.net.URL
import java.util.concurrent.Executors


class Matchday(config: Config) {
    companion object {

    }
}

enum class GameResult {
    WIN, DRAW, LOSS
}

data class Standing(val team: String, val gd: Int, val points: Int)

private fun winTieLossSample(pWin: Float, pTie: Float): GameResult {
    val r = Math.random()

    return when {
        r < pWin -> GameResult.WIN
        r < pWin + pTie -> GameResult.DRAW
        else -> GameResult.LOSS
    }
}

private fun getLeagueStandings(league: Config.League): ListenableFuture<Set<Standing>> {
    val service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10))
    val request: ListenableFuture<Response> = service.submit(Request(URL(league.espnStandings)))
    val v: ListenableFuture<String> = Futures.transform(
        request,
        com.google.common.base.Function { response: Response? -> "" },
        service
    )
    // TODO
    return Futures.immediateFuture(HashSet())
}