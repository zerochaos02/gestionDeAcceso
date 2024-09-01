import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class gestionAccesoEventosTest {
    private String[][] matriz;

    @BeforeEach
    void setUp() {
        matriz = gestionAccesoEventos.crearMatriz();
        matriz[0] = new String[]{"Juan", "20", "VIP", "2", "False"};
        matriz[1] = new String[]{"Ana", "17", "General", "1", "False"};
        matriz[2] = new String[]{"Luis", "25", "General", "0", "False"};
    }

    @Test
    public void testVerificarEdad() {
        assertTrue(gestionAccesoEventos.verificarEdad(matriz, 0));
        assertFalse(gestionAccesoEventos.verificarEdad(matriz, 1));
    }

    @Test
    public void testVerificarBoleto() {
        assertEquals("VIP", gestionAccesoEventos.verificarBoleto(matriz, 0));
        assertEquals("General", gestionAccesoEventos.verificarBoleto(matriz, 1));
        assertEquals("General", gestionAccesoEventos.verificarBoleto(matriz, 2));
    }

    @Test
    public void testValidarInvitados() {
        assertTrue(gestionAccesoEventos.validarInvitados(matriz, 0));
        assertTrue(gestionAccesoEventos.validarInvitados(matriz, 1));
        assertTrue(gestionAccesoEventos.validarInvitados(matriz, 2));
    }

    @Test
    public void testAforoDisponible() {
        assertEquals(48, gestionAccesoEventos.aforoDisponible(matriz, "VIP"));
        assertEquals(148, gestionAccesoEventos.aforoDisponible(matriz, "General"));
    }

    @Test
    public void testIngresarPersona() {
        gestionAccesoEventos.ingresarPersona(matriz, "Juan");
        assertEquals("True", matriz[0][4]);
    }

    @Test
    public void testPermitirEntrada() {
        assertTrue(gestionAccesoEventos.permitirEntrada(matriz, "Juan"));
        assertFalse(gestionAccesoEventos.permitirEntrada(matriz, "Ana"));
    }

    @Test
    public void testRemoverPersona() {
        gestionAccesoEventos.removerPersona(matriz, "Juan");
        assertNull(matriz[0][0]);
    }
}