import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedWriter;
import java.net.HttpURLConnection;
import java.util.List;

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

    private static final Gson gson = new Gson();


    @Override
    public void service(HttpRequest request, HttpResponse response) throws Exception {

            String contentType = request.getContentType().orElse("no header");

            System.out.println(contentType);

            if(contentType.equals("application/json; charset=UTF-8")){

                GeneralModel info = gson.fromJson(request.getReader(), GeneralModel.class);

                System.out.println("nombre de la lista: " + info.getListName());

                System.out.println("_________________________________________________________________");
                List<VideoModel> items = info.getVideoItem();

                for (VideoModel vid : items){
                    System.out.println("nombre del video: " + vid.getName());
                    System.out.println("*******************************");
                }

                BufferedWriter writer = response.getWriter();
                writer.write("lista: " + info.getListName() + " procesada correctamente");


            }else {

                // Invalid or missing header "Content-Type"
                response.setStatusCode(HttpURLConnection.HTTP_BAD_REQUEST);
                BufferedWriter writer = response.getWriter();
                writer.write("Invalid or missing header \"Content-Type\"");
            }

    }
}
