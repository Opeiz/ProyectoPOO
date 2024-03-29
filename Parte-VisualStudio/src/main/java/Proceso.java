import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;

public class Proceso extends Thread {

    SheetsQuickstart conexion;
    private static HashMap<String, String> rangos;

    public Proceso(SheetsQuickstart conexion) {
        this.conexion = conexion;
        rangos = new HashMap<String, String>();
        rangos.put("CarreraRobot", "CarreraRobot!B6:D15");
        rangos.put("LaberintoRobot", "LaberintoRobot!B6:D15");
        rangos.put("SeguirLinea", "SeguirLinea!B6:D15");
        rangos.put("PeleaRobot", "PeleaRobot!B6:D15");

    }

    public void run() {
        while (true) {
            int contador = 0;
            for(contador = 0;contador < 1 ;contador++){
                try {
                    conexion.ResultadosLineaComando(rangos.get("CarreraRobot"));
                    Thread.sleep(1000);
                } catch (InterruptedException | IOException | GeneralSecurityException e) {
                    e.printStackTrace();
                }
                    
                try {
                    conexion.ResultadosLineaComando(rangos.get("LaberintoRobot"));
                    Thread.sleep(1000);
                } catch (InterruptedException | IOException | GeneralSecurityException e) {
                    e.printStackTrace();
                }

                try {
                    conexion.ResultadosLineaComando(rangos.get("SeguirLinea"));
                    Thread.sleep(1000);
                } catch (InterruptedException | IOException | GeneralSecurityException e) {
                    e.printStackTrace();
                }
            
                try {
                    conexion.ResultadosLineaComando(rangos.get("PeleaRobot"));
                    Thread.sleep(1000);
                } catch (InterruptedException | IOException | GeneralSecurityException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }
}

    
