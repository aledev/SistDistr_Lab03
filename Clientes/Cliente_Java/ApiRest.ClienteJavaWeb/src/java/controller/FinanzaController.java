/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.org.apache.bcel.internal.generic.D2F;
import dto.*;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FinanzaModel;

/**
 *
 * @author aialiagam
 */
@WebServlet(name = "FinanzaController", urlPatterns = {"/FinanzaController"})
public class FinanzaController extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="propiedades privadas">
    private static String CPREFIX = "Lab03_RMI_ClienteWeb.src.controller.FinanzaControler";
    private FinanzaModel finanzaModel;
    private static final long serialVersionUID = 1L;
    private static Logger logger;
    // </editor-fold>
 
    // <editor-fold defaultstate="collapsed" desc="constructores">
    public FinanzaController() {
        super();        
        logger = Logger.getLogger(getClass().getName());
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="eventos">
    
    // <editor-fold defaultstate="collapsed" desc="doPost">
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String MPREFIX = " [doPost(HttpServletRequest request, HttpServletResponse response)]";
        
        String id = request.getParameter("idFinanza"); // no visible
        String nombrePersona = request.getParameter("nombrePersona");
        String fechaMovimiento = request.getParameter("fchMovimiento");
        String saldoMovimiento = request.getParameter("saldoMovimiento");
        String transaccion = request.getParameter("action");
        DateFormat format = null;
        Date date = null;
        RequestDispatcher rd = null;
        System.out.println("controller.FinanzaController.doPost()1"+transaccion);
        
        try{
            // Creamos un nuevo objeto tipo UsuarioDTO
            System.out.println("controller.FinanzaController.doPost()2");

            FinanzaDTO objRequest = new FinanzaDTO();
            if(id==null || id.equals(""))
            {id="0";}   
            objRequest.setId(Integer.parseInt(id));
            System.out.println("controller.FinanzaController.doPost()3");

            objRequest.setNombrePersona(nombrePersona);
            System.out.println("controller.FinanzaController.doPost()4");

            objRequest.setFchMovimiento(new Date());
            System.out.println("controller.FinanzaController.doPost()5");
            
            switch(transaccion)
            {
            case "buscarAll": 
                   List<FinanzaDTO> objResult = this.getFinanzaModel().buscarAll();
                   if(objResult != null){
                       rd = request.getRequestDispatcher("paginas/finanzas/list.jsp");
                       request.setAttribute("finanzaAllObj", objResult);
                   }
                   else{
                       rd = request.getRequestDispatcher("paginas/finanzas/list.jsp");
                       request.setAttribute("finanzaAllObj", objResult);
                       request.setAttribute("error", "No existen datos para mostrar!");
                   }
            break;
            case "editar": 
                   objRequest.set_Id(request.getParameter("_id"));
                   FinanzaDTO objsalida = this.getFinanzaModel().buscarById(objRequest.get_Id());
                   if(objsalida != null){
                   rd = request.getRequestDispatcher("/paginas/finanzas/editar.jsp");
                        request.setAttribute("finanzaObj", objsalida);
                        request.setAttribute("finanzaAll", buscarTodo());
                   }
                   else{
                       rd = request.getRequestDispatcher("/paginas/home.jsp");
                       request.setAttribute("error", "Se ha presentado un problema al realizar peticion, conectate  mesa de ayuda");
                   }
            break;
            case "guardarEditar": 
                    objRequest.set_Id(request.getParameter("_id"));
                    objRequest.setSaldoMovimiento(Double.parseDouble(saldoMovimiento));
                    System.out.println("controller.FinanzaController.doPost()5");
                    
                    format = new SimpleDateFormat("yyyy-MM-dd");
                    date = format.parse(fechaMovimiento);
                    objRequest.setFchMovimiento(date);
                    
                    boolean salida2 = this.getFinanzaModel().update(objRequest);
                    
                    if(salida2){
                        rd = request.getRequestDispatcher("/paginas/finanzas/list.jsp");
                        request.setAttribute("salida", salida2);
                        request.setAttribute("finanzaAllObj", buscarTodo());
                    }
                    else{
                        rd = request.getRequestDispatcher("/paginas/home.jsp");
                        request.setAttribute("error", "Se ha presentado un problema al realizar peticion, conectate  mesa de ayuda");
                    }   
            break;
            case "eliminar": 
                objRequest.set_Id(request.getParameter("_id"));
                boolean salida5 = this.getFinanzaModel().borrarFinanza(objRequest);
                if(salida5){
                    rd = request.getRequestDispatcher("/paginas/finanzas/list.jsp");
                    request.setAttribute("salida", salida5);
                    request.setAttribute("finanzaAllObj", buscarTodo());
                }
                else{
                    rd = request.getRequestDispatcher("/paginas/home.jsp");
                    request.setAttribute("error", "Se ha presentado un problema al realizar peticion, conectate  mesa de ayuda");
                }
            break;
            case "crear":
                rd = request.getRequestDispatcher("/paginas/finanzas/crear.jsp");
           break;
           case "guardarNuevo": 
                format = new SimpleDateFormat("yyyy-MM-dd");
                date = format.parse(fechaMovimiento);
                objRequest.setFchMovimiento(date);
                System.out.println("controller.FinanzaController.doPost()4");

                objRequest.setSaldoMovimiento(Double.parseDouble(saldoMovimiento));
                System.out.println("controller.FinanzaController.doPost()5");
                
                boolean salida3 = this.getFinanzaModel().insertarFinanza(objRequest);
                if(salida3){
                    rd = request.getRequestDispatcher("/paginas/finanzas/list.jsp");
                    request.setAttribute("salida", salida3);
                    request.setAttribute("finanzaAll", buscarTodo());
                }
                else{
                    rd = request.getRequestDispatcher("/paginas/home.jsp");
                    request.setAttribute("error", "Se ha presentado un problema al realizar petición, conectate  mesa de ayuda");
                }
           break;
           default: 
           break; 
            }
        }
        catch(Exception ex){
            rd = request.getRequestDispatcher("/paginas/home.jsp");
            request.setAttribute("error", "Ha ocurrido un error durante la solicitud. Por favor, intentelo nuevamente");
        }
        
        rd.forward(request, response);
    }
    // </editor-fold>
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="metodos privados">
    private FinanzaModel getFinanzaModel(){
        if(this.finanzaModel == null){
            this.finanzaModel = FinanzaModel.GetInstance();
        }
        
        return this.finanzaModel;
    }
    // </editor-fold>
    
    private List<FinanzaDTO> buscarTodo()
    {
        try {
            List<FinanzaDTO> objResult = this.getFinanzaModel().buscarAll();
            return objResult;
        } catch (Exception ex) {
            Logger.getLogger(FinanzaController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    } 
      
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       /* try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
            doPost(request, response);
    }
}
