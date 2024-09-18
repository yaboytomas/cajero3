package cuentas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppCuentaCorriente {

    public static void main(String[] args) throws MyExeptions {
        //Instanciar las cuentas
        CuentaCorriente nuevaCuenta1 = new CuentaCorriente("Tomas", new ArrayList<>(), 2222000);


        // Probar exeptions
        try {
            //caso 3
            nuevaCuenta1.abonar(100);
            nuevaCuenta1.cargar(30);
            System.out.println();
            for (Movimientos movimiento : nuevaCuenta1.getMovimientos()) {
                if (movimiento != null) {
                    System.out.println(movimiento);
                }
            }
            System.out.println();

            //caso 4
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el monto a abonar: ");
            int monto = scanner.nextInt();
            nuevaCuenta1.abonar(monto);
            System.out.println("Ingrese el monto a cargar: ");
            monto = scanner.nextInt();
            nuevaCuenta1.cargar(monto);

            //caso 2
            ArrayList<String> list = new ArrayList<>();
            list.add("Element 1");
            list.add("Element 2");
            list.add("Element 3");
            list.get(2);

            //caso1
            System.out.println("Ingrese la fecha: ");
            String fecha = scanner.next();
            if (DateValidator.isValidDate(fecha)) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = formatter.parse(fecha);
                System.out.println("La fecha es valida");
            } else {
                throw new MyExeptions(1);
            }

        } catch (MyExeptions e) {
            System.out.println("Hubo un error de MyExeptions: " + e.getMessage());
        } catch (InputMismatchException e) {
            try {
                throw new MyExeptions(4);
            } catch (MyExeptions ex) {
                System.out.println("Hubo un error de MyExeptions: " + ex.getMessage());
            }
        } catch (IndexOutOfBoundsException e) {
            try {
                throw new MyExeptions(2);
            } catch (MyExeptions ex) {
                System.out.println("Hubo un error de MyExeptions: " + ex.getMessage());
            }
        } catch (ParseException e) {
            throw new MyExeptions(1);
        }
    }
}
