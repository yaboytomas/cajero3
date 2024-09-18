package cuentas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Movimientos {

    //---------------ATRIBUTOS---------------//

    private String tipoMovimiento;
    private Date fecha;
    private int monto;

    //---------------CONSTRUCTORES---------------/

    public Movimientos(String tipoMovimiento, Date fecha, int monto) {
        this.tipoMovimiento = tipoMovimiento;
        this.fecha = fecha;
        this.monto = monto;
    }

    //---------------GETTERS Y SETTERS---------------//

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "Movimientos{" +
                "tipoMovimiento='" + tipoMovimiento + '\'' +
                ", fecha=" + formatter.format(fecha) +
                ", monto=" + monto +
                '}';
    }

    //---------------METODOS----------------//



}
