package src.logica;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cuenta {
    private float saldo;
    private float ingresos;
    private float gastos;
    private ArrayList<Movimiento> listaMovimientos = new ArrayList<>();    
    

    // Constructor principal
    public Cuenta(float saldo) {
        this.saldo = saldo;
        ingresos = 0;
        gastos = 0;
    }

    public Cuenta() {
        this(0);  // equivale a llamar a Cuenta(0)
    }

    public float getSaldo() {
        return saldo;
    }

    public void ingresar(float valor, CategoriaIngreso categoria, LocalDate fecha, String concepto) {
        saldo += valor;
        ingresos += valor;

        Ingreso ing = new Ingreso(fecha, concepto, valor, categoria);
        listaMovimientos.add(ing);
    }

    public void gastar(float valor, CategoriaGasto categoria, LocalDate fecha, String concepto) {
        saldo -= valor;
        gastos += valor;

        Gasto gasto = new Gasto(fecha, concepto, valor, categoria);
        listaMovimientos.add(gasto);
    }

    public float getTotalIngresos() {
        return ingresos;
    }

    public float getTotalGastos() {
        return gastos;
    }

    public Ingreso[] getIngresos() {
        ArrayList <Ingreso> ingresos = new ArrayList<> ();
        
        for(Movimiento mov: listaMovimientos) {
            if(mov instanceof Ingreso) {
                ingresos.add((Ingreso)mov);
            }
        }

        return ingresos.toArray(new Ingreso[0]);
    }

    
    public Gasto[] getGastos() {

        ArrayList <Gasto> gastos = new ArrayList<> ();

        for(Movimiento mov: listaMovimientos) {
            if(mov instanceof Gasto) {
                gastos.add((Gasto)mov);
            }
        }

        return gastos.toArray(new Gasto[0]);
    }

    public Movimiento[] getListaMovimientos() {
        return listaMovimientos.toArray(new Movimiento[0]);
    }

}