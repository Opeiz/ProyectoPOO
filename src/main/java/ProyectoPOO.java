import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

public class ProyectoPOO {
    private static Sheets sheetsService;
    private static String APPLICATION_NAME = "ProyectoPOO";
    private static String SPREADSHEET_ID = "1AeLMDsaj2b1PHTYW26vovGma_BuzG5H7IFDwYrH1qvw";

    private static Credential authorize() throws IOException, GeneralSecurityException{

        InputStream in = ProyectoPOO.class.getResourceAsStream( "/credential.json");

        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
                JacksonFactory.getDefaultInstance(), new InputStreamReader(in)
        );

        List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(),
                clientSecrets, scopes)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver())
                .authorize("user");

        return credential;
    }

    public static Sheets getSheetsService() throws IOException, GeneralSecurityException{
        Credential credential = authorize();
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(),
                JacksonFactory.getDefaultInstance(), credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static void main(String[] args) throws IOException, GeneralSecurityException{
        sheetsService = getSheetsService();
        String range = "Sheet1!B2:C15";  //Rango Cuadrado de trabajo

        //Del CRUD - R!

        ValueRange READ = sheetsService.spreadsheets().values()
                .get(SPREADSHEET_ID,range)
                .execute();

        List<List<Object>> values = READ.getValues();

        //Del CRUD - C!
        /*
        ValueRange NuevaFila = new ValueRange()
                .setValues(Arrays.asList(
                        Arrays.asList("Agregado", "Correctamente")
                ));
        AppendValuesResponse CREATE = sheetsService.spreadsheets().values()
                .append(SPREADSHEET_ID,"Sheet",NuevaFila)
                .setValueInputOption("USER_ENTERED")
                .setInsertDataOption("INSERT_ROWS")
                .setIncludeValuesInResponse(true)
                .execute();
        */

        //Del CRUD - U!

        /*
        ValueRange ActualizarFila = new ValueRange()
                .setValues(Arrays.asList(
                        Arrays.asList("Cambioo")
                ));
        UpdateValuesResponse UPDATE = sheetsService.spreadsheets().values()
                .update(SPREADSHEET_ID,"Celda_a_Cambiar", ActualizarFila)
                .setValueInputOption("RAW")
                .execute();
        */

        //Del CRUD - D

        /*
        DeleteDimensionRequest DELETE = new DeleteDimensionRequest()
                .setRange(
                        new DimensionRange()
                            .setSheetId(0)          //ID de la Hoja ultimos numeros despues de gid=
                            .setDimension("RAW")
                            .setStartIndex(654654)  //Fila a la Eliminar + 1
                 );
        List<Request> requests = new ArrayList<>();
        requests.add(new Request().setDeleteDimension(DELETE));

        BatchUpdateSpreadsheetRequest body = new BatchUpdateSpreadsheetRequest().setRequests(requests);
        sheetsService.spreadsheets().batchUpdate(SPREADSHEET_ID,body).execute();
        */

        if (values == null || values.isEmpty()){
            System.out.println("Error No Data");
        } else {
            for (List row : values){
                System.out.printf("%s %s",row.get(0), row.get(4));
            }
        }
    }


}
