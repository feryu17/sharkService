import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;

import java.io.BufferedWriter;



//comando para terminar de escuchar el puerto 8080
// netstat -ano | find "8080" taskkill -pid 2380 /f

//para finalizar de escuchar
// taskkill -pid 2380 /f   // **** se refiere al codigo que aparece despues de la leyenda LISTENING

//gcloud functions deploy oauth2callback
// --trigger-http --allow-unauthenticated
// --runtime java11
// --entry-point SharkService
// --source C:\Users\52831\IdeaProjects\sharkService

//gcloud functions deploy apishark --trigger-http --allow-unauthenticated --runtime java11 --entry-point SharkService --source C:\Users\52831\IdeaProjects\sharkService


public class SharkService implements HttpFunction {

    @Override
    public void service(HttpRequest request, HttpResponse response) throws Exception {

        BufferedWriter writer = response.getWriter();
        writer.write("Hello world!");
    }
}
