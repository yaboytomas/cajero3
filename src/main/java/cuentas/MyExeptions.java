package cuentas;

public class MyExeptions extends Exception {

    // Atributos
    private String message;
    private int code;

    // Constructor para mis expetions
    public MyExeptions(int code) {
        this.code = code;
    }

    public MyExeptions(String message) {
        this.message = message;
    }

    // Metodo para mis exeptions
    public String getMessage() {
        System.out.println();
        String message = "";
        switch(code) {
            case 1:
                message += "La fecha no es real y/o no sigue el formato DD/MM/YYYY";
                break;
            case 2:
                message += "El arreglo no se inicio y/o los numeros se salieron de rango";
                break;
            case 3:
                message += "Los numeros ingresados no pueden ser negativos y/o 0";
                break;
            case 4:
                message += "No se pueden insertar otros caracteres que no sean numeros";
                break;
        }
        return message;
    }



}
