package com.weatherRadar.app;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.logging.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Scanner;
import java.io.IOException;
/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    private static final Map<Integer, String> places = new HashMap<>();
    /*
    loggers provide a better alternative to System.out.println
    https://rules.sonarsource.com/java/tag/bad-practice/RSPEC-106
     */
    private static final Logger logger = Logger.getLogger(WeatherStarter.class.getName());

    public static void  main(String[] args ) {

        /*
        get a retrofit instance, loaded with the GSon lib to convert JSON into objects
         */
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IpmaService service = retrofit.create(IpmaService.class);

        //Preencher mapa com as infos de cada cidade para fazer o pedido à API pelo nome da cidade
        DistrictsIlhas cidades = null;
        try {
            cidades = service.getCodes().execute().body();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        Iterator<CityInfo> iterator = cidades.getData().listIterator();
        while (iterator.hasNext()) {
            CityInfo cityObj = iterator.next();
            places.put(cityObj.getGlobalIdLocal(), cityObj.getLocal());
        }

        String codigo_cidade = args[0];
        String cidade_pedida = null;
        Boolean flag = true;
        while(flag){
            if(places.get(Integer.parseInt(codigo_cidade)) != null){
                cidade_pedida = places.get(Integer.parseInt(codigo_cidade));
                flag = false;
            }
            else {
                Scanner myObj = new Scanner(System.in);
                System.out.println("Put a valid capital, district or island: ");
                codigo_cidade = myObj.nextLine();
            }
        }

        Call<IpmaCityForecast> callSync = service.getForecastForACity(Integer.parseInt(codigo_cidade));

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                logger.info( "Max temperature for " + cidade_pedida + ", today is: " + forecast.getData().
                        listIterator().next().getTMax());
            } else {
                logger.info( "No results!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}