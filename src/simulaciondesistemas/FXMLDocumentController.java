/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*
PROGRAMADO POR JORGE ANDRÉS HERNÁNDEZ ROJAS         MATRÍCULA: 1624294
CORREO ELECTRÓNICO: jorge16andres@gmail.com
FACULTAD DE INGENIERÍA MECÁNICA Y ELÉCTRICA, CIUDAD UNVERSITARIA UANL, SAN NICOLÁS DE LOS GARZA, NUEVO LEÓN, MÉXICO.
*/
package simulaciondesistemas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static java.lang.Math.*;
import java.text.DecimalFormat;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

/**
 *
 * @author Jorge
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button btnIniciar, btnCerrar;
    
    @FXML 
    public TextField txtclientes, txtpromsist, txttotal, txtcajero1, txtcajero2, txtcajero3;
    
    @FXML
    public ScrollPane Scroll, Scroll2;
    
    @FXML
    public TextArea txtarea, txtarea2;
    
    String FINAL="", FINAL2="";
    
 @FXML
public void handleCloseButtonAction(ActionEvent event) {
    Stage stage = (Stage) btnCerrar.getScene().getWindow();
    stage.close();
}

        @FXML 
        public void Calculo (ActionEvent event){
        try{
        int clientes = Integer.parseInt(txtclientes.getText());
        Sistema(clientes);
        }//fin del try
        catch(NumberFormatException e)    //si no, mostrar:
        {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Proyecto");
        alert.setHeaderText(null);
        alert.setContentText("Introduce variables que sean válidas.");
        alert.showAndWait();
        }
        
        }//fin del método
        
        //a = clientes
        public void Sistema(int a){
            boolean cajero1 = false;
            boolean cajero2 = false;
            boolean cajero3 = false;
            DecimalFormat forma = new DecimalFormat("#0.00000");
            int ccajero1 = 0, ccajero2 = 0, ccajero3 = 0;
            int cantc1=0,cantc2=0,cantc3=0;
            double aleatorio = 0.0, total2 = 0.0, total=0.0, ttotal, promedio=0.0;
            int meta = 0;
            String aleatorioS, promS, totalS, total2S;
            FINAL="";
            FINAL2="";
            double C[] = new double[a];
            double A[] = new double[a];
            for(int i=0;i<a;i++){
                aleatorio = (random()*1);
                C[i]= aleatorio;
                total+=aleatorio;
                aleatorioS=forma.format(aleatorio);
                FINAL2+=i+1+".-"+aleatorioS+" mins\n";
            }
            promedio = total/a;
            promS=forma.format(promedio);
            while(meta<a){
                if(cajero1==false){
                   cajero1=true;
                   ccajero1 = meta;
                   meta++;
                   cantc1++;
                   FINAL+="Cajero 1: Ocupado\n"; 
                } 
                if(cajero2 == false){
                    cajero2=true;
                    ccajero2 = meta;
                    meta++;
                    cantc2++;
                    FINAL+="Cajero 2: Ocupado\n"; 
                }
                if (cajero3 == false){
                    cajero3=true;
                    ccajero3 = meta;
                    meta++;
                    cantc3++;
                    FINAL+="Cajero 3: Ocupado\n"; 
                }//acomodo de cajeros
                
                if(C[ccajero1]<C[ccajero2] && C[ccajero1]<C[ccajero3]){
                   FINAL+="Cajero 1: Desocupado\n";  
                   cajero1=false;
                   C[ccajero2] -= C[ccajero1];
                   C[ccajero3] -= C[ccajero1];
				   if(C[ccajero2]<0)
				   {
				   C[ccajero2]=0.0;
				   }
				   if(C[ccajero3]<0){
					   C[ccajero3]=0.0;
				   }
                   
                } else if(C[ccajero2]<C[ccajero1] && C[ccajero2]<C[ccajero3]){
                    FINAL+="Cajero 2: Desocupado\n"; 
                    cajero2=false;
                    C[ccajero1] -= C[ccajero2];
                    C[ccajero3] -= C[ccajero2];
					if(C[ccajero1]<0){
					   C[ccajero1]=0.0;
					}
				   if(C[ccajero3]<0){
					   C[ccajero3]=0.0;
				   }
                    
                } else if(C[ccajero3]<C[ccajero1] && C[ccajero3]<C[ccajero2]){
                    FINAL+="Cajero 3: Desocupado\n"; 
                    cajero3=false;
                    C[ccajero1] -= C[ccajero3];
                    C[ccajero2] -= C[ccajero3];
					if(C[ccajero1]<0){
					   C[ccajero1]=0.0;
					}
				   if(C[ccajero2]<0){
					   C[ccajero2]=0.0;
				   }
                    
                }//restas
                
                if(C[ccajero1]<C[ccajero2] && C[ccajero1]>C[ccajero3]){
                    total2+=C[ccajero1];
                    total2S=forma.format(total2);
                   FINAL+="Tiempo acumulado: "+total2S+" mins\n";
                } else if(C[ccajero2]<C[ccajero1] && C[ccajero2]>C[ccajero3]){
                    total2+=C[ccajero2];
                    total2S=forma.format(total2);
                   FINAL+="Tiempo acumulado: "+total2S+" mins\n";
                } else if(C[ccajero3]<C[ccajero1] && C[ccajero3]>C[ccajero2]){
                    total2+=C[ccajero3];
                    total2S=forma.format(total2);
                   FINAL+="Tiempo acumulado: "+total2S+" mins\n";   
                }//acomodo de restas*/
            }
            ttotal = total + total2;
            totalS=forma.format(ttotal);
            txtarea.setText(String.valueOf(FINAL));
            txtarea2.setText(String.valueOf(FINAL2));
            txtpromsist.setText(promS+" mins");
            txttotal.setText(totalS+" mins");
            txtcajero1.setText(String.valueOf(cantc1));
            txtcajero2.setText(String.valueOf(cantc2));
            txtcajero3.setText(String.valueOf(cantc3));
        }//fin del metodo
           
           
/*   public void Limpiar(ActionEvent event) {
     li.setText("");
     lf.setText("");
     theta.setText("");
     ei.setText("");
     ef.setText("");
     pi.setText("");
     pf.setText("");
     k.setText("");
     gi.setText("");
     gf.setText("");
     phi.setText("");
}*/
 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
