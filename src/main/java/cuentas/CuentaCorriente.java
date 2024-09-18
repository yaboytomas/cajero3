package cuentas;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

public class CuentaCorriente {

    //---------------ATRIBUTOS---------------//
    public String titular;
    private int numeroCuenta;
    private int saldo;
    private ArrayList<Movimientos> movimientos;

    //---------------CONSTRUCTORES---------------//
    public CuentaCorriente(String titular, ArrayList<Movimientos> movimientos, int numeroCuenta, int saldo) {
        this.titular = titular;
        this.movimientos = new ArrayList<>(10);
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public CuentaCorriente(String titular, ArrayList<Movimientos> movimientos, int numeroCuenta) {
        this.titular = titular;
        this.movimientos = new ArrayList<>(10);
        this.numeroCuenta = numeroCuenta;
    }

    // GETTERS Y SETTERS
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    // TOSTRING
    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "saldo=" + saldo +
                ", numeroCuenta=" + numeroCuenta +
                ", titular='" + titular + '\'' +
                '}';
    }


    //----------------METODOS----------------//



    // ABONAR
    public void abonar(int abono) throws MyExeptions {
        if (abono <= 0) {
            throw new MyExeptions(3);
            //System.out.println("ERROR 876-12.A: Debe ingresar un monto mayor a $0 para abonar en su cuenta, intente nuevamente.");
        } else {
            saldo = saldo + abono;
            Movimientos movimiento = new Movimientos("Abono", new Date(), abono);
            addMovimiento(movimiento.getTipoMovimiento(), movimiento.getFecha(), movimiento.getMonto());
            //System.out.println("Se abono: $" + abono + ", su saldo actual ahora es: $" + saldo);
        }
    }

    // CARGAR
    public void cargar(int carga) throws MyExeptions {
        if (carga > saldo) {
            System.out.println("ERROR: No se puede cargar un monto mayor al saldo disponible.");
        }
        if (carga <= 0) {
            throw new MyExeptions(3);
        } else {
            saldo = saldo - carga;
            Movimientos movimiento = new Movimientos("Cargo", new Date(), carga);
            addMovimiento(movimiento.getTipoMovimiento(), movimiento.getFecha(), movimiento.getMonto());
            //System.out.println("Se cargo un monto de: $" + carga + ", Su nuevo saldo es: $" + saldo);
        }
    }

    // VALIDAR SI NUMERO ES NUMERO
    public void caso4(String input) throws MyExeptions {
        try {
            int carga = Integer.parseInt(input);
            cargar(carga);
        } catch (NumberFormatException e) {
            throw new MyExeptions(4);
        }
    }

    // AGREGAR MOVIMIETNO A ARRAYLIST
    public void addMovimiento(String tipoMovimiento, Date fecha, int monto) {
        if (movimientos.size() == 10) {
            movimientos.remove(0);
        }
        movimientos.add(new Movimientos(tipoMovimiento, fecha, monto));
    }

    // GETTER MOVIEMIENTOS
    public ArrayList<Movimientos> getMovimientos() {
        return movimientos;
    }

}