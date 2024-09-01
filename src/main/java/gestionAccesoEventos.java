public class gestionAccesoEventos {
    public static void main(String[] args) {
        ;
    }

    public static String[][] crearMatriz() {
        String[][] matriz = new String[10][5];
        return matriz;
    }

    public static boolean verificarEdad(String[][] matriz, int persona) {
        if (Integer.parseInt(matriz[persona][1]) >= 18) {
            System.out.println("El usuario " + matriz[persona][0] + " es mayor de edad.");
            return true;
        } else {
            System.out.println("El usuario " + matriz[persona][0] + " es menor de edad.");
        }
        return false;
    }

    public static String verificarBoleto(String[][] matriz, int persona) {
        if (matriz[persona][0] != null) {
            if (matriz[persona][2].equals("General")) {
                System.out.println("El usuario " + matriz[persona][0] + " tiene boleto General.");
                return "General";
            } else if (matriz[persona][2].equals("VIP")) {
                System.out.println("El usuario " + matriz[persona][0] + " tiene boleto VIP.");
                return "VIP";
            }
        }
        return "False";
    }

    public static boolean validarInvitados(String[][] matriz, int persona) {
        if (Integer.parseInt(matriz[persona][3]) > 2) {
            System.out.println("El usuario " + matriz[persona][0] + " excede el limite de invitados.");
            return false;
        } else {
            System.out.println("El usuario " + matriz[persona][0] + " no excede el limite de invitados.");
        }
        return true;
    }

    public static int aforoDisponible(String[][] matriz, String sala) {
        int invitadosMaximoVIP = 50;
        int invitadosMaximoGeneral = 150;
        int aforoGeneral = 0;
        int aforoVIP = 0;
        int suma = 0;
        if (sala.equals("VIP")) {
            for (int i = 0; i < matriz.length; i++) {
                if ("VIP".equals(matriz[i][2])) {
                    suma++;
                }
            }
            aforoVIP = invitadosMaximoVIP - suma - 1;
            return aforoVIP;
        } else if (sala.equals("General")) {
            for (int i = 0; i < matriz.length; i++) {
                if ("General".equals(matriz[i][2])) {
                    suma++;
                }
            }
            aforoGeneral = invitadosMaximoGeneral - suma;
            return aforoGeneral;
        } else {
            System.out.println("Sala no válida.");
        }
        return 0;
    }

    public static void ingresarPersona(String[][] matriz, String nombre) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] != null && matriz[i][0].equals(nombre)) {
                matriz[i][4] = "True";
                System.out.println(nombre + " ha ingresado.");
                return;
            }
        }
        System.out.println("El usuario " + nombre + " no se encuentra en la lista.");
    }

    public static boolean permitirEntrada(String[][] matriz, String nombre) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] != null) {
                if (matriz[i][0].equals(nombre)) {
                    if (Integer.parseInt(matriz[i][1]) >= 18) {
                        if (matriz[i][2].equals("General") || matriz[i][2].equals("VIP")) {
                            if (aforoDisponible(matriz, matriz[i][2]) > 0) {
                                ingresarPersona(matriz, matriz[i][0]);
                                System.out.println("El usuario " + nombre + " puede ingresar.");
                                return true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("El usuario " + nombre + " no puede ingresar.");
        return false;
    }

    public static void removerPersona(String[][] matriz, String nombre) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][0] != null) {
                if (matriz[i][0].equals(nombre)) {
                    matriz[i][0] = null;
                    matriz[i][1] = null;
                    matriz[i][2] = null;
                    matriz[i][3] = null;
                    System.out.println("Usuario removido: " + nombre);
                    return;
                }
            }
        }
        System.out.println("El usuario " + nombre + " no se encuentra en la lista.");
    }

    public static int aforo(String sala) {
        int invitadosMaximoVIP = 50;
        int invitadosMaximoGeneral = 150;
        if (sala.equals("VIP")) {
            return invitadosMaximoVIP;
        } else if (sala.equals("General")) {
            return invitadosMaximoGeneral;
        } else {
            System.out.println("Sala no válida.");
            return 0;
        }
    }
}