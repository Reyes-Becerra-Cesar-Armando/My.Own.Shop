import java.util.Arrays;
import java.util.Scanner;
public class MyOwnShop {
    public static int i = 0;
    public static int Log = 0;
    public static String[] producto = new String[100];
    public static String[] NomProd = new String[100];
    public static double [] PrecProd = new double[100];
    public static int[] ExistProd = new int[100];
    public static double[] PSug = new double[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println( " _____ ______       ___    ___      ________  ___       __   ________           ________  ___  ___  ________  ________   \n" +
                "|\\   _ \\  _   \\    |\\  \\  /  /|    |\\   __  \\|\\  \\     |\\  \\|\\   ___  \\        |\\   ____\\|\\  \\|\\  \\|\\   __  \\|\\   __  \\  \n" +
                "\\ \\  \\\\\\__\\ \\  \\   \\ \\  \\/  / /    \\ \\  \\|\\  \\ \\  \\    \\ \\  \\ \\  \\\\ \\  \\       \\ \\  \\___|\\ \\  \\\\\\  \\ \\  \\|\\  \\ \\  \\|\\  \\ \n" +
                " \\ \\  \\\\|__| \\  \\   \\ \\    / /      \\ \\  \\\\\\  \\ \\  \\  __\\ \\  \\ \\  \\\\ \\  \\       \\ \\_____  \\ \\   __  \\ \\  \\\\\\  \\ \\   ____\\\n" +
                "  \\ \\  \\    \\ \\  \\   \\/  /  /        \\ \\  \\\\\\  \\ \\  \\|\\__\\_\\  \\ \\  \\\\ \\  \\       \\|____|\\  \\ \\  \\ \\  \\ \\  \\\\\\  \\ \\  \\___|\n" +
                "   \\ \\__\\    \\ \\__\\__/  / /           \\ \\_______\\ \\____________\\ \\__\\\\ \\__\\        ____\\_\\  \\ \\__\\ \\__\\ \\_______\\ \\__\\   \n" +
                "    \\|__|     \\|__|\\___/ /             \\|_______|\\|____________|\\|__| \\|__|       |\\_________\\|__|\\|__|\\|_______|\\|__|   \n" +
                "                  \\|___|/                                                         \\|_________|                           \n" +
                "                                                                                                           " );
        System.out.println( "---------------------------------------------------------------------------------------------------------------------------" );
        int opcMenu = 0;
        while ( opcMenu != 4 ) {
            System.out.println("¿A qué módulo deseas ingresar?\n1. Inventario\n2. Ventass\n3. Estadisticas\n4. Salir");
            opcMenu = sc.nextInt();
            switch (opcMenu) {
                case 1:
                    Inventario();
                    break;
                case 2:
                    Ventas();
                    break;
                case 3:
                    Estadisticas();
                    break;
                case 4:
                    System.out.println( "Saliendo..." );
                default:
                    break;
            }
        }
    }

    private static void Estadisticas() {
        while ( Log == 0 ){
            LoginBasico();
        }
    }

    private static void Ventas() {
    }

    private static void Inventario() {
        Scanner sc = new Scanner(System.in);
        while ( Log == 0 ){
            LoginBasico();
        }
        int opcInventario = 0;
        while (opcInventario != 4 ) {
            System.out.println("¿Qué desea realizar?\n1. Ver productos\n2. Eliminar productos\n3. Gestionar inventario");
            opcInventario = sc.nextInt();
            switch (opcInventario) {
                case 1:
                    Productos();
                    break;
                case 2:
                    EliminarProductos();
                    break;
                case 3:
                    GestionarInventario();
                    break;
                default:
                    break;
            }
        }
    }

    private static void GestionarInventario() {

    }

    private static void EliminarProductos() {
        Scanner sc = new Scanner(System.in);
        System.out.print( "Ingresa el código del producto que desees borrar: ");
        int codigo = sc.nextInt();
        sc.nextLine();
            if (codigo < 0 || codigo >= i){
                System.out.println( "Producto no encontrado" );
            }
        for (int j = codigo; j < i - 1; j++) {
            NomProd[ j ] = NomProd[ j + 1 ];
            PrecProd[ j ] = PrecProd[ j + 1 ];
            ExistProd[ j ] = ExistProd[ j + 1 ];
            PSug[ j ] = PSug[ j + 1 ];
        }
        System.out.println( "¿Estas seguro?\n1. Si\n2. No" );
        int estado = sc.nextInt();
        if (estado == 1)
        {
            NomProd[i - 1] = null;
            PrecProd[i - 1] = 0;
            ExistProd[i - 1] = 0;
            PSug[i - 1] = 0;
            i--;
        }
        System.out.println( "Producto eliminado correctamente" );
    }

    private static void Productos() {
        Scanner sc = new Scanner(System.in);
        int j = 0;
        while ( j == 0 ) {
            System.out.println( "Ingresa el nombre del producto: " );
            NomProd[ i ] = sc.nextLine();
            System.out.println( "Ingresa el precio del producto: " );
            PrecProd[ i ] = sc.nextInt();
            sc.nextLine();
            PSug[ i ] = (double) (PrecProd[ i ] + (PrecProd[ i ] * 0.30 ));
            System.out.println( "Ingresa el número existencias del producto: " );
            ExistProd[ i ] = sc.nextInt();
            sc.nextLine();
            producto[i] = "Código: " + i + " | " + "Nombre: " + NomProd[i] + " | " + "Precio: " + PrecProd[i] + " | " + "Cantidad: " + ExistProd[i] + " | " + "Precio sugerido: " + PSug[i];
            System.out.println( "¿Desea agregar más prodcutos?\n1. Si\n2. No");
            int Elec = sc.nextInt();
            sc.nextLine();
            if (Elec == 2){
                j++;
            }
            i++;
        }
        for ( int k = 0; k < i; k++){
            System.out.println(producto[k]);
        }
    }
    private static void LoginBasico( ) {
        Scanner sc = new Scanner(System.in);
        Log = 0;
        String usuarioCorrecto = "admin";
        String passwordCorrecta = "1234";
        System.out.print("Usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();
        if (usuario.equals(usuarioCorrecto) && pass.equals(passwordCorrecta)) {
            System.out.println("Acceso permitido.");
            Log = 1;
        }
        else {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }
}
