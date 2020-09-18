package codigo;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author valer
 */
public class Funciones {
    ArrayList<String> provincias;
    
    public Funciones()
    {
        this.provincias = new ArrayList<String>();
    }
    
    public String[] estado()
    {
        String estado[] = new String[5];
        estado[0]="arrendado";
        estado[1]="dañado";
        estado[2]="disponible";
        estado[3]="mantenimiento";
        estado[4]="vendido";
        return estado;
    }
    
    public ArrayList nombreProvincias ()
    {                
        provincias.add("Azuay");
        provincias.add("Bolívar");
        provincias.add("Cañar");
        provincias.add("Carchi");
        provincias.add("Chimborazo");
        provincias.add("Cotopaxi");
        provincias.add("El Oro");
        provincias.add("Esmeraldas");
        provincias.add("Galápagos");
        provincias.add("Guayas");
        provincias.add("Imbabura");
        provincias.add("Loja");
        provincias.add("Los Ríos");
        provincias.add("Manabí");
        provincias.add("Morona Santiago");
        provincias.add("Napo");
        provincias.add("Orellana");
        provincias.add("Pastaza");
        provincias.add("Pichincha");
        provincias.add("Santa Elena");
        provincias.add("Santo Domingo de los Tsáchilas");
        provincias.add("Sucumbíos");
        provincias.add("Tungurahua");
        provincias.add("Zamora Chinchipe");
        return provincias;
    }
    public boolean ValidacionNombreNumero(String nombre, int condicion){
        int maximo = 0;
        if(condicion==0){
            maximo=50;
        }else if(condicion ==1){
            maximo=30;
        }
        boolean resultado = true;
        int digitos = nombre.length();
        if(digitos ==0 || digitos >maximo)
        {
            resultado= false;
        }
        return resultado;
    }
    public boolean ValidacionNombreCaracteres(String nombre){
        boolean resultado = true;
        Pattern pat = Pattern.compile("^([A-Z]{1}[a-záéíóú]{1,24}[\\s]{1}[A-Z]{1}[a-z]{1,24}|[A-Z]{1}[a-záéíóú]{1,24}[\\s]{1}[A-Z]{1}[a-z]{1,24}[\\s]"
        +"{1}[A-Z]{1}[a-z]{1,24}[\\s]{1}[A-Z]{1}[a-z]{1,24})");
        Matcher mat = pat.matcher(nombre);
        if (!mat.matches())
        {
            resultado = false;
        }
        return resultado;
    }
    public boolean nombreYLog(String name, int tam)
    {
       boolean band= true;
       boolean val = name.length() > 0;
       boolean val2 = name.length() < tam;
       
       Pattern pat = Pattern.compile("[A-Za-záéíóú\\s]{1,50}");
       Matcher mat = pat.matcher(name);
      
       if(!mat.matches() || !val || !val2)
       {
           band = false;
       }
       return band;
    }
    //Prueba de cambio
    public boolean ValidacionNombreCaracteresYLong(String nombre, int tam){
       boolean val = nombre.length() > 0;
       boolean val2 = nombre.length() < tam;
       boolean bandera =true;
        if (!nombre.isEmpty())
        {    
            if (!ValidacionNombreCaracteres(nombre) || !val || !val2)
            {
               bandera = false;
            }
        } 
        return bandera;
    }
    
    public boolean ValidacionCodigoContrato(String contrato){
        boolean resultado = true;
        if(contrato.length()>5){
            resultado = false;
        }
        return resultado;
    }
    
    public boolean validarCelular(String celular)
    {
       boolean band= true;
       Pattern pat = Pattern.compile("^09[0-9]{8}");
       Matcher mat = pat.matcher(celular);
      
       if(!mat.matches())
       {
           band = false;
       }
       return band;
    }   
    
    public boolean validarNombreEmpresa(String nombre)
    {
        boolean band= true;
       Pattern pat = Pattern.compile("[A-Za-záéíóú0-9\\s]{1,50}");
       Matcher mat = pat.matcher(nombre);
      
       if(!mat.matches())
       {
           band = false;
       }
       return band;
    }
    public boolean validaFonoConv(String numero)
    {
       boolean band= true;
       Pattern pat = Pattern.compile("[0-9]{7,10}");
       Matcher mat = pat.matcher(numero);
      //hola
       if(!mat.matches())
       {
           band = false;
       }
       return band;
    
    }
    public boolean ValidacionRUC(String ruc){
       Pattern pat = Pattern.compile("^[0123456789]{10}00(1|2|3){1}");
       Matcher mat = pat.matcher(ruc);
       boolean rucCorrecto=true;
       if(ruc.length()==13){
       if(mat.matches()){
           char arreglo[]=new char[ruc.length()-3];
           String cadena="";
           for(int i=0;i<(ruc.length()-3);i++)
            {
                arreglo[i]=ruc.charAt(i);
                cadena+=arreglo[i];
               
            }
            if(!this.validadorDeCedula(cadena)){
                rucCorrecto=false;
            }
        }else{
           rucCorrecto=false;
       }
      }else{
           rucCorrecto = false;
       }
       return rucCorrecto;
    }   
    public boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;
        try {
            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                // Coeficientes de validación cédula
                // El decimo digito se lo considera dígito verificador
                int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
                int verificador = Integer.parseInt(cedula.substring(9,10));
                int suma = 0;
                int digito = 0;
                for (int i = 0; i < (cedula.length() - 1); i++) {
                    digito = Integer.parseInt(cedula.substring(i, i + 1))* coefValCedula[i];
                    suma += ((digito % 10) + (digito / 10));
                }
                if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                    cedulaCorrecta = true;
                }
                else if ((10 - (suma % 10)) == verificador) {
                    cedulaCorrecta = true;
                } else {
                    cedulaCorrecta = false;
                }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }
        if (!cedulaCorrecta) {
//            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return cedulaCorrecta;
    }
    public boolean validacionFecha(String date){
        boolean resultado=true;
        Pattern pat = Pattern.compile("^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$");
        Matcher mat = pat.matcher(date);
        if(!mat.matches()){
          resultado = false; 
        }   
        return resultado;
    }
    public boolean validacionCostoMensual(String valor){
        boolean resultado=true;
        Pattern pat = Pattern.compile("^[123456789]{1}[0123456789]{0,}[.,]{1}[0123456789]{2}");
        Matcher mat = pat.matcher(valor);
        if (!mat.matches()){
            resultado = false;
        }
        return resultado;
    }
    public boolean validacionDuracionContrato(String meses){
    boolean resultado = true;
    Pattern pat = Pattern.compile("^([1-9]{1})$|^(1[0-2]{1})$");
    Matcher mat = pat.matcher(meses);
    if (!mat.matches()){
        resultado=false;
    }
        return resultado; 
    }
    public boolean validacionDigitosCodigoEquipo(String equipo){
        if(equipo.length()==13 || equipo.length()==15)
        {return true;}
        else
        {return false;}
    }
    public boolean validacionCodigoEquipo(String equipo){
        Pattern pat = Pattern.compile("^\\d{13}|\\d{15}");
        Matcher mat = pat.matcher(equipo);
        if(mat.matches()){
            return true;
        }else{
            return false;
           
        }
    
    }
    public boolean validacionNombreEquipo(String nombre_equipo){
        Pattern pat = Pattern.compile("^[A-Z]{2}\\d{1}");
        Matcher mat = pat.matcher(nombre_equipo);
        if(mat.matches()){
            return true;
        }else{
            return false;
           
        }
        
    }
}

