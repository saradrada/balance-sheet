package spark.helloworld;

import com.google.gson.Gson;
import spark.Spark;

/**
 * The main entry point.
 * @author Miguel Jimenez (miguel@uvic.ca)
 * @date 2019-02-14
 * @version $Id$
 * @since 0.0.1
 */
public class Application {

    public static class Response {

        private final String content;

        public Response(final String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return this.content;
        }
    }

    public Response compile(String input) {
        return new Response(input);
    }

    public static void main(String[] args) {
        final Application app = new Application();
        final Gson gson = new Gson();
        Spark.port(9090);
        enableCORS("http://0.0.0.0:8080", "GET, POST", "Authorization,Access-Control-Expose-Headers,Access-Control-Allow-Headers,Origin,Accept,X-Requested-With,content-type,Access-Control-Request-Method,Access-Control-Request-Headers,Access-Control-Allow-Methods,Access-Control-Allow-Credentials,user_language,");
        Spark.get("/hvlv", (request, response) -> {
            response.type("application/json");
            if (request.queryParams("input") == null)
                return new Response("An input is required");
            return app.compile(request.queryParams("input"));
        }, gson::toJson);
    }

    // Enables CORS on requests. This method is an initialization method and should be called once.
    private static void enableCORS(final String origin, final String methods, final String headers) {
        Spark.options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        Spark.before((request, response) -> {
            response.header("Access-Control-Allow-Origin", origin);
            response.header("Access-Control-Request-Method", methods);
            response.header("Access-Control-Allow-Headers", headers);
        });
    }
}
