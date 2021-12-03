import javax.swing.*;
import java.util.Scanner;

public class CuentaBancaria {
    String nombreCliente;
    String dniCliente;
    double saldo;
    double ultimoMovimiento;
    boolean deposito = false;
    boolean retiro = false;

    public CuentaBancaria(String nombreCliente, String dniCliente) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
    }
    public CuentaBancaria(String nombreCliente, String dniCliente, double saldo) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.saldo = saldo;
    }
    public void depositar(double cantidad) {
        if (cantidad >=0) {
            saldo += cantidad;
            ultimoMovimiento = cantidad;
            deposito = true;
            retiro = false;
        } else {
            System.out.println("por favor ingrese nuevamente el monto a depositar:");
        }
    }
    public void retirar(double cantidad) {
        if (cantidad > saldo) {
            System.out.println("error saldo insuficiente");
        } else {
            saldo -= cantidad;
            ultimoMovimiento = cantidad;
            retiro = true;
            deposito = false;
        }
    }
    public void consultarUltimoMovimiento() {
        if (deposito == true && retiro == false) {
            System.out.println("Cantidad depositada:" + "+" + ultimoMovimiento);
        } else if (retiro == true && deposito == false) {
            System.out.println("Cantidad retirada:" + "-" + ultimoMovimiento);
        } else  {
            System.out.println("no se han realizado transacciones");
        }
    }
    public void mostrarMenu() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Bienvenido/a: " + nombreCliente);
        String opciones;
       do {
           System.out.println("por favor ingrese una opcion:\n Opción A: Consultar Saldo. \n Opción B: Depositar. \n Opción C: Retirar. \n Opción D: Consultar último movimiento. \n Opción E: Salir.");

           opciones=scanner.next();

            switch (opciones) {
                case "A":System.out.println("su saldo es: " + saldo);
                break;
                case "B":System.out.println("Depositar");
                    depositar(Double.parseDouble(JOptionPane.showInputDialog("ingrese cantidad a depositar")));
                break;
                case "C":System.out.println("Retirar: s");
                    retirar(Double.parseDouble(JOptionPane.showInputDialog("ingrese cantidad a retirar:")));
                break;
                case "D":System.out.println("Consultar ultimo movimiento: ");
                    consultarUltimoMovimiento();
                break;
                case "E":System.out.println("Gracias por operar con nuestro sistema:");
                break;
                default:
                    System.out.println("Error en el ingreso por favor elija una opcion:");
            }
        }while (!opciones.equalsIgnoreCase("E"));
    }
}