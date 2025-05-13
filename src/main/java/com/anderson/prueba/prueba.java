package com.anderson.prueba;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registro")
public class prueba extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, String> errores = new HashMap<>();
        List<Integer> primos = new ArrayList<>();
        String resultado = null;

        // Obtener parámetros del formulario
        String numero1Str = request.getParameter("numero1");
        String numero2Str = request.getParameter("numero2");

        // Validar números
        int numero1 = 0, numero2 = 0;
        try {
            numero1 = Integer.parseInt(numero1Str);
            numero2 = Integer.parseInt(numero2Str);
            if (numero1 < 0 || numero2 < 0) {
                errores.put("numeros", "Los números deben ser positivos.");
            } else if (numero1 > numero2) {
                errores.put("numeros", "El primer número debe ser menor que el segundo.");
            }
        } catch (NumberFormatException e) {
            errores.put("numeros", "Los números deben ser válidos.");
        }


        if (errores.isEmpty()) {
            for (int i = numero1; i <= numero2; i++) {
                if (esPrimo(i)) {
                    primos.add(i);
                }
            }
            resultado = "Números primos: " + primos.toString() +
                    "<br>Total de números primos: " + primos.size();
        }


        request.setAttribute("error", errores);
        request.setAttribute("resultado", resultado);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private boolean esPrimo(int numero) {
        if (numero <= 1) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}