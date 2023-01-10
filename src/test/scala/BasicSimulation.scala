import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BasicSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8080")

  val scn = scenario("Scenario Name") // A scenario is a chain of requests and pauses
    .exec(http("request")
      .get("/auth/state"))

  setUp(scn.inject(atOnceUsers(20)).protocols(httpProtocol))
}
