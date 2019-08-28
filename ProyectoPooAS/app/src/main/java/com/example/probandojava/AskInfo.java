package com.example.probandojava;

import com.example.probandojava.config.Config;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.util.List;

public class AskInfo {


    HttpTransport transport = AndroidHttp.newCompatibleTransport();
    JsonFactory factory = JacksonFactory.getDefaultInstance();
    final Sheets sheetsService = new Sheets.Builder(transport, factory, null)
            .setApplicationName("Competencia Robotica")
            .build();

    final String spreadsheetId = Config.spreadsheet_id;


    public List<List<Object>> AskInfoCR(){
        List<List<Object>> ResultadosCR = null;
        try{

            String rangeCR = "CarreraRobot!A2:B6";
            ValueRange resultCR = sheetsService.spreadsheets().values()
                    .get(spreadsheetId, rangeCR)
                    .setKey(Config.google_api_key)
                    .execute();

            ResultadosCR = resultCR.getValues();

        } catch (IOException e) {
            System.out.println("Sheets failed" + e.getLocalizedMessage());
        }

        return ResultadosCR;
    }

    /*
    public List<List<Object>> AskInfoSL(){
        try{

            String rangeSL = "SeguirLinea!A2:B6";
            ValueRange resultSL = sheetsService.spreadsheets().values()
                    .get(spreadsheetId, rangeSL)
                    .setKey(Config.google_api_key)
                    .execute();

            return resultSL.getValues();

        } catch (IOException e) {
            System.out.println("Sheets failed" + e.getLocalizedMessage());
        }

    }

    public List<List<Object>> AskInfoLR(){
        try{

            String rangeLR = "LaberintoRobot!A2:B6";
            ValueRange resultLR = sheetsService.spreadsheets().values()
                    .get(spreadsheetId, rangeLR)
                    .setKey(Config.google_api_key)
                    .execute();

            return resultLR.getValues();

        } catch (IOException e) {
            System.out.println("Sheets failed" + e.getLocalizedMessage());
        }

    }

    public List<List<Object>> AskInfoPR(){
        try{
            String rangePR = "PeleaRobot!A2:B6";
            ValueRange resultPR = sheetsService.spreadsheets().values()
                    .get(spreadsheetId, rangePR)
                    .setKey(Config.google_api_key)
                    .execute();

            return resultPR.getValues();

        } catch (IOException e) {
            System.out.println("Sheets failed" + e.getLocalizedMessage());
        }

    }*/

}
